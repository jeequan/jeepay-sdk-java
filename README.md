# jeepay-sdk-java

## 快速开始

引入sdk依赖（最新发布版本1.1.0）

```xml
  <dependency>
      <groupId>com.jeequan</groupId>
      <artifactId>jeepay-sdk-java</artifactId>
      <version>1.1.0</version>
  </dependency>
```

客户端调用代码可参考：

支付测试代码 `com.jeequan.jeepay.PayOrderTest`

退款测试代码 `com.jeequan.jeepay.RefundOrderTest`

```java
    // 创建客户端
    JeepayClient jeepayClient = new JeepayClient();

    // 构建请求数据
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
    
    // 发起支付请求
    PayOrderCreateResponse response = jeepayClient.execute(request);

    // 验证返回数据签名
    response.checkSign(Jeepay.apiKey);

    // 判断下单是否返回成功
    response.isSuccess(Jeepay.apiKey)
```

## 其他相关

Jeepay是一套适合互联网企业使用的开源支付系统，支持多渠道服务商和普通商户模式。已对接`微信支付`，`支付宝`，`云闪付`官方接口，支持聚合码支付。

Jeepay使用`Spring Boot`和`Ant Design Vue`开发，集成`Spring Security`实现权限管理功能，是一套非常实用的web开发框架。

- Jeepay支付流程体验：[https://www.jeequan.com/demo/jeepay_cashier.html](https://www.jeequan.com/demo/jeepay_cashier.html "Jeepay支付体验")
- Jeepay运营平台和商户系统演体验：[https://www.jeequan.com/doc/detail_84.html](https://www.jeequan.com/doc/detail_84.html "Jeepay支付系统体验")
- Jeepay项目文档：[https://www.jeepay.vip](https://www.jeepay.vip "Jeepay项目文档")

Jeepay项目地址：[https://gitee.com/jeequan](https://gitee.com/jeequan "Jeepay项目")
