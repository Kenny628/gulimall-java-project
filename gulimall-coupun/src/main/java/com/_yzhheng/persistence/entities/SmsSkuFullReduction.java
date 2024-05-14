/*
 * Created on 2024-05-02 ( 16:20:03 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 3.3.0
 */
package com._yzhheng.persistence.entities;

import java.io.Serializable;

import java.math.BigDecimal;
import jakarta.persistence.*;
import lombok.Data;

/**
 * JPA entity class for "SmsSkuFullReduction"
 *
 * @author Telosys
 *
 */
@Data
@Entity
@Table(name="sms_sku_full_reduction", catalog="gulimall-sms" )
public class SmsSkuFullReduction implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- PRIMARY KEY 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Long       id ;

    //--- OTHER DATA FIELDS 
    @Column(name="sku_id")
    private Long       skuId ;

    @Column(name="full_price")
    private BigDecimal fullPrice ;

    @Column(name="reduce_price")
    private BigDecimal reducePrice ;

    @Column(name="add_other")
    private Boolean    addOther ;

    /**
     * Constructor
     */
    public SmsSkuFullReduction() {
		super();
    }
  
	@Override
 public String toString() { 
  StringBuilder sb = new StringBuilder(); 
  sb.append(id);
  sb.append("|");
  sb.append(skuId);
  sb.append("|");
  sb.append(fullPrice);
  sb.append("|");
  sb.append(reducePrice);
  sb.append("|");
  sb.append(addOther);
  return sb.toString(); 
 } 


}