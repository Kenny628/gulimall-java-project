package com._yzhheng.vo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.util.CollectionUtils;

// TODO: 学习充血模型 
//整个购物车
//重写了get方法，保证每次获取值都会进行计算
public class Cart {
    private List<CartItem> items;
    private Integer countNum;
    private Integer countType;
    private BigDecimal totalAmount;
    private Integer checkedNum;
    private BigDecimal reduce = new BigDecimal("0.00");

    public List<CartItem> getItems() {
        return items;
    }

    public Integer getCheckedNum() {
        return checkedNum;
    }

    public void setCheckedNum(Integer checkedNum) {
        this.checkedNum = checkedNum;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public Integer getCountNum() {
        int count = 0;
        if (items != null && items.size() > 0) {
            for (CartItem item : items) {
                count += item.getCount();
            }
        }
        return count;
    }

    // public void setCountNum(Integer countNum) {
    // this.countNum = countNum;
    // }

    public Integer getCountType() {
        return items == null ? 0 : items.size();
    }

    public void setCountType(Integer countType) {
        this.countType = countType;
    }

    // public BigDecimal getTotalAmount() {
    // BigDecimal amount = new BigDecimal("0");
    // if (items != null && items.size() > 0) {
    // for (CartItem item : items) {
    // amount = amount.add(item.getTotalPrice());
    // }
    // }

    // BigDecimal discounted = amount.subtract(getReduce());
    // return discounted;
    // }

    public BigDecimal getTotalAmount() {
        BigDecimal amount = new BigDecimal("0");
        // 计算购物项总价
        if (!CollectionUtils.isEmpty(items)) {
            for (CartItem cartItem : items) {
                if (cartItem.getChecked()) {
                    amount = amount.add(cartItem.getTotalPrice());
                }
            }
        }
        // 计算优惠后的价格
        return amount.subtract(getReduce());
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getReduce() {
        return reduce;
    }

    public void setReduce(BigDecimal reduce) {
        this.reduce = reduce;
    }

}
