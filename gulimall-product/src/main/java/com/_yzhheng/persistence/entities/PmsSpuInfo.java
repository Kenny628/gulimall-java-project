/*
 * Created on 2024-05-02 ( 14:45:36 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 3.3.0
 */
package com._yzhheng.persistence.entities;

import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;
import jakarta.persistence.*;
import lombok.Data;

/**
 * JPA entity class for "PmsSpuInfo"
 *
 * @author Telosys
 *
 */
@Data
@Entity
@Table(name="pms_spu_info", catalog="gulimall-pms" )
public class PmsSpuInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- PRIMARY KEY 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Long       id ;

    //--- OTHER DATA FIELDS 
    @Column(name="spu_name", length=200)
    private String     spuName ;

    @Column(name="spu_description", length=1000)
    private String     spuDescription ;

    @Column(name="catalog_id")
    private Long       catalogId ;

    @Column(name="brand_id")
    private Long       brandId ;

    @Column(name="weight")
    private BigDecimal weight ;

    @Column(name="publish_status")
    private Byte       publishStatus ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_time")
    private Date       createTime ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="update_time")
    private Date       updateTime ;

    /**
     * Constructor
     */
    public PmsSpuInfo() {
		super();
    }
  
	@Override
 public String toString() { 
  StringBuilder sb = new StringBuilder(); 
  sb.append(id);
  sb.append("|");
  sb.append(spuName);
  sb.append("|");
  sb.append(spuDescription);
  sb.append("|");
  sb.append(catalogId);
  sb.append("|");
  sb.append(brandId);
  sb.append("|");
  sb.append(weight);
  sb.append("|");
  sb.append(publishStatus);
  sb.append("|");
  sb.append(createTime);
  sb.append("|");
  sb.append(updateTime);
  return sb.toString(); 
 } 


}
