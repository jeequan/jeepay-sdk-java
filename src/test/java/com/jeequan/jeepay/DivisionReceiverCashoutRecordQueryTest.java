package com.jeequan.jeepay;

import com.jeequan.jeepay.exception.JeepayException;
import com.jeequan.jeepay.model.DivisionReceiverCashoutRecordQueryReqModel;
import com.jeequan.jeepay.request.DivisionReceiverCashoutRecordQueryRequest;
import com.jeequan.jeepay.response.DivisionReceiverCashoutRecordQueryResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// 分账提现记录查询test
class DivisionReceiverCashoutRecordQueryTest {

    final static Logger _log = LoggerFactory.getLogger(DivisionReceiverCashoutRecordQueryTest.class);

    @BeforeAll
    public static void initApiKey() {
        Jeepay.setApiBase(JeepayTestData.getApiBase());
        Jeepay.apiKey = JeepayTestData.getApiKey();
        Jeepay.mchNo = JeepayTestData.getMchNo();
        Jeepay.appId = JeepayTestData.getAppId();
    }

    @Test
    public void testRecordQuery() {
        JeepayClient jeepayClient = JeepayClient.getInstance(Jeepay.appId, Jeepay.apiKey, Jeepay.getApiBase());
        DivisionReceiverCashoutRecordQueryRequest request = new DivisionReceiverCashoutRecordQueryRequest();
        DivisionReceiverCashoutRecordQueryReqModel model = new DivisionReceiverCashoutRecordQueryReqModel();
        model.setMchNo(Jeepay.mchNo);                                          // 商户号
        model.setAppId(jeepayClient.getAppId());                               // 应用ID
        model.setReceiverId(800009L);                                          // 分账接收者ID
//        model.setRid("C123456789");                                            // 提现记录单号
//        model.setMchOrderNo(System.currentTimeMillis() + "");                  // 商户提现单号（发起分账提现时使用的分账提现单号）
//        model.setQueryCreatedAtBegin("2025-11-22 14:00:00");                   // 提现单创建时间范围：起始时间yyyy-MM-dd HH:mm:ss
//        model.setQueryCreatedAtEnd("2026-11-25 14:00:00");                     // 提现单创建时间范围：结束时间yyyy-MM-dd HH:mm:ss
        request.setBizModel(model);
        try {
            DivisionReceiverCashoutRecordQueryResponse response = jeepayClient.execute(request);
            _log.info("验签结果：{}", response.checkSign(Jeepay.apiKey));
            if(response.isSuccess(Jeepay.apiKey)) {
                _log.info("查询信息：{}", response);
            }
        } catch (JeepayException e) {
            e.printStackTrace();
        }

    }
}
