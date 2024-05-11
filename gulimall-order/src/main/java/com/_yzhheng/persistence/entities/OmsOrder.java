/*
 * Created on 2024-05-02 ( 22:23:25 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 3.3.0
 */
package com._yzhheng.persistence.entities;

import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;
import jakarta.persistence.*;
import lombok.Data;

/**
 * JPA entity class for "OmsOrder"
 *
 * @author Telosys
 *
 */
@Data
@Entity
@Table(name="oms_order", catalog="gulimall-oms" )
public class OmsOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- PRIMARY KEY 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Long       id ;

    //--- OTHER DATA FIELDS 
    @Column(name="member_id")
    private Long       memberId ;

    @Column(name="order_sn", length=32)
    private String     orderSn ;

    @Column(name="coupon_id")
    private Long       couponId ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_time")
    private Date       createTime ;

    @Column(name="member_username", length=200)
    private String     memberUsername ;

    @Column(name="total_amount")
    private BigDecimal totalAmount ;

    @Column(name="pay_amount")
    private BigDecimal payAmount ;

    @Column(name="freight_amount")
    private BigDecimal freightAmount ;

    @Column(name="promotion_amount")
    private BigDecimal promotionAmount ;

    @Column(name="integration_amount")
    private BigDecimal integrationAmount ;

    @Column(name="coupon_amount")
    private BigDecimal couponAmount ;

    @Column(name="discount_amount")
    private BigDecimal discountAmount ;

    @Column(name="pay_type")
    private Byte       payType ;

    @Column(name="source_type")
    private Byte       sourceType ;

    @Column(name="status")
    private Byte       status ;

    @Column(name="delivery_company", length=64)
    private String     deliveryCompany ;

    @Column(name="delivery_sn", length=64)
    private String     deliverySn ;

    @Column(name="auto_confirm_day")
    private Integer    autoConfirmDay ;

    @Column(name="integration")
    private Integer    integration ;

    @Column(name="growth")
    private Integer    growth ;

    @Column(name="bill_type")
    private Byte       billType ;

    @Column(name="bill_header", length=255)
    private String     billHeader ;

    @Column(name="bill_content", length=255)
    private String     billContent ;

    @Column(name="bill_receiver_phone", length=32)
    private String     billReceiverPhone ;

    @Column(name="bill_receiver_email", length=64)
    private String     billReceiverEmail ;

    @Column(name="receiver_name", length=100)
    private String     receiverName ;

    @Column(name="receiver_phone", length=32)
    private String     receiverPhone ;

    @Column(name="receiver_post_code", length=32)
    private String     receiverPostCode ;

    @Column(name="receiver_province", length=32)
    private String     receiverProvince ;

    @Column(name="receiver_city", length=32)
    private String     receiverCity ;

    @Column(name="receiver_region", length=32)
    private String     receiverRegion ;

    @Column(name="receiver_detail_address", length=200)
    private String     receiverDetailAddress ;

    @Column(name="note", length=500)
    private String     note ;

    @Column(name="confirm_status")
    private Byte       confirmStatus ;

    @Column(name="delete_status")
    private Byte       deleteStatus ;

    @Column(name="use_integration")
    private Integer    useIntegration ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="payment_time")
    private Date       paymentTime ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="delivery_time")
    private Date       deliveryTime ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="receive_time")
    private Date       receiveTime ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="comment_time")
    private Date       commentTime ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="modify_time")
    private Date       modifyTime ;

    /**
     * Constructor
     */
    public OmsOrder() {
		super();
    }
  
	@Override
 public String toString() { 
  StringBuilder sb = new StringBuilder(); 
  sb.append(id);
  sb.append("|");
  sb.append(memberId);
  sb.append("|");
  sb.append(orderSn);
  sb.append("|");
  sb.append(couponId);
  sb.append("|");
  sb.append(createTime);
  sb.append("|");
  sb.append(memberUsername);
  sb.append("|");
  sb.append(totalAmount);
  sb.append("|");
  sb.append(payAmount);
  sb.append("|");
  sb.append(freightAmount);
  sb.append("|");
  sb.append(promotionAmount);
  sb.append("|");
  sb.append(integrationAmount);
  sb.append("|");
  sb.append(couponAmount);
  sb.append("|");
  sb.append(discountAmount);
  sb.append("|");
  sb.append(payType);
  sb.append("|");
  sb.append(sourceType);
  sb.append("|");
  sb.append(status);
  sb.append("|");
  sb.append(deliveryCompany);
  sb.append("|");
  sb.append(deliverySn);
  sb.append("|");
  sb.append(autoConfirmDay);
  sb.append("|");
  sb.append(integration);
  sb.append("|");
  sb.append(growth);
  sb.append("|");
  sb.append(billType);
  sb.append("|");
  sb.append(billHeader);
  sb.append("|");
  sb.append(billContent);
  sb.append("|");
  sb.append(billReceiverPhone);
  sb.append("|");
  sb.append(billReceiverEmail);
  sb.append("|");
  sb.append(receiverName);
  sb.append("|");
  sb.append(receiverPhone);
  sb.append("|");
  sb.append(receiverPostCode);
  sb.append("|");
  sb.append(receiverProvince);
  sb.append("|");
  sb.append(receiverCity);
  sb.append("|");
  sb.append(receiverRegion);
  sb.append("|");
  sb.append(receiverDetailAddress);
  sb.append("|");
  sb.append(note);
  sb.append("|");
  sb.append(confirmStatus);
  sb.append("|");
  sb.append(deleteStatus);
  sb.append("|");
  sb.append(useIntegration);
  sb.append("|");
  sb.append(paymentTime);
  sb.append("|");
  sb.append(deliveryTime);
  sb.append("|");
  sb.append(receiveTime);
  sb.append("|");
  sb.append(commentTime);
  sb.append("|");
  sb.append(modifyTime);
  return sb.toString(); 
 } 


}
