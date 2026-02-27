package com.jeequan.jeepay.response;

import com.jeequan.jeepay.model.DivisionReceiverCashoutRecordQueryResModel;


/**
 * 分账提现记录查询
 *
 * @author yr
 * @site https://www.jeequan.com
 * @date 2024/11/20 08:46
 */
public class DivisionReceiverCashoutRecordQueryResponse extends JeepayResponse {

    public DivisionReceiverCashoutRecordQueryResModel get() {
        if(getData() == null) return new DivisionReceiverCashoutRecordQueryResModel();
        return getData().toJavaObject(DivisionReceiverCashoutRecordQueryResModel.class);
    }

    @Override
    public boolean isSuccess(String apiKey) {
        return super.isSuccess(apiKey);
    }
}
