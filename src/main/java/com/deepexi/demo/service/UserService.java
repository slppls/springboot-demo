package com.deepexi.demo.service;

import com.deepexi.demo.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author liuhuishan
 * @Date 2019/4/5 5:29
 * @Version v1.0
 **/
public interface UserService {

    List<User> getAll();

    User findById(Long id);

}
