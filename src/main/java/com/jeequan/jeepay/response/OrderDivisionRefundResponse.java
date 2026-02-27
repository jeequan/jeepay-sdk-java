package com.jeequan.jeepay.response;

import com.jeequan.jeepay.model.OrderDivisionRefundResModel;


/***
* 订单分账回退 响应实现
*
* @author yr
* @site https://www.jeepay.vip
* @date 2025/11/21 10:22
*/
public class OrderDivisionRefundResponse extends JeepayResponse {

    private static final long serialVersionUID = 7419683269497002904L;

    public OrderDivisionRefundResModel get() {
        if(getData() == null) return new OrderDivisionRefundResModel();
        return getData().toJavaObject(OrderDivisionRefundResModel.class);
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
