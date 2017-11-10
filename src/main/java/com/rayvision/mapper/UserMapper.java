package com.rayvision.mapper;

import com.rayvision.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by admin on 2017/11/10.
 */
@Repository
public interface UserMapper {

    int insertSelective(User user);

    int updateByPrimaryKeySelective(User user);

    User findByUserName(String userName);

    List<String> findRoleByUserName(String userName);
}
