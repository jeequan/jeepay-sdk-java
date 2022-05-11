package com.jeequan.jeepay.model;

/**
* 分账渠道余额提现
*
* @author terrfly
* @site https://www.jeequan.com
* @date 2022/5/11 15:14
*/
public class DivisionReceiverChannelBalanceCashoutResModel extends JeepayObject {

    /**
     * 分账接收者ID
     */
    private Long receiverId;

    /** 提现状态: 1-成功, 0-失败  **/
    private Byte state;

    /** 渠道返回错误代码 **/
    private String errCode;

    /** 渠道返回错误信息 **/
    private String errMsg;

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
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
