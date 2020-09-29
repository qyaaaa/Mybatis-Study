package com.qy.dao;

import com.qy.pojo.User;
import com.qy.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;



public class UserDaoTest {

    @Test
    public void test1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);

        System.out.println(user);

        sqlSession.close();
    }

}
