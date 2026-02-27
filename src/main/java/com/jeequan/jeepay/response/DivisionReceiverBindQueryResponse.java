package com.jeequan.jeepay.response;

import com.jeequan.jeepay.model.DivisionReceiverBindQueryResModel;


/***
 * 分账用户绑定状态查询 响应实现
 *
 * @author yr
 * @site https://www.jeepay.vip
 * @date 2024/12/11 08:43
 */
public class DivisionReceiverBindQueryResponse extends JeepayResponse {

    private static final long serialVersionUID = 7419683269497002904L;

    public DivisionReceiverBindQueryResModel get() {
        if(getData() == null) return new DivisionReceiverBindQueryResModel();
        return getData().toJavaObject(DivisionReceiverBindQueryResModel.class);
    }

    @Override
    public boolean isSuccess(String apiKey) {
        if(super.isSuccess(apiKey)) {
            int state = get().getBindState();
            return state == 1;
        }
        return false;
    }

}
