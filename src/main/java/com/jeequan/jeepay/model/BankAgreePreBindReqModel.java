package com.jeequan.jeepay.model;

import com.jeequan.jeepay.ApiField;

/***
* 银行卡协议支付预绑卡
*
* @author terrfly
* @site https://www.jeequan.com
* @date 2024/3/22 9:53
*/
public class BankAgreePreBindReqModel extends JeepayObject{

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
     * 用户ID
     */
    @ApiField("userId")
    String userId;

    /**
     * 银行卡号
     */
    @ApiField("bankcardNo")
    String bankcardNo;

    /**
     * 持卡人姓名
     */
    @ApiField("bankcardName")
    String bankcardName;

    /**
     * 持卡人证件号
     */
    @ApiField("idcardNo")
    String idcardNo;

    /**
     * 持卡人手机号
     */
    @ApiField("telphoneNo")
    String telphoneNo;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBankcardNo() {
        return bankcardNo;
    }

    public void setBankcardNo(String bankcardNo) {
        this.bankcardNo = bankcardNo;
    }

    public String getBankcardName() {
        return bankcardName;
    }

    public void setBankcardName(String bankcardName) {
        this.bankcardName = bankcardName;
    }

    public String getIdcardNo() {
        return idcardNo;
    }

    public void setIdcardNo(String idcardNo) {
        this.idcardNo = idcardNo;
    }

    public String getTelphoneNo() {
        return telphoneNo;
    }

    public void setTelphoneNo(String telphoneNo) {
        this.telphoneNo = telphoneNo;
    }
}
