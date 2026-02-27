package com.jeequan.jeepay.response;

import com.jeequan.jeepay.model.BalanceDivisionRefundQueryResModel;


/***
* 余额分账回退查询响应
*
* @author terrfly
* @site https://www.jeequan.com
* @date 2024/5/20 15:29
*/
public class BalanceDivisionRefundQueryResponse extends JeepayResponse {

    private static final long serialVersionUID = 7419683269497002904L;

    public BalanceDivisionRefundQueryResModel get() {
        if(getData() == null) return new BalanceDivisionRefundQueryResModel();
        return getData().toJavaObject(BalanceDivisionRefundQueryResModel.class);
    }

}
