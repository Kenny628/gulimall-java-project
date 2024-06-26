/*
 * Created on 2024-05-02 ( 16:45:39 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 3.3.0
 */
package com._yzhheng.persistence.entities;

import java.io.Serializable;

import java.util.Date;
import jakarta.persistence.*;
import lombok.Data;

/**
 * JPA entity class for "UmsMember"
 *
 * @author Telosys
 *
 */
@Data
@Entity
@Table(name = "ums_member", catalog = "gulimall-ums")
public class UmsMember implements Serializable {

  private static final long serialVersionUID = 1L;

  // --- PRIMARY KEY
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Long id;

  // --- OTHER DATA FIELDS
  @Column(name = "level_id")
  private Long levelId;

  @Column(name = "username", length = 64)
  private String username;

  @Column(name = "password", length = 64)
  private String password;

  @Column(name = "nickname", length = 64)
  private String nickname;

  @Column(name = "mobile", length = 20)
  private String mobile;

  @Column(name = "email", length = 64)
  private String email;

  @Column(name = "header", length = 500)
  private String header;

  @Column(name = "gender")
  private Byte gender;

  @Temporal(TemporalType.DATE)
  @Column(name = "birth")
  private Date birth;

  @Column(name = "city", length = 500)
  private String city;

  @Column(name = "job", length = 255)
  private String job;

  @Column(name = "sign", length = 255)
  private String sign;

  @Column(name = "source_type")
  private Byte sourceType;

  @Column(name = "integration")
  private Integer integration;

  @Column(name = "growth")
  private Integer growth;

  @Column(name = "status")
  private Byte status;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "create_time")
  private Date createTime;

  @Column(name = "social_uid", length = 255)
  private String socialUid;

  @Column(name = "access_token", length = 255)
  private String accessToken;

  /**
   * Constructor
   */
  public UmsMember() {
    super();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(id);
    sb.append("|");
    sb.append(levelId);
    sb.append("|");
    sb.append(username);
    sb.append("|");
    sb.append(password);
    sb.append("|");
    sb.append(nickname);
    sb.append("|");
    sb.append(mobile);
    sb.append("|");
    sb.append(email);
    sb.append("|");
    sb.append(header);
    sb.append("|");
    sb.append(gender);
    sb.append("|");
    sb.append(birth);
    sb.append("|");
    sb.append(city);
    sb.append("|");
    sb.append(job);
    sb.append("|");
    sb.append(sign);
    sb.append("|");
    sb.append(sourceType);
    sb.append("|");
    sb.append(integration);
    sb.append("|");
    sb.append(growth);
    sb.append("|");
    sb.append(status);
    sb.append("|");
    sb.append(createTime);
    return sb.toString();
  }

}
