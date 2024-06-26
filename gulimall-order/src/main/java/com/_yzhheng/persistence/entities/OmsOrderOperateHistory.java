/*
 * Created on 2024-05-02 ( 22:23:25 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 3.3.0
 */
package com._yzhheng.persistence.entities;

import java.io.Serializable;

import java.util.Date;
import jakarta.persistence.*;
import lombok.Data;

/**
 * JPA entity class for "OmsOrderOperateHistory"
 *
 * @author Telosys
 *
 */
@Data
@Entity
@Table(name="oms_order_operate_history", catalog="gulimall-oms" )
public class OmsOrderOperateHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- PRIMARY KEY 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Long       id ;

    //--- OTHER DATA FIELDS 
    @Column(name="order_id")
    private Long       orderId ;

    @Column(name="operate_man", length=100)
    private String     operateMan ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_time")
    private Date       createTime ;

    @Column(name="order_status")
    private Byte       orderStatus ;

    @Column(name="note", length=500)
    private String     note ;

    /**
     * Constructor
     */
    public OmsOrderOperateHistory() {
		super();
    }
  
	@Override
 public String toString() { 
  StringBuilder sb = new StringBuilder(); 
  sb.append(id);
  sb.append("|");
  sb.append(orderId);
  sb.append("|");
  sb.append(operateMan);
  sb.append("|");
  sb.append(createTime);
  sb.append("|");
  sb.append(orderStatus);
  sb.append("|");
  sb.append(note);
  return sb.toString(); 
 } 


}
