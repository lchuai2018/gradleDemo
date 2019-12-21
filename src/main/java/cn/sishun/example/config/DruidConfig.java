/*
 *
 *  * Copyright 2019 ShenQi. All rights reserved.
 *  * You can get our information at http://www.sqinet.cn
 *  * Anyone can't use this file without our permission.
 *
 */

package cn.sishun.example.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;
//import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

/**
 * Druid的DataResource配置类
 * 凡是被Spring管理的类，实现接口 EnvironmentAware 重写方法 setEnvironment 可以在工程启动时，
 * 获取到系统环境变量和application配置文件中的变量。 还有一种方式是采用注解的方式获取 @value("${变量的key值}")
 * 获取application配置文件中的变量。 这里采用第一种要方便些
 */
@Configuration
@EnableTransactionManagement  // 开启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@MapperScan(basePackages = {"cn.sishun.example.dao"})
public class DruidConfig implements EnvironmentAware {
    @Autowired
    private Environment environment;

    @Override
    public void setEnvironment(final Environment environment) {
        this.environment = environment;
    }

    @Bean
    @ConfigurationProperties("spring.datasource.druid")
    @Primary
    public DataSource dataSource() {
        return DruidDataSourceBuilder.create().build();
    }
}