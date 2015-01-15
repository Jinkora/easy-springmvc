package com.kavlez.controller;

import org.junit.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * @author: Kavlez
 * sweet_dreams@aliyun.com
 */
public class ControllerTest {

    @Test
    public void testDemo() {
        RestTemplate template = new RestTemplate();
        MultiValueMap<String, String> valueMap = new LinkedMultiValueMap<>();
        valueMap.add("firstName", "Kavlez");
        valueMap.add("lastName", "Jin");
        valueMap.add("age", "11");
        URI uri = template.postForLocation("http://localhost:8080/easy-springmvc/messageConvert/body", valueMap);

    }
}
