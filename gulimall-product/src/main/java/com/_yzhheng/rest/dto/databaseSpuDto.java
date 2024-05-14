package com._yzhheng.rest.dto;

import lombok.Data;

@Data
public class databaseSpuDto {

    private String attrGroupName;
    private String attrName;
    private String attrValue;

    public databaseSpuDto(String attrGroupName, String attrName, String attrValue) {
        this.attrGroupName = attrGroupName;
        this.attrName = attrName;
        this.attrValue = attrValue;
    }

    // getters and setters
}
