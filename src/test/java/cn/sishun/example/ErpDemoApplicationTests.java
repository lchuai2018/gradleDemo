package cn.sishun.example;

import cn.sishun.example.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: lichenghuai
 * @Date: 2019/12/16 14:18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ErpDemoApplicationTests {
    @Autowired
    private UserService userService;
    @Test
    public void contextLoads() {
        userService.findAll("sishun");
        System.out.println("success!!");
    }

}
