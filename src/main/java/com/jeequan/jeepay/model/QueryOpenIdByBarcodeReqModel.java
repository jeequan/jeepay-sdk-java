package com.jeequan.jeepay.model;

import com.jeequan.jeepay.ApiField;

/***
* barcode条码换取 openId
*
* @author terrfly
* @site https://www.jeequan.com
* @date 2024/1/23 14:27
*/
public class QueryOpenIdByBarcodeReqModel extends JeepayObject{

    private static final long serialVersionUID = -5184554341263929245L;


    @ApiField("pas")
    private String pas;

    /**
     * 商户号
     */
    @ApiField("mchNo")
    private String mchNo;
    /**
     * 应用ID
     */
    @ApiField("appId")
    private String appId;
    /**
     * 条码值
     */
    @ApiField("barCode")
    String barCode;
    /**
     * subAppId
     */
    @ApiField("subAppId")
    String subAppId;

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

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getSubAppId() {
        return subAppId;
    }

    public void setSubAppId(String subAppId) {
        this.subAppId = subAppId;
    }
}
