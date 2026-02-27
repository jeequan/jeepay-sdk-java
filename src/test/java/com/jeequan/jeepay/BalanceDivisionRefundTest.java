package com.jeequan.jeepay;

import com.jeequan.jeepay.exception.JeepayException;
import com.jeequan.jeepay.model.BalanceDivisionRefundQueryReqModel;
import com.jeequan.jeepay.model.BalanceDivisionRefundReqModel;
import com.jeequan.jeepay.request.BalanceDivisionRefundQueryRequest;
import com.jeequan.jeepay.request.BalanceDivisionRefundRequest;
import com.jeequan.jeepay.response.BalanceDivisionRefundQueryResponse;
import com.jeequan.jeepay.response.BalanceDivisionRefundResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class BalanceDivisionRefundTest {

    final static Logger _log = LoggerFactory.getLogger(BalanceDivisionRefundTest.class);

    @BeforeAll
    public static void initApiKey() {
        Jeepay.setApiBase(JeepayTestData.getApiBase());
        Jeepay.apiKey = JeepayTestData.getApiKey();
        Jeepay.mchNo = JeepayTestData.getMchNo();
        Jeepay.appId = JeepayTestData.getAppId();
    }

    @Test
    public void testPayOrderDivisionRefund() {
        // 分账接口文档：https://docs.jeequan.com/docs/jeepay/division_api
        JeepayClient jeepayClient = JeepayClient.getInstance(Jeepay.appId, Jeepay.apiKey, Jeepay.getApiBase());
        BalanceDivisionRefundRequest request = new BalanceDivisionRefundRequest();
        BalanceDivisionRefundReqModel model = new BalanceDivisionRefundReqModel();
        request.setBizModel(model);
        model.setMchNo(Jeepay.mchNo);                       // 商户号
        model.setAppId(jeepayClient.getAppId());            // 应用ID
        model.setMchDivisionNo("1741080214792");
        model.setMchRefundNo(System.currentTimeMillis() + "");
        model.setReceiverId(4L);
        model.setRefundAmount(1L);
        model.setRemark("测试aa");

        try {
            BalanceDivisionRefundResponse response = jeepayClient.execute(request);
            _log.info("验签结果：{}", response.checkSign(Jeepay.apiKey));
            // 判断转账发起是否成功（并不代表转账成功）
            if(response.isSuccess(Jeepay.apiKey)) {
                _log.info("渠道分账回退订单号：{}， 回退成功", response.get().getDivisionRefundId());
                _log.info("上游回退单号：{}， 回退成功", response.get().getChannelOrderNo());

            }else {
                _log.info("通道错误码：{}", response.get().getErrCode());
                _log.info("通道错误信息：{}", response.get().getErrMsg());
            }
        } catch (JeepayException e) {
            _log.error(e.getMessage());
        }

    }


    @Test
    public void testBalanceDivisionRefundQuery() {
        // 分账接口文档：https://docs.jeequan.com/docs/jeepay/division_api
        JeepayClient jeepayClient = JeepayClient.getInstance(Jeepay.appId, Jeepay.apiKey, Jeepay.getApiBase());
        BalanceDivisionRefundQueryRequest request = new BalanceDivisionRefundQueryRequest();
        BalanceDivisionRefundQueryReqModel model = new BalanceDivisionRefundQueryReqModel();
        request.setBizModel(model);
        model.setMchNo(Jeepay.mchNo);                       // 商户号
        model.setAppId(jeepayClient.getAppId());            // 应用ID
        // model.setPayOrderId("P1792369673117708289");
        model.setDivisionRefundId("R1896855157590052865");
//        model.setReceiverId(800001L);


        try {
            BalanceDivisionRefundQueryResponse response = jeepayClient.execute(request);
            _log.info("验签结果：{}", response.checkSign(Jeepay.apiKey));
            if(response.isSuccess(Jeepay.apiKey)) {
                _log.info("渠道分账批次号：{}， 分账回退查询成功", response.get().getBatchOrderId());

            }else {
                _log.info("分账查询失败：mchRefundNo：{}，divisionRefundId：{}", model.getMchRefundNo(), model.getDivisionRefundId());
            }
        } catch (JeepayException e) {
            _log.error(e.getMessage());
        }
    }


}
