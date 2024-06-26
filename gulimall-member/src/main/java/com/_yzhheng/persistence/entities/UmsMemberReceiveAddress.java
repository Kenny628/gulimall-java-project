/*
 * Created on 2024-05-02 ( 16:45:39 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 3.3.0
 */
package com._yzhheng.persistence.entities;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Data;

/**
 * JPA entity class for "UmsMemberReceiveAddress"
 *
 * @author Telosys
 *
 */
@Data
@Entity
@Table(name="ums_member_receive_address", catalog="gulimall-ums" )
public class UmsMemberReceiveAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- PRIMARY KEY 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Long       id ;

    //--- OTHER DATA FIELDS 
    @Column(name="member_id")
    private Long       memberId ;

    @Column(name="name", length=255)
    private String     name ;

    @Column(name="phone", length=64)
    private String     phone ;

    @Column(name="post_code", length=64)
    private String     postCode ;

    @Column(name="province", length=100)
    private String     province ;

    @Column(name="city", length=100)
    private String     city ;

    @Column(name="region", length=100)
    private String     region ;

    @Column(name="detail_address", length=255)
    private String     detailAddress ;

    @Column(name="areacode", length=15)
    private String     areacode ;

    @Column(name="default_status")
    private Boolean    defaultStatus ;

    /**
     * Constructor
     */
    public UmsMemberReceiveAddress() {
		super();
    }
  
	@Override
 public String toString() { 
  StringBuilder sb = new StringBuilder(); 
  sb.append(id);
  sb.append("|");
  sb.append(memberId);
  sb.append("|");
  sb.append(name);
  sb.append("|");
  sb.append(phone);
  sb.append("|");
  sb.append(postCode);
  sb.append("|");
  sb.append(province);
  sb.append("|");
  sb.append(city);
  sb.append("|");
  sb.append(region);
  sb.append("|");
  sb.append(detailAddress);
  sb.append("|");
  sb.append(areacode);
  sb.append("|");
  sb.append(defaultStatus);
  return sb.toString(); 
 } 


}
