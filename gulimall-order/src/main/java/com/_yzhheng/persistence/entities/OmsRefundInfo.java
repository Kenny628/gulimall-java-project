/*
 * Created on 2024-05-02 ( 22:23:26 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 3.3.0
 */
package com._yzhheng.persistence.entities;

import java.io.Serializable;

import java.math.BigDecimal;
import jakarta.persistence.*;
import lombok.Data;

/**
 * JPA entity class for "OmsRefundInfo"
 *
 * @author Telosys
 *
 */
@Data
@Entity
@Table(name="oms_refund_info", catalog="gulimall-oms" )
public class OmsRefundInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- PRIMARY KEY 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Long       id ;

    //--- OTHER DATA FIELDS 
    @Column(name="order_return_id")
    private Long       orderReturnId ;

    @Column(name="refund")
    private BigDecimal refund ;

    @Column(name="refund_sn", length=64)
    private String     refundSn ;

    @Column(name="refund_status")
    private Boolean    refundStatus ;

    @Column(name="refund_channel")
    private Byte       refundChannel ;

    @Column(name="refund_content", length=5000)
    private String     refundContent ;

    /**
     * Constructor
     */
    public OmsRefundInfo() {
		super();
    }
  
	@Override
 public String toString() { 
  StringBuilder sb = new StringBuilder(); 
  sb.append(id);
  sb.append("|");
  sb.append(orderReturnId);
  sb.append("|");
  sb.append(refund);
  sb.append("|");
  sb.append(refundSn);
  sb.append("|");
  sb.append(refundStatus);
  sb.append("|");
  sb.append(refundChannel);
  sb.append("|");
  sb.append(refundContent);
  return sb.toString(); 
 } 


}
