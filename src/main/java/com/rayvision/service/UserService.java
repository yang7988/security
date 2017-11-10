package com.rayvision.service;

import com.rayvision.domain.User;

import java.util.List;

/**
 * Created by admin on 2017/11/10.
 */
public interface UserService {
    User findUserByUserName(String userName);

    List<String> findRoleByUserName(String userName);
}
