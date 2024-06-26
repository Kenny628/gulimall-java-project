/*
 * Created on 2024-05-02 ( 14:45:35 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 3.3.0
 */
package com._yzhheng.persistence.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

/**
 * JPA entity class for "PmsCategory"
 *
 * @author Telosys
 *
 */
@Data
@Entity
@Table(name = "pms_category", catalog = "gulimall-pms")
public class PmsCategory implements Serializable {

  private static final long serialVersionUID = 1L;

  // --- PRIMARY KEY
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "cat_id", nullable = false)
  private Long catId;

  // --- OTHER DATA FIELDS
  @Column(name = "name", length = 50)
  private String name;

  @Column(name = "parent_cid")
  private Long parentCid;

  @Column(name = "cat_level")
  private Integer catLevel;

  @Column(name = "show_status")
  private Byte showStatus;

  @Column(name = "sort")
  private Integer sort;

  @Column(name = "icon", length = 255)
  private String icon;

  @Column(name = "product_unit", length = 50)
  private String productUnit;

  @Column(name = "product_count")
  private Integer productCount;

  @Transient
  private List<PmsCategory> children;

  /**
   * Constructor
   */
  public PmsCategory() {
    super();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(catId);
    sb.append("|");
    sb.append(name);
    sb.append("|");
    sb.append(parentCid);
    sb.append("|");
    sb.append(catLevel);
    sb.append("|");
    sb.append(showStatus);
    sb.append("|");
    sb.append(sort);
    sb.append("|");
    sb.append(icon);
    sb.append("|");
    sb.append(productUnit);
    sb.append("|");
    sb.append(productCount);
    return sb.toString();
  }

}
