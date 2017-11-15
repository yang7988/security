package com.rayvision.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by xuyangyang on 2017/11/14.
 */
public class RestGrantedAuthority implements GrantedAuthority {

    private String resUrl;
    private String permCode;

    public RestGrantedAuthority(String resUrl, String permCode) {
        this.resUrl = resUrl;
        this.permCode = permCode;
    }

    public String getResUrl() {
        return resUrl;
    }

    public void setResUrl(String resUrl) {
        this.resUrl = resUrl;
    }

    public String getPermCode() {
        return permCode;
    }

    public void setPermCode(String permCode) {
        this.permCode = permCode;
    }

    @Override
    public String getAuthority() {
        return this.resUrl.concat(":").concat(this.permCode);
    }
}