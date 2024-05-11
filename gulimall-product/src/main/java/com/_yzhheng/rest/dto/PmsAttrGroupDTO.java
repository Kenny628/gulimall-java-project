/*
 * Created on 2024-05-02 ( 14:45:35 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 3.3.0
 */
package com._yzhheng.rest.dto;

import java.io.Serializable;
import lombok.Data;


/**
 * DTO class for "PmsAttrGroup"
 *
 * @author Telosys
 *
 */
@Data
public class PmsAttrGroupDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- PRIMARY KEY 
    private Long attrGroupId ;
    //--- OTHER DATA FIELDS 
    private String attrGroupName ;
    private Integer sort ;
    private String descript ;
    private String icon ;
    private Long catelogId ;

    /**
     * Constructor
     */
    public PmsAttrGroupDTO() {
		super();
    }
}
    

