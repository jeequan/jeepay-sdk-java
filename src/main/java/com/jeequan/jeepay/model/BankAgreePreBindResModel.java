package com.jeequan.jeepay.model;

/***
* 银行卡协议支付预绑卡
*
* @author terrfly
* @site https://www.jeequan.com
* @date 2024/3/22 9:55
*/
public class BankAgreePreBindResModel extends JeepayObject {

    /**
     * 商户号
     */
    private String mchNo;

    /**
     * 应用ID
     */
    private String appId;

    /**
     * recordId
     */
    private String recordId;

    /**
     * signRequestNo
     */
    private String signRequestNo;

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

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getSignRequestNo() {
        return signRequestNo;
    }

    public void setSignRequestNo(String signRequestNo) {
        this.signRequestNo = signRequestNo;
    }
}
