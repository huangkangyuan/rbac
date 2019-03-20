package com.hl.controller;

import com.hl.common.JsonData;
import com.hl.exception.PermissionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class TestController {

    @RequestMapping("/test.json")
    @ResponseBody
    public JsonData test(){
        throw new RuntimeException("aaa");
    }

    @RequestMapping("/test1")
    @ResponseBody
    public JsonData test1(){
        return new JsonData(true);
    }

}
