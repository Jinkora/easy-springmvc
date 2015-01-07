package com.kavlez.controller;

import com.kavlez.pojo.Subject;
import com.kavlez.pojo.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * @author: Kavlez
 * sweet_dreams@aliyun.com
 */
@Controller
@RequestMapping("/returnFormat")
public class ReturnFormatController {


    @RequestMapping
    public String main() {
        return "/returnFormat";
    }

    /**
     * @return as json format due to jackson-core is declared in pom.xml
     */
    @RequestMapping(value = "/teachers")
    @ResponseBody
    public List<Teacher> teachers() {
        return Arrays.asList(
                new Teacher().setName("Silva"),
                new Teacher().setName("Velasquez"),
                new Teacher().setName("Aldo"),
                new Teacher().setName("Machida"));
    }

    /**
     * @return as json format due to jackson-core is declared in pom.xml
     */
    @RequestMapping("/subject")
    @ResponseBody
    public Subject subject() {
        Subject subject = new Subject();
        subject.setName("computer science");
        return subject;
    }
}
