package com.kavlez.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author: Kavlez
 * sweet_dreams@aliyun.com
 * 14-12-22
 */
@Controller
@RequestMapping("/")
public class HelloController {

    /**
     * use {@link org.springframework.web.servlet.view.InternalResourceViewResolver}
     * to dispatch request to hello.jsp
     *
     * @return hello.jsp
     */
    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("message","Hello Controller!");
        return "/hello";
    }
}
