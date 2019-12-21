package cn.sishun.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @Author: lichenghuai
 * @Date: 2019/12/16 13:20
 */
@EnableDiscoveryClient
@EnableConfigurationProperties
@RefreshScope
//@MapperScan("cn.sishun.example.dao")
@SpringBootApplication
public class ErpDemoApplication {
    public static void main(String[] args){
        SpringApplication.run(ErpDemoApplication.class,args);
    }
}
