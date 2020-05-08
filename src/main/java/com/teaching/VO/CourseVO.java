package com.teaching.VO;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class CourseVO {
    /**
     * ID
     */
    @Id
    @ExcelProperty("序号")
    private Integer id;

    /**
     * 归属人,用户id
     */
    @ExcelProperty("教师id")
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 课程名称
     */
    @ExcelProperty("课程名称")
    private String name;

    /**
     * 描述
     */
    @ExcelProperty("描述")
    private String brief;

    /**
     * 一级课程分类
     */
    @ExcelProperty("一级课程分类")
    private String classify;

    /**
     * 一级分类名称
     */
    @Column(name = "classify_name")
    @ExcelProperty("一级分类名称")
    private String classifyName;

    /**
     * 二级课程分类
     */
    @ExcelProperty("二级课程分类")
    @Column(name = "sub_classify")
    private String subClassify;

    /**
     * 二级分类名称
     */
    @ExcelProperty("二级分类名称")
    @Column(name = "sub_classify_name")
    private String subClassifyName;

    /**
     * 图片
     */
    @ExcelProperty("图片地址")
    private String picture;

    /**
     * 课程级别：1-初级，2-中级，3-高级
     */
    @ExcelProperty("课程级别")
    private Integer level;

    /**
     * 是否免费：0-否，1-是
     */
    @ExcelProperty("是否免费")
    private Integer free;

    /**
     * 课程价格
     */
    @ExcelProperty("课程价格")
    private BigDecimal price;

    /**
     * 时长
     */
    @ExcelProperty("时长")
    private String time;

    /**
     * status：0-默认，1-审核中，2-申请成功，3-申请失败
     */
    @ExcelProperty("状态")
    private Integer status;

    /**
     * 未上架（0）、上架（1）
     */
    @ExcelProperty("上架")
    private Integer onsale;

    /**
     * 未推荐（0）、推荐（1）
     */
    @ExcelProperty("推荐")
    private Integer recommend;

    /**
     * 权重，高的优先显示
     */
    @ExcelProperty("权重")
    private Integer weight;

    /**
     * 学习人数
     */
    @ExcelProperty("学习人数")
    @Column(name = "study_count")
    private Integer studyCount;

    /**
     * create_time
     */
    @ExcelProperty("create_time")
    @Column(name = "create_time")
    private Date createTime;

    /**
     * create_user
     */
    @ExcelProperty("create_user")
    @Column(name = "create_user")
    private String createUser;

    /**
     * update_time
     */
    @ExcelProperty("update_time")
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * update_user
     */
    @ExcelProperty("update_user")
    @Column(name = "update_user")
    private String updateUser;

    /**
     * del
     */
    @ExcelProperty("del")
    private Integer del;




}