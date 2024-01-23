package com.jeequan.jeepay.response;

import com.jeequan.jeepay.model.QueryOpenIdByBarcodeResModel;

public class QueryOpenIdByBarcodeResponse extends JeepayResponse {

    private static final long serialVersionUID = 7654172640802954221L;

    public QueryOpenIdByBarcodeResModel get() {
        if(getData() == null) return new QueryOpenIdByBarcodeResModel();
        return getData().toJavaObject(QueryOpenIdByBarcodeResModel.class);
    }

}
