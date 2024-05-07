package com.jeequan.jeepay.model;

/***
 * barcode条码换取 openId
 *
 * @author terrfly
 * @site https://www.jeequan.com
 * @date 2024/1/23 14:31
 */
public class QueryOpenIdByBarcodeResModel extends JeepayObject {

    /**
     * 商户号
     */
    private String mchNo;

    /**
     * 应用ID
     */
    private String appId;

    /**
     * openId
     */
    private String openId;

    /**
     * subOpenId
     */
    private String subOpenId;

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

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getSubOpenId() {
        return subOpenId;
    }

    public void setSubOpenId(String subOpenId) {
        this.subOpenId = subOpenId;
    }
}
