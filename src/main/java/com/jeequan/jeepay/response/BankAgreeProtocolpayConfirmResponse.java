package com.jeequan.jeepay.response;

import com.jeequan.jeepay.model.BankAgreeProtocolpayConfirmResModel;

public class BankAgreeProtocolpayConfirmResponse extends JeepayResponse {

    private static final long serialVersionUID = 7654172640802954221L;

    public BankAgreeProtocolpayConfirmResModel get() {
        if(getData() == null) return new BankAgreeProtocolpayConfirmResModel();
        return getData().toJavaObject(BankAgreeProtocolpayConfirmResModel.class);
    }

}
