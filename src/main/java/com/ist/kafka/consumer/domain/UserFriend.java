package com.ist.kafka.consumer.domain;

import java.util.Date;

public class UserFriend {
    private Long id;

    private Long userid;

    private Short status;

    private Short grouptype;

    private Long friendgroupid;

    private Long fuserid;

    private String markname;

    private Date createtime;

    private Date updatetime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getGrouptype() {
        return grouptype;
    }

    public void setGrouptype(Short grouptype) {
        this.grouptype = grouptype;
    }

    public Long getFriendgroupid() {
        return friendgroupid;
    }

    public void setFriendgroupid(Long friendgroupid) {
        this.friendgroupid = friendgroupid;
    }

    public Long getFuserid() {
        return fuserid;
    }

    public void setFuserid(Long fuserid) {
        this.fuserid = fuserid;
    }

    public String getMarkname() {
        return markname;
    }

    public void setMarkname(String markname) {
        this.markname = markname == null ? null : markname.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}