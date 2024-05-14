/*
 * Created on 2024-05-02 ( 16:45:39 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 3.3.0
 */
package com._yzhheng.rest.dto;

import java.io.Serializable;
import lombok.Data;

import java.math.BigDecimal;


/**
 * DTO class for "UmsMemberLevel"
 *
 * @author Telosys
 *
 */
@Data
public class UmsMemberLevelDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- PRIMARY KEY 
    private Long id ;
    //--- OTHER DATA FIELDS 
    private String name ;
    private Integer growthPoint ;
    private Byte defaultStatus ;
    private BigDecimal freeFreightPoint ;
    private Integer commentGrowthPoint ;
    private Byte priviledgeFreeFreight ;
    private Byte priviledgeMemberPrice ;
    private Byte priviledgeBirthday ;
    private String note ;

    /**
     * Constructor
     */
    public UmsMemberLevelDTO() {
		super();
    }
}
    
