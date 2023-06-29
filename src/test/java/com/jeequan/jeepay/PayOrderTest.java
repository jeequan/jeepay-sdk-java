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

        /*
            支持自己定义RequestOptions属性,更灵活
            RequestOptions options = RequestOptions.builder().setAppId("60deb8d6c6104c854e2346e4").setApiKey("11982212000912313").setUri("api/pay/unifiedOrder").setReadTimeout(100).build();
            PayOrderCreateRequest request = new PayOrderCreateRequest();
            request.setRequestOptions(options);
        */

        /*
            特殊支付方式：
            QR_CASHIER  ( 通过二维码跳转到收银台完成支付， 已集成获取用户ID的实现。  )
            AUTO_BAR （自动分类条码支付）
        */

        // 支付接口文档：https://docs.jeequan.com/docs/jeepay/payment_api
        JeepayClient jeepayClient = JeepayClient.getInstance(Jeepay.appId, Jeepay.apiKey, Jeepay.getApiBase());
        String wayCode = "QR_CASHIER";                           // 支付方式
        PayOrderCreateRequest request = new PayOrderCreateRequest();
        PayOrderCreateReqModel model = new PayOrderCreateReqModel();
        model.setMchNo(Jeepay.mchNo);                       // 商户号
        model.setAppId(jeepayClient.getAppId());            // 应用ID
        String orderNo = "mho" + new Date().getTime();
        model.setMchOrderNo(orderNo);                       // 商户订单号
        model.setWayCode(wayCode);                          // 支付方式
        model.setAmount(1l);                                // 金额，单位分
        model.setCurrency("CNY");                           // 币种，目前只支持cny
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
                _log.info("getPayData：{}", response.get().getPayData());
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
        if("YSF_BAR".equals(wayCode)) return ysfBarExtra();
        if("UPACP_BAR".equals(wayCode)) return upacpBarExtra();
        if("QR_CASHIER".equals(wayCode)) return qrCashierExtra();
        if("AUTO_BAR".equals(wayCode)) return autoBarExtra();
        if("PP_PC".equals(wayCode)) return ppExtra();
        if("SAND_H5".equals(wayCode)) return sandH5Extra();
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

    private String ysfBarExtra() {
        JSONObject obj = new JSONObject();
        obj.put("authCode", "6223194037624963090");
        return obj.toString();
    }

    private String upacpBarExtra() {
        JSONObject obj = new JSONObject();
        obj.put("authCode", "6227662446181058584");
        return obj.toString();
    }

    private String qrCashierExtra() {
        JSONObject obj = new JSONObject();
        //obj.put("payDataType", "codeImgUrl");
        //obj.put("entryPageType", "lite");
        obj.put("entryLiteType", "alih5");
        obj.put("payDataType", "codeUrl");

        return obj.toString();
    }

    private String autoBarExtra() {
        JSONObject obj = new JSONObject();
        obj.put("authCode", "134753177301492386");
        return obj.toString();
    }

    private String ppExtra() {
        JSONObject obj = new JSONObject();
        obj.put("cancelUrl", "http://baidu.com");
        return obj.toString();
    }

    private String sandH5Extra() {
        JSONObject obj = new JSONObject();
        JSONObject payExtra = new JSONObject();
        // 聚合码
        obj.put("productCode", "02000001");
        obj.put("payExtra", "");
        obj.put("metaOption", "[{\"s\":\"Pc\",\"n\":\"支付\"}]");
        // 微信公众号
        /*obj.put("productCode", "02010002");
        payExtra = new JSONObject();
        payExtra.put("mer_app_id", "");
        payExtra.put("openid", "");
        obj.put("payExtra", payExtra.toString());
        obj.put("metaOption", "");
        // 微信小程序(云函数sdk)
        obj.put("productCode", "02010007");
        payExtra = new JSONObject();
        payExtra.put("wx_app_id", "");  // 移动应用Appid（微信开放平台获取，wx开头）
        payExtra.put("gh_ori_id", "");  // 小程序原始id（微信公众平台获取，gh_开头）
        payExtra.put("path_url", "");   // 拉起小程序页面的可带参路径，不填默认拉起小程序首页
        payExtra.put("miniProgramType", "0");   // 开发时根据小程序是开发版、体验版或正式版自行选择。正式版:0; 开发版:1; 体验版:2
        obj.put("payExtra", payExtra.toString());
        obj.put("metaOption", "");
        // 支付宝生活号
        obj.put("productCode", "02010002");
        payExtra = new JSONObject();
        payExtra.put("buyer_id", "");  // 支付宝生活号所需参数（支付宝H5建议不传）
        obj.put("payExtra", payExtra.toString());
        obj.put("metaOption", "");*/
        return obj.toString();

    }

    @Test
    public void testPayOrderQuery() {
        // 支付接口文档：https://docs.jeequan.com/docs/jeepay/payment_api
        JeepayClient jeepayClient = JeepayClient.getInstance(Jeepay.appId, Jeepay.apiKey, Jeepay.getApiBase());
        PayOrderQueryRequest request = new PayOrderQueryRequest();
        PayOrderQueryReqModel model = new PayOrderQueryReqModel();
        model.setMchNo(Jeepay.mchNo);                                           // 商户号
        model.setAppId(jeepayClient.getAppId());                                // 应用ID
        model.setPayOrderId("P202106181104177050002");                          // 支付订单号
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

    @Test
    public void testPayOrderClose() {
        JeepayClient jeepayClient = new JeepayClient();
        PayOrderCloseRequest request = new PayOrderCloseRequest();
        PayOrderCloseReqModel model = new PayOrderCloseReqModel();
        model.setMchNo(Jeepay.mchNo);                                           // 商户号
        model.setAppId(Jeepay.appId);
        model.setPayOrderId("P1485879219030011906");                            // 支付订单号
        request.setBizModel(model);

        try {
            PayOrderCloseResponse response = jeepayClient.execute(request);
            _log.info("验签结果：{}", response.checkSign(Jeepay.apiKey));

            if(response.isSuccess(Jeepay.apiKey)) {
                _log.info("返回信息：{}", response);
            }
        } catch (JeepayException e) {

            e.printStackTrace();
        }

    }
}