package cn.sishun.example.controller;

import cn.sishun.example.entity.UserInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: lichenghuai
 * @Date: 2019/12/16 13:37
 */
@RestController
public class HelloController {
    @GetMapping("/")
    @ResponseBody
    public String hello(){
        UserInfo userInfo=new UserInfo();


        return "hello gradle!";
    }
}
