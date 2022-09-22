package com.shk;

import com.shk.utils.SqlSessionUtil;
import com.shk.mapper.UserMapper;
import com.shk.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: sunhengkang
 * @date:2022/9/20
 */
public class mybatis {

    @Test
    public void myBatistest() throws IOException {
//        //加载核心配置文件
//        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
//        //获取sqlsessionFactoryBuilder
//        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
//        //获取sqlsessionfactory
//        SqlSessionFactory build = sqlSessionFactoryBuilder.build(resourceAsStream);
//        //获取sqlsession,true表明要自动提交事物
//        SqlSession sqlSession = build.openSession(true);
//        //获取mapper借口对象
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        //测试功能
//        int result = mapper.insertUser();
//        //手动提交，可以提交自动
//        //sqlSession.commit();
//        System.out.println(result);

    }

    @Test
    public  void updateTest() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //获取mapper借口对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //测试功能
        Map<String, Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("username","dd1");
        stringObjectMap.put("password","123");
        User user = mapper.checkLogin("shk","df3");
        System.out.println(user);
    }

    @Test
    public  void updateTest2() throws IOException {
//        SqlSession sqlSession = Utils.getSqlSession();
//        //获取mapper借口对象
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        //测试功能
//        User user1 = new User(null, "shk3", "df32");
//        int user = mapper.insertUserByUser(user1);
//        sqlSession.commit();
//        System.out.println(user);
    }

}
