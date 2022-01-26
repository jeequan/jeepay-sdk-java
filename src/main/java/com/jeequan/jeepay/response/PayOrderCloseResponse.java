package com.jeequan.jeepay.response;

import com.jeequan.jeepay.model.PayOrderCloseResModel;

/**
 * Jeepay支付 关闭订单响应实现
 *
 * @author xiaoyu
 * @site https://www.jeequan.com
 * @date 2022/1/25 9:56
 */
public class PayOrderCloseResponse extends JeepayResponse {

    private static final long serialVersionUID = 7654172640802954221L;

    public PayOrderCloseResModel get() {
        if(getData() == null) return new PayOrderCloseResModel();
        return getData().toJavaObject(PayOrderCloseResModel.class);
    }

}
