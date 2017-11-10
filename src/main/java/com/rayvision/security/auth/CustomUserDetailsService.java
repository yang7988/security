package com.rayvision.security.auth;

import com.rayvision.domain.User;
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
 * Created by admin on 2017/11/9.
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserDetails userDetails = null;
        User user = userService.findUserByUserName(userName);
        if (user == null)
        {
            throw new UsernameNotFoundException("用户不存在");
        }
        // 读取用户角色列表
        List<String> roles = userService.findRoleByUserName(userName);
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        if (roles != null && roles.size() > 0)
        {
            for (String role : roles)
            {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role);
                authorities.add(grantedAuthority);
            }
        }
        userDetails = new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),authorities);
        return userDetails;
    }
}