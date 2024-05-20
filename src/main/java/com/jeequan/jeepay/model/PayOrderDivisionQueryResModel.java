package com.jeequan.jeepay.model;

/***
* 分账查询响应结果
*
* @author terrfly
* @site https://www.jeequan.com
* @date 2024/5/20 15:30
*/
public class PayOrderDivisionQueryResModel extends JeepayObject {

    /** 支付系统订单号 **/
    private String payOrderId;

    /** 系统分账批次号 **/
    private String batchOrderId;

    /** 详细信息 **/
    private String records;

    public String getPayOrderId() {
        return payOrderId;
    }

    public void setPayOrderId(String payOrderId) {
        this.payOrderId = payOrderId;
    }

    public String getBatchOrderId() {
        return batchOrderId;
    }

    public void setBatchOrderId(String batchOrderId) {
        this.batchOrderId = batchOrderId;
    }

    public String getRecords() {
        return records;
    }

    public void setRecords(String records) {
        this.records = records;
    }
}
