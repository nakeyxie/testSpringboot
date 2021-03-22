
package com.xiechy.code;


/**
 * @author xiechy
 * @create 2018-03-22
 * @Descrption
 **/

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

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




    
