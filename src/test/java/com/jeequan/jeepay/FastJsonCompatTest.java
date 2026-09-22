package com.jeequan.jeepay;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jeequan.jeepay.model.PayOrderCreateReqModel;
import com.jeequan.jeepay.response.PayOrderCreateResponse;
import com.jeequan.jeepay.response.JeepayResponse;
import com.jeequan.jeepay.util.JeepayKit;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * fastjson 1.x API 兼容层（com.alibaba:fastjson 2.0.x，内核 fastjson2）冒烟测试。
 * 覆盖 SDK 的真实用法：响应模型反序列化、参数序列化、签名稳定性（getStrSort 显式排序，
 * 不受兼容层字段输出顺序差异影响）。
 */
class FastJsonCompatTest {

    /** JeepayResponse（含 JSONObject data 字段）的序列化/反序列化往返 */
    @Test
    void responseRoundTrip() {
        String body = "{\"code\":0,\"msg\":\"SUCCESS\",\"data\":{\"payOrderId\":\"P123\",\"amount\":100,\"state\":2}}";

        JeepayResponse response = JSON.parseObject(body, PayOrderCreateResponse.class);
        assertEquals(0, response.getCode());
        assertEquals("SUCCESS", response.getMsg());
        assertNotNull(response.getData());
        assertEquals("P123", response.getData().getString("payOrderId"));
        assertEquals(100, response.getData().getIntValue("amount"));

        // 重新序列化后语义不变（兼容层字段顺序可能与 1.x 不同，做语义比较）
        JSONObject back = JSONObject.parseObject(JSONObject.toJSONString(response));
        assertEquals(response.getCode(), back.getIntValue("code"));
        assertEquals("P123", back.getJSONObject("data").getString("payOrderId"));
    }

    /** 签名与字段顺序无关：不同的插入顺序必须得到同一签名（getStrSort 显式排序保障） */
    @Test
    void signatureIndependentOfFieldOrder() {
        Map<String, Object> a = new HashMap<>();
        a.put("mchNo", "M2000001");
        a.put("appId", "A1000001");
        a.put("amount", 10000L);
        a.put("payOrderId", "P9876543210");

        Map<String, Object> b = new TreeMap<>();
        b.put("payOrderId", "P9876543210");
        b.put("amount", 10000L);
        b.put("appId", "A1000001");
        b.put("mchNo", "M2000001");

        // 同一内容不同容器/顺序 → 签名一致
        assertEquals(JeepayKit.getSign(a, "testKey"), JeepayKit.getSign(b, "testKey"));
        // 值不同 → 签名不同
        b.put("amount", 20000L);
        assertTrue(!JeepayKit.getSign(a, "testKey").equals(JeepayKit.getSign(b, "testKey")));
    }

    /** SDK 请求参数的 JSON 序列化（HttpClient/HttpContent 使用路径） */
    @Test
    void requestParamsSerialization() {
        Map<String, Object> params = new HashMap<>();
        params.put("mchOrderNo", "MOrder123");
        params.put("wayCode", "ALI_QR");
        params.put("currency", "CNY");

        String json = JSON.toJSONString(params);
        Map<String, Object> back = JSON.parseObject(json, Map.class);

        assertEquals("MOrder123", back.get("mchOrderNo"));
        assertEquals("ALI_QR", back.get("wayCode"));
        assertEquals("CNY", back.get("currency"));

        // 模拟 APIResource 的参数处理路径
        JSONObject parsed = JSONObject.parseObject(json);
        assertEquals("MOrder123", parsed.getString("mchOrderNo"));
    }

    /** 典型下单请求模型的序列化/反序列化往返 */
    @Test
    void payOrderCreateReqRoundTrip() {
        String json = "{\"mchNo\":\"M2000001\",\"appId\":\"A1000001\",\"mchOrderNo\":\"MOrder123\",\"wayCode\":\"ALI_QR\",\"amount\":10000,\"currency\":\"CNY\",\"divisionMode\":1}";
        PayOrderCreateReqModel req = JSON.parseObject(json, PayOrderCreateReqModel.class);
        assertEquals("M2000001", req.getMchNo());
        assertEquals("A1000001", req.getAppId());

        String out = JSON.toJSONString(req);
        JSONObject back = JSONObject.parseObject(out);
        assertEquals("M2000001", back.getString("mchNo"));
        assertEquals(1, back.getIntValue("divisionMode"));
        assertEquals(10000, back.getIntValue("amount"));
    }
}
