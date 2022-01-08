package com.xiaowei.aiproject.controller;

import com.xiaowei.aiproject.utiles.Aiutils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin
public class AiController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String picToWord(@RequestParam("file") MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());
        String s = Aiutils.picToWord(file.getBytes());
        return s;
    }

}
