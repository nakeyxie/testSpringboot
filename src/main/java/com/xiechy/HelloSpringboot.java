package com.xiechy;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xiechy
 * @create 2018-01-03
 * @Descrption
 **/
@RestController
public class HelloSpringboot {

    @RequestMapping("/hellos")
    public String hello() {
        List<User> userList = TestQuery.getUser();
        StringBuffer strbuf = new StringBuffer();
        strbuf.append("<table width=\"250px\" style=\"border-collapse: collapse \">");
        strbuf.append("<thead><tr  style=\"background-color: #C0C0C0\"><th  style=\"border:1px solid #000000 \">").append("id");
        strbuf.append("</th><th style=\"border:1px solid #000000 \">").append("名称");
        strbuf.append("</th></tr></thead>");
        userList.stream().forEach(i -> {
            strbuf.append("<tr><td  style=\"border:1px solid #000000\">").append(i.getId());
            strbuf.append("</td><td  style=\"border:1px solid #000000\">").append(i.getName());
            strbuf.append("</td></tr>");
        });
        strbuf.append("</table>");
        return strbuf.toString();
    }

    @RequestMapping("/putParam")
    public String resive(int id, String name) {
        //tests
        System.out.println("收到前台信息：id:" + id + ",name:" + name);
        TestQuery.insertUser(new User(id, name));
        return "ok!";
    }


}




    
        