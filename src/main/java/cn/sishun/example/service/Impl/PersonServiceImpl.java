package cn.sishun.example.service.Impl;

import cn.sishun.example.dao.PersonMapper;
import cn.sishun.example.entity.Person;
import cn.sishun.example.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: lichenghuai
 * @Date: 2019/12/16 15:26
 */
@Slf4j
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonMapper personMapper;

    @Override
    public Person findById(Integer id) {
        log.info("入参id{}",id);
        return personMapper.selectByPrimaryKey(id);
    }
}
