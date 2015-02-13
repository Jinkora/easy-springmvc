package com.kavlez.webcomponent.bindingInitializer;

import com.kavlez.pojo.Teacher;
import com.kavlez.webcomponent.Editor.TeacherEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

/**
 * @author Kavlez
 * sweet_dreams@aliyun.com
 *
 * if you want to register property editor on global
 * declare your custom BindingInitializer in config file.
 */
public class MyBindingInitializer implements WebBindingInitializer{
    @Override
    public void initBinder(WebDataBinder webDataBinder, WebRequest webRequest) {
        webDataBinder.registerCustomEditor(Teacher.class,new TeacherEditor());
    }
}
