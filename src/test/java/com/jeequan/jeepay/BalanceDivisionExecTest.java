package com.jeequan.jeepay;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jeequan.jeepay.exception.JeepayException;
import com.jeequan.jeepay.model.BalanceDivisionExecReqModel;
import com.jeequan.jeepay.model.BalanceDivisionQueryReqModel;
import com.jeequan.jeepay.request.BalanceDivisionExecRequest;
import com.jeequan.jeepay.request.BalanceDivisionQueryRequest;
import com.jeequan.jeepay.response.BalanceDivisionExecResponse;
import com.jeequan.jeepay.response.BalanceDivisionQueryResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class BalanceDivisionExecTest {

    final static Logger _log = LoggerFactory.getLogger(BalanceDivisionExecTest.class);

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
        BalanceDivisionExecRequest request = new BalanceDivisionExecRequest();
        BalanceDivisionExecReqModel model = new BalanceDivisionExecReqModel();
        request.setBizModel(model);
        model.setMchNo(Jeepay.mchNo);                       // 商户号
        model.setAppId(jeepayClient.getAppId());            // 应用ID
        model.setMchDivisionNo("1792369673117708282");
        model.setIfCode("demomockpay");
        model.setTotalAmount(1L);

        JSONArray receviers = new JSONArray();
        receviers.add(JSONObject.parseObject("{receiverId: '6', divisionAmount: '1'}"));

        model.setReceivers(receviers.toJSONString());

        try {
            BalanceDivisionExecResponse response = jeepayClient.execute(request);
            _log.info("验签结果：{}", response.checkSign(Jeepay.apiKey));
            // 判断转账发起是否成功（并不代表转账成功）
            if(response.isSuccess(Jeepay.apiKey)) {
                _log.info("渠道分账订单号：{}， 分账成功", response.get().getChannelBatchOrderId());
                _log.info("渠道分账批次号：{}， 分账成功", response.get().getBatchOrderId());

            }else {
                _log.info("通道错误码：{}", response.get().getErrCode());
                _log.info("通道错误信息：{}", response.get().getErrMsg());
            }
        } catch (JeepayException e) {
            _log.error(e.getMessage());
        }

    }


    @Test
    public void testBalanceDivisionQuery() {
        // 分账接口文档：https://docs.jeequan.com/docs/jeepay/division_api
        JeepayClient jeepayClient = JeepayClient.getInstance(Jeepay.appId, Jeepay.apiKey, Jeepay.getApiBase());
        BalanceDivisionQueryRequest request = new BalanceDivisionQueryRequest();
        BalanceDivisionQueryReqModel model = new BalanceDivisionQueryReqModel();
        request.setBizModel(model);
        model.setMchNo(Jeepay.mchNo);                       // 商户号
        model.setAppId(jeepayClient.getAppId());            // 应用ID
        // model.setPayOrderId("P1792369673117708289");
        model.setMchDivisionNo("1792369673117708282");
//        model.setReceiverId(800001L);


        try {
            BalanceDivisionQueryResponse response = jeepayClient.execute(request);
            _log.info("验签结果：{}", response.checkSign(Jeepay.apiKey));
            if(response.isSuccess(Jeepay.apiKey)) {
                _log.info("渠道分账批次号：{}， 分账查询成功", response.get().getBatchOrderId());

            }else {
                _log.info("分账查询失败：mchDivisionNo：{}，batchOrderId：{}", model.getMchDivisionNo(), model.getBatchOrderId());
            }
        } catch (JeepayException e) {
            _log.error(e.getMessage());
        }
    }


}
