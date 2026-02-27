package com.jeequan.jeepay.model;

import com.jeequan.jeepay.ApiField;


/***
* 分账接收方结算信息修改
*
* @author terrfly
* @site https://www.jeepay.vip
* @date 2021/8/25 10:36
*/
public class DivisionReceiverSettleUpdateReqModel extends JeepayObject {

    private static final long serialVersionUID = -3998573128290306948L;

    @ApiField("pas")
    private String pas;

    @ApiField("mchNo")
    private String mchNo;      // 商户号

    @ApiField("appId")
    private String appId;      // 应用ID

    /** 分账接收者ID   **/
    @ApiField("receiverId")
    private Long receiverId;

    /** 结算账号名称 **/
    @ApiField("settAccountName")
    private String settAccountName;

    /** 结算账号 **/
    @ApiField("settAccountNo")
    private String settAccountNo;

    /** 结算银行名称 **/
    @ApiField("settAccountBankName")
    private String settAccountBankName;

    /** 结算银行开户支行联行号 **/
    @ApiField("settAccountBankBranchCode")
    private String settAccountBankBranchCode;

    /** 结算银行开户支行名称 **/
    @ApiField("settAccountBankBranchName")
    private String settAccountBankBranchName;

    /** 渠道特殊信息 */
    @ApiField("channelExtInfo")
    private String channelExtInfo;

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

    public String getSettAccountName() {
        return settAccountName;
    }

    public void setSettAccountName(String settAccountName) {
        this.settAccountName = settAccountName;
    }

    public String getSettAccountNo() {
        return settAccountNo;
    }

    public void setSettAccountNo(String settAccountNo) {
        this.settAccountNo = settAccountNo;
    }

    public String getSettAccountBankName() {
        return settAccountBankName;
    }

    public void setSettAccountBankName(String settAccountBankName) {
        this.settAccountBankName = settAccountBankName;
    }

    public String getSettAccountBankBranchCode() {
        return settAccountBankBranchCode;
    }

    public void setSettAccountBankBranchCode(String settAccountBankBranchCode) {
        this.settAccountBankBranchCode = settAccountBankBranchCode;
    }

    public String getSettAccountBankBranchName() {
        return settAccountBankBranchName;
    }

    public void setSettAccountBankBranchName(String settAccountBankBranchName) {
        this.settAccountBankBranchName = settAccountBankBranchName;
    }

    public String getChannelExtInfo() {
        return channelExtInfo;
    }

    public void setChannelExtInfo(String channelExtInfo) {
        this.channelExtInfo = channelExtInfo;
    }
}
