package com.rayvision.controller;

import com.rayvision.security.UserPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuyangyang on 2017/11/10.
 */
@RestController
@RequestMapping(value = "/api")
public class HomeController {

    @GetMapping(value = "/user")
    public Object foos() {
        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userPrincipal;
    }
 }