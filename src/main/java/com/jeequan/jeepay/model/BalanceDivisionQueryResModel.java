package com.jeequan.jeepay.model;

/***
 * 余额分账查询响应结果
 *
 * @author terrfly
 * @site https://www.jeepay.vip
 * @date 2021/8/27 10:19
 */
public class BalanceDivisionQueryResModel extends JeepayObject {

    /** 系统分账批次号 **/
    private String batchOrderId;

    /** 商户分账单号 */
    private String mchDivisionNo;

    /**上游分账批次号 */
    private String channelBatchOrderId;

    /** 详细信息 **/
    private String records;

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

    public String getChannelBatchOrderId() {
        return channelBatchOrderId;
    }

    public void setChannelBatchOrderId(String channelBatchOrderId) {
        this.channelBatchOrderId = channelBatchOrderId;
    }

    public String getRecords() {
        return records;
    }

    public void setRecords(String records) {
        this.records = records;
    }
}
