package com.rayvision.service.impl;

import com.rayvision.domain.Permission;
import com.rayvision.mapper.PermissionMapper;
import com.rayvision.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xuyangyang on 2017/11/14.
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> findPermissionByUserId(Integer userId) {
        return permissionMapper.findPermissionByUserId(userId);
    }

    @Override
    public List<Permission> findAllPermissions() {
        return permissionMapper.findAllPermissions();
    }
}