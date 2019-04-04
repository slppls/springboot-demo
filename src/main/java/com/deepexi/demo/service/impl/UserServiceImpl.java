package com.deepexi.demo.service.impl;

import com.deepexi.demo.entity.User;
import com.deepexi.demo.mapper.UserMapper;
import com.deepexi.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author liuhuishan
 * @Date 2019/4/5 5:30
 * @Version v1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Transactional
    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }

    @Override
    public User findById(Long id) {
        User user = new User();
        user.setId(Math.toIntExact(id));
        return userMapper.selectOne(user);
    }
}
