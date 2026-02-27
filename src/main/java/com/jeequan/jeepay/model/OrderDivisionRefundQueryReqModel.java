package com.jeequan.jeepay.model;

import com.jeequan.jeepay.ApiField;

/***
* 订单分账回退查询
*
* @author yr
* @site https://www.jeepay.vip
* @date 2025/11/26 10:16
*/
public class OrderDivisionRefundQueryReqModel extends JeepayObject {

    private static final long serialVersionUID = -3998573128290306948L;

    @ApiField("pas")
    private String pas;

    @ApiField("mchNo")
    private String mchNo;      // 商户号

    @ApiField("appId")
    private String appId;      // 应用ID

    @ApiField("divisionRefundId")
    private String divisionRefundId; // 支付系统分账回退单号

    @ApiField("mchRefundNo")
    private String mchRefundNo; // 商户回退单号

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

    public String getDivisionRefundId() {
        return divisionRefundId;
    }

    public void setDivisionRefundId(String divisionRefundId) {
        this.divisionRefundId = divisionRefundId;
    }

    public String getMchRefundNo() {
        return mchRefundNo;
    }

    public void setMchRefundNo(String mchRefundNo) {
        this.mchRefundNo = mchRefundNo;
    }

}
