/*
 * Created on 2024-05-02 ( 16:20:03 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 3.3.0
 */
package com._yzhheng.rest.dto;

import java.io.Serializable;
import lombok.Data;

import java.math.BigDecimal;


/**
 * DTO class for "SmsSeckillSkuRelation"
 *
 * @author Telosys
 *
 */
@Data
public class SmsSeckillSkuRelationDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- PRIMARY KEY 
    private Long id ;
    //--- OTHER DATA FIELDS 
    private Long promotionId ;
    private Long promotionSessionId ;
    private Long skuId ;
    private BigDecimal seckillPrice ;
    private BigDecimal seckillCount ;
    private BigDecimal seckillLimit ;
    private Integer seckillSort ;

    /**
     * Constructor
     */
    public SmsSeckillSkuRelationDTO() {
		super();
    }
}
    

