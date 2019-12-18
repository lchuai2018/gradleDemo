package cn.sishun.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: lichenghuai
 * @Date: 2019/12/16 13:20
 */
@MapperScan("cn.sishun.example.dao")
@SpringBootApplication
public class ErpDemoApplication {
    public static void main(String[] args){
        SpringApplication.run(ErpDemoApplication.class,args);
    }
}
