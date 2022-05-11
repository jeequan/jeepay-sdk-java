package com.jeequan.jeepay.response;

import com.jeequan.jeepay.model.DivisionReceiverChannelBalanceCashoutResModel;

/**
 * 分账渠道余额提现
 *
 * @author terrfly
 * @site https://www.jeequan.com
 * @date 2022/5/11 15:13
 */
public class DivisionReceiverChannelBalanceCashoutResponse extends JeepayResponse {

    public DivisionReceiverChannelBalanceCashoutResModel get() {
        if(getData() == null) return new DivisionReceiverChannelBalanceCashoutResModel();
        return getData().toJavaObject(DivisionReceiverChannelBalanceCashoutResModel.class);
    }

    @Override
    public boolean isSuccess(String apiKey) {
        if(super.isSuccess(apiKey)) {
            int state = get().getState();
            return state == 1;
        }
        return false;
    }

}
