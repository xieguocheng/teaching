package com.teaching.pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
@Data
@Table(name = "user_behavior")
public class UserBehavior {

    private List<UserBehavior> userBehaviorList;

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
     * 课程id
     */
    @Column(name = "course_id")
    private Integer courseId;

    /**
     * 用户收藏分类
     */
    private Integer classify;

    /**
     * 用户行为类型：浏览-1，收藏-2，加购物车-3，购买-4
     */
    private Integer type;

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
     * 获取课程id
     *
     * @return course_id - 课程id
     */
    public Integer getCourseId() {
        return courseId;
    }

    /**
     * 设置课程id
     *
     * @param courseId 课程id
     */
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    /**
     * 获取用户收藏分类
     *
     * @return classify - 用户收藏分类
     */
    public Integer getClassify() {
        return classify;
    }

    /**
     * 设置用户收藏分类
     *
     * @param classify 用户收藏分类
     */
    public void setClassify(Integer classify) {
        this.classify = classify;
    }

    /**
     * 获取用户行为类型：浏览-1，收藏-2，加购物车-3，购买-4
     *
     * @return type - 用户行为类型：浏览-1，收藏-2，加购物车-3，购买-4
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置用户行为类型：浏览-1，收藏-2，加购物车-3，购买-4
     *
     * @param type 用户行为类型：浏览-1，收藏-2，加购物车-3，购买-4
     */
    public void setType(Integer type) {
        this.type = type;
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