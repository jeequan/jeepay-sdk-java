package com.jeequan.jeepay;

import com.jeequan.jeepay.exception.JeepayException;
import com.jeequan.jeepay.net.APIResource;
import com.jeequan.jeepay.net.RequestOptions;
import com.jeequan.jeepay.request.JeepayRequest;
import com.jeequan.jeepay.response.JeepayResponse;

/**
 * Jeepay sdk客户端
 * @author jmdhappy
 * @site https://www.jeepay.vip
 * @date 2021-06-08 11:00
 */
public class JeepayClient extends APIResource {

    private String signType = Jeepay.DEFAULT_SIGN_TYPE;
    private String apiKey = Jeepay.apiKey;
    private String apiBase = Jeepay.getApiBase();

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public JeepayClient(String apiBase, String signType, String apiKey) {
        this.apiBase = apiBase;
        this.signType = signType;
        this.apiKey = apiKey;
    }

    public JeepayClient(String apiBase, String apiKey) {
        this.apiBase = apiBase;
        this.apiKey = apiKey;
    }

    public JeepayClient(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiBase() {
        return apiBase;
    }

    public void setApiBase(String apiBase) {
        this.apiBase = apiBase;
    }

    public JeepayClient() {
    }

    public <T extends JeepayResponse> T execute(JeepayRequest<T> request) throws JeepayException {

        // 支持用户自己设置RequestOptions
        if(request.getRequestOptions() == null) {
            RequestOptions options = RequestOptions.builder()
                    .setVersion(request.getApiVersion())
                    .setUri(request.getApiUri())
                    .setApiKey(this.apiKey)
                    .build();
            request.setRequestOptions(options);
        }

        return execute(request, RequestMethod.POST, this.apiBase);
    }

}
