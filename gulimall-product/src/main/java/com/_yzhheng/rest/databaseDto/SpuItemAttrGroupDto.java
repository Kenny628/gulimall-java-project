package com._yzhheng.rest.databaseDto;

import java.util.List;

public class SpuItemAttrGroupDto {
    private String groupName;
    private List<AttrDto> attrs;

    // Constructors, getters, and setters
    public SpuItemAttrGroupDto(String groupName, List<AttrDto> attrs) {
        this.groupName = groupName;
        this.attrs = attrs;
    }

    // Getters and setters
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<AttrDto> getAttrs() {
        return attrs;
    }

    public void setAttrs(List<AttrDto> attrs) {
        this.attrs = attrs;
    }
}
