package com.kavlez.controller;

import com.kavlez.common.BaseTestCase;
import com.kavlez.pojo.Subject;
import com.kavlez.pojo.Teacher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author: Kavlez
 * sweet_dreams@aliyun.com
 */
public class ControllerTest extends BaseTestCase {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testMarshalling() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        headers.set("a", "2");

        ResponseEntity<Subject> response = restTemplate.exchange(
                "http://localhost:8080/easy-springmvc/messageConvert/subject"
                , HttpMethod.GET
                , new HttpEntity<String>(headers)
                , Subject.class);
        logger.warn(response.getBody().toString());

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
        logger.warn(response.toString());

    }

    @Test
    public void testStream() {

        List<Teacher> teachers = Arrays.asList(
                new Teacher().setName("Silva"),
                new Teacher().setName("Silva"),
                new Teacher().setName("Velasquez"),
                new Teacher().setName("Aldo"),
                new Teacher().setName("Machida"))
                .stream().filter(teacher -> teacher.getName().length() > 2)
                .collect(Collectors.toList());

        logger.warn(teachers);
        logger.warn(teachers.stream().map(Teacher::getName).collect(Collectors.toList()));
        teachers.stream().map(new Function<Teacher, Teacher>() {
            @Override
            public Teacher apply(Teacher teacher) {
                teacher.setSalary(0);
                return teacher;
            }
        }).collect(Collectors.toList());
        long t0 = System.nanoTime();

        int end = 1_000_000_0;;
        IntStream.range(0, end).filter(p -> p % 2 == 0).toArray();
        long t1 = System.nanoTime();

        IntStream.range(0, end).parallel().filter(p -> p % 2 == 0).toArray();
        long t2 = System.nanoTime();

        System.out.printf("serial: %.2fs, parallel %.2fs%n", (t1 - t0) * 1e-9, (t2 - t1) * 1e-9);

    }

    private final static Logger logger = LogManager.getLogger(ControllerTest.class);
}
