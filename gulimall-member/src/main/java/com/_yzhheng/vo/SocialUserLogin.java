package com._yzhheng.vo;

import lombok.Data;

@Data
public class SocialUserLogin {
    private String access_token;
    private String scope;
    private String token_type;
    private String retrievedUsername;
    private String retrievedUserId;
}
