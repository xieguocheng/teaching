package com.teaching.pojo;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "auth_teacher")
public class AuthTeacher {

    /**
     * id
     */
    @Id
    private Integer id;

    /**
     * user_id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * brief
     */
    private String brief;

    /**
     * 姓名
     */
    private String name;

    /**
     * 联系方式
     */
    private String mobile;

    /**
     * 试讲视频
     */
    private String video;

    /**
     * 审核是否通过0-未通过，1-通过
     */
    private Integer status;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 保留字段1
     */
    @Column(name = "Column_1")
    private String column1;

    /**
     * 保留字段2
     */
    @Column(name = "Column_2")
    private String column2;

    /**
     * create_time
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * update_time
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * del
     */
    private Boolean del;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取user_id
     *
     * @return user_id - user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置user_id
     *
     * @param userId user_id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取brief
     *
     * @return brief - brief
     */
    public String getBrief() {
        return brief;
    }

    /**
     * 设置brief
     *
     * @param brief brief
     */
    public void setBrief(String brief) {
        this.brief = brief;
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取联系方式
     *
     * @return mobile - 联系方式
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置联系方式
     *
     * @param mobile 联系方式
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取试讲视频
     *
     * @return video - 试讲视频
     */
    public String getVideo() {
        return video;
    }

    /**
     * 设置试讲视频
     *
     * @param video 试讲视频
     */
    public void setVideo(String video) {
        this.video = video;
    }

    /**
     * 获取审核是否通过0-未通过，1-通过
     *
     * @return status - 审核是否通过0-未通过，1-通过
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置审核是否通过0-未通过，1-通过
     *
     * @param status 审核是否通过0-未通过，1-通过
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取保留字段1
     *
     * @return Column_1 - 保留字段1
     */
    public String getColumn1() {
        return column1;
    }

    /**
     * 设置保留字段1
     *
     * @param column1 保留字段1
     */
    public void setColumn1(String column1) {
        this.column1 = column1;
    }

    /**
     * 获取保留字段2
     *
     * @return Column_2 - 保留字段2
     */
    public String getColumn2() {
        return column2;
    }

    /**
     * 设置保留字段2
     *
     * @param column2 保留字段2
     */
    public void setColumn2(String column2) {
        this.column2 = column2;
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
     * 获取del
     *
     * @return del - del
     */
    public Boolean getDel() {
        return del;
    }

    /**
     * 设置del
     *
     * @param del del
     */
    public void setDel(Boolean del) {
        this.del = del;
    }


}