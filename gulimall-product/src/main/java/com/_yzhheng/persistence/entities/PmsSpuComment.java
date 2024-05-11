/*
 * Created on 2024-05-02 ( 14:45:36 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 3.3.0
 */
package com._yzhheng.persistence.entities;

import java.io.Serializable;

import java.util.Date;
import jakarta.persistence.*;
import lombok.Data;

/**
 * JPA entity class for "PmsSpuComment"
 *
 * @author Telosys
 *
 */
@Data
@Entity
@Table(name="pms_spu_comment", catalog="gulimall-pms" )
public class PmsSpuComment implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- PRIMARY KEY 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Long       id ;

    //--- OTHER DATA FIELDS 
    @Column(name="sku_id")
    private Long       skuId ;

    @Column(name="spu_id")
    private Long       spuId ;

    @Column(name="spu_name", length=255)
    private String     spuName ;

    @Column(name="member_nick_name", length=255)
    private String     memberNickName ;

    @Column(name="star")
    private Boolean    star ;

    @Column(name="member_ip", length=64)
    private String     memberIp ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_time")
    private Date       createTime ;

    @Column(name="show_status")
    private Boolean    showStatus ;

    @Column(name="spu_attributes", length=255)
    private String     spuAttributes ;

    @Column(name="likes_count")
    private Integer    likesCount ;

    @Column(name="reply_count")
    private Integer    replyCount ;

    @Column(name="resources", length=1000)
    private String     resources ;

    @Column(name="content", length=65535)
    private String     content ;

    @Column(name="member_icon", length=255)
    private String     memberIcon ;

    @Column(name="comment_type")
    private Byte       commentType ;

    /**
     * Constructor
     */
    public PmsSpuComment() {
		super();
    }
  
	@Override
 public String toString() { 
  StringBuilder sb = new StringBuilder(); 
  sb.append(id);
  sb.append("|");
  sb.append(skuId);
  sb.append("|");
  sb.append(spuId);
  sb.append("|");
  sb.append(spuName);
  sb.append("|");
  sb.append(memberNickName);
  sb.append("|");
  sb.append(star);
  sb.append("|");
  sb.append(memberIp);
  sb.append("|");
  sb.append(createTime);
  sb.append("|");
  sb.append(showStatus);
  sb.append("|");
  sb.append(spuAttributes);
  sb.append("|");
  sb.append(likesCount);
  sb.append("|");
  sb.append(replyCount);
  sb.append("|");
  sb.append(resources);
  // attribute 'content' not usable (type = String Long Text)
  sb.append("|");
  sb.append(memberIcon);
  sb.append("|");
  sb.append(commentType);
  return sb.toString(); 
 } 


}
