package com.jeequan.jeepay.response;

import com.jeequan.jeepay.model.OrderDivisionRefundQueryResModel;


/***
* 订单分账回退查询响应
*
* @author yr
* @site https://www.jeequan.com
* @date 2025/11/21 14:29
*/
public class OrderDivisionRefundQueryResponse extends JeepayResponse {

    private static final long serialVersionUID = 7419683269497002904L;

    public OrderDivisionRefundQueryResModel get() {
        if(getData() == null) return new OrderDivisionRefundQueryResModel();
        return getData().toJavaObject(OrderDivisionRefundQueryResModel.class);
    }

}
