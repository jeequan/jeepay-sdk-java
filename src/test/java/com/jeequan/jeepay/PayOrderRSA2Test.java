package com.jeequan.jeepay;

import com.alibaba.fastjson.JSONObject;
import com.jeequan.jeepay.exception.JeepayException;
import com.jeequan.jeepay.model.PayOrderCloseReqModel;
import com.jeequan.jeepay.model.PayOrderCreateReqModel;
import com.jeequan.jeepay.model.PayOrderQueryReqModel;
import com.jeequan.jeepay.request.PayOrderCloseRequest;
import com.jeequan.jeepay.request.PayOrderCreateRequest;
import com.jeequan.jeepay.request.PayOrderQueryRequest;
import com.jeequan.jeepay.response.PayOrderCloseResponse;
import com.jeequan.jeepay.response.PayOrderCreateResponse;
import com.jeequan.jeepay.response.PayOrderQueryResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

class PayOrderRSA2Test {

    final static Logger _log = LoggerFactory.getLogger(PayOrderRSA2Test.class);

    @BeforeAll
    public static void initApiKey() {
        Jeepay.setApiBase(JeepayTestData.getApiBase());
        Jeepay.rsa2AppPrivateKey = JeepayTestData.getRSA2AppPrivateKey();
        Jeepay.rsa2PayPublicKey = JeepayTestData.getRSA2PayPublicKey();
        Jeepay.mchNo = JeepayTestData.getMchNo();
        Jeepay.appId = JeepayTestData.getAppId();
    }

    @Test
    public void testPayOrderQuery() {
        // 支付接口文档：https://docs.jeequan.com/docs/jeepay/payment_api
        JeepayClient jeepayClient = JeepayClient.getInstance(Jeepay.appId, Jeepay.rsa2AppPrivateKey, Jeepay.getApiBase());
        PayOrderQueryRequest request = new PayOrderQueryRequest();
        PayOrderQueryReqModel model = new PayOrderQueryReqModel();
        model.setMchNo(Jeepay.mchNo);                                           // 商户号
        model.setAppId(jeepayClient.getAppId());                                // 应用ID
        model.setPayOrderId("P1526477317539262465");                          // 支付订单号
        request.setBizModel(model);

        try {
            PayOrderQueryResponse response = jeepayClient.executeByRSA2(request);
            _log.info("验签结果：{}", response.checkSignByRsa2(Jeepay.rsa2PayPublicKey));

            if(response.isSuccessByRsa2(Jeepay.rsa2PayPublicKey)) {
                _log.info("订单信息：{}", response);
                _log.info("金额：{}", response.get().getAmount());
            }
        } catch (JeepayException e) {

            e.printStackTrace();
        }

    }

}
