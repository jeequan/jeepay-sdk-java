package com.jeequan.jeepay.response;

import com.jeequan.jeepay.model.BankAgreeConfirmBindResModel;

public class BankAgreeConfirmBindResponse extends JeepayResponse {

    private static final long serialVersionUID = 7654172640802954221L;

    public BankAgreeConfirmBindResModel get() {
        if(getData() == null) return new BankAgreeConfirmBindResModel();
        return getData().toJavaObject(BankAgreeConfirmBindResModel.class);
    }

}
