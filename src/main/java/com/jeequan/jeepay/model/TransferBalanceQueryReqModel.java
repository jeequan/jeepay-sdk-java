package com.jeequan.jeepay.model;

import com.jeequan.jeepay.ApiField;

/***
* 转账可用余额查单请求实体类
*
* @author zx
* @site https://www.jeepay.vip
* @date 2021/8/16 16:08
*/
public class TransferBalanceQueryReqModel extends JeepayObject {

    private static final long serialVersionUID = -3998573128290306948L;

    @ApiField("pas")
    private String pas;

    @ApiField("mchNo")
    private String mchNo;      // 商户号

    @ApiField("appId")
    private String appId;      // 应用ID

    @ApiField("ifCode")
    private String ifCode;      // 支付接口

    public TransferBalanceQueryReqModel() {
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

    public String getPas() {
        return pas;
    }

    public void setPas(String pas) {
        this.pas = pas;
    }
}
