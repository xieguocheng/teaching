package com.teaching.pojo;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "consts_site_carousel")
public class ConstsSiteCarousel {
    /**
     * id
     */
    @Id
    private Integer id;

    /**
     * 0-轮播，1-免费课程，2-名师推荐
     */
    private Integer type;

    /**
     * 名称：课程名称/教师名称
     */
    private String name;

    /**
     * 图片：课程图片/教师图片
     */
    private String picture;

    /**
     * 链接：课程链接/教师链接
     */
    private String url;

    /**
     * 内容：课程简介/教师简介
     */
    private String content;

    /**
     * 权重
     */
    private Integer weight;

    /**
     * 0-正常使用，1-弃用
     */
    private Integer status;

    /**
     * 保留字段
     */
    @Column(name = "Column_1")
    private String column1;

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
    private Integer del;

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
     * 获取0-轮播，1-免费课程，2-名师推荐
     *
     * @return type - 0-轮播，1-免费课程，2-名师推荐
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置0-轮播，1-免费课程，2-名师推荐
     *
     * @param type 0-轮播，1-免费课程，2-名师推荐
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取名称：课程名称/教师名称
     *
     * @return name - 名称：课程名称/教师名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称：课程名称/教师名称
     *
     * @param name 名称：课程名称/教师名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取图片：课程图片/教师图片
     *
     * @return picture - 图片：课程图片/教师图片
     */
    public String getPicture() {
        return picture;
    }

    /**
     * 设置图片：课程图片/教师图片
     *
     * @param picture 图片：课程图片/教师图片
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * 获取链接：课程链接/教师链接
     *
     * @return url - 链接：课程链接/教师链接
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置链接：课程链接/教师链接
     *
     * @param url 链接：课程链接/教师链接
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取内容：课程简介/教师简介
     *
     * @return content - 内容：课程简介/教师简介
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容：课程简介/教师简介
     *
     * @param content 内容：课程简介/教师简介
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取权重
     *
     * @return weight - 权重
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * 设置权重
     *
     * @param weight 权重
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     * 获取0-正常使用，1-弃用
     *
     * @return status - 0-正常使用，1-弃用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置0-正常使用，1-弃用
     *
     * @param status 0-正常使用，1-弃用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取保留字段
     *
     * @return Column_1 - 保留字段
     */
    public String getColumn1() {
        return column1;
    }

    /**
     * 设置保留字段
     *
     * @param column1 保留字段
     */
    public void setColumn1(String column1) {
        this.column1 = column1;
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
}