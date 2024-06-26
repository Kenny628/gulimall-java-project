/*
 * Created on 2024-05-02 ( 19:42:32 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 3.3.0
 */
package com._yzhheng.persistence.entities;

import java.io.Serializable;

import java.util.Date;
import jakarta.persistence.*;
import lombok.Data;

/**
 * JPA entity class for "WmsWareOrderTask"
 *
 * @author Telosys
 *
 */
@Data
@Entity
@Table(name="wms_ware_order_task", catalog="gulimall-wms" )
public class WmsWareOrderTask implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- PRIMARY KEY 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Long       id ;

    //--- OTHER DATA FIELDS 
    @Column(name="order_id")
    private Long       orderId ;

    @Column(name="order_sn", length=255)
    private String     orderSn ;

    @Column(name="consignee", length=100)
    private String     consignee ;

    @Column(name="consignee_tel", length=15)
    private String     consigneeTel ;

    @Column(name="delivery_address", length=500)
    private String     deliveryAddress ;

    @Column(name="order_comment", length=200)
    private String     orderComment ;

    @Column(name="payment_way")
    private Boolean    paymentWay ;

    @Column(name="task_status")
    private Byte       taskStatus ;

    @Column(name="order_body", length=255)
    private String     orderBody ;

    @Column(name="tracking_no", length=30)
    private String     trackingNo ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_time")
    private Date       createTime ;

    @Column(name="ware_id")
    private Long       wareId ;

    @Column(name="task_comment", length=500)
    private String     taskComment ;

    /**
     * Constructor
     */
    public WmsWareOrderTask() {
		super();
    }
  
	@Override
 public String toString() { 
  StringBuilder sb = new StringBuilder(); 
  sb.append(id);
  sb.append("|");
  sb.append(orderId);
  sb.append("|");
  sb.append(orderSn);
  sb.append("|");
  sb.append(consignee);
  sb.append("|");
  sb.append(consigneeTel);
  sb.append("|");
  sb.append(deliveryAddress);
  sb.append("|");
  sb.append(orderComment);
  sb.append("|");
  sb.append(paymentWay);
  sb.append("|");
  sb.append(taskStatus);
  sb.append("|");
  sb.append(orderBody);
  sb.append("|");
  sb.append(trackingNo);
  sb.append("|");
  sb.append(createTime);
  sb.append("|");
  sb.append(wareId);
  sb.append("|");
  sb.append(taskComment);
  return sb.toString(); 
 } 


}
