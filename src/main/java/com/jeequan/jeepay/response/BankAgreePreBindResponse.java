package com.jeequan.jeepay.response;

import com.jeequan.jeepay.model.BankAgreePreBindResModel;

public class BankAgreePreBindResponse extends JeepayResponse {

    private static final long serialVersionUID = 7654172640802954221L;

    public BankAgreePreBindResModel get() {
        if(getData() == null) return new BankAgreePreBindResModel();
        return getData().toJavaObject(BankAgreePreBindResModel.class);
    }

}
