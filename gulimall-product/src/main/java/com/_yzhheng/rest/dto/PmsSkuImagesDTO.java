/*
 * Created on 2024-05-02 ( 14:45:36 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 3.3.0
 */
package com._yzhheng.rest.dto;

import java.io.Serializable;
import lombok.Data;


/**
 * DTO class for "PmsSkuImages"
 *
 * @author Telosys
 *
 */
@Data
public class PmsSkuImagesDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- PRIMARY KEY 
    private Long id ;
    //--- OTHER DATA FIELDS 
    private Long skuId ;
    private String imgUrl ;
    private Integer imgSort ;
    private Integer defaultImg ;

    /**
     * Constructor
     */
    public PmsSkuImagesDTO() {
		super();
    }
}
    

