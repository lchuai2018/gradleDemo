package cn.sishun.example.service.Impl;

import cn.sishun.example.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author: lichenghuai
 * @Date: 2019/12/16 13:22
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public void findAll(String name) {
        System.out.println("Welcome to erp System");
    }
}
