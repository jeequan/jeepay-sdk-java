package com.jeequan.jeepay;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jeequan.jeepay.exception.JeepayException;
import com.jeequan.jeepay.model.PayOrderDivisionExecReqModel;
import com.jeequan.jeepay.request.PayOrderDivisionExecRequest;
import com.jeequan.jeepay.response.PayOrderDivisionExecResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;

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
        JeepayClient jeepayClient = new JeepayClient();
        //jeepayClient.setApiKey("F22nwkjrwre23t552324244");    // 设置apiKey,
        //jeepayClient.setApiBase("https://pay.jeepay.vip");

        PayOrderDivisionExecRequest request = new PayOrderDivisionExecRequest();
        PayOrderDivisionExecReqModel model = new PayOrderDivisionExecReqModel();
        request.setBizModel(model);

        model.setMchNo(Jeepay.mchNo);                       // 商户号
        model.setAppId(Jeepay.appId);                       // 应用ID

        model.setPayOrderId("P202108271011207970001");
        model.setUseSysAutoDivisionReceivers((byte) 0);

        JSONArray receviers = new JSONArray();
        receviers.add(JSONObject.parseObject("{receiverId: '800029', receiverGroupId: '', divisionProfit: '0.0001'}"));
        receviers.add(JSONObject.parseObject("{receiverId: '800028', receiverGroupId: '', divisionProfit: '0.0002'}"));

        model.setReceivers(receviers.toJSONString());

        try {
            PayOrderDivisionExecResponse response = jeepayClient.execute(request);
            _log.info("验签结果：{}", response.checkSign(Jeepay.apiKey));
            // 判断转账发起是否成功（并不代表转账成功）
            if(response.isSuccess(Jeepay.apiKey)) {
                _log.info("渠道分账订单号：{}， 分账成功", response.get().getChannelBatchOrderId());
            }else {
                _log.info("分账失败：payOrderId：{}", model.getPayOrderId());
                _log.info("通道错误码：{}", response.get().getErrCode());
                _log.info("通道错误信息：{}", response.get().getErrMsg());
            }
        } catch (JeepayException e) {
            _log.error(e.getMessage());
        }

    }

}
