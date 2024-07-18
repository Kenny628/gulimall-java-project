package com._yzhheng.vo;

import com._yzhheng.persistence.entities.OmsOrder;
import com._yzhheng.rest.dto.OmsOrderDTO;

import lombok.Data;

@Data
public class SubmitOrderResponseVo {

    private OmsOrder Order;
    private Integer code;// error status code
}
