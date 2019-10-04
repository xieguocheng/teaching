package com.teaching.pojo;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "auth_user")
public class AuthUser {
    /**
     * id
     */
    @Id
    private Integer id;

    /**
     * 登录账号-可以用来登录
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机-可以用来登录
     */
    private String mobile;

    /**
     * 用户真实名字
     */
    private String realname;

    /**
     * 0-未知，1-男，1-女
     */
    private Integer gender;

    /**
     * 头像
     */
    private String hearder;

    /**
     * 用户账号状态：待审核（0），有效（1），无效（2）',
     */
    private Integer status;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 学历：大专、本科、硕士、博士、博士后
     */
    private String education;

    /**
     * 学校，外键
     */
    private Integer school;

    /**
     * 头衔
     */
    private String title;

    /**
     * 签名
     */
    private String sign;

    /**
     * 保留字段-微信公众号openid
     */
    @Column(name = "open_id")
    private String openId;

    /**
     * 保留字段-微信号
     */
    @Column(name = "wechat_id")
    private String wechatId;

    /**
     * 保留字段-qq
     */
    private String qq;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 区域
     */
    private String district;

    /**
     * USER和ADIMI
     */
    private String role;

    /**
     * 0-未申请教师资格，1-申请成功，2-申请失败，3-审核中
     */
    private Integer teacher;

    /**
     * 兴趣爱好
     */
    private String hobby;

    /**
     * 最后一次登录IP
     */
    private String ip;

    /**
     * 最新登录时间
     */
    @Column(name = "login_time")
    private Date loginTime;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 创建人
     */
    @Column(name = "create_user")
    private String createUser;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 更新人
     */
    @Column(name = "update_user")
    private String updateUser;

    /**
     * 是否逻辑删除0-未删除，1-已删除
     */
    private Integer del;

    public AuthUser(Integer id) {
        this.id = id;
    }
    public AuthUser() {

    }

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
     * 获取登录账号-可以用来登录
     *
     * @return username - 登录账号-可以用来登录
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置登录账号-可以用来登录
     *
     * @param username 登录账号-可以用来登录
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取手机-可以用来登录
     *
     * @return mobile - 手机-可以用来登录
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机-可以用来登录
     *
     * @param mobile 手机-可以用来登录
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取用户真实名字
     *
     * @return realname - 用户真实名字
     */
    public String getRealname() {
        return realname;
    }

    /**
     * 设置用户真实名字
     *
     * @param realname 用户真实名字
     */
    public void setRealname(String realname) {
        this.realname = realname;
    }

    /**
     * 获取0-未知，1-男，1-女
     *
     * @return gender - 0-未知，1-男，1-女
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 设置0-未知，1-男，1-女
     *
     * @param gender 0-未知，1-男，1-女
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 获取头像
     *
     * @return hearder - 头像
     */
    public String getHearder() {
        return hearder;
    }

    /**
     * 设置头像
     *
     * @param hearder 头像
     */
    public void setHearder(String hearder) {
        this.hearder = hearder;
    }

    /**
     * 获取用户账号状态：待审核（0），有效（1），无效（2）',
     *
     * @return status - 用户账号状态：待审核（0），有效（1），无效（2）',
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置用户账号状态：待审核（0），有效（1），无效（2）',
     *
     * @param status 用户账号状态：待审核（0），有效（1），无效（2）',
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取生日
     *
     * @return birthday - 生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置生日
     *
     * @param birthday 生日
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取学历：大专、本科、硕士、博士、博士后
     *
     * @return education - 学历：大专、本科、硕士、博士、博士后
     */
    public String getEducation() {
        return education;
    }

    /**
     * 设置学历：大专、本科、硕士、博士、博士后
     *
     * @param education 学历：大专、本科、硕士、博士、博士后
     */
    public void setEducation(String education) {
        this.education = education;
    }

    /**
     * 获取学校，外键
     *
     * @return school - 学校，外键
     */
    public Integer getSchool() {
        return school;
    }

    /**
     * 设置学校，外键
     *
     * @param school 学校，外键
     */
    public void setSchool(Integer school) {
        this.school = school;
    }

    /**
     * 获取头衔
     *
     * @return title - 头衔
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置头衔
     *
     * @param title 头衔
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取签名
     *
     * @return sign - 签名
     */
    public String getSign() {
        return sign;
    }

    /**
     * 设置签名
     *
     * @param sign 签名
     */
    public void setSign(String sign) {
        this.sign = sign;
    }

    /**
     * 获取保留字段-微信公众号openid
     *
     * @return open_id - 保留字段-微信公众号openid
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 设置保留字段-微信公众号openid
     *
     * @param openId 保留字段-微信公众号openid
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * 获取保留字段-微信号
     *
     * @return wechat_id - 保留字段-微信号
     */
    public String getWechatId() {
        return wechatId;
    }

    /**
     * 设置保留字段-微信号
     *
     * @param wechatId 保留字段-微信号
     */
    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    /**
     * 获取保留字段-qq
     *
     * @return qq - 保留字段-qq
     */
    public String getQq() {
        return qq;
    }

    /**
     * 设置保留字段-qq
     *
     * @param qq 保留字段-qq
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * 获取省份
     *
     * @return province - 省份
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省份
     *
     * @param province 省份
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取城市
     *
     * @return city - 城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置城市
     *
     * @param city 城市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取区域
     *
     * @return district - 区域
     */
    public String getDistrict() {
        return district;
    }

    /**
     * 设置区域
     *
     * @param district 区域
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * 获取USER和ADIMI
     *
     * @return role - USER和ADIMI
     */
    public String getRole() {
        return role;
    }

    /**
     * 设置USER和ADIMI
     *
     * @param role USER和ADIMI
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * 获取0-未申请教师资格，1-申请成功，2-申请失败，3-审核中
     *
     * @return teacher - 0-未申请教师资格，1-申请成功，2-申请失败，3-审核中
     */
    public Integer getTeacher() {
        return teacher;
    }

    /**
     * 设置0-未申请教师资格，1-申请成功，2-申请失败，3-审核中
     *
     * @param teacher 0-未申请教师资格，1-申请成功，2-申请失败，3-审核中
     */
    public void setTeacher(Integer teacher) {
        this.teacher = teacher;
    }

    /**
     * 获取兴趣爱好
     *
     * @return hobby - 兴趣爱好
     */
    public String getHobby() {
        return hobby;
    }

    /**
     * 设置兴趣爱好
     *
     * @param hobby 兴趣爱好
     */
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    /**
     * 获取最后一次登录IP
     *
     * @return ip - 最后一次登录IP
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置最后一次登录IP
     *
     * @param ip 最后一次登录IP
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 获取最新登录时间
     *
     * @return login_time - 最新登录时间
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * 设置最新登录时间
     *
     * @param loginTime 最新登录时间
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取创建人
     *
     * @return create_user - 创建人
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 设置创建人
     *
     * @param createUser 创建人
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取更新人
     *
     * @return update_user - 更新人
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * 设置更新人
     *
     * @param updateUser 更新人
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * 获取是否逻辑删除0-未删除，1-已删除
     *
     * @return del - 是否逻辑删除0-未删除，1-已删除
     */
    public Integer getDel() {
        return del;
    }

    /**
     * 设置是否逻辑删除0-未删除，1-已删除
     *
     * @param del 是否逻辑删除0-未删除，1-已删除
     */
    public void setDel(Integer del) {
        this.del = del;
    }
}