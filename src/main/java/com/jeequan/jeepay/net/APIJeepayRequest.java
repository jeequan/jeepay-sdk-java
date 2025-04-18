package com.jeequan.jeepay.net;

import com.jeequan.jeepay.Jeepay;
import com.jeequan.jeepay.exception.APIConnectionException;
import com.jeequan.jeepay.exception.JeepayException;
import com.jeequan.jeepay.util.JeepayKit;
import com.jeequan.jeepay.util.JeepayRSA2Kit;
import com.jeequan.jeepay.util.StringUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * API请求
 * @author jmdhappy
 * @site https://www.jeepay.vip
 * @date 2021-06-08 11:00
 */
public class APIJeepayRequest {
    /**
     * 请求方法 (GET, POST, DELETE or PUT)
     * */
    APIResource.RequestMethod method;

    /**
     * 请求URL
     */
    URL url;

    /**
     * 请求Body
     */
    HttpContent content;

    /**
     * 请求Header
     */
    HttpHeaders headers;

    /**
     * 请求参数
     */
    Map<String, Object> params;

    /**
     * 请求选项
     */
    RequestOptions options;

    /**
     * 实例化Jeepay请求
     * @param method
     * @param url
     * @param params
     * @param options
     * @throws JeepayException
     */
    public APIJeepayRequest(
            APIResource.RequestMethod method,
            String url,
            Map<String, Object> params,
            RequestOptions options)
            throws JeepayException {
        try {
            this.params = Collections.unmodifiableMap(new ConcurrentHashMap<>(params != null ? params : new HashMap<>()));
            this.options = options;
            this.method = method;
            this.url = buildURL(method, StringUtils.genUrl(url, this.options.getUri()), params);
            this.content = buildContent(method, params, this.options);
            this.headers = buildHeaders(method, this.options);
        } catch (IOException e) {
            throw new APIConnectionException(
                    String.format(
                            "请求Jeepay(%s)异常,请检查网络或重试.异常信息:%s",
                            StringUtils.genUrl(url, options.getUri()), e.getMessage()),
                    e);
        }
    }

    private static URL buildURL(
            APIResource.RequestMethod method, String spec, Map<String, Object> params)
            throws IOException {
        StringBuilder sb = new StringBuilder(spec);

        if ((method != APIResource.RequestMethod.POST && method != APIResource.RequestMethod.PUT) && (params != null)) {
            String queryString = createQuery(params);
            if (!queryString.isEmpty()) {
                sb.append("?").append(queryString);
            }
        }

        return new URL(sb.toString());
    }

    private static HttpContent buildContent (
            APIResource.RequestMethod method, Map<String, Object> params, RequestOptions options) throws JeepayException {
        if (method != APIResource.RequestMethod.POST && method != APIResource.RequestMethod.PUT) {
            return null;
        }

        if (params == null) {
            return null;
        }

        params.put(Jeepay.API_VERSION_NAME, options.getVersion());
        params.put(Jeepay.API_SIGN_TYPE_NAME, options.getSignType());
        String requestTime = currentTimeString();
        params.put(Jeepay.API_REQ_TIME_NAME, requestTime);
        String signature;
        try {
            signature = buildJeepaySignature(params, options);
        } catch (IOException e) {
            throw new APIConnectionException("生成Jeepay请求签名异常", e);
        }
        if (signature != null) {
            params.put(Jeepay.API_SIGN_NAME, signature);
        }

        return HttpContent.buildJSONContent(params);
    }

    /**
     * @param params the parameters
     * @return queryString
     */
    private static String createQuery(Map<String, Object> params) {
        if (params == null || params.isEmpty()) {
            return "";
        }

        Map<String, String> flatParams = flattenParams(params);
        StringBuilder queryStringBuffer = new StringBuilder();
        for (Map.Entry<String, String> entry : flatParams.entrySet()) {
            if (queryStringBuffer.length() > 0) {
                queryStringBuffer.append("&");
            }
            queryStringBuffer.append(urlEncodePair(entry.getKey(), entry.getValue()));
        }
        return queryStringBuffer.toString();
    }

    /**
     * @param k the key
     * @param v the value
     * @return urlEncodedString
     */
    private static String urlEncodePair(String k, String v) {
        return String.format("%s=%s", urlEncode(k), urlEncode(v));
    }

    /**
     * @param str the string to encode
     * @return urlEncodedString
     */
    protected static String urlEncode(String str) {
        if (str == null) {
            return "";
        }

        try {
            return URLEncoder.encode(str, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError("UTF-8 is unknown");
        }
    }

    /**
     * @param params the parameters
     * @return flattenParams
     */
    private static Map<String, String> flattenParams(Map<String, Object> params) {
        if (params == null) {
            return Collections.emptyMap();
        }

        Map<String, String> flatParams = new ConcurrentHashMap<>();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (value instanceof Map<?, ?>) {
                flattenNestedMap(key, (Map<?, ?>) value, flatParams);
            } else if (value instanceof List<?>) {
                flattenNestedList(key, (List<?>) value, flatParams);
            } else if (value == null) {
                flatParams.put(key, "");
            } else {
                flatParams.put(key, value.toString());
            }
        }
        return flatParams;
    }

    private static void flattenNestedMap(String prefix, Map<?, ?> nestedMap, Map<String, String> flatParams) {
        for (Map.Entry<?, ?> entry : nestedMap.entrySet()) {
            String newKey = String.format("%s[%s]", prefix, entry.getKey());
            Object value = entry.getValue();
            if (value instanceof Map<?, ?>) {
                flattenNestedMap(newKey, (Map<?, ?>) value, flatParams);
            } else if (value instanceof List<?>) {
                flattenNestedList(newKey, (List<?>) value, flatParams);
            } else {
                flatParams.put(newKey, value == null ? "" : value.toString());
            }
        }
    }

    private static void flattenNestedList(String prefix, List<?> nestedList, Map<String, String> flatParams) {
        for (int i = 0; i < nestedList.size(); i++) {
            String newKey = String.format("%s[%d]", prefix, i);
            Object value = nestedList.get(i);
            if (value instanceof Map<?, ?>) {
                flattenNestedMap(newKey, (Map<?, ?>) value, flatParams);
            } else if (value instanceof List<?>) {
                flattenNestedList(newKey, (List<?>) value, flatParams);
            } else {
                flatParams.put(newKey, value == null ? "" : value.toString());
            }
        }
    }

    private static HttpHeaders buildHeaders(APIResource.RequestMethod method, RequestOptions options)
            throws JeepayException {
        Map<String, List<String>> headerMap = new HashMap<>();

        // Accept
        headerMap.put("Accept", singletonList("application/json"));

        // Accept-Charset
        headerMap.put("Accept-Charset", singletonList(APIResource.CHARSET.name()));

        // Accept-Language
        headerMap.put("Accept-Language", singletonList(options.getAcceptLanguage()));

        return HttpHeaders.of(headerMap);
    }

    protected static String buildJeepaySignature(Map<String, Object> params, RequestOptions options)
            throws IOException {

        String signType = options.getSignType();
        if ("MD5".equalsIgnoreCase(signType)) {
            return JeepayKit.getSign(params, options.getApiKey());
        } else if ("RSA2".equalsIgnoreCase(signType)) {
            try {
                return JeepayRSA2Kit.getSign(params, options.getApiKey());
            } catch (Exception e) {
                throw new IOException("RSA2签名生成失败: " + e.getMessage(), e);
            }
        }
        throw new AssertionError("请设置正确的签名类型");
    }

    /**
     * 获取当前时间的13位毫秒级时间戳字符串表示。
     *
     * @return 当前时间的13位毫秒级时间戳字符串
     */
    protected static String currentTimeString() {
        return String.valueOf(System.currentTimeMillis());
    }

    private static List<String> singletonList(String value) {
        return Collections.singletonList(value);
    }

    public APIResource.RequestMethod getMethod() {
        return method;
    }

    public URL getUrl() {
        return url;
    }

    public HttpContent getContent() {
        return content;
    }

    public HttpHeaders getHeaders() {
        return headers;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public RequestOptions getOptions() {
        return options;
    }
}
