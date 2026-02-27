package com.jeequan.jeepay.request;

import com.jeequan.jeepay.Jeepay;
import com.jeequan.jeepay.model.JeepayObject;
import com.jeequan.jeepay.net.RequestOptions;
import com.jeequan.jeepay.response.OrderDivisionRefundQueryResponse;

/***
* 订单分账回退查询
*
* @author yr
* @site https://www.jeepay.vip
* @date 2025/11/21 10:19
*/
public class OrderDivisionRefundQueryRequest implements JeepayRequest<OrderDivisionRefundQueryResponse> {

    private String apiVersion = Jeepay.VERSION;
    private String apiUri = "api/division/order/refund/query";
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
    public Class<OrderDivisionRefundQueryResponse> getResponseClass() {
        return OrderDivisionRefundQueryResponse.class;
    }

}
