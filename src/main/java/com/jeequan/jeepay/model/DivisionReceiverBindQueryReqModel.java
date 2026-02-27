package com.jeequan.jeepay.model;

import com.jeequan.jeepay.ApiField;


/***
* 分账用户绑定状态查询
*
* @author yr
* @site https://www.jeepay.vip
* @date 2024/12/11 08:43
*/
public class DivisionReceiverBindQueryReqModel extends JeepayObject {

    private static final long serialVersionUID = -3998573128290306948L;

    @ApiField("pas")
    private String pas;

    @ApiField("mchNo")
    private String mchNo;      // 商户号

    @ApiField("appId")
    private String appId;      // 应用ID

    /** receiverId   **/
    @ApiField("receiverId")
    private Long receiverId;

    /** 商户分账用户ID **/
    @ApiField("mchReceiverId")
    private String mchReceiverId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public String getMchReceiverId() {
        return mchReceiverId;
    }

    public void setMchReceiverId(String mchReceiverId) {
        this.mchReceiverId = mchReceiverId;
    }
}
