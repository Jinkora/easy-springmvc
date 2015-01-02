package com.kavlez.controller;

import com.kavlez.pojo.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * @author Kavlez
 *         sweet_dreams@aliyun.com
 *         <p>
 *         Same url,different method
 */
@Controller
@RequestMapping("/httpMethod")
public class HttpMethodController {

    private static final String VIEW_DIR = "httpMethod";

    @RequestMapping
    public String main() {
        return VIEW_DIR.concat("/main");
    }


    @RequestMapping(value = "/teachers",method = RequestMethod.GET)
    public
    @ResponseBody
    List<Teacher> teachers() {
        Teacher t0 = new Teacher();
        t0.setName("Silva");
        Teacher t1 = new Teacher();
        t1.setName("Velasquez");
        Teacher t2 = new Teacher();
        t2.setName("Aldo");
        Teacher t3 = new Teacher();
        t3.setName("Machida");
//description The resource identified by this request is only capable of generating responses with characteristics not acceptable according to the request "accept" headers.

        return Arrays.asList(t0, t1, t2, t3);
    }

    @RequestMapping(value = "/teachers",method = RequestMethod.POST)
    public
    @ResponseBody
    String insertTeachers() {
        return "teachers' data inserted";
    }

    @RequestMapping(value = "/teachers",method = RequestMethod.DELETE)
    public
    @ResponseBody
    String deleteTeachers() {
        return "teachers' data deleted";
    }

    @RequestMapping(value = "/teachers",method = RequestMethod.PUT)
    public
    @ResponseBody
    String putTeachers() {
        return "teachers' data modified";
    }



}