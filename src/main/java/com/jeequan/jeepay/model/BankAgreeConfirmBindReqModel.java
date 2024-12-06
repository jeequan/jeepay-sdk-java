package com.jeequan.jeepay.model;

import com.jeequan.jeepay.ApiField;

/***
* 银行卡协议支付确认绑卡
*
* @author terrfly
* @site https://www.jeequan.com
* @date 2024/3/22 9:53
*/
public class BankAgreeConfirmBindReqModel extends JeepayObject{

    private static final long serialVersionUID = -5184554341263929245L;


    @ApiField("pas")
    private String pas;

    /**
     * 商户号
     */
    @ApiField("mchNo")
    private String mchNo;
    /**
     * 应用ID
     */
    @ApiField("appId")
    private String appId;

    /**
     * 接口名称
     */
    @ApiField("ifCode")
    String ifCode;

    /**
     * recordId
     */
    @ApiField("recordId")
    String recordId;

    /**
     * smsCode
     */
    @ApiField("smsCode")
    String smsCode;


    public String getPas() {
        return pas;
    }

    public void setPas(String pas) {
        this.pas = pas;
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

    public String getIfCode() {
        return ifCode;
    }

    public void setIfCode(String ifCode) {
        this.ifCode = ifCode;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }
}
