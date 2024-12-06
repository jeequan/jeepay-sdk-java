package com.jeequan.jeepay.model;

/***
* 银行卡协议支付 确认支付
*
* @author terrfly
* @site https://www.jeequan.com
* @date 2024/3/22 9:55
*/
public class BankAgreeProtocolpayConfirmResModel extends JeepayObject {

    /**
     * channelState
     */
    private Byte channelState;

    /**
     * errCode
     */
    private String errCode;

    /**
     * errMsg
     */
    private String errMsg;


    public Byte getChannelState() {
        return channelState;
    }

    public void setChannelState(Byte channelState) {
        this.channelState = channelState;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
