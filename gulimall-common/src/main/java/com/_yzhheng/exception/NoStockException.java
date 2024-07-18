package com._yzhheng.exception;

import lombok.Getter;
import lombok.Setter;

public class NoStockException extends RuntimeException {

    @Getter
    @Setter
    private Long skuId;

    public NoStockException(Long skuId) {
        super("商品id为" + skuId + "：没有足够的库存了");
    }

    public NoStockException(String msg) {
        super(msg);
    }
}
