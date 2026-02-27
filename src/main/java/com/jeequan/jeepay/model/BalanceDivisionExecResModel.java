package com.jeequan.jeepay.model;

/***
 * 余额分账响应结果
 *
 * @author terrfly
 * @site https://www.jeepay.vip
 * @date 2021/8/27 10:19
 */
public class BalanceDivisionExecResModel extends JeepayObject {

    /**
     * 分账状态 1-分账成功, 2-分账失败, 3-待分账, 4-分账中
     */
    private Byte state;

    /**
     * 上游分账批次号
     */
    private String channelBatchOrderId;

    /**
     * 系统分账批次号
     */
    private String batchOrderId;

    /**
     * 商户分账单号
     */
    private String mchDivisionNo;

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

    public String getChannelBatchOrderId() {
        return channelBatchOrderId;
    }

    public void setChannelBatchOrderId(String channelBatchOrderId) {
        this.channelBatchOrderId = channelBatchOrderId;
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
