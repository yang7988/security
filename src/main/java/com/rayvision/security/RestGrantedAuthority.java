package com.rayvision.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by xuyangyang on 2017/11/14.
 */
public class RestGrantedAuthority implements GrantedAuthority {

    private String resName;
    private String authority;

    public RestGrantedAuthority() {
    }

    public RestGrantedAuthority(String resName, String authority) {
        this.resName = resName;
        this.authority = authority;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}