package com.rayvision.service;

import com.rayvision.domain.Permission;

import java.util.List;

/**
 * Created by xuyangyang on 2017/11/14.
 */
public interface PermissionService {

    List<Permission> findPermissionByUserId(Integer userId);

    List<Permission> findPermissionByRoleId(Integer roleId);

    List<Permission> findAllPermissions();
}
