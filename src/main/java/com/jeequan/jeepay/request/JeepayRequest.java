package com.jeequan.jeepay.request;

import com.jeequan.jeepay.model.JeepayObject;
import com.jeequan.jeepay.net.RequestOptions;
import com.jeequan.jeepay.response.JeepayResponse;

/**
 * Jeepay请求接口
 * @author jmdhappy
 * @site https://www.jeepay.vip
 * @date 2021-06-08 11:00
 */
public interface JeepayRequest<T extends JeepayResponse> {

    /**
     * 获取当前接口的路径
     * @return
     */
    String getApiUri();

    /**
     * 获取当前接口的版本
     * @return
     */
    String getApiVersion();

    /**
     * 设置当前接口的版本
     * @return
     */
    void setApiVersion(String apiVersion);

    RequestOptions getRequestOptions();

    void setRequestOptions(RequestOptions options);

    JeepayObject getBizModel();

    void setBizModel(JeepayObject bizModel);

    Class<T> getResponseClass();

}
