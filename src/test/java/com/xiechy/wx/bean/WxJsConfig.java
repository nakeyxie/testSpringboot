package com.xiechy.wx.bean;

/**
 * 微信JS api 配置信息
 */
public class WxJsConfig {

    private boolean isDebug;
    private String appId;
    private long timestamp;
    private String nonceStr;
    private String signature;

    public boolean isDebug() {
        return isDebug;
    }

    public WxJsConfig setDebug(boolean debug) {
        isDebug = debug;
        return this;
    }

    public String getAppId() {
        return appId;
    }

    public WxJsConfig setAppId(String appId) {
        this.appId = appId;
        return this;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public WxJsConfig setTimestamp(long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public WxJsConfig setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
        return this;
    }

    public String getSignature() {
        return signature;
    }

    public WxJsConfig setSignature(String signature) {
        this.signature = signature;
        return this;
    }
}
