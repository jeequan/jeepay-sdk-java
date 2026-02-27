package com.jeequan.jeepay.response;

import com.jeequan.jeepay.model.DivisionReceiverSettleUpdateResModel;


/***
* 分账接收方结算信息修改  响应
*
* @author terrfly
* @site https://www.jeepay.vip
* @date 2021/8/25 10:35
*/
public class DivisionReceiverSettleUpdateResponse extends JeepayResponse {

    private static final long serialVersionUID = 7419683269497002904L;

    public DivisionReceiverSettleUpdateResModel get() {
        if(getData() == null) return new DivisionReceiverSettleUpdateResModel();
        return getData().toJavaObject(DivisionReceiverSettleUpdateResModel.class);
    }

}
