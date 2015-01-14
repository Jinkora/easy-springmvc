package com.kavlez.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author: Kavlez
 * sweet_dreams@aliyun.com
 *
 *
 * 1.如果客户端发出的http请求符合DisptcherServlet的映射路径，则由DisptcherServlet处理
 * 2.根据http message(所有因素)和HandlerMapping(DefaultAnnotationHandlerMapping)配置找到相应Handler。
 *   PS:Handler并不是一个接口,任何pojo都可能成为Handler
 * 3.通过HandlerAdapter对Handler进行封装,并用Adapter接口调用Handler。
 * 4.处理完成后返回model和逻辑视图,DispatcherServlet通过ViewResolver(InternalViewResolver)找到视图对象。
 * 5.找到view后对返回的model进行渲染。
 *
 *
 * 以下元素构成了Spring web MVC的架构
 *
 * (s)MultipartResolver
 * (s)LocaleResolver
 * (s)ThemeResolver
 * (m)HandlerMappings
 * (m)HandlerAdapters
 * (m)HandlerExceptionResolver
 * (s)RequestToViewNameTranslator
 * (m)ViewResolver
 *
 * 这些元素的默认实现在 org.springframework.web.servlet下DispatcherServlet.properties定义
 *
 * check specification of DispatcherServlet in web.xml
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
