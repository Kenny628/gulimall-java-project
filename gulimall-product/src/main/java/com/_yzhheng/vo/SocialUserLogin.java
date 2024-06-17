package com._yzhheng.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class SocialUserLogin implements Serializable {
    private String access_token;
    private String scope;
    private String token_type;
    private String retrievedUsername;
    private String retrievedUserId;
}
