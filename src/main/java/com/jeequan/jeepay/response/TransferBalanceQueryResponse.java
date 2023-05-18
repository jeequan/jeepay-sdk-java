package com.jeequan.jeepay.response;

import com.jeequan.jeepay.model.DivisionReceiverChannelBalanceQueryResModel;
import com.jeequan.jeepay.model.TransferBalanceQueryResModel;


/***
 * 转账可用余额查询接口
 *
 * @author zx
 * @site https://www.jeequan.com
 * @date 2022/5/11 15:03
 */
public class TransferBalanceQueryResponse extends JeepayResponse {

    public TransferBalanceQueryResModel get() {
        if(getData() == null) return new TransferBalanceQueryResModel();
        return getData().toJavaObject(TransferBalanceQueryResModel.class);
    }

    @Override
    public boolean isSuccess(String apiKey) {
        return super.isSuccess(apiKey);
    }

}
