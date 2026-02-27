package com.jeequan.jeepay.request;

import com.jeequan.jeepay.Jeepay;
import com.jeequan.jeepay.model.JeepayObject;
import com.jeequan.jeepay.net.RequestOptions;
import com.jeequan.jeepay.response.DivisionReceiverBindQueryResponse;

/***
 * 分账用户绑定状态查询
 *
 * @author yr
 * @site https://www.jeepay.vip
 * @date 2024/12/11 08:43
 */
public class DivisionReceiverBindQueryRequest implements JeepayRequest<DivisionReceiverBindQueryResponse> {

    private String apiVersion = Jeepay.VERSION;
    private String apiUri = "api/division/receiver/bindQuery";
    private RequestOptions options;
    private JeepayObject bizModel = null;

    @Override
    public String getApiUri() {
        return this.apiUri;
    }

    @Override
    public String getApiVersion() {
        return this.apiVersion;
    }

    @Override
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @Override
    public RequestOptions getRequestOptions() {
        return this.options;
    }

    @Override
    public void setRequestOptions(RequestOptions options) {
        this.options = options;
    }

    @Override
    public JeepayObject getBizModel() {
        return this.bizModel;
    }

    @Override
    public void setBizModel(JeepayObject bizModel) {
        this.bizModel = bizModel;
    }

    @Override
    public Class<DivisionReceiverBindQueryResponse> getResponseClass() {
        return DivisionReceiverBindQueryResponse.class;
    }

}
