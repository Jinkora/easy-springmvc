package com.kavlez.controller;

import com.kavlez.pojo.Teacher;
import org.springframework.beans.propertyeditors.PropertiesEditor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author: Kavlez
 * sweet_dreams@aliyun.com
 * <p>
 * Take annotations below:
 * @see org.springframework.web.bind.annotation.RequestMapping
 * @see org.springframework.web.bind.annotation.PathVariable
 * @see org.springframework.web.bind.annotation.RequestParam
 * @see org.springframework.web.bind.annotation.RequestHeader
 * @see org.springframework.web.bind.annotation.RequestBody
 * @see org.springframework.web.bind.annotation.ResponseBody
 * <p>
 * Here is usage.
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

    @RequestMapping("/reqParam")
    @ResponseBody
    public String requestParam(@RequestParam(required = true, defaultValue = "kavlez") String name) {
        return "name:".concat(name);
    }

    @RequestMapping("/header")
    @ResponseBody
    public String printReqHeader(@RequestHeader String referer) {
        return "you are from ["+referer+"]";
    }

    /**
     * ModelAttribute annotated with args
     */
    @RequestMapping("/modelAttr")
    @ResponseBody
    public String modelAttr(@ModelAttribute Teacher teacher) {
        return "Teacher's name inputed was ["+teacher.toString()+"]";
    }

    /**
     * ModelAttribute annotated with method
     * call modelAttr , teacher.getGender() == Gender.Female
     */
    @ModelAttribute("teacher")
    @ResponseBody
    public Teacher modelAttrMethod() {
        Teacher teacher = new Teacher();
        teacher.setGender(Teacher.Gender.Female);
        return teacher;
    }

    /**
     * use model map instead
     */
    @RequestMapping("/modelMap")
    @ResponseBody
    public String modelMap(ModelMap modelMap){
        Teacher teacher = (Teacher) modelMap.get("teacher");
        teacher.setName("Kavlez");
        return modelMap.toString();
    }

    @RequestMapping("/cookie")
    @ResponseBody
    public String printCookie(@CookieValue("JSESSIONID") String sessionId) {
        return sessionId;
    }


    /**
     *
     * replace RequestBody & ResponseBody with HttpEntity & ResponseEntity
     *
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("/entity")
    @ResponseBody
    public ResponseEntity<String> handle(HttpEntity<byte[]> requestEntity) throws UnsupportedEncodingException {
        System.out.println(requestEntity.getHeaders().getFirst("MyRequestHeader"));
        System.out.println(Arrays.toString(requestEntity.getBody()));

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("MyResponseHeader", "MyValue");
        return new ResponseEntity<>("Hello World", responseHeaders, HttpStatus.CREATED);
    }

    @InitBinder
    protected void initBinder(ServletRequestDataBinder binder) throws Exception {
        binder.setAutoGrowNestedPaths(false);
        binder.registerCustomEditor(Teacher.class, new PropertiesEditor());
    }
}
