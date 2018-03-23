
package com.xiechy;


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
        map.put("name", "Clark");

        System.out.println("============================================");
        return "hello";
    }

}




    
