package com.kavlez.controller;

import com.kavlez.pojo.Teacher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.propertyeditors.PropertiesEditor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

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
@SessionAttributes("teacher")
public class AnnotationController {
    
    private static final Logger logger = LogManager.getLogger(AnnotationController.class);

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
    public Teacher modelAttrMethod() {
        Teacher teacher = new Teacher();
        teacher.setName("kavlez");
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
     * 调用控制器之前会创建一个隐藏模型
     * 调用所有标注了ModelAttributes的方法 处理隐藏模型
     * 查看session中是否存在SessionAttribute指定的属性 有则加入或覆盖隐藏模型中的属性
     * 对于标注了ModelAttribute的参数
     *      1.先从隐藏模型中填充  再从请求报文中填充
     *      2.如果该参数是SessionAttributes指定的属性 则先从session中填充 再从请求报文中填充
     *      如果session中找不到则抛出HttpSessionRequiredException
     *      3.如果隐藏模型不存在该属性且该属性非session属性则从报文中填充
     *
     */
    @RequestMapping("/session")
    @ResponseBody
    public String printSessionAttr(ModelMap modelMap,SessionStatus sessionStatus){
        Teacher teacher = (Teacher) modelMap.get("teacher");
        logger.debug("before cleanup session attributes::"+teacher);
        sessionStatus.setComplete();    //cleanup session attrs
        return  teacher.toString();
    }

    /**
     *
     * replace annotations with HttpEntity+ResponseEntity
     *
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("/entity")
    @ResponseBody
    public ResponseEntity<String> handle(HttpEntity<byte[]> requestEntity) throws UnsupportedEncodingException {
        logger.debug(requestEntity.getHeaders().getFirst("MyRequestHeader"));
        logger.debug(Arrays.toString(requestEntity.getBody()));

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
