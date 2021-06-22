package com.jeequan.jeepay;

import com.alibaba.fastjson.JSONObject;
import com.jeequan.jeepay.exception.JeepayException;
import com.jeequan.jeepay.model.PayOrderCreateReqModel;
import com.jeequan.jeepay.model.PayOrderQueryReqModel;
import com.jeequan.jeepay.request.PayOrderCreateRequest;
import com.jeequan.jeepay.request.PayOrderQueryRequest;
import com.jeequan.jeepay.response.PayOrderCreateResponse;
import com.jeequan.jeepay.response.PayOrderQueryResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

class PayOrderTest {

    final static Logger _log = LoggerFactory.getLogger(PayOrderTest.class);

    @BeforeAll
    public static void initApiKey() {
        Jeepay.setApiBase(JeepayTestData.getApiBase());
        Jeepay.apiKey = JeepayTestData.getApiKey();
        Jeepay.mchNo = JeepayTestData.getMchNo();
        Jeepay.appId = JeepayTestData.getAppId();
    }

    @Test
    public void testPayOrderCreate() {
        JeepayClient jeepayClient = new JeepayClient();
        //jeepayClient.setApiKey("F22nwkjrwre23t552324244");    // 设置apiKey,
        //jeepayClient.setApiBase("https://pay.jeepay.vip");

        /*
            支持自己定义RequestOptions属性,更灵活
            RequestOptions options = RequestOptions.builder().setApiKey("11982212000912313").setUri("api/pay/unifiedOrder").setReadTimeout(100).build();
            PayOrderCreateRequest request = new PayOrderCreateRequest();
            request.setRequestOptions(options);
        */

        /*
            特殊支付方式：
            QR_CASHIER  ( 通过二维码跳转到收银台完成支付， 已集成获取用户ID的实现。  )
            AUTO_BAR （自动分类条码支付）
        */

        String wayCode = "ALI_BAR";
        PayOrderCreateRequest request = new PayOrderCreateRequest();
        PayOrderCreateReqModel model = new PayOrderCreateReqModel();
        model.setMchNo(Jeepay.mchNo);                       // 商户号
        model.setAppId(Jeepay.appId);                       // 应用ID
        String orderNo = "mho" + new Date().getTime();
        model.setMchOrderNo(orderNo);                       // 商户订单号
        model.setWayCode(wayCode);                          // 支付方式
        model.setAmount(8l);                                // 金额，单位分
        model.setCurrency("cny");                           // 币种，目前只支持cny
        model.setClientIp("192.166.1.132");                 // 发起支付请求客户端的IP地址
        model.setSubject("商品标题");                         // 商品标题
        model.setBody("商品描述");                            // 商品描述
        model.setNotifyUrl("https://www.jeequan.com");      // 异步通知地址
        model.setReturnUrl("");                             // 前端跳转地址
        model.setChannelExtra(channelExtra(wayCode));       // 渠道扩展参数
        model.setExtParam("");                              // 商户扩展参数,回调时原样返回
        request.setBizModel(model);
        try {
            PayOrderCreateResponse response = jeepayClient.execute(request);
            _log.info("验签结果：{}", response.checkSign(Jeepay.apiKey));
            // 下单成功
            if(response.isSuccess(Jeepay.apiKey)) {
                String payOrderId = response.get().getPayOrderId();
                _log.info("payOrderId：{}", payOrderId);
                _log.info("mchOrderNo：{}", response.get().getMchOrderNo());
            }else {
                _log.info("下单失败：{}", orderNo);
                _log.info("通道错误码：{}", response.get().getErrCode());
                _log.info("通道错误信息：{}", response.get().getErrMsg());
            }
        } catch (JeepayException e) {
            _log.error(e.getMessage());
        }

    }

    String channelExtra(String wayCode) {
        if("WX_JSAPI".equals(wayCode)) return wxJsapiExtra();
        if("WX_BAR".equals(wayCode)) return wxBarExtra();
        if("ALI_BAR".equals(wayCode)) return aliBarExtra();
        if("QR_CASHIER".equals(wayCode)) return qrCashierExtra();
        if("AUTO_BAR".equals(wayCode)) return autoBarExtra();
        return "";
    }

    private String wxJsapiExtra() {
        JSONObject obj = new JSONObject();
        obj.put("openId", "134756231107811344");
        return obj.toString();
    }

    private String wxBarExtra() {
        JSONObject obj = new JSONObject();
        obj.put("authCode", "134675721924600802");
        return obj.toString();
    }

    private String aliBarExtra() {
        JSONObject obj = new JSONObject();
        obj.put("authCode", "1180812820366966512");
        return obj.toString();
    }

    private String qrCashierExtra() {
        JSONObject obj = new JSONObject();
        obj.put("payDataType", "codeImgUrl");
        return obj.toString();
    }

    private String autoBarExtra() {
        JSONObject obj = new JSONObject();
        obj.put("authCode", "134753177301492386");
        return obj.toString();
    }

    @Test
    public void testPayOrderQuery() {
        JeepayClient jeepayClient = new JeepayClient();
        PayOrderQueryRequest request = new PayOrderQueryRequest();
        PayOrderQueryReqModel model = new PayOrderQueryReqModel();
        model.setMchNo(Jeepay.mchNo);                                           // 商户号
        model.setAppId(Jeepay.appId);
        model.setPayOrderId("P202106181104177050002");                            // 支付订单号
        request.setBizModel(model);

        try {
            PayOrderQueryResponse response = jeepayClient.execute(request);
            _log.info("验签结果：{}", response.checkSign(Jeepay.apiKey));

            if(response.isSuccess(Jeepay.apiKey)) {
                _log.info("订单信息：{}", response);
                _log.info("金额：{}", response.get().getAmount());
            }
        } catch (JeepayException e) {

            e.printStackTrace();
        }

    }



}