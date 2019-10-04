package com.teaching.web.controller.admin;

import com.alibaba.fastjson.JSONArray;
import com.teaching.mapper.ConstsClassifyMapper;
import com.teaching.pojo.ConstsClassify;
import com.teaching.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Author： XO
 * @Description：
 * @Date： 2019/9/29 20:34
 */

@Controller
public class ConstsClassifyController {

    @Autowired
    private ConstsClassifyMapper constsClassifyMapper;


    /**
     * 课程分类tree数据
     * @param model
     * @return
     */
    @GetMapping("/admin/category/categoryList")
    public String welcomePage(Model model) {
        List<ConstsClassify> constsClassifyList= constsClassifyMapper.selectAll();
        model.addAttribute("list",JSONArray.toJSON(constsClassifyList));

        return "admin/category/category-list";
    }


    /**
     * 显示分类类目内容
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/admin/category/show/{id}")
    public String show(Model model ,@PathVariable(name = "id",required = false) String id) {

        Example example=new Example(ConstsClassify.class);
        example.createCriteria().andEqualTo("id",id);
        ConstsClassify constsClassify=constsClassifyMapper.selectByExample(example).get(0);
        model.addAttribute("constsClassify",constsClassify);

        return "admin/category/category-show";
    }


    /**
     * 修改类目
     * @param model
     * @return
     */
    @PostMapping("/admin/category/update")
    @ResponseBody
    public ApiResponse update(Model model ,ConstsClassify constsClassify) {

        try{
            System.out.println(constsClassify);
             ConstsClassify exist=constsClassifyMapper.selectByPrimaryKey(constsClassify.getId());
             exist.setName(constsClassify.getName());
             exist.setIntro(constsClassify.getIntro());
            constsClassifyMapper.updateByPrimaryKey(exist);
            return ApiResponse.ofSuccess(null);
        }catch (Exception e) {
            e.printStackTrace();
            return ApiResponse.ofStatus(ApiResponse.Status.BAD_REQUEST);
        }

    }

    @PostMapping("/admin/category/remove")
    @ResponseBody
    public ApiResponse remove(ConstsClassify constsClassify){
        System.out.print(constsClassify);

        if(constsClassify.getId().equals("")||constsClassify.getId()==null){
            return ApiResponse.ofStatus(ApiResponse.Status.NOT_FOUND);
        }

        constsClassifyMapper.deleteByPrimaryKey(constsClassify);

        return ApiResponse.ofSuccess("");
    }


    /**
     * 添加界面
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/admin/category/categoryAdd/{id}")
    public String categoryAddPage(Model model ,@PathVariable(name = "id",required = false) String id) {

        model.addAttribute("parentId",id);

        return "admin/category/category-add";
    }

    /**
     * 添加类目
     * @param constsClassify
     * @return
     */
    @PostMapping("/admin/category/add")
    @ResponseBody
    public ApiResponse add(ConstsClassify constsClassify){

        System.out.print(constsClassify);

        if(constsClassify.getParentId().equals("")||constsClassify.getParentId()==null){
            return ApiResponse.ofStatus(ApiResponse.Status.NOT_FOUND);
        }

        constsClassifyMapper.insertSelective(constsClassify);

        return ApiResponse.ofSuccess("");
    }


















}
