package com.rayvision.service.impl;

import com.rayvision.domain.Role;
import com.rayvision.mapper.RoleMapper;
import com.rayvision.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2017/11/14.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Role> findRoleByUserId(Integer userId) {
        return roleMapper.findRoleByUserId(userId);
    }
}