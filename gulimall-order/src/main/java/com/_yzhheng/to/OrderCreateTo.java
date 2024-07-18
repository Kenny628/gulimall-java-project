package com._yzhheng.to;

import java.math.BigDecimal;
import java.util.List;

import com._yzhheng.persistence.entities.OmsOrder;
import com._yzhheng.persistence.entities.OmsOrderItem;
import com._yzhheng.rest.dto.OmsOrderDTO;
import com._yzhheng.rest.dto.OmsOrderItemDTO;

import lombok.Data;

/**
 * 订单创建成功后返回的数据
 */
@Data
public class OrderCreateTo {

    /** 订单信息 **/
    private OmsOrder order;

    /** 订单项信息 **/
    private List<OmsOrderItem> orderItems;

    /** 订单计算的应付价格 **/
    private BigDecimal payPrice;

    /** 运费 **/
    private BigDecimal fare;
}