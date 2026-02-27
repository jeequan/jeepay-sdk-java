package com.jeequan.jeepay.model;

import com.jeequan.jeepay.ApiField;

/***
* 余额分账回退
*
* @author terrfly
* @site https://www.jeepay.vip
* @date 2021/8/27 10:16
*/
public class BalanceDivisionRefundReqModel extends JeepayObject {

    private static final long serialVersionUID = -3998573128290306948L;

    @ApiField("pas")
    private String pas;

    @ApiField("mchNo")
    private String mchNo;      // 商户号

    @ApiField("appId")
    private String appId;      // 应用ID

    /** 系统分账批次号 **/
    @ApiField("batchOrderId")
    private String batchOrderId;

    /** 商户分账单号 **/
    @ApiField("mchDivisionNo")
    private String mchDivisionNo;

    /** 商户回退单号 **/
    @ApiField("mchRefundNo")
    private String mchRefundNo;

    /** 分账接收者ID **/
    @ApiField("receiverId")
    private Long receiverId;

    /** 回退金额 **/
    @ApiField("refundAmount")
    private Long refundAmount;

    /** 备注 **/
    @ApiField("remark")
    private String remark;

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

    public String getBatchOrderId() {
        return batchOrderId;
    }

    public void setBatchOrderId(String batchOrderId) {
        this.batchOrderId = batchOrderId;
    }

    public String getMchDivisionNo() {
        return mchDivisionNo;
    }

    public void setMchDivisionNo(String mchDivisionNo) {
        this.mchDivisionNo = mchDivisionNo;
    }

    public String getMchRefundNo() {
        return mchRefundNo;
    }

    public void setMchRefundNo(String mchRefundNo) {
        this.mchRefundNo = mchRefundNo;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public Long getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Long refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
