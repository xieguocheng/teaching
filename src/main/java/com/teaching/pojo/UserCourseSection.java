package com.teaching.pojo;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;
@Data
@Table(name = "user_course_section")
public class UserCourseSection {
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
     * 章节id
     */
    @Column(name = "section_id")
    private Integer sectionId;

    /**
     * 速度
     */
    private Integer rate;

    /**
     * 状态：0-学习中；1-学习结束
     */
    private Integer status;

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
     * 获取章节id
     *
     * @return section_id - 章节id
     */
    public Integer getSectionId() {
        return sectionId;
    }

    /**
     * 设置章节id
     *
     * @param sectionId 章节id
     */
    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    /**
     * 获取速度
     *
     * @return rate - 速度
     */
    public Integer getRate() {
        return rate;
    }

    /**
     * 设置速度
     *
     * @param rate 速度
     */
    public void setRate(Integer rate) {
        this.rate = rate;
    }

    /**
     * 获取状态：0-学习中；1-学习结束
     *
     * @return status - 状态：0-学习中；1-学习结束
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态：0-学习中；1-学习结束
     *
     * @param status 状态：0-学习中；1-学习结束
     */
    public void setStatus(Integer status) {
        this.status = status;
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