package com.typealpha.notecms.bean;

import java.util.Date;

/**
 * 存储文章用的bean类
 */
public class Note {
    /** 纯数字文章ID,自增主键 */
    Integer id;
    /** 文章标题，最多256字 */
    String heading;
    /** 文章发表时间 */
    Date publishTime; //注意这里要在Dao处理一下DATETIME格式
    /** 文章最后更新时间 */
    Date latestUpdate; //DATETIME格式注意
    /** 作者ID */
    String owner;
    /** 文章限制
     * 0:只有最高管理员可见,
     * 1:管理员可见,
     * 2:登录可见,
     * 3:所有人可见
     */
    Integer restrict;
    /** 文章状态
     * 0:正常状态遵照restrict
     * 1:在作者的草稿箱
     * 2:在作者的回收站中
     * 3:被作者删除
     */
    Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Date getLatestUpdate() {
        return latestUpdate;
    }

    public void setLatestUpdate(Date latestUpdate) {
        this.latestUpdate = latestUpdate;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getRestrict() {
        return restrict;
    }

    public void setRestrict(Integer restrict) {
        this.restrict = restrict;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Note() {
    }

    public Note(Integer id, String heading, Date publishTime, Date latestUpdate, String owner, Integer restrict, Integer status) {
        this.id = id;
        this.heading = heading;
        this.publishTime = publishTime;
        this.latestUpdate = latestUpdate;
        this.owner = owner;
        this.restrict = restrict;
        this.status = status;
    }
}
