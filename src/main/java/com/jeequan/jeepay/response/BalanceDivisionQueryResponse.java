package com.jeequan.jeepay.response;

import com.jeequan.jeepay.model.BalanceDivisionQueryResModel;


/***
* 分账查询响应
*
* @author terrfly
* @site https://www.jeequan.com
* @date 2024/5/20 15:29
*/
public class BalanceDivisionQueryResponse extends JeepayResponse {

    private static final long serialVersionUID = 7419683269497002904L;

    public BalanceDivisionQueryResModel get() {
        if(getData() == null) return new BalanceDivisionQueryResModel();
        return getData().toJavaObject(BalanceDivisionQueryResModel.class);
    }

}
