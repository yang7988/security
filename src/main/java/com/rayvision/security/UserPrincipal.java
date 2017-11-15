package com.rayvision.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rayvision.domain.Resources;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by admin on 2017/11/15.
 */
public class UserPrincipal implements UserDetails,Serializable {

    //用户名
    private String username;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private boolean accountNonExpired;
    @JsonIgnore
    private boolean accountNonLocked;
    @JsonIgnore
    private boolean credentialsNonExpired;
    @JsonIgnore
    private boolean enabled;
    private Set<GrantedAuthority> authorities;
    private List<Resources> resources;

    public UserPrincipal(String username, String password, Set<GrantedAuthority> authorities,List<Resources> resources) {
        this(username,password,true, true, true, true,authorities,resources);
    }

    public UserPrincipal(String username, String password, boolean accountNonExpired, boolean accountNonLocked
            , boolean credentialsNonExpired, boolean enabled, Set<GrantedAuthority> authorities,List<Resources> resources) {
        this.username = username;
        this.password = password;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
        this.authorities = authorities;
        this.resources = resources;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    public List<Resources> getResources() {
        return resources;
    }
}