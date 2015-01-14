package com.kavlez.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Author: Kavlez
 * sweet_dreams@aliyun.com
 */
@Controller
@RequestMapping("/multiPart")
public class MultipartController {

    /**
     * upload a image file and show it
     *
     * @param image uploaded image file
     * @return byte array as {@link org.springframework.http.MediaType}
     * @throws IOException
     */
    @RequestMapping(value = "/image", method = RequestMethod.POST,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] headImage(@RequestParam MultipartFile image) throws IOException {
        return image.getBytes();
    }

}
