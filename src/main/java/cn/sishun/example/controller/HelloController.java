package cn.sishun.example.controller;

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
        return "hello gradle!";
    }
}
