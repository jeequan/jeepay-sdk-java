package com.jeequan.jeepay;

import com.jeequan.jeepay.exception.JeepayException;
import com.jeequan.jeepay.model.QueryOpenIdByBarcodeReqModel;
import com.jeequan.jeepay.request.QueryOpenIdByBarcodeRequest;
import com.jeequan.jeepay.response.QueryOpenIdByBarcodeResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class QueryOpenIdByBarcodeTest {

    final static Logger _log = LoggerFactory.getLogger(QueryOpenIdByBarcodeTest.class);

    @BeforeAll
    public static void initApiKey() {
        Jeepay.setApiBase(JeepayTestData.getApiBase());
        Jeepay.apiKey = JeepayTestData.getApiKey();
        Jeepay.mchNo = JeepayTestData.getMchNo();
        Jeepay.appId = JeepayTestData.getAppId();
    }

    @Test
    public void testQuery() {
        JeepayClient jeepayClient = JeepayClient.getInstance(Jeepay.appId, Jeepay.apiKey, Jeepay.getApiBase());
        QueryOpenIdByBarcodeRequest request = new QueryOpenIdByBarcodeRequest();
        QueryOpenIdByBarcodeReqModel model = new QueryOpenIdByBarcodeReqModel();
        model.setMchNo(Jeepay.mchNo);                                          // 商户号
        model.setAppId(jeepayClient.getAppId());                               // 应用ID
        model.setBarCode("130839546952920000");                         // 条码值, 微信： 18位纯数字
        request.setBizModel(model);
        try {
            QueryOpenIdByBarcodeResponse response = jeepayClient.execute(request);
            _log.info("验签结果：{}", response.checkSign(Jeepay.apiKey));
            if(response.isSuccess(Jeepay.apiKey)) {
                _log.info("查询信息：{}", response);
            }
        } catch (JeepayException e) {
            e.printStackTrace();
        }

    }

}
