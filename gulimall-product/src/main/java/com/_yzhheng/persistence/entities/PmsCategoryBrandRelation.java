/*
 * Created on 2024-05-02 ( 14:45:35 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 3.3.0
 */
package com._yzhheng.persistence.entities;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Data;

/**
 * JPA entity class for "PmsCategoryBrandRelation"
 *
 * @author Telosys
 *
 */
@Data
@Entity
@Table(name="pms_category_brand_relation", catalog="gulimall-pms" )
public class PmsCategoryBrandRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- PRIMARY KEY 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Long       id ;

    //--- OTHER DATA FIELDS 
    @Column(name="brand_id")
    private Long       brandId ;

    @Column(name="catelog_id")
    private Long       catelogId ;

    @Column(name="brand_name", length=255)
    private String     brandName ;

    @Column(name="catelog_name", length=255)
    private String     catelogName ;

    /**
     * Constructor
     */
    public PmsCategoryBrandRelation() {
		super();
    }
  
	@Override
 public String toString() { 
  StringBuilder sb = new StringBuilder(); 
  sb.append(id);
  sb.append("|");
  sb.append(brandId);
  sb.append("|");
  sb.append(catelogId);
  sb.append("|");
  sb.append(brandName);
  sb.append("|");
  sb.append(catelogName);
  return sb.toString(); 
 } 


}