package com._yzhheng.vo;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

// @Data
public class OrderConfirmVo {
    @Getter
    @Setter
    List<MemberAddressVo> address;
    @Getter
    @Setter
    List<OrderItemVo> items;
    // 积分信息
    @Getter
    @Setter
    Integer integration;
    BigDecimal total;
    Integer count;

    public BigDecimal getTotal() {
        BigDecimal total = new BigDecimal("0");
        if (items != null) {
            for (OrderItemVo item : items) {
                total = total.add(item.getPrice().multiply(new BigDecimal(item.getCount().toString())));
            }
        }
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getPayPrice() {
        return getTotal();
    }

    public void setPayPrice(BigDecimal payPrice) {
        this.payPrice = payPrice;
    }

    BigDecimal payPrice;
    // 防重令牌 - 防止多次提交
    @Getter
    @Setter
    String orderToken;

    public Integer getCount() {
        Integer count = 0;
        for (OrderItemVo item : items) {
            count++;
        }
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
