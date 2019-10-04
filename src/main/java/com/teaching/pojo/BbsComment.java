package com.teaching.pojo;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "bbs_comment")
public class BbsComment {
    /**
     * id
     */
    @Id
    private Integer id;

    /**
     * 用户名字
     */
    private String username;

    /**
     * 评论对象
     */
    @Column(name = "to_username")
    private String toUsername;

    /**
     * 文章id
     */
    @Column(name = "att_id")
    private Integer attId;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 引用id
     */
    @Column(name = "ref_id")
    private Integer refId;

    /**
     * 引用内容
     */
    @Column(name = "ref_content")
    private String refContent;

    /**
     * 类型：0-评论；1-答疑
     */
    private Integer type;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

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
     * 获取用户名字
     *
     * @return username - 用户名字
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名字
     *
     * @param username 用户名字
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取评论对象
     *
     * @return to_username - 评论对象
     */
    public String getToUsername() {
        return toUsername;
    }

    /**
     * 设置评论对象
     *
     * @param toUsername 评论对象
     */
    public void setToUsername(String toUsername) {
        this.toUsername = toUsername;
    }

    /**
     * 获取文章id
     *
     * @return att_id - 文章id
     */
    public Integer getAttId() {
        return attId;
    }

    /**
     * 设置文章id
     *
     * @param attId 文章id
     */
    public void setAttId(Integer attId) {
        this.attId = attId;
    }

    /**
     * 获取评论内容
     *
     * @return content - 评论内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置评论内容
     *
     * @param content 评论内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取引用id
     *
     * @return ref_id - 引用id
     */
    public Integer getRefId() {
        return refId;
    }

    /**
     * 设置引用id
     *
     * @param refId 引用id
     */
    public void setRefId(Integer refId) {
        this.refId = refId;
    }

    /**
     * 获取引用内容
     *
     * @return ref_content - 引用内容
     */
    public String getRefContent() {
        return refContent;
    }

    /**
     * 设置引用内容
     *
     * @param refContent 引用内容
     */
    public void setRefContent(String refContent) {
        this.refContent = refContent;
    }

    /**
     * 获取类型：0-评论；1-答疑
     *
     * @return type - 类型：0-评论；1-答疑
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置类型：0-评论；1-答疑
     *
     * @param type 类型：0-评论；1-答疑
     */
    public void setType(Integer type) {
        this.type = type;
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
}