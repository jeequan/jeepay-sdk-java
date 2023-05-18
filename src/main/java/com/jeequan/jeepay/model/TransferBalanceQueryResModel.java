package com.jeequan.jeepay.model;

/***
 * 分账渠道余额查询接口
 *
 * @author zx
 * @site https://www.jeequan.com
 * @date 2022/5/11 15:03
 */
public class TransferBalanceQueryResModel extends JeepayObject {

    /**
     * 余额, 单位：分
     */
    private Long balanceAmount;

    public Long getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(Long balanceAmount) {
        this.balanceAmount = balanceAmount;
    }
}
