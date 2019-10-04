package com.teaching.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_follow")
public class UserFollow {
    /**
     * id
     */
    @Id
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 关注的用户id
     */
    @Column(name = "follow_id")
    private Integer followId;

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
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取关注的用户id
     *
     * @return follow_id - 关注的用户id
     */
    public Integer getFollowId() {
        return followId;
    }

    /**
     * 设置关注的用户id
     *
     * @param followId 关注的用户id
     */
    public void setFollowId(Integer followId) {
        this.followId = followId;
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