package cn.sishun.example.controller;

import cn.sishun.example.entity.Person;
import cn.sishun.example.service.PersonService;
import cn.sishun.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

 /*   @ApiOperation("根据id读取数据")
    @ApiImplicitParam(value = "用户id",name="id",required = true,dataType = "String",paramType = "path")
    @RequestMapping(value = "/read/{id}",method = RequestMethod.GET)
    public Person read(@PathVariable("id") int id){
        Person person = personService.findById(1);
        return person;
    }*/
}
