package com.teaching.web.controller.admin;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.model.DefaultPutRet;
import com.teaching.dto.QiNiuPutRet;
import com.teaching.service.QiNiuService;
import com.teaching.utils.ApiResponse;
import com.teaching.utils.VideoUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author： XO
 * @Description：
 * @Date： 2019/4/12 13:25
 */

@Controller
@Slf4j
public class QiniuController {

    @Value("${qiniu.cdn.prefix}")
    private String prefix;

    @Autowired
    private QiNiuService qiNiuService;

    @Autowired
    private Gson gson;


    /**
     * 上传视频
     * @param video
     */
    @PostMapping(value="/qiniu/upload/video",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public ApiResponse video(MultipartFile video){

        String fileName = video.getOriginalFilename();//设置文件名路径名字：courseid/userid/文件名字IDUtils.getImageName()+"/"+
        QiNiuPutRet ret;

        //获取视频总时长
        String time=VideoUtil.ReadVideoTimeMs(video);
        log.info("视频时长："+time);

        //判断视频是否为空
        if (video.isEmpty()) {//判断是否有选择图片
            return ApiResponse.ofStatus(ApiResponse.Status.NOT_FOUND);
        }

        //开始上传视频
        try {
            InputStream inputStream = video.getInputStream();
            Response response = qiNiuService.uploadFile(inputStream,fileName);//上传文件用inputStream方式到七牛云，失败就重复3次
            if (response.isOK()) {
                ret = gson.fromJson(response.bodyString(), QiNiuPutRet.class);//使用自定义的qiNiuPutRet【如果上传成功返回gson数据，内含重要的图片信息key】
                log.info("七牛云视频上传："+ret);
            } else {
                return ApiResponse.ofMessage(response.statusCode, response.getInfo());//失败返回错误码和错误信息
            }
        } catch (QiniuException e) {
            Response response = e.response;
            try {
                return ApiResponse.ofMessage(response.statusCode, response.bodyString());
            } catch (QiniuException e1) {
                e1.printStackTrace();
                return ApiResponse.ofStatus(ApiResponse.Status.INTERNAL_SERVER_ERROR);
            }
        } catch (IOException e) {
            return ApiResponse.ofStatus(ApiResponse.Status.INTERNAL_SERVER_ERROR);
        }

        Map<String,String> map=new HashMap<String,String>();
        map.put("time",time);
        map.put("videoUrl",prefix+ret.key);

        return ApiResponse.ofSuccess(map);

    }


}
