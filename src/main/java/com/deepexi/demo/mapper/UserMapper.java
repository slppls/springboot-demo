package com.deepexi.demo.mapper;

import com.deepexi.demo.common.BaseMapper;
import com.deepexi.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author liuhuishan
 * @Date 2019/4/5 5:27
 * @Version v1.0
 **/
@Mapper
@Component
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user")
    List<User> getAll();
}
