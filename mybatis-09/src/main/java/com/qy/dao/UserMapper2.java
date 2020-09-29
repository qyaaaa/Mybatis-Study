package com.qy.dao;

import com.qy.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper2 {
    //根据id查询用户
    User queryUserById(@Param("id")int id);

    int updateUser(User user);
}
