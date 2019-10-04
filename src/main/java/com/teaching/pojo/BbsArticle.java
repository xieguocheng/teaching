package com.teaching.pojo;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "bbs_article")
public class BbsArticle {
    /**
     * id
     */
    @Id
    private Integer id;

    /**
     * 用户id，null表示系统添加
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 标题
     */
    private String title;

    /**
     * 类型
     */
    @Column(name = "type_id")
    private String typeId;

    /**
     * 浏览量
     */
    private Integer view;

    /**
     * 点赞数
     */
    private Integer love;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    private Integer del;

    /**
     * 正文
     */
    private String content;

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
     * 获取用户id，null表示系统添加
     *
     * @return user_id - 用户id，null表示系统添加
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id，null表示系统添加
     *
     * @param userId 用户id，null表示系统添加
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取标题
     *
     * @return title - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取类型
     *
     * @return type_id - 类型
     */
    public String getTypeId() {
        return typeId;
    }

    /**
     * 设置类型
     *
     * @param typeId 类型
     */
    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    /**
     * 获取浏览量
     *
     * @return view - 浏览量
     */
    public Integer getView() {
        return view;
    }

    /**
     * 设置浏览量
     *
     * @param view 浏览量
     */
    public void setView(Integer view) {
        this.view = view;
    }

    /**
     * 获取点赞数
     *
     * @return love - 点赞数
     */
    public Integer getLove() {
        return love;
    }

    /**
     * 设置点赞数
     *
     * @param love 点赞数
     */
    public void setLove(Integer love) {
        this.love = love;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return del
     */
    public Integer getDel() {
        return del;
    }

    /**
     * @param del
     */
    public void setDel(Integer del) {
        this.del = del;
    }

    /**
     * 获取正文
     *
     * @return content - 正文
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置正文
     *
     * @param content 正文
     */
    public void setContent(String content) {
        this.content = content;
    }
}