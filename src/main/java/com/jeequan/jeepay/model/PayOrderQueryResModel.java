package com.jeequan.jeepay.model;

/**
 * 支付查单响应实体类
 * @author jmdhappy
 * @site https://www.jeepay.vip
 * @date 2021-06-08 11:00
 */
public class PayOrderQueryResModel extends JeepayObject {

    /**
     * 支付订单号
     */
    private String payOrderId;

    /**
     * 商户号
     */
    private String mchNo;

    /**
     * 应用ID
     */
    private String appId;

    /**
     * 商户订单号
     */
    private String mchOrderNo;

    /**
     * 支付接口
     */
    private String ifCode;

    /**
     * 支付方式
     */
    private String wayCode;

    /**
     * 支付金额,单位分
     */
    private Long amount;

    /**
     * 三位货币代码,人民币:cny
     */
    private String currency;

    /**
     * 支付订单状态
     * 0-订单生成
     * 1-支付中
     * 2-支付成功
     * 3-支付失败
     * 4-已撤销
     * 5-已退款
     * 6-订单关闭
     */
    private int state;

    /**
     * 客户端IPV4地址
     */
    private String clientIp;

    /**
     * 商品标题
     */
    private String subject;

    /**
     * 商品描述
     */
    private String body;

    /**
     * 渠道订单号
     */
    private String channelOrderNo;

    /**
     * 渠道错误码
     */
    private String errCode;

    /**
     * 渠道错误描述
     */
    private String errMsg;

    /**
     * 扩展参数
     */
    private String extParam;

    /**
     * 订单创建时间,13位时间戳
     */
    private Long createdAt;

    /**
     * 订单支付成功时间,13位时间戳
     */
    private Long successTime;


    ///////////   以下扩展参数如需同步传递需在商户后台配置  ////////////////////////


    /**
     * 商户门店ID
     */
    private Long storeId;

    /**
     * 经度
     */
    private String lng;

    /**
     * 纬度
     */
    private String lat;

    /**
     * 码牌ID
     */
    private Long qrcId;

    /**
     * 支付方式代码分类
     */
    private String wayCodeType;

    /**
     * 商户手续费费率快照
     */
    private String mchFeeRate;

    /**
     * 商户实际手续费,单位分 ( 订单手续费 - 手续费退还金额 )
     */
    private Long mchFeeAmount;

    /**
     * 渠道用户标识,如微信openId,支付宝账号
     */
    private String channelUser;

    /**
     * 订单分账模式：0-该笔订单不允许分账, 1-支付成功按配置自动完成分账, 2-商户手动分账(解冻商户金额)
     */
    private Byte divisionMode;

    /**
     * 买家备注
     */
    private String buyerRemark;

    /**
     * 卖家备注
     */
    private String sellerRemark;

    /**
     * 订单失效时间
     */
    private Long expiredTime;

    /**
     * 支付凭证交易单号
     */
    private String platformOrderNo;

    /**
     * 支付凭证商户单号
     */
    private String platformMchOrderNo;


    public String getPayOrderId() {
        return payOrderId;
    }

    public void setPayOrderId(String payOrderId) {
        this.payOrderId = payOrderId;
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

    public String getIfCode() {
        return ifCode;
    }

    public void setIfCode(String ifCode) {
        this.ifCode = ifCode;
    }

    public String getWayCode() {
        return wayCode;
    }

    public void setWayCode(String wayCode) {
        this.wayCode = wayCode;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getChannelOrderNo() {
        return channelOrderNo;
    }

    public void setChannelOrderNo(String channelOrderNo) {
        this.channelOrderNo = channelOrderNo;
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

    public String getExtParam() {
        return extParam;
    }

    public void setExtParam(String extParam) {
        this.extParam = extParam;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(Long successTime) {
        this.successTime = successTime;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public Long getQrcId() {
        return qrcId;
    }

    public void setQrcId(Long qrcId) {
        this.qrcId = qrcId;
    }

    public String getWayCodeType() {
        return wayCodeType;
    }

    public void setWayCodeType(String wayCodeType) {
        this.wayCodeType = wayCodeType;
    }

    public String getMchFeeRate() {
        return mchFeeRate;
    }

    public void setMchFeeRate(String mchFeeRate) {
        this.mchFeeRate = mchFeeRate;
    }

    public Long getMchFeeAmount() {
        return mchFeeAmount;
    }

    public void setMchFeeAmount(Long mchFeeAmount) {
        this.mchFeeAmount = mchFeeAmount;
    }

    public String getChannelUser() {
        return channelUser;
    }

    public void setChannelUser(String channelUser) {
        this.channelUser = channelUser;
    }

    public Byte getDivisionMode() {
        return divisionMode;
    }

    public void setDivisionMode(Byte divisionMode) {
        this.divisionMode = divisionMode;
    }

    public String getBuyerRemark() {
        return buyerRemark;
    }

    public void setBuyerRemark(String buyerRemark) {
        this.buyerRemark = buyerRemark;
    }

    public String getSellerRemark() {
        return sellerRemark;
    }

    public void setSellerRemark(String sellerRemark) {
        this.sellerRemark = sellerRemark;
    }

    public Long getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Long expiredTime) {
        this.expiredTime = expiredTime;
    }

    public String getPlatformOrderNo() {
        return platformOrderNo;
    }

    public void setPlatformOrderNo(String platformOrderNo) {
        this.platformOrderNo = platformOrderNo;
    }

    public String getPlatformMchOrderNo() {
        return platformMchOrderNo;
    }

    public void setPlatformMchOrderNo(String platformMchOrderNo) {
        this.platformMchOrderNo = platformMchOrderNo;
    }
}
