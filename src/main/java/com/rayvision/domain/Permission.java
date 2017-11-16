package com.rayvision.domain;

/**
 * Created by xuyangyang on 2017/11/14.
 */
public class Permission {

    private Integer id;
    private Integer resourcesId;
    private Integer type;
    private String name;
    private String descritpion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getResourcesId() {
        return resourcesId;
    }

    public void setResourcesId(Integer resourcesId) {
        this.resourcesId = resourcesId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescritpion() {
        return descritpion;
    }

    public void setDescritpion(String descritpion) {
        this.descritpion = descritpion;
    }
}