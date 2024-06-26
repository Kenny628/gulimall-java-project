/*
 * Created on 2024-05-02 ( 16:45:39 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 3.3.0
 */
package com._yzhheng.rest.dto;

import java.io.Serializable;
import lombok.Data;

import java.util.Date;


/**
 * DTO class for "UmsIntegrationChangeHistory"
 *
 * @author Telosys
 *
 */
@Data
public class UmsIntegrationChangeHistoryDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- PRIMARY KEY 
    private Long id ;
    //--- OTHER DATA FIELDS 
    private Long memberId ;
    private Date createTime ;
    private Integer changeCount ;
    private String note ;
    private Byte sourceTyoe ;

    /**
     * Constructor
     */
    public UmsIntegrationChangeHistoryDTO() {
		super();
    }
}
    

