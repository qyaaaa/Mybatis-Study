package com.qy.dao;

import com.qy.pojo.User;
import com.qy.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {
    @Test
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.getUserLike("liu____");

        for (User user : users){
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void test1(){
        //第一步，获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //第二步，执行
        //方式1：getMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();

        //方式2(不推荐)
        //List<User> userList = sqlSession.selectList("com.qy.dao.UserDao.getUserList");


        for (User user : userList){
            System.out.println(user);
        }

        //关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void test2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);

        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void test7(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("hello",1);
        map.put("name","liuqian");

        mapper.getUserById2(map);
        System.out.println("查询成功");

        sqlSession.close();
    }

    //增删改需要提交事务
    @Test
    public void test3(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int user = mapper.addUser(new User(5, "wlw", "123908"));
        if (user > 0){
            System.out.println("插入成功");
        }

        //提交事务
        sqlSession.commit();


        sqlSession.close();
    }

    @Test
    public void test6(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("userid",6);
        map.put("password",112234);

        mapper.addUser2(map);

        System.out.println("添加成功");

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test4(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int user = mapper.updateUser(new User(1, "liuqian", "272374"));

        if (user > 0){
            System.out.println("修改成功");
        }

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test5(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int i = mapper.deleteUser(3);
        if (i > 0){
            System.out.println("删除成功");
        }

        sqlSession.commit();
        sqlSession.close();
    }
}
