package com.jeequan.jeepay.request;

import com.jeequan.jeepay.Jeepay;
import com.jeequan.jeepay.model.JeepayObject;
import com.jeequan.jeepay.net.RequestOptions;
import com.jeequan.jeepay.response.DivisionReceiverCashoutRecordQueryResponse;

/**
 * 分账提现记录查询接口
 *
 * @author yr
 * @site https://www.jeequan.com
 * @date 2024/11/21 10:46
 */
public class DivisionReceiverCashoutRecordQueryRequest implements JeepayRequest<DivisionReceiverCashoutRecordQueryResponse> {

    private String apiVersion = Jeepay.VERSION;
    private String apiUri = "api/division/receiver/cashoutRecordQuery";
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
    public Class<DivisionReceiverCashoutRecordQueryResponse> getResponseClass() {
        return DivisionReceiverCashoutRecordQueryResponse.class;
    }

}
