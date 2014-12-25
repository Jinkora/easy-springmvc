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
 * 14-12-25
 */
@Controller
public class MultipartController {

    /**
     * upload a image file and show it
     *
     * @param image an image file uploaded
     * @return just a byte array? ByteArrayHttpMessageConverter convert it to image
     * @see org.springframework.http.converter.ByteArrayHttpMessageConverter
     * @throws IOException
     */
    @RequestMapping(value = "/headImage",method = RequestMethod.POST,
            produces = {MediaType.IMAGE_JPEG_VALUE,MediaType.IMAGE_GIF_VALUE, MediaType.IMAGE_PNG_VALUE})
    public @ResponseBody
    byte[] headImage(@RequestParam MultipartFile image) throws IOException {
        return image.getBytes();
    }

}
