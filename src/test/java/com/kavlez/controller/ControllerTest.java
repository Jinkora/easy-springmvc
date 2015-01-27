package com.kavlez.controller;

import com.kavlez.pojo.Subject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
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
    public void testMarshalling() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        headers.set("a","2");

        ResponseEntity<Subject> response = restTemplate.exchange(
                "http://localhost:8080/easy-springmvc/messageConvert/subject"
                , HttpMethod.GET
                , new HttpEntity<String>(headers)
                , Subject.class);
        logger.debug(response.getBody().toString());

    }

    @Test
    public void testResponseEntity() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<String> response = restTemplate.exchange(
                "http://localhost:8080/easy-springmvc/annotation/entity"
                , HttpMethod.GET
                , new HttpEntity<String>(headers)
                , String.class);
        logger.debug(response.toString());

    }

    private final static Logger logger = LogManager.getLogger(ControllerTest.class);
}
