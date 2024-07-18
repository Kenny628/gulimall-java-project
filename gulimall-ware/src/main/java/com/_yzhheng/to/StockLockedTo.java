package com._yzhheng.to;

import lombok.Data;

import java.util.List;

@Data
public class StockLockedTo {

    // 库存工作单id
    private Long id;
    // 工作单详情
    private StockDetailTo detail;
}
