package com.typealpha.notecms.bean;

/**
 * 存储用户用的bean类
 */
public class User {
    /** ID是自定的，不可以和其他用户重复 */
    String id;
    /** 密码 */
    String password;
    /** 用户昵称 */
    String nickname;
    /** 用户简历 */
    String bio;
    /** 用户权限
     * 0:游客
     * 1:普通用户
     * 2:管理员
     * 3:超级管理员
     */
    Integer authority;

    public User() {
    }

    public User(String id, String password, String nickname, String bio, Integer authority) {
        this.id = id;
        this.password = password;
        this.nickname = nickname;
        this.bio = bio;
        this.authority = authority;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getAuthority() {
        return authority;
    }

    public void setAuthority(Integer authority) {
        this.authority = authority;
    }
}
