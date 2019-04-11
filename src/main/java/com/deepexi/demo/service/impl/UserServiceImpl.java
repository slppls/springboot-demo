package com.deepexi.demo.service.impl;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deepexi.demo.entity.User;
import com.deepexi.demo.mapper.UserMapper;
import com.deepexi.demo.service.UserService;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedissonClient redissonClient;


    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }

    @Override
    public User findById(Long id) {
        User user = new User();
        RBucket<String> keyBucket = redissonClient.getBucket("USER_ID_"+id);
        String value = keyBucket.get();
        LOGGER.info("根据key获取值，key不存在也会进行映射，判断是否有缓存 key:{}--value:{}","USER_ID_"+id,value);
        if(StrUtil.isEmpty(value)){
            LOGGER.info("value:{} 为空",value);
            user.setId(Math.toIntExact(id));
            user = userMapper.selectOne(user);
            keyBucket.set(JSON.toJSONString(user));
        }else {
            LOGGER.info("value:{} 不为空",value);
            user = JSONObject.parseObject(value,User.class);
        }
        return user;
    }
}
