package com.rayvision.security;

import com.rayvision.domain.Permission;
import com.rayvision.domain.Role;
import com.rayvision.domain.User;
import com.rayvision.service.PermissionService;
import com.rayvision.service.RoleService;
import com.rayvision.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuyangyang on 2017/11/9.
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private RoleService roleService;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserDetails userDetails;
        User user = userService.findUserByUserName(userName);
        if (user == null)
        {
            throw new UsernameNotFoundException("用户不存在");
        }
        List<Role> roles = roleService.findRoleByUserId(user.getId());
        // 读取用户角色列表
        List<Permission> permissions = permissionService.findPermissionByUserId(user.getId());
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Permission permission : permissions)
        {
            if (permission != null && permission.getName() != null)
            {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getName());
                authorities.add(grantedAuthority);
            }
        }
        userDetails = new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),authorities);
        return userDetails;
    }
}