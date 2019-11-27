package com.teaching.pojo;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;
@Data
@Table(name = "course_section")
public class CourseSection {
    /**
     * ID
     */
    @Id
    private Integer id;

    /**
     * 归属课程id
     */
    @Column(name = "course_id")
    private Integer courseId;

    /**
     * 父章节id
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 章节名称 
     */
    private String name;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 时长:00:00
     */
    private String time;

    /**
     * 未上架（0）、上架（1）
     */
    private String onsale;

    /**
     * video路径
     */
    @Column(name = "video_url")
    private String videoUrl;

    /**
     * 资料下载路径
     */
    @Column(name = "file_url")
    private String fileUrl;

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

    public CourseSection(Integer id) {
        this.id = id;
    }
    public CourseSection() {
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
     * 获取归属课程id
     *
     * @return course_id - 归属课程id
     */
    public Integer getCourseId() {
        return courseId;
    }

    /**
     * 设置归属课程id
     *
     * @param courseId 归属课程id
     */
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    /**
     * 获取父章节id
     *
     * @return parent_id - 父章节id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置父章节id
     *
     * @param parentId 父章节id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取章节名称 
     *
     * @return name - 章节名称 
     */
    public String getName() {
        return name;
    }

    /**
     * 设置章节名称 
     *
     * @param name 章节名称 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取时长:00:00
     *
     * @return time - 时长:00:00
     */
    public String getTime() {
        return time;
    }

    /**
     * 设置时长:00:00
     *
     * @param time 时长:00:00
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * 获取未上架（0）、上架（1）
     *
     * @return onsale - 未上架（0）、上架（1）
     */
    public String getOnsale() {
        return onsale;
    }

    /**
     * 设置未上架（0）、上架（1）
     *
     * @param onsale 未上架（0）、上架（1）
     */
    public void setOnsale(String onsale) {
        this.onsale = onsale;
    }

    /**
     * 获取video路径
     *
     * @return video_url - video路径
     */
    public String getVideoUrl() {
        return videoUrl;
    }

    /**
     * 设置video路径
     *
     * @param videoUrl video路径
     */
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    /**
     * 获取资料下载路径
     *
     * @return file_url - 资料下载路径
     */
    public String getFileUrl() {
        return fileUrl;
    }

    /**
     * 设置资料下载路径
     *
     * @param fileUrl 资料下载路径
     */
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
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