package com.teaching.pojo;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "course_comment")
public class CourseComment {
    /**
     * id
     */
    @Id
    private Integer id;

    /**
     * 用户username
     */
    private String username;

    /**
     * 评论对象username
     */
    @Column(name = "to_username")
    private String toUsername;

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
     * 章节标题
     */
    @Column(name = "section_title")
    private String sectionTitle;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 引用id：null-父级没有引用
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
     * 获取用户username
     *
     * @return username - 用户username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户username
     *
     * @param username 用户username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取评论对象username
     *
     * @return to_username - 评论对象username
     */
    public String getToUsername() {
        return toUsername;
    }

    /**
     * 设置评论对象username
     *
     * @param toUsername 评论对象username
     */
    public void setToUsername(String toUsername) {
        this.toUsername = toUsername;
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
     * 获取章节标题
     *
     * @return section_title - 章节标题
     */
    public String getSectionTitle() {
        return sectionTitle;
    }

    /**
     * 设置章节标题
     *
     * @param sectionTitle 章节标题
     */
    public void setSectionTitle(String sectionTitle) {
        this.sectionTitle = sectionTitle;
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
     * 获取引用id：null-父级没有引用
     *
     * @return ref_id - 引用id：null-父级没有引用
     */
    public Integer getRefId() {
        return refId;
    }

    /**
     * 设置引用id：null-父级没有引用
     *
     * @param refId 引用id：null-父级没有引用
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