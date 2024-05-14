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
 * JPA entity class for "SmsSkuLadder"
 *
 * @author Telosys
 *
 */
@Data
@Entity
@Table(name="sms_sku_ladder", catalog="gulimall-sms" )
public class SmsSkuLadder implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- PRIMARY KEY 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Long       id ;

    //--- OTHER DATA FIELDS 
    @Column(name="sku_id")
    private Long       skuId ;

    @Column(name="full_count")
    private Integer    fullCount ;

    @Column(name="discount")
    private BigDecimal discount ;

    @Column(name="price")
    private BigDecimal price ;

    @Column(name="add_other")
    private Boolean    addOther ;

    /**
     * Constructor
     */
    public SmsSkuLadder() {
		super();
    }
  
	@Override
 public String toString() { 
  StringBuilder sb = new StringBuilder(); 
  sb.append(id);
  sb.append("|");
  sb.append(skuId);
  sb.append("|");
  sb.append(fullCount);
  sb.append("|");
  sb.append(discount);
  sb.append("|");
  sb.append(price);
  sb.append("|");
  sb.append(addOther);
  return sb.toString(); 
 } 


}