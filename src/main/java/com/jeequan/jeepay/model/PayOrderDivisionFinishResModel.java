package com.jeequan.jeepay.model;

/***
* 分账查询响应结果
*
* @author terrfly
* @site https://www.jeequan.com
* @date 2024/5/20 15:30
*/
public class PayOrderDivisionFinishResModel extends JeepayObject {

    /** 分账完结状态 1-成功, 2-失败，3-处理中 */
    private Byte state;

    /** 支付渠道错误码 */
    private String errCode;

    /** 支付渠道错误信息 */
    private String errMsg;

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
