package com.jeequan.jeepay.model;

/***
 * 分账渠道余额查询接口
 *
 * @author terrfly
 * @site https://www.jeequan.com
 * @date 2022/5/11 15:03
 */
public class DivisionReceiverChannelBalanceQueryResModel extends JeepayObject {

    /**
     * 分账接收者ID
     */
    private Long receiverId;

    /**
     * 可提现余额, 单位：分
     */
    private Long balanceAmount;

    /**
     * 不可提现余额, 单位：分
     **/
    private Long unBalanceAmount;

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public Long getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(Long balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public Long getUnBalanceAmount() {
        return unBalanceAmount;
    }

    public void setUnBalanceAmount(Long unBalanceAmount) {
        this.unBalanceAmount = unBalanceAmount;
    }
}
