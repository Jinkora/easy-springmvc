package com.kavlez.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author: Kavlez
 * sweet_dreams@aliyun.com
 * 14-12-22
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "/hello";
    }
}
