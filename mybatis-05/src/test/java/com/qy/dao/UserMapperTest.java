package com.qy.dao;

import com.qy.pojo.User;
import com.qy.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //底层主要应用反射
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.deleteUser(6);
        //mapper.updateUser(new User(5,"sb","147963"));
        //mapper.addUser(new User(6,"hello","123456"));
//        User userById = mapper.getUserById(1);
//
//        System.out.println(userById);

        sqlSession.close();
    }


}
