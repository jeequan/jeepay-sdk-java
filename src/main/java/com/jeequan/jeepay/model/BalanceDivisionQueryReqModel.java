package com.jeequan.jeepay.model;

import com.jeequan.jeepay.ApiField;

/***
* 余额分账查询
*
* @author terrfly
* @site https://www.jeepay.vip
* @date 2021/8/27 10:16
*/
public class BalanceDivisionQueryReqModel extends JeepayObject {

    private static final long serialVersionUID = -3998573128290306948L;

    @ApiField("pas")
    private String pas;

    @ApiField("mchNo")
    private String mchNo;      // 商户号

    @ApiField("appId")
    private String appId;      // 应用ID

    @ApiField("batchOrderId")
    private String batchOrderId; // 支付系统分账批次号

    @ApiField("mchDivisionNo")
    private String mchDivisionNo; // 商户分账单号

    @ApiField("receiverId")
    private Long receiverId; // 分账接收者ID（非必填）

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

    public String getBatchOrderId() {
        return batchOrderId;
    }

    public void setBatchOrderId(String batchOrderId) {
        this.batchOrderId = batchOrderId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }
}
