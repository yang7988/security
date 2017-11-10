package com.rayvision.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2017/11/10.
 */
@RestController(value = "/api")
public class HomeController {

    @GetMapping(value = "/foos")
    public Object foos() {
        Map<String,Object> foo = new HashMap<String,Object>();
        foo.put("id", 0);
        foo.put("name", "xuyang");
        return foo;
    }
 }