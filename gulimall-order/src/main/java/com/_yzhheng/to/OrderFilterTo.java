package com._yzhheng.to;

import java.math.BigDecimal;
import java.util.Date;
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
public class OrderFilterTo {

    private String orderSn;

    private Date createTime;
    private String receiverName;
    private BigDecimal payAmount;
    private Integer status;
    private List<OmsOrderItemDTO> items;
}