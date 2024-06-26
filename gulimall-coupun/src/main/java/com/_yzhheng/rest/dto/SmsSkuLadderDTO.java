/*
 * Created on 2024-05-02 ( 16:20:03 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 3.3.0
 */
package com._yzhheng.rest.dto;

import java.io.Serializable;
import lombok.Data;

import java.math.BigDecimal;


/**
 * DTO class for "SmsSkuLadder"
 *
 * @author Telosys
 *
 */
@Data
public class SmsSkuLadderDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- PRIMARY KEY 
    private Long id ;
    //--- OTHER DATA FIELDS 
    private Long skuId ;
    private Integer fullCount ;
    private BigDecimal discount ;
    private BigDecimal price ;
    private Boolean addOther ;

    /**
     * Constructor
     */
    public SmsSkuLadderDTO() {
		super();
    }
}
    

