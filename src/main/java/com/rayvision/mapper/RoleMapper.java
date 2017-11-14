package com.rayvision.mapper;

import com.rayvision.domain.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xuyangyang on 2017/11/10.
 */
@Repository
public interface RoleMapper {
    int insertSelective(Role role);

    int updateByPrimaryKeySelective(Role role);

    List<Role> findRoleByUserId(Integer userId);
}
