package com.jeequan.jeepay.model;

import com.jeequan.jeepay.ApiField;

/***
*
* 分账查询接口
* @author terrfly
* @site https://www.jeequan.com
* @date 2024/5/20 14:28
*/
public class PayOrderDivisionQueryReqModel extends JeepayObject {

    private static final long serialVersionUID = -3998573128290306948L;

    @ApiField("pas")
    private String pas;

    @ApiField("mchNo")
    private String mchNo;      // 商户号

    @ApiField("appId")
    private String appId;      // 应用ID

    /** 商户订单号 **/
    @ApiField("mchOrderNo")
    private String mchOrderNo;

    /** 支付系统订单号 **/
    @ApiField("payOrderId")
    private String payOrderId;

    /** 分账接收者ID（非必填） **/
    @ApiField("receiverId")
    private Long receiverId;

    /** 系统分账批次号 **/
    @ApiField("batchOrderId")
    private String batchOrderId;

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

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public String getBatchOrderId() {
        return batchOrderId;
    }

    public void setBatchOrderId(String batchOrderId) {
        this.batchOrderId = batchOrderId;
    }

    public String getPas() {
        return pas;
    }

    public void setPas(String pas) {
        this.pas = pas;
    }
}
