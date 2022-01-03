package com.xiaowei.aiproject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloWorld(){
        return "Hello World!";
    }


}
