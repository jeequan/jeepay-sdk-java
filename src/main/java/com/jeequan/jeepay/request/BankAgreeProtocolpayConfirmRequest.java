package com.jeequan.jeepay.request;

import com.jeequan.jeepay.Jeepay;
import com.jeequan.jeepay.model.JeepayObject;
import com.jeequan.jeepay.net.RequestOptions;
import com.jeequan.jeepay.response.BankAgreeProtocolpayConfirmResponse;

public class BankAgreeProtocolpayConfirmRequest implements JeepayRequest<BankAgreeProtocolpayConfirmResponse> {

    private String apiVersion = Jeepay.VERSION;
    private String apiUri = "api/pay/bankAgreeProtocolpayConfirm";
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
    public Class<BankAgreeProtocolpayConfirmResponse> getResponseClass() {
        return BankAgreeProtocolpayConfirmResponse.class;
    }

}
