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

    private static final String VIEW_DIR="returnFormat";

    @RequestMapping
    public String main(){
        return VIEW_DIR.concat("/main");
    }

    @RequestMapping(value = "/teachers")
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

    @RequestMapping("/subject")
    public
    @ResponseBody
    Subject subject() {
        Subject subject = new Subject();
        subject.setName("computer science");
        return subject;
    }
}
