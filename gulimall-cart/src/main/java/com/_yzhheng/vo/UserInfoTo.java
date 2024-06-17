package com._yzhheng.vo;

import lombok.Data;

@Data
public class UserInfoTo {
    private String username;
    private String userkey;
    private boolean tempUser = false;
}
