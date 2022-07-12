package com.jeequan.jeepay.model;

import com.jeequan.jeepay.ApiField;

public class ChannelUserReqModel extends JeepayObject {

    private static final long serialVersionUID = -5120697539129675241L;
    @ApiField("ifCode")
    String ifCode;
    @ApiField("redirectUrl")
    String redirectUrl;
    @ApiField("mchNo")
    private String mchNo;
    @ApiField("appId")
    private String appId;

    public ChannelUserReqModel() {
    }

    public String getIfCode() {
        return ifCode;
    }

    public void setIfCode(String ifCode) {
        this.ifCode = ifCode;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getMchNo() {
        return mchNo;
    }

    public void setMchNo(String mchNo) {
        this.mchNo = mchNo;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}
