package com._yzhheng.rest.databaseDto;

public class AttrDto {
    private Long attrId;
    private String attrName;
    private String attrValue;

    // Constructors, getters, and setters
    public AttrDto(Long attrId, String attrName, String attrValue) {
        this.attrId = attrId;
        this.attrName = attrName;
        this.attrValue = attrValue;
    }

    // Getters and setters
    public Long getAttrId() {
        return attrId;
    }

    public void setAttrId(Long attrId) {
        this.attrId = attrId;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public String getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue;
    }
}
