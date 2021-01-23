package com.ist.kafka.consumer.domain;

import java.util.Date;

public class Msg {
    private Long timeid;

    private Short msgtype;

    private Short contenttype;

    private String content;

    private Long sender;

    private Long no;

    private Short status;

    private Date createtime;

    private Date updatetime;

    private Short type;

    private Long talker;

    private Integer shopid;

    private String receiverId;

    public Long getTimeid() {
        return timeid;
    }

    public void setTimeid(Long timeid) {
        this.timeid = timeid;
    }

    public Short getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(Short msgtype) {
        this.msgtype = msgtype;
    }

    public Short getContenttype() {
        return contenttype;
    }

    public void setContenttype(Short contenttype) {
        this.contenttype = contenttype;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Long getSender() {
        return sender;
    }

    public void setSender(Long sender) {
        this.sender = sender;
    }

    public Long getNo() {
        return no;
    }

    public void setNo(Long no) {
        this.no = no;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
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

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Long getTalker() {
        return talker;
    }

    public void setTalker(Long talker) {
        this.talker = talker;
    }

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }
}