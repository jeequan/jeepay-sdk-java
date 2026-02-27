package com.jeequan.jeepay.model;

import com.jeequan.jeepay.ApiField;

/***
* 发起余额分账
*
* @author terrfly
* @site https://www.jeepay.vip
* @date 2021/8/27 10:16
*/
public class BalanceDivisionExecReqModel extends JeepayObject {

    private static final long serialVersionUID = -3998573128290306948L;

    @ApiField("pas")
    private String pas;

    @ApiField("mchNo")
    private String mchNo;      // 商户号

    @ApiField("appId")
    private String appId;      // 应用ID

    /** 商户分账单号 **/
    @ApiField("mchDivisionNo")
    private String mchDivisionNo;

    /** 支付接口代码 **/
    @ApiField("ifCode")
    private String ifCode;

    /**
     * 分账总金额
     **/
    @ApiField("totalAmount")
    private Long totalAmount;

    /** 接收者账号列表（JSONArray 转换为字符串类型）
     * 参考：
     * [{
     *     receiverId: 800001,
     *     divisionAmount: 100 ( 实际分账金额，单位：分 )
     * }]
     * **/
    @ApiField("receivers")
    private String receivers;

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

    public String getMchDivisionNo() {
        return mchDivisionNo;
    }

    public void setMchDivisionNo(String mchDivisionNo) {
        this.mchDivisionNo = mchDivisionNo;
    }

    public String getIfCode() {
        return ifCode;
    }

    public void setIfCode(String ifCode) {
        this.ifCode = ifCode;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getReceivers() {
        return receivers;
    }

    public void setReceivers(String receivers) {
        this.receivers = receivers;
    }
}
