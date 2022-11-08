package com.jeequan.jeepay.model;

import com.jeequan.jeepay.ApiField;

/**
 * 退款下单请求实体类
 * @author jmdhappy
 * @site https://www.jeepay.vip
 * @date 2021-06-18 09:00
 */
public class RefundOrderCreateReqModel extends JeepayObject {

    private static final long serialVersionUID = -3998573128290306948L;

    @ApiField("pas")
    private String pas;
    @ApiField("mchNo")
    private String mchNo;      // 商户号
    @ApiField("appId")
    private String appId;      // 应用ID
    @ApiField("mchOrderNo")
    String mchOrderNo;          // 商户订单号
    @ApiField("payOrderId")
    String payOrderId;          // 支付系统订单号
    @ApiField("mchRefundNo")
    String mchRefundNo;         // 退款单号
    @ApiField("refundAmount")
    Long refundAmount;          // 退款金额
    @ApiField("currency")
    String currency;            // 货币代码，当前只支持cny
    @ApiField("refundReason")
    String refundReason;        // 退款原因
    @ApiField("clientIp")
    String clientIp;            // 客户端IP
    @ApiField("notifyUrl")
    String notifyUrl;           // 异步通知地址
    @ApiField("channelExtra")
    String channelExtra;        // 特定渠道额外支付参数
    @ApiField("extParam")
    String extParam;            // 商户扩展参数

    public RefundOrderCreateReqModel() {
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

    public String getMchOrderNo() {
        return mchOrderNo;
    }

    public void setMchOrderNo(String mchOrderNo) {
        this.mchOrderNo = mchOrderNo;
    }

    public String getPayOrderId() {
        return payOrderId;
    }

    public void setPayOrderId(String payOrderId) {
        this.payOrderId = payOrderId;
    }

    public String getMchRefundNo() {
        return mchRefundNo;
    }

    public void setMchRefundNo(String mchRefundNo) {
        this.mchRefundNo = mchRefundNo;
    }

    public Long getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Long refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getRefundReason() {
        return refundReason;
    }

    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getChannelExtra() {
        return channelExtra;
    }

    public void setChannelExtra(String channelExtra) {
        this.channelExtra = channelExtra;
    }

    public String getExtParam() {
        return extParam;
    }

    public void setExtParam(String extParam) {
        this.extParam = extParam;
    }

    public String getPas() {
        return pas;
    }

    public void setPas(String pas) {
        this.pas = pas;
    }
}
