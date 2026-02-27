package com.jeequan.jeepay;

import com.alibaba.fastjson.JSON;
import com.jeequan.jeepay.exception.JeepayException;
import com.jeequan.jeepay.model.DivisionReceiverChannelBalanceCashoutReqModel;
import com.jeequan.jeepay.request.DivisionReceiverChannelBalanceCashoutRequest;
import com.jeequan.jeepay.response.DivisionReceiverChannelBalanceCashoutResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 余额查询
 */
class DivisionReceiverChannelBalanceCashoutTest {

    final static Logger _log = LoggerFactory.getLogger(DivisionReceiverChannelBalanceCashoutTest.class);

    @BeforeAll
    public static void initApiKey() {
        Jeepay.setApiBase(JeepayTestData.getApiBase());
        Jeepay.apiKey = JeepayTestData.getApiKey();
        Jeepay.mchNo = JeepayTestData.getMchNo();
        Jeepay.appId = JeepayTestData.getAppId();
    }

    @Test
    public void testCashout() {
        JeepayClient jeepayClient = JeepayClient.getInstance(Jeepay.appId, Jeepay.apiKey, Jeepay.getApiBase());

        DivisionReceiverChannelBalanceCashoutRequest request = new DivisionReceiverChannelBalanceCashoutRequest();
        DivisionReceiverChannelBalanceCashoutReqModel model = new DivisionReceiverChannelBalanceCashoutReqModel();
        model.setMchNo(Jeepay.mchNo);                       // 商户号
        model.setAppId(jeepayClient.getAppId());
        model.setReceiverId(800009L);
        model.setMchOrderNo(System.currentTimeMillis() + "");
        model.setCashoutAmount(100L);
        request.setBizModel(model);
        try {
            DivisionReceiverChannelBalanceCashoutResponse response = jeepayClient.execute(request);
            _log.info("response:{}", response.checkSign(Jeepay.apiKey));
            // �µ��ɹ�
            if(response.isSuccess(Jeepay.apiKey)) {
                _log.info("data:{}", JSON.toJSONString(response.get()));
            }else {
                _log.info("response:{}", JSON.toJSONString(response));
            }
        } catch (JeepayException e) {
            _log.error(e.getMessage());
        }
    }
}