package com.jeequan.jeepay.model;

/***
 * 余额分账响应结果
 *
 * @author terrfly
 * @site https://www.jeepay.vip
 * @date 2021/8/27 10:19
 */
public class BalanceDivisionRefundResModel extends JeepayObject {

    /**
     * 分账回退状态: 0-退款中 1-退款成功 2-退款失败
     */
    private Byte state;

    /**
     * 上游回退单号
     */
    private String channelOrderNo;

    /**
     * 系统分账批次号
     */
    private String batchOrderId;

    /**
     * 商户分账单号
     */
    private String mchDivisionNo;

    /**
     * 分账回退单号
     **/
    private String divisionRefundId;

    /**
     * 商户回退单号
     **/
    private String mchRefundNo;

    /**
     * 支付渠道错误码
     */
    private String errCode;

    /**
     * 支付渠道错误信息
     */
    private String errMsg;


    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getChannelOrderNo() {
        return channelOrderNo;
    }

    public void setChannelOrderNo(String channelOrderNo) {
        this.channelOrderNo = channelOrderNo;
    }

    public String getBatchOrderId() {
        return batchOrderId;
    }

    public void setBatchOrderId(String batchOrderId) {
        this.batchOrderId = batchOrderId;
    }

    public String getMchDivisionNo() {
        return mchDivisionNo;
    }

    public void setMchDivisionNo(String mchDivisionNo) {
        this.mchDivisionNo = mchDivisionNo;
    }

    public String getDivisionRefundId() {
        return divisionRefundId;
    }

    public void setDivisionRefundId(String divisionRefundId) {
        this.divisionRefundId = divisionRefundId;
    }

    public String getMchRefundNo() {
        return mchRefundNo;
    }

    public void setMchRefundNo(String mchRefundNo) {
        this.mchRefundNo = mchRefundNo;
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
