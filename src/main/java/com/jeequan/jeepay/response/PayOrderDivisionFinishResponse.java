package com.jeequan.jeepay.response;

import com.jeequan.jeepay.model.PayOrderDivisionFinishResModel;


/***
* 分账查询响应
*
* @author terrfly
* @site https://www.jeequan.com
* @date 2024/5/20 15:29
*/
public class PayOrderDivisionFinishResponse extends JeepayResponse {

    private static final long serialVersionUID = 7419683269497002904L;

    public PayOrderDivisionFinishResModel get() {
        if(getData() == null) return new PayOrderDivisionFinishResModel();
        return getData().toJavaObject(PayOrderDivisionFinishResModel.class);
    }

}
