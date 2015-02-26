package com.kavlez.controller;

import com.kavlez.pojo.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Kavlez
 *         sweet_dreams@aliyun.com
 *         <p>
 *         Same url,different method,different message
 */
@Controller
@RequestMapping("/httpMethod")
public class HttpMethodController {


    @RequestMapping
    public String main() {
        return "/httpMethod";
    }

    @RequestMapping(value = "/teachers", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Teacher> teachers() {

        return Arrays.asList(
                new Teacher().setName("Silva"),
                new Teacher().setName("Velasquez"),
                new Teacher().setName("Aldo"),
                new Teacher().setName("Machida"))
                .stream().filter(teacher -> teacher.getName().length() > 2).collect(Collectors.toList());
    }

    @RequestMapping(value = "/teachers", method = RequestMethod.POST)
    public
    @ResponseBody
    String insertTeachers() {
        return "teachers' data inserted";
    }

    @RequestMapping(value = "/teachers", method = RequestMethod.DELETE)
    public
    @ResponseBody
    String deleteTeachers() {
        return "teachers' data deleted";
    }

    @RequestMapping(value = "/teachers", method = RequestMethod.PUT)
    public
    @ResponseBody
    String putTeachers() {
        return "teachers' data modified";
    }


}