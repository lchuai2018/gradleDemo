package cn.sishun.example.controller;

import cn.sishun.example.entity.Person;
import cn.sishun.example.service.PersonService;
import cn.sishun.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: lichenghuai
 * @Date: 2019/12/16 15:25
 */
@RestController
@RequestMapping(value = "person")
public class PesonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/")
    Person findById() {
        Person person = personService.findById(1);
        return person;
    }
}
