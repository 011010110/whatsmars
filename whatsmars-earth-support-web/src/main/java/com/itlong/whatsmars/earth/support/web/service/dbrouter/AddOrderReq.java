package com.itlong.whatsmars.earth.support.web.service.dbrouter;

import java.math.BigDecimal;

/**
 * Created by shenhongxi on 16/7/16.
 */
public class AddOrderReq extends BaseReq {

    private BigDecimal amount;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
