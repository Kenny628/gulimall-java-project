/*
 * Created on 2024-05-02 ( 16:45:39 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 3.3.0
 */
package com._yzhheng.vo;

import java.io.Serializable;
import lombok.Data;

import java.util.Date;

/**
 * DTO class for "UmsMember"
 *
 * @author Telosys
 *
 */
@Data
public class UmsMemberDTO {

  private static final long serialVersionUID = 1L;

  // --- PRIMARY KEY
  private Long id;
  // --- OTHER DATA FIELDS
  private Long levelId;
  private String username;
  private String password;
  private String nickname;
  private String mobile;
  private String email;
  private String header;
  private Byte gender;
  private Date birth;
  private String city;
  private String job;
  private String sign;
  private Byte sourceType;
  private Integer integration;
  private Integer growth;
  private Byte status;
  private Date createTime;
  private String socialUid;
  private String accessToken;

  /**
   * Constructor
   */
  public UmsMemberDTO() {
    super();
  }
}