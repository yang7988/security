package com.rayvision.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by xuyangyang on 2017/11/14.
 */
public class RestGrantedAuthority implements GrantedAuthority {

    private String resCode;
    private String permCode;

    public RestGrantedAuthority() {
    }

    public RestGrantedAuthority(String resCode, String permCode) {
        this.resCode = resCode;
        this.permCode = permCode;
    }

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getPermCode() {
        return permCode;
    }

    public void setPermCode(String permCode) {
        this.permCode = permCode;
    }

    @Override
    public String getAuthority() {
        return this.resCode.concat(":").concat(this.permCode);
    }
}