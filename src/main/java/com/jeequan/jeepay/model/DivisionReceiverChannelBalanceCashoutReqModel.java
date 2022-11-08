package com.jeequan.jeepay.model;

import com.jeequan.jeepay.ApiField;


/***
* 分账渠道余额提现
*
* @author terrfly
* @site https://www.jeequan.com
* @date 2022/5/11 15:03
*/
public class DivisionReceiverChannelBalanceCashoutReqModel extends JeepayObject {

    @ApiField("pas")
    private String pas;

    @ApiField("mchNo")
    private String mchNo;      // 商户号

    @ApiField("appId")
    private String appId;      // 应用ID

    /** receiverId   **/
    @ApiField("receiverId")
    private Long receiverId;

    /** 提现金额： 单位：分   **/
    @ApiField("cashoutAmount")
    private Long cashoutAmount;

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

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public Long getCashoutAmount() {
        return cashoutAmount;
    }

    public void setCashoutAmount(Long cashoutAmount) {
        this.cashoutAmount = cashoutAmount;
    }

    public String getPas() {
        return pas;
    }

    public void setPas(String pas) {
        this.pas = pas;
    }
}
