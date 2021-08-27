package com.jeequan.jeepay;

import com.jeequan.jeepay.exception.JeepayException;
import com.jeequan.jeepay.model.DivisionReceiverBindReqModel;
import com.jeequan.jeepay.request.DivisionReceiverBindRequest;
import com.jeequan.jeepay.response.DivisionReceiverBindResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class DivisionReceiverBindTest {

    final static Logger _log = LoggerFactory.getLogger(DivisionReceiverBindTest.class);

    @BeforeAll
    public static void initApiKey() {
        Jeepay.setApiBase(JeepayTestData.getApiBase());
        Jeepay.apiKey = JeepayTestData.getApiKey();
        Jeepay.mchNo = JeepayTestData.getMchNo();
        Jeepay.appId = JeepayTestData.getAppId();
    }

    @Test
    public void testDivisionReceiverBind() {
        JeepayClient jeepayClient = new JeepayClient();
        //jeepayClient.setApiKey("F22nwkjrwre23t552324244");    // 设置apiKey,
        //jeepayClient.setApiBase("https://pay.jeepay.vip");

        DivisionReceiverBindRequest request = new DivisionReceiverBindRequest();
        DivisionReceiverBindReqModel model = new DivisionReceiverBindReqModel();

        model.setMchNo(Jeepay.mchNo);                       // 商户号
        model.setAppId(Jeepay.appId);                       // 应用ID
        model.setIfCode("wxpay");
        model.setReceiverAlias("wxpay");
        model.setReceiverGroupId(100001L);
        model.setAccType((byte)0);
        model.setAccNo("OPENIDOPENIDOPENIDOPENIDOPENID");
        model.setAccName("测试账号");
        model.setRelationType("PARTNER");
        model.setRelationTypeName("合作伙伴");
        model.setDivisionProfit("0.01");

        request.setBizModel(model);

        try {
            DivisionReceiverBindResponse response = jeepayClient.execute(request);
            _log.info("验签结果：{}", response.checkSign(Jeepay.apiKey));
            // 判断转账发起是否成功（并不代表转账成功）
            if(response.isSuccess(Jeepay.apiKey)) {
                _log.info("accNo：{}， 绑定成功", response.get().getAccNo());
            }else {
                _log.info("绑定失败：accNo：{}", model.getAccNo());
                _log.info("通道错误码：{}", response.get().getErrCode());
                _log.info("通道错误信息：{}", response.get().getErrMsg());
            }
        } catch (JeepayException e) {
            _log.error(e.getMessage());
        }

    }

}
