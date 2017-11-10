package com.rayvision.mapper;

import com.rayvision.domain.Role;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 2017/11/10.
 */
@Repository
public interface RoleMapper {
    int insertSelective(Role role);

    int updateByPrimaryKeySelective(Role role);
}
