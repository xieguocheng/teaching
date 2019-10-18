package com.teaching.utils;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.MultimediaInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.channels.FileChannel;
import java.util.UUID;

@Slf4j
@Component
public class VideoUtil {

    /**
     * @Description: 获取视频时长(时分秒)
     * @params: [file]
     * @return: java.lang.String
     */
    public static String ReadVideoTimeMs(MultipartFile file) {
        Encoder encoder = new Encoder(); //该方法为jave-1.0.2.jar中的方法，需要先在本地注入该jar
        long ms = 0;
        try {
            // 获取文件类型
            String fileName = file.getContentType();
            // 获取文件后缀
            String pref = fileName.indexOf("/") != -1 ? fileName.substring(fileName.lastIndexOf("/") + 1, fileName.length()) : null;
            String prefix = "." + pref;
            // 用uuid作为文件名，防止生成的临时文件重复
            final File excelFile = File.createTempFile(UUID.randomUUID().toString().replace("-", ""), prefix);
            // MultipartFile to File
            file.transferTo(excelFile);//该方法将把传入的MultipartFile写入磁盘中
            MultimediaInfo m = encoder.getInfo(excelFile); //该方法为jave-1.0.2.jar中的方法，需要先在本地注入该jar
            ms = m.getDuration();//得到视频的毫秒时间
            //程序结束时，删除临时文件
            VideoUtil.deleteFile(excelFile);
        } catch (Exception e) {
            log.info("视频上传功能出错！！");
        }
        //定义时分秒的毫秒时间
        int ss = 1000;
        int mi = ss * 60;
        int hh = mi * 60;
        int dd = hh * 24;
        //分别计算时分秒
        long day = ms / dd;
        long hour = (ms - day * dd) / hh;
        long minute = (ms - day * dd - hour * hh) / mi;
        long second = (ms - day * dd - hour * hh - minute * mi) / ss;
        //根据三目表达式拼接时间前的0，保证格式为 00:00:00
        String strHour = hour < 10 ? "0" + hour : "" + hour;//小时
        String strMinute = minute < 10 ? "0" + minute : "" + minute;//分钟
        String strSecond = second < 10 ? "0" + second : "" + second;//秒
        if (strHour.equals("00")) {
            return strMinute + ":" + strSecond;
        } else {
            return strHour + ":" + strMinute + ":" + strSecond;
        }
    }

    /**
     * @Description: 删除文件
     * @params: [files] File...中的三个点作用为 如果不明确files入参具体有几个，可以用三个点代替，作用同数组差不多，
     * 该方法最好适用于后台内部的调用，各种类型都适用如String，File，Integer等，前台的如果是String类型，作用同数组集合等一模一样，
     * 但如果是integer类型的，前台入参就不太方便了
     * @return: void
     */
    private static void deleteFile(File... files) {
        for (File file : files) {
            if (file.exists()) {
                file.delete();
            }
        }
    }




    public static void main(String arg[]) throws EncoderException {

       /* File source = new File("C:\\Users\\Administrator\\Desktop\\20191014_173145.mp4");
        Encoder encoder = new Encoder();
        FileChannel fc = null;
        String size = "";
        it.sauronsoftware.jave.MultimediaInfo m = encoder.getInfo(source);
        long ls = m.getDuration();
        System.out.println("此视频时长为:" + ls / 60000 + "分" + (ls) / 1000 + "秒！");*/


    }

}