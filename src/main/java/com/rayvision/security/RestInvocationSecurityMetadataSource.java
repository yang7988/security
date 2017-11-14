package com.rayvision.security;

import com.rayvision.domain.Permission;
import com.rayvision.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by xuyangyang on 2017/11/13.
 */
@Component
public class RestInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private PermissionService permissionService;
    private HashMap<String, Collection<ConfigAttribute>> recesourcesMap =null;

    public void loadResourceDefine()
    {
        recesourcesMap = new HashMap<>();
        Collection<ConfigAttribute> collection;
        ConfigAttribute cfg;
        List<Permission> permissions = permissionService.findAllPermissions();
        for (Permission permission : permissions)
        {
            collection = new ArrayList<>();
            cfg = new SecurityConfig(permission.getPermissionName());
            collection.add(cfg);
            recesourcesMap.put(permission.getUrl(), collection);
        }
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        if(recesourcesMap ==null) loadResourceDefine();
        HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
        AntPathRequestMatcher matcher;
        String resUrl;
        for(Iterator<String> it = recesourcesMap.keySet().iterator(); it.hasNext(); )
        {
            resUrl = it.next();
            matcher = new AntPathRequestMatcher(resUrl);
            if(matcher.matches(request))
            {
                return recesourcesMap.get(resUrl);
            }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}