package com.jeequan.jeepay;

import com.jeequan.jeepay.exception.JeepayException;
import com.jeequan.jeepay.model.DivisionReceiverChannelBalanceQueryReqModel;
import com.jeequan.jeepay.request.DivisionReceiverChannelBalanceQueryRequest;
import com.jeequan.jeepay.response.DivisionReceiverChannelBalanceQueryResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class DivisionReceiverChannelBalanceQueryTest {

    final static Logger _log = LoggerFactory.getLogger(DivisionReceiverChannelBalanceQueryTest.class);

    @BeforeAll
    public static void initApiKey() {
        Jeepay.setApiBase(JeepayTestData.getApiBase());
        Jeepay.apiKey = JeepayTestData.getApiKey();
        Jeepay.mchNo = JeepayTestData.getMchNo();
        Jeepay.appId = JeepayTestData.getAppId();
    }

    /******************************  分账渠道余额查询接口  ***********************************/
    @Test
    public void testDivisionReceiverChannelBalanceQuery() {
        JeepayClient jeepayClient = JeepayClient.getInstance(Jeepay.appId, Jeepay.apiKey, Jeepay.getApiBase());
        DivisionReceiverChannelBalanceQueryRequest request = new DivisionReceiverChannelBalanceQueryRequest();
        DivisionReceiverChannelBalanceQueryReqModel model = new DivisionReceiverChannelBalanceQueryReqModel();
        model.setMchNo(Jeepay.mchNo);                       // 商户号
        model.setAppId(jeepayClient.getAppId());            // 应用ID
        model.setReceiverId(800007L);
        request.setBizModel(model);

        try {
            DivisionReceiverChannelBalanceQueryResponse response = jeepayClient.execute(request);
            _log.info("验签结果：{}", response.checkSign(Jeepay.apiKey));
            if(response.isSuccess(Jeepay.apiKey)) {
                _log.info("receiverId：{}， 分账接收者ID", response.get().getReceiverId());
            }else {
                _log.info("通道错误码：{}", response.getCode());
                _log.info("通道错误信息：{}", response.getMsg());
            }
        } catch (JeepayException e) {
            _log.error(e.getMessage());
        }
    }
}
