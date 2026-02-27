package com.jeequan.jeepay.model;

/***
 * 订单分账回退 查询响应结果
 *
 * @author yr
 * @site https://www.jeepay.vip
 * @date 2025/11/21 10:19
 */
public class OrderDivisionRefundQueryResModel extends JeepayObject {

    /**
     * 分账回退状态: 0-退款中 1-退款成功 2-退款失败
     */
    private Byte state;

    /**
     * 分账回退单号
     **/
    private String divisionRefundId;

    /**
     * 商户回退单号
     **/
    private String mchRefundNo;

    /**
     * 上游回退单号
     */
    private String channelOrderNo;

    /**
     * 系统分账批次号
     */
    private String batchOrderId;

    /** 回退金额 */
    private Long refundAmount;

    /**
     * 支付渠道错误码
     */
    private String errCode;

    /**
     * 支付渠道错误信息
     */
    private String errMsg;

    /** 备注 */
    private String remark;

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
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

    public Long getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Long refundAmount) {
        this.refundAmount = refundAmount;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
