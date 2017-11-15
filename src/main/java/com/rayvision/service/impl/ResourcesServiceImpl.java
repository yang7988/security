package com.rayvision.service.impl;

import com.rayvision.domain.Resources;
import com.rayvision.mapper.ResourcesMapper;
import com.rayvision.security.GrantedResources;
import com.rayvision.service.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2017/11/14.
 */
@Service
public class ResourcesServiceImpl implements ResourcesService {

    @Autowired
    private ResourcesMapper resourcesMapper;

    @Override
    public List<Resources> findResourcesByPermissionId(Integer permissionId) {
        return resourcesMapper.findResourcesByPermissionId(permissionId);
    }

    @Override
    public List<GrantedResources> findGrantedResources() {
        return resourcesMapper.findGrantedResources();
    }
}