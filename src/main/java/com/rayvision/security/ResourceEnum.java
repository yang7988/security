package com.rayvision.security;

/**
 * Created by admin on 2017/11/15.
 */
public enum ResourceEnum {
    STATIC(1),
    DYNAMIC(2);
    private Integer type;

    ResourceEnum(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
