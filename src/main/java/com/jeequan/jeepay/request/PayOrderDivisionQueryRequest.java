package com.jeequan.jeepay.request;

import com.jeequan.jeepay.Jeepay;
import com.jeequan.jeepay.model.JeepayObject;
import com.jeequan.jeepay.net.RequestOptions;
import com.jeequan.jeepay.response.PayOrderDivisionQueryResponse;

/***
* 分账查询
*
* @author terrfly
* @site https://www.jeequan.com
* @date 2024/5/20 14:32
*/
public class PayOrderDivisionQueryRequest implements JeepayRequest<PayOrderDivisionQueryResponse> {

    private String apiVersion = Jeepay.VERSION;
    private String apiUri = "api/division/query";
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
    public Class<PayOrderDivisionQueryResponse> getResponseClass() {
        return PayOrderDivisionQueryResponse.class;
    }

}
