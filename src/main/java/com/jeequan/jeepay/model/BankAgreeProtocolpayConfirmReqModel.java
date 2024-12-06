package com.jeequan.jeepay.model;

import com.jeequan.jeepay.ApiField;

/***
* 银行卡协议 确认支付
*
* @author terrfly
* @site https://www.jeequan.com
* @date 2024/3/22 9:53
*/
public class BankAgreeProtocolpayConfirmReqModel extends JeepayObject{

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
     * mchOrderNo
     */
    @ApiField("mchOrderNo")
    String mchOrderNo;

    /**
     * payOrderId
     */
    @ApiField("payOrderId")
    String payOrderId;

    /**
     * channelBizData ，第一步响应参数需原样返回。
     */
    @ApiField("channelBizData")
    String channelBizData;

    /**
     * agreeRecordId
     */
    @ApiField("agreeRecordId")
    String agreeRecordId;

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

    public String getMchOrderNo() {
        return mchOrderNo;
    }

    public void setMchOrderNo(String mchOrderNo) {
        this.mchOrderNo = mchOrderNo;
    }

    public String getPayOrderId() {
        return payOrderId;
    }

    public void setPayOrderId(String payOrderId) {
        this.payOrderId = payOrderId;
    }

    public String getChannelBizData() {
        return channelBizData;
    }

    public void setChannelBizData(String channelBizData) {
        this.channelBizData = channelBizData;
    }

    public String getAgreeRecordId() {
        return agreeRecordId;
    }

    public void setAgreeRecordId(String agreeRecordId) {
        this.agreeRecordId = agreeRecordId;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }
}
