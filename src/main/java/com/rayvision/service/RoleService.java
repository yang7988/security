package com.rayvision.service;

import com.rayvision.domain.Role;

import java.util.List;

/**
 * Created by admin on 2017/11/14.
 */
public interface RoleService {
    List<Role> findRoleByUserId(Integer userId);
}
