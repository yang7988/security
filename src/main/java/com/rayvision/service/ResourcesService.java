package com.rayvision.service;

import com.rayvision.domain.Resources;
import com.rayvision.security.GrantedResources;

import java.util.List;

/**
 * Created by admin on 2017/11/14.
 */
public interface ResourcesService {

    public List<Resources> findResourcesByPermissionId(Integer permissionId);

    public List<GrantedResources> findGrantedResources();
}
