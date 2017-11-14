package com.rayvision.mapper;

import com.rayvision.domain.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xuyangyang on 2017/11/10.
 */
@Repository
public interface PermissionMapper {
    int insertSelective(Permission permission);

    List<Permission> findPermissionByUserId(Integer userId);

    List<Permission> findAllPermissions();

    List<Permission> findPermissionByRoleId(Integer roleId);
}
