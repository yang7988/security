package com.rayvision.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by xuyangyang on 2017/11/14.
 */
public class RestGrantedAuthority implements GrantedAuthority {

    private String resUrl;
    private String authority;

    public RestGrantedAuthority() {
    }

    public RestGrantedAuthority(String resUrl, String authority) {
        this.resUrl = resUrl;
        this.authority = authority;
    }

    public String getResUrl() {
        return resUrl;
    }

    public void setResUrl(String resUrl) {
        this.resUrl = resUrl;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}