package com.kavlez.controller;

import com.kavlez.pojo.Subject;
import com.kavlez.pojo.Teacher;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Kavlez
 * sweet_dreams@aliyun.com
 * <p>
 * <p>
 * every single request/response  is based on string
 * how to convert between http message and object in java
 * @see org.springframework.http.converter.HttpMessageConverter
 * @see org.springframework.http.converter.BufferedImageHttpMessageConverter
 * @see org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
 * @see org.springframework.http.converter.ByteArrayHttpMessageConverter
 * @see org.springframework.http.converter.StringHttpMessageConverter
 * @see org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter
 */
@Controller
@RequestMapping("/messageConvert")
public class MessageConvertController {


    @RequestMapping
    public String main() {
        return "/messageConvert";
    }

    /**
     * @return as json format
     */
    @RequestMapping(value = "/teachers", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Teacher> teachers() {
        return Arrays.asList(
                new Teacher().setName("Silva"),
                new Teacher().setName("Velasquez"),
                new Teacher().setName("Aldo"),
                new Teacher().setName("Machida"));
    }

    /**
     * @return as xml format
     * Subject.class is annotated with @XmlRootElement
     */
    @RequestMapping(value = "/subject", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public Subject subject() {
        Subject subject = new Subject();
        subject.setName("computer science");
        return subject;
    }

    /**
     * StringMessageConverter used
     *
     * @param requestBody
     * @return plain text
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/body")
    public String messageBody(@RequestBody String requestBody) {
        return "server accept:::".concat(requestBody);

    }

    /**
     * StringMessageConverter bind request message into httpEntity
     *
     * @param httpEntity
     * @return plain text
     */
    @RequestMapping("/httpEntity")
    @ResponseBody
    public String httpEntity(HttpEntity<String> httpEntity) {
        return "server accept:::".concat(httpEntity.getBody());
    }

    /**
     * upload a image file and show it
     *
     * @param image uploaded image file
     * @return byte array as {@link org.springframework.http.MediaType}
     * @throws java.io.IOException
     */
    @RequestMapping(value = "/image", method = RequestMethod.POST,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] headImage(@RequestParam MultipartFile image) throws IOException {
        return image.getBytes();
    }

    /**
     * upload a image file and show it
     * ByteArrayHttpMessageConverter used
     */
    @RequestMapping(value = "/byteImage", method = RequestMethod.POST,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> byteImage(@RequestParam MultipartFile image) throws IOException {
        return new ResponseEntity<byte[]>(image.getBytes(), HttpStatus.OK);
    }

}
