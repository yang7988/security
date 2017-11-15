package com.rayvision.security;

import com.rayvision.domain.Permission;
import com.rayvision.domain.Resources;
import com.rayvision.domain.Role;
import com.rayvision.domain.User;
import com.rayvision.service.PermissionService;
import com.rayvision.service.ResourcesService;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @Autowired
    private ResourcesService resourcesService;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserDetails userDetails;
        User user = userService.findUserByUserName(userName);
        if (user == null) throw new UsernameNotFoundException("用户不存在");
        List<Role> roles = roleService.findRoleByUserId(user.getId());
        // 读取用户角色列表
        List<Permission> permissions = permissionService.findPermissionByUserId(user.getId());
        Set<GrantedAuthority> authorities = new HashSet<>();
        List<Resources> availableResources = new ArrayList<>();
        for (Permission permission : permissions)
        {
            List<Resources> resources = resourcesService.findResourcesByPermissionId(permission.getId());
            if (resources != null && resources.size() > 0)
            {
                for (Resources resource : resources)
                {
                    if(ResourceEnum.DYNAMIC.getType().equals(resource.getType()))
                    {
                        GrantedAuthority grantedAuthority = new RestGrantedAuthority(resource.getUrl(),permission.getName());
                        authorities.add(grantedAuthority);
                    }
                }
                availableResources.addAll(resources);
            }
        }
        userDetails = new UserPrincipal(user.getUserName(), user.getPassword(), authorities, availableResources);
        return userDetails;
    }
}