package com.jeequan.jeepay.model;

/***
* 银行卡协议支付确认绑卡
*
* @author terrfly
* @site https://www.jeequan.com
* @date 2024/3/22 9:55
*/
public class BankAgreeConfirmBindResModel extends JeepayObject {

    /**
     * 商户号
     */
    private String mchNo;

    /**
     * 应用ID
     */
    private String appId;

    /**
     * protocolNo
     */
    private String protocolNo;

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

    public String getProtocolNo() {
        return protocolNo;
    }

    public void setProtocolNo(String protocolNo) {
        this.protocolNo = protocolNo;
    }
}
