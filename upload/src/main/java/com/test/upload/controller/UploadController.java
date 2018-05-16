package com.test.upload.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Map;

/**
 * @Description:
 * @Author: fanyongjiu
 * @Date: 18/5/16 13:59
 */
@RestController
@RequestMapping("/file")
public class UploadController {

    @PostMapping("/uploadImg")
    public void uploadImg(@RequestParam MultipartFile file[], MultipartHttpServletRequest request) throws Exception {
        Map<String, MultipartFile> map = request.getFileMap();

        System.out.println(map);
    }
}
