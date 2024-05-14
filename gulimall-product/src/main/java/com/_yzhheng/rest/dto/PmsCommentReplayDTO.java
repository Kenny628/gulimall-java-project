/*
 * Created on 2024-05-02 ( 14:45:35 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 3.3.0
 */
package com._yzhheng.rest.dto;

import java.io.Serializable;
import lombok.Data;


/**
 * DTO class for "PmsCommentReplay"
 *
 * @author Telosys
 *
 */
@Data
public class PmsCommentReplayDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- PRIMARY KEY 
    private Long id ;
    //--- OTHER DATA FIELDS 
    private Long commentId ;
    private Long replyId ;

    /**
     * Constructor
     */
    public PmsCommentReplayDTO() {
		super();
    }
}
    
