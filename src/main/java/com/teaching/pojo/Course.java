package com.teaching.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
@Data
public class Course {
    /**
     * ID
     */
    @Id
    private Integer id;

    /**
     * 归属人,用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 课程名称
     */
    private String name;

    /**
     * 一级课程分类
     */
    private String classify;

    /**
     * 一级分类名称
     */
    @Column(name = "classify_name")
    private String classifyName;

    /**
     * 二级课程分类
     */
    @Column(name = "sub_classify")
    private String subClassify;

    /**
     * 二级分类名称
     */
    @Column(name = "sub_classify_name")
    private String subClassifyName;

    /**
     * 图片
     */
    private String picture;

    /**
     * 课程级别：1-初级，2-中级，3-高级
     */
    private Integer level;

    /**
     * 是否免费：0-否，1-是
     */
    private Integer free;

    /**
     * 课程价格
     */
    private BigDecimal price;

    /**
     * 时长
     */
    private String time;

    /**
     * status：0-默认，1-审核中，2-申请成功，3-申请失败
     */
    private Integer status;

    /**
     * 未上架（0）、上架（1）
     */
    private Integer onsale;

    /**
     * 未推荐（0）、推荐（1）
     */
    private Integer recommend;

    /**
     * 权重，高的优先显示
     */
    private Integer weight;

    /**
     * 学习人数
     */
    @Column(name = "study_count")
    private Integer studyCount;

    /**
     * create_time
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * create_user
     */
    @Column(name = "create_user")
    private String createUser;

    /**
     * update_time
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * update_user
     */
    @Column(name = "update_user")
    private String updateUser;

    /**
     * del
     */
    private Integer del;

    /**
     * 描述
     */
    private String brief;

    public Course() {
    }

    public Course(Integer id) {
        this.id = id;
    }

    /**
     * 获取ID
     *
     * @return id - ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取归属人,用户id
     *
     * @return user_id - 归属人,用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置归属人,用户id
     *
     * @param userId 归属人,用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取课程名称
     *
     * @return name - 课程名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置课程名称
     *
     * @param name 课程名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取一级课程分类
     *
     * @return classify - 一级课程分类
     */
    public String getClassify() {
        return classify;
    }

    /**
     * 设置一级课程分类
     *
     * @param classify 一级课程分类
     */
    public void setClassify(String classify) {
        this.classify = classify;
    }

    /**
     * 获取一级分类名称
     *
     * @return classify_name - 一级分类名称
     */
    public String getClassifyName() {
        return classifyName;
    }

    /**
     * 设置一级分类名称
     *
     * @param classifyName 一级分类名称
     */
    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    /**
     * 获取二级课程分类
     *
     * @return sub_classify - 二级课程分类
     */
    public String getSubClassify() {
        return subClassify;
    }

    /**
     * 设置二级课程分类
     *
     * @param subClassify 二级课程分类
     */
    public void setSubClassify(String subClassify) {
        this.subClassify = subClassify;
    }

    /**
     * 获取二级分类名称
     *
     * @return sub_classify_name - 二级分类名称
     */
    public String getSubClassifyName() {
        return subClassifyName;
    }

    /**
     * 设置二级分类名称
     *
     * @param subClassifyName 二级分类名称
     */
    public void setSubClassifyName(String subClassifyName) {
        this.subClassifyName = subClassifyName;
    }

    /**
     * 获取图片
     *
     * @return picture - 图片
     */
    public String getPicture() {
        return picture;
    }

    /**
     * 设置图片
     *
     * @param picture 图片
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * 获取课程级别：1-初级，2-中级，3-高级
     *
     * @return level - 课程级别：1-初级，2-中级，3-高级
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 设置课程级别：1-初级，2-中级，3-高级
     *
     * @param level 课程级别：1-初级，2-中级，3-高级
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 获取是否免费：0-否，1-是
     *
     * @return free - 是否免费：0-否，1-是
     */
    public Integer getFree() {
        return free;
    }

    /**
     * 设置是否免费：0-否，1-是
     *
     * @param free 是否免费：0-否，1-是
     */
    public void setFree(Integer free) {
        this.free = free;
    }

    /**
     * 获取课程价格
     *
     * @return price - 课程价格
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置课程价格
     *
     * @param price 课程价格
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取时长
     *
     * @return time - 时长
     */
    public String getTime() {
        return time;
    }

    /**
     * 设置时长
     *
     * @param time 时长
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * 获取status：0-默认，1-审核中，2-申请成功，3-申请失败
     *
     * @return status - status：0-默认，1-审核中，2-申请成功，3-申请失败
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置status：0-默认，1-审核中，2-申请成功，3-申请失败
     *
     * @param status status：0-默认，1-审核中，2-申请成功，3-申请失败
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取未上架（0）、上架（1）
     *
     * @return onsale - 未上架（0）、上架（1）
     */
    public Integer getOnsale() {
        return onsale;
    }

    /**
     * 设置未上架（0）、上架（1）
     *
     * @param onsale 未上架（0）、上架（1）
     */
    public void setOnsale(Integer onsale) {
        this.onsale = onsale;
    }

    /**
     * 获取未推荐（0）、推荐（1）
     *
     * @return recommend - 未推荐（0）、推荐（1）
     */
    public Integer getRecommend() {
        return recommend;
    }

    /**
     * 设置未推荐（0）、推荐（1）
     *
     * @param recommend 未推荐（0）、推荐（1）
     */
    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
    }

    /**
     * 获取权重，高的优先显示
     *
     * @return weight - 权重，高的优先显示
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * 设置权重，高的优先显示
     *
     * @param weight 权重，高的优先显示
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     * 获取学习人数
     *
     * @return study_count - 学习人数
     */
    public Integer getStudyCount() {
        return studyCount;
    }

    /**
     * 设置学习人数
     *
     * @param studyCount 学习人数
     */
    public void setStudyCount(Integer studyCount) {
        this.studyCount = studyCount;
    }

    /**
     * 获取create_time
     *
     * @return create_time - create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置create_time
     *
     * @param createTime create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取create_user
     *
     * @return create_user - create_user
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 设置create_user
     *
     * @param createUser create_user
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * 获取update_time
     *
     * @return update_time - update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置update_time
     *
     * @param updateTime update_time
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取update_user
     *
     * @return update_user - update_user
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * 设置update_user
     *
     * @param updateUser update_user
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * 获取del
     *
     * @return del - del
     */
    public Integer getDel() {
        return del;
    }

    /**
     * 设置del
     *
     * @param del del
     */
    public void setDel(Integer del) {
        this.del = del;
    }

    /**
     * 获取描述
     *
     * @return brief - 描述
     */
    public String getBrief() {
        return brief;
    }

    /**
     * 设置描述
     *
     * @param brief 描述
     */
    public void setBrief(String brief) {
        this.brief = brief;
    }
}