package com.jeequan.jeepay;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jeequan.jeepay.exception.JeepayException;
import com.jeequan.jeepay.model.PayOrderDivisionExecReqModel;
import com.jeequan.jeepay.model.PayOrderDivisionQueryReqModel;
import com.jeequan.jeepay.request.PayOrderDivisionExecRequest;
import com.jeequan.jeepay.request.PayOrderDivisionQueryRequest;
import com.jeequan.jeepay.response.PayOrderDivisionExecResponse;
import com.jeequan.jeepay.response.PayOrderDivisionQueryResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class PayOrderDivisionReceiverExecTest {

    final static Logger _log = LoggerFactory.getLogger(PayOrderDivisionReceiverExecTest.class);

    @BeforeAll
    public static void initApiKey() {
        Jeepay.setApiBase(JeepayTestData.getApiBase());
        Jeepay.apiKey = JeepayTestData.getApiKey();
        Jeepay.mchNo = JeepayTestData.getMchNo();
        Jeepay.appId = JeepayTestData.getAppId();
    }

    @Test
    public void testPayOrderDivisionExec() {
        // 分账接口文档：https://docs.jeequan.com/docs/jeepay/division_api
        JeepayClient jeepayClient = JeepayClient.getInstance(Jeepay.appId, Jeepay.apiKey, Jeepay.getApiBase());
        PayOrderDivisionExecRequest request = new PayOrderDivisionExecRequest();
        PayOrderDivisionExecReqModel model = new PayOrderDivisionExecReqModel();
        request.setBizModel(model);
        model.setMchNo(Jeepay.mchNo);                       // 商户号
        model.setAppId(jeepayClient.getAppId());            // 应用ID
        model.setPayOrderId("P1792369673117708289");
        model.setUseSysAutoDivisionReceivers((byte) 0);

        JSONArray receviers = new JSONArray();
        receviers.add(JSONObject.parseObject("{receiverId: '800002', receiverGroupId: '', divisionProfit: '0.1'}"));
        receviers.add(JSONObject.parseObject("{receiverId: '800001', receiverGroupId: '', divisionProfit: '0.2'}"));

        model.setReceivers(receviers.toJSONString());

        try {
            PayOrderDivisionExecResponse response = jeepayClient.execute(request);
            _log.info("验签结果：{}", response.checkSign(Jeepay.apiKey));
            // 判断转账发起是否成功（并不代表转账成功）
            if(response.isSuccess(Jeepay.apiKey)) {
                _log.info("渠道分账订单号：{}， 分账成功", response.get().getChannelBatchOrderId());
                _log.info("渠道分账批次号：{}， 分账成功", response.get().getBatchOrderId());

            }else {
                _log.info("分账失败：payOrderId：{}", model.getPayOrderId());
                _log.info("通道错误码：{}", response.get().getErrCode());
                _log.info("通道错误信息：{}", response.get().getErrMsg());
            }
        } catch (JeepayException e) {
            _log.error(e.getMessage());
        }

    }


    @Test
    public void testPayOrderDivisionQuery() {
        // 分账接口文档：https://docs.jeequan.com/docs/jeepay/division_api
        JeepayClient jeepayClient = JeepayClient.getInstance(Jeepay.appId, Jeepay.apiKey, Jeepay.getApiBase());
        PayOrderDivisionQueryRequest request = new PayOrderDivisionQueryRequest();
        PayOrderDivisionQueryReqModel model = new PayOrderDivisionQueryReqModel();
        request.setBizModel(model);
        model.setMchNo(Jeepay.mchNo);                       // 商户号
        model.setAppId(jeepayClient.getAppId());            // 应用ID
        model.setPayOrderId("P1792369673117708289");
        model.setBatchOrderId("D1792435159956271105");
//        model.setReceiverId(800001L);


        try {
            PayOrderDivisionQueryResponse response = jeepayClient.execute(request);
            _log.info("验签结果：{}", response.checkSign(Jeepay.apiKey));
            if(response.isSuccess(Jeepay.apiKey)) {
                _log.info("渠道分账批次号：{}， 分账查询成功", response.get().getRecords());

            }else {
                _log.info("分账查询失败：payOrderId：{}", model.getPayOrderId());
            }
        } catch (JeepayException e) {
            _log.error(e.getMessage());
        }
    }

}
