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
    private HashMap<String, Collection<ConfigAttribute>> map =null;

    public void loadResourceDefine()
    {
        map = new HashMap<>();
        Collection<ConfigAttribute> collection;
        ConfigAttribute cfg;
        List<Permission> permissions = permissionService.findAllPermissions();
        for (Permission permission : permissions)
        {
            collection = new ArrayList<>();
            cfg = new SecurityConfig(permission.getPermissionName());
            //此处只添加了用户的名字，其实还可以添加更多权限的信息，
            // 例如请求方法到ConfigAttribute的集合中去。此处添加的信息将会作为MyAccessDecisionManager类的decide的第三个参数。
            collection.add(cfg);
            //用权限的getUrl() 作为map的key，用ConfigAttribute的集合作为 value，
            map.put(permission.getUrl(), collection);
        }
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        if(map ==null) loadResourceDefine();
        //object 中包含用户请求的request 信息
        HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
        AntPathRequestMatcher matcher;
        String resUrl;
        for(Iterator<String> it = map.keySet().iterator(); it.hasNext(); )
        {
            resUrl = it.next();
            matcher = new AntPathRequestMatcher(resUrl);
            if(matcher.matches(request))
            {
                return map.get(resUrl);
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