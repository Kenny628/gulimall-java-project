/*
 * Created on 2024-05-02 ( 22:23:25 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 3.3.0
 */
package com._yzhheng.persistence.entities;

import java.io.Serializable;

import java.math.BigDecimal;
import jakarta.persistence.*;
import lombok.Data;

/**
 * JPA entity class for "OmsOrderItem"
 *
 * @author Telosys
 *
 */
@Data
@Entity
@Table(name="oms_order_item", catalog="gulimall-oms" )
public class OmsOrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- PRIMARY KEY 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Long       id ;

    //--- OTHER DATA FIELDS 
    @Column(name="order_id")
    private Long       orderId ;

    @Column(name="order_sn", length=32)
    private String     orderSn ;

    @Column(name="spu_id")
    private Long       spuId ;

    @Column(name="spu_name", length=255)
    private String     spuName ;

    @Column(name="spu_pic", length=500)
    private String     spuPic ;

    @Column(name="spu_brand", length=200)
    private String     spuBrand ;

    @Column(name="category_id")
    private Long       categoryId ;

    @Column(name="sku_id")
    private Long       skuId ;

    @Column(name="sku_name", length=255)
    private String     skuName ;

    @Column(name="sku_pic", length=500)
    private String     skuPic ;

    @Column(name="sku_price")
    private BigDecimal skuPrice ;

    @Column(name="sku_quantity")
    private Integer    skuQuantity ;

    @Column(name="sku_attrs_vals", length=500)
    private String     skuAttrsVals ;

    @Column(name="promotion_amount")
    private BigDecimal promotionAmount ;

    @Column(name="coupon_amount")
    private BigDecimal couponAmount ;

    @Column(name="integration_amount")
    private BigDecimal integrationAmount ;

    @Column(name="real_amount")
    private BigDecimal realAmount ;

    @Column(name="gift_integration")
    private Integer    giftIntegration ;

    @Column(name="gift_growth")
    private Integer    giftGrowth ;

    /**
     * Constructor
     */
    public OmsOrderItem() {
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
  sb.append(spuId);
  sb.append("|");
  sb.append(spuName);
  sb.append("|");
  sb.append(spuPic);
  sb.append("|");
  sb.append(spuBrand);
  sb.append("|");
  sb.append(categoryId);
  sb.append("|");
  sb.append(skuId);
  sb.append("|");
  sb.append(skuName);
  sb.append("|");
  sb.append(skuPic);
  sb.append("|");
  sb.append(skuPrice);
  sb.append("|");
  sb.append(skuQuantity);
  sb.append("|");
  sb.append(skuAttrsVals);
  sb.append("|");
  sb.append(promotionAmount);
  sb.append("|");
  sb.append(couponAmount);
  sb.append("|");
  sb.append(integrationAmount);
  sb.append("|");
  sb.append(realAmount);
  sb.append("|");
  sb.append(giftIntegration);
  sb.append("|");
  sb.append(giftGrowth);
  return sb.toString(); 
 } 


}
