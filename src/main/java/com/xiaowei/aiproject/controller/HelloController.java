package com.xiaowei.aiproject.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class HelloController {


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloWorld(){
        return "Hello World!";
    }


}
