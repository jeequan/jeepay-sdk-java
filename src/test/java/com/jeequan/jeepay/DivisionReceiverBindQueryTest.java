package com.jeequan.jeepay;

import com.jeequan.jeepay.exception.JeepayException;
import com.jeequan.jeepay.model.DivisionReceiverBindQueryReqModel;
import com.jeequan.jeepay.request.DivisionReceiverBindQueryRequest;
import com.jeequan.jeepay.response.DivisionReceiverBindQueryResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class DivisionReceiverBindQueryTest {

    final static Logger _log = LoggerFactory.getLogger(DivisionReceiverBindQueryTest.class);

    @BeforeAll
    public static void initApiKey() {
        Jeepay.setApiBase(JeepayTestData.getApiBase());
        Jeepay.apiKey = JeepayTestData.getApiKey();
        Jeepay.mchNo = JeepayTestData.getMchNo();
        Jeepay.appId = JeepayTestData.getAppId();
    }

    /******************************  分账用户绑定状态查询  ***********************************/
    @Test
    public void testDivisionReceiverBindQuery() {
        JeepayClient jeepayClient = JeepayClient.getInstance(Jeepay.appId, Jeepay.apiKey, Jeepay.getApiBase());
        DivisionReceiverBindQueryRequest request = new DivisionReceiverBindQueryRequest();
        DivisionReceiverBindQueryReqModel model = new DivisionReceiverBindQueryReqModel();
        model.setMchNo(Jeepay.mchNo);                       // 商户号
        model.setAppId(jeepayClient.getAppId());            // 应用ID
        model.setReceiverId(800001L);
        request.setBizModel(model);

        try {
            DivisionReceiverBindQueryResponse response = jeepayClient.execute(request);
            _log.info("验签结果：{}", response.checkSign(Jeepay.apiKey));
            // 判断转账发起是否成功（并不代表转账成功）
            if(response.isSuccess(Jeepay.apiKey)) {
                _log.info("accNo：{}， 绑定成功", response.get().getAccNo());
            }else {
//                _log.info("绑定失败：accNo：{}", model.getAccNo());
                _log.info("通道错误码：{}", response.get().getErrCode());
                _log.info("通道错误信息：{}", response.get().getErrMsg());
            }
        } catch (JeepayException e) {
            _log.error(e.getMessage());
        }
    }
}
