package com.kavlez.controller;

import com.kavlez.pojo.Teacher;
import org.springframework.beans.propertyeditors.PropertiesEditor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

/**
 * @author: Kavlez
 * sweet_dreams@aliyun.com
 * <p>
 * you should know these annotations
 */

@Controller
@RequestMapping("/annotation")
public class AnnotationController {

    /**
     * you already know
     */
    @RequestMapping
    public String main() {
        return "/annotation";
    }

    /**
     * ModelAttribute for args
     */
    @RequestMapping("/modelAttr")
    @ResponseBody
    public String modelAttr(@ModelAttribute Teacher teacher) {
        return teacher.toString();
    }

    @ModelAttribute
    public void modelAttrMethod(){

    }

    @InitBinder
    protected void initBinder(ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(Teacher.class, new PropertiesEditor());
    }

    @RequestMapping("/reqParam")
    @ResponseBody
    public String requestParam(@RequestParam(required = true,defaultValue = "kavlez" ) String name) {
        return "name:".concat(name);
    }


    @RequestMapping("/entity")
    @ResponseBody
    public ResponseEntity<String> handle(HttpEntity<byte[]> requestEntity) throws UnsupportedEncodingException {
        String requestHeader = requestEntity.getHeaders().getFirst("MyRequestHeader");
        byte[] requestBody = requestEntity.getBody();

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("MyResponseHeader", "MyValue");
        return new ResponseEntity<String>("Hello World", responseHeaders, HttpStatus.CREATED);
    }
}
