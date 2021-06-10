
package com.xiechy.code;


/**
 * @author xiechy
 * @create 2018-03-22
 * @Descrption
 **/

import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Api("测试接口文档")
@Controller
public class HelloController {

    @ApiOperation("测试首页")
    @RequestMapping("/index")
    @ResponseBody
    public String index() {
        return "index";
    }

    @RequestMapping("/name")
    public String name(Map<String, Object> map) {
        map.put("name", "nakey22112");


        System.out.println("============================================");
        return "hello";
    }

    @RequestMapping("/user")
    public String userPage(){
        return "user";
    }

    @RequestMapping("/user2")
    public String userPage2(){
        return "user2";
    }
    @RequestMapping("/layout")
    public String layout(){
        return "layout";
    }
}




    
