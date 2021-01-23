package com.ist.kafka.consumer.domain;

import java.util.Date;

public class ShopApp {
    private Integer id;

    private String appId;

    private String appName;

    private String appSecret;

    private Integer status;

    private String developId;

    private String developName;

    private String createUserId;

    private Date createDate;

    private String lastModifiedId;

    private Date lastModified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret == null ? null : appSecret.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDevelopId() {
        return developId;
    }

    public void setDevelopId(String developId) {
        this.developId = developId == null ? null : developId.trim();
    }

    public String getDevelopName() {
        return developName;
    }

    public void setDevelopName(String developName) {
        this.developName = developName == null ? null : developName.trim();
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId == null ? null : createUserId.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getLastModifiedId() {
        return lastModifiedId;
    }

    public void setLastModifiedId(String lastModifiedId) {
        this.lastModifiedId = lastModifiedId == null ? null : lastModifiedId.trim();
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }
}