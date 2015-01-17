package com.kavlez.controller;

import com.kavlez.pojo.Subject;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author: Kavlez
 * sweet_dreams@aliyun.com
 */
public class ControllerTest {

    private static final ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/spring-mvc.xml");
    private static final RestTemplate restTemplate = (RestTemplate) ctx.getBean("restTemplate");

    @Test
    public void testDemo() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);

        ResponseEntity<Subject> response = restTemplate.exchange(
                "http://localhost:8080/easy-springmvc/messageConvert/subject"
                , HttpMethod.GET
                , new HttpEntity<String>(headers)
                , Subject.class);
        logger.debug(response.toString());

    }

    private final static Logger logger = LoggerFactory.getLogger(ControllerTest.class);
}
