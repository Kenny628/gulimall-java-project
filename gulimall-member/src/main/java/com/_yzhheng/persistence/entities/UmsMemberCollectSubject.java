/*
 * Created on 2024-05-02 ( 16:45:39 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 3.3.0
 */
package com._yzhheng.persistence.entities;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Data;

/**
 * JPA entity class for "UmsMemberCollectSubject"
 *
 * @author Telosys
 *
 */
@Data
@Entity
@Table(name="ums_member_collect_subject", catalog="gulimall-ums" )
public class UmsMemberCollectSubject implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- PRIMARY KEY 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Long       id ;

    //--- OTHER DATA FIELDS 
    @Column(name="subject_id")
    private Long       subjectId ;

    @Column(name="subject_name", length=255)
    private String     subjectName ;

    @Column(name="subject_img", length=500)
    private String     subjectImg ;

    @Column(name="subject_urll", length=500)
    private String     subjectUrll ;

    /**
     * Constructor
     */
    public UmsMemberCollectSubject() {
		super();
    }
  
	@Override
 public String toString() { 
  StringBuilder sb = new StringBuilder(); 
  sb.append(id);
  sb.append("|");
  sb.append(subjectId);
  sb.append("|");
  sb.append(subjectName);
  sb.append("|");
  sb.append(subjectImg);
  sb.append("|");
  sb.append(subjectUrll);
  return sb.toString(); 
 } 


}
