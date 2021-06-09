# jeepay-sdk-java

## 快速开始

下载代码后，编译打包（暂未上传私服，需要自行打包引用）

引入sdk依赖

```xml
  <dependency>
      <groupId>com.jeequan</groupId>
      <artifactId>jeepay-sdk-java</artifactId>
      <version>1.0.0</version>
  </dependency>
```

客户端调用代码可参考测试类代码 `com.jeequan.jeepay.PayOrderTest`

```java
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

        String wayCode = "AUTO_BAR";
        PayOrderCreateRequest request = new PayOrderCreateRequest();
        PayOrderCreateReqModel model = new PayOrderCreateReqModel();
        model.setMchNo(Jeepay.mchNo);                       // 商户号
        String orderNo = "mho" + new Date().getTime();
        model.setMchOrderNo(orderNo);                       // 商户订单号
        model.setWayCode(wayCode);                          // 支付方式
        model.setAmount(4l);                                // 金额，单位分
        model.setCurrency("cny");                           // 币种，目前只支持cny
        model.setClientIp("192.166.1.132");                 // 发起支付请求客户端的 IP 地址，格式为 IPV4，如: 127.0.0.1
        model.setSubject("商品标题");                         // 商品标题
        model.setBody("商品描述");                            // 商品描述
        model.setNotifyUrl("https://www.jeequan.com");      // 异步通知地址
        model.setReturnUrl("");                             // 前端跳转地址
        model.setChannelExtra(channelExtra(wayCode));       // 渠道扩展参数
        model.setExtParam("");                              // 商户扩展参数,会掉时原样返回

        request.setBizModel(model);

        try {
            PayOrderCreateResponse response = jeepayClient.execute(request);

            _log.info("验签结果：{}", response.checkSign(Jeepay.apiKey));

            // 下单成功
            if(response.isSuccess(Jeepay.apiKey)) {
                String payOrderId = response.get().getPayOrderId();
                _log.info("payOrderId：{}", payOrderId);
                _log.info("payOrderId：{}", response.get().getMchOrderNo());
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
        switch (wayCode) {
            case "WX_JSAPI":
                return wxJsapiExtra();
            case "WX_BAR":
                return wxBarExtra();
            case "ALI_BAR":
                return aliBarExtra();
            case "QR_CASHIER":
                return qrCashierExtra();
            case "AUTO_BAR":
                return autoBarExtra();
            default:
                return "";
        }
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
        obj.put("authCode", "286364366818511766");
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
        model.setPayOrderId("20210529015532444001");                            // 支付订单号
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
```