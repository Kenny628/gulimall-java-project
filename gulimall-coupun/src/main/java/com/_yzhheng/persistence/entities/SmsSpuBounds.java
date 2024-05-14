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
 * JPA entity class for "SmsSpuBounds"
 *
 * @author Telosys
 *
 */
@Data
@Entity
@Table(name="sms_spu_bounds", catalog="gulimall-sms" )
public class SmsSpuBounds implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- PRIMARY KEY 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Long       id ;

    //--- OTHER DATA FIELDS 
    @Column(name="spu_id")
    private Long       spuId ;

    @Column(name="grow_bounds")
    private BigDecimal growBounds ;

    @Column(name="buy_bounds")
    private BigDecimal buyBounds ;

    @Column(name="work")
    private Boolean    work ;

    /**
     * Constructor
     */
    public SmsSpuBounds() {
		super();
    }
  
	@Override
 public String toString() { 
  StringBuilder sb = new StringBuilder(); 
  sb.append(id);
  sb.append("|");
  sb.append(spuId);
  sb.append("|");
  sb.append(growBounds);
  sb.append("|");
  sb.append(buyBounds);
  sb.append("|");
  sb.append(work);
  return sb.toString(); 
 } 


}