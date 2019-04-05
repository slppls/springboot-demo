package com.deepexi.demo.controller;

import com.deepexi.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author liuhuishan
 * @Date 2019/4/5 4:36
 * @Version v1.0
 **/
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private UserService userService;

    @GetMapping("/sayHello")
    public Map<String,Object> sayHello(){
        Map<String,Object> resultMap = new HashMap<>(8);
        resultMap.put("code",0);
        resultMap.put("msg","ok");
        resultMap.put("result",userService.getAll());
        return resultMap;
    }

    @GetMapping("/findUser")
    public Map<String,Object> findUser(@RequestParam("id") Long id){
        Map<String,Object> resultMap = new HashMap<>(8);
        resultMap.put("code",0);
        resultMap.put("msg","ok");
        resultMap.put("result",userService.findById(id));
        return resultMap;
    }

}
