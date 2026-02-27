package com.jeequan.jeepay.model;

import com.jeequan.jeepay.ApiField;

/***
*
* 分账完结接口
* @author terrfly
* @site https://www.jeequan.com
* @date 2024/5/20 14:28
*/
public class PayOrderDivisionFinishReqModel extends JeepayObject {

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

    public String getPas() {
        return pas;
    }

    public void setPas(String pas) {
        this.pas = pas;
    }
}
