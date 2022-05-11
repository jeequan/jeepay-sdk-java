package com.jeequan.jeepay.response;

import com.jeequan.jeepay.model.DivisionReceiverChannelBalanceQueryResModel;


/***
 * 分账渠道余额查询接口
 *
 * @author terrfly
 * @site https://www.jeequan.com
 * @date 2022/5/11 15:03
 */
public class DivisionReceiverChannelBalanceQueryResponse extends JeepayResponse {

    public DivisionReceiverChannelBalanceQueryResModel get() {
        if(getData() == null) return new DivisionReceiverChannelBalanceQueryResModel();
        return getData().toJavaObject(DivisionReceiverChannelBalanceQueryResModel.class);
    }

    @Override
    public boolean isSuccess(String apiKey) {
        return super.isSuccess(apiKey);
    }

}
