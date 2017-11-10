package com.rayvision.service.impl;

import com.rayvision.domain.User;
import com.rayvision.mapper.UserMapper;
import com.rayvision.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/11/10.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserByUserName(String userName) {
        User user = new User();
        user.setId(1);
        user.setUserName("xuyang");
        user.setPassword("12345678");
        return user;
//        return userMapper.findByUserName(userName);
    }

    @Override
    public List<String> findRoleByUserName(String userName) {
        List<String> list = new ArrayList<>();
        list.add("ADMIN");
        return list;
//        return userMapper.findRoleByUserName(userName);
    }
}