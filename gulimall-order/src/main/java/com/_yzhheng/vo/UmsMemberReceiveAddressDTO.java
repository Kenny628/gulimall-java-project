/*
 * Created on 2024-05-02 ( 16:45:40 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 3.3.0
 */
package com._yzhheng.vo;

import java.io.Serializable;
import lombok.Data;

/**
 * DTO class for "UmsMemberReceiveAddress"
 *
 * @author Telosys
 *
 */
@Data
public class UmsMemberReceiveAddressDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  // --- PRIMARY KEY
  private Long id;
  // --- OTHER DATA FIELDS
  private Long memberId;
  private String name;
  private String phone;
  private String postCode;
  private String province;
  private String city;
  private String region;
  private String detailAddress;
  private String areacode;
  private Boolean defaultStatus;

  /**
   * Constructor
   */
  public UmsMemberReceiveAddressDTO() {
    super();
  }
}
