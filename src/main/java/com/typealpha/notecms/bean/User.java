package com.typealpha.notecms.bean;

/**
 * 存储用户用的bean类
 */
public class User {
    /** ID是自定的，不可以和其他用户重复 */
    String id;
    /** 密码 */
    String password;
    /** cookie */
    String cookie;
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

    public User(String id, String password, String cookie, String nickname, String bio, Integer authority) {
        this.id = id;
        this.password = password;
        this.cookie = cookie;
        this.nickname = nickname;
        this.bio = bio;
        this.authority = authority;
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

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Integer getAuthority() {
        return authority;
    }

    public void setAuthority(Integer authority) {
        this.authority = authority;
    }
}
