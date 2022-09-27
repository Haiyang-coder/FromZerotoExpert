package com.shk;

import com.shk.utils.SensitivewordFilter;
import com.shk.utils.SqlSessionUtil;
import com.shk.mapper.UserMapper;
import com.shk.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author: sunhengkang
 * @date:2022/9/20
 */
public class mybatis {

    @Test
    public void myBatistest() throws IOException {
        Set<String> wordSet = SensitivewordFilter.getSensitiveWordSet();
        SensitivewordFilter.init(wordSet);
        String nickname = "cnm";
        boolean contains = SensitivewordFilter.contains(nickname);
        if (contains){
            System.out.println("不合规");
        }else {
            System.out.println("合规");
        }

    }

    @Test
    public void hashmaptest(){
        HashMap stringStringHashMap = new HashMap(10);
        Map nowMap = null;
        Map<String, String> newWorMap = null;

        nowMap = stringStringHashMap;
        newWorMap = new HashMap<String, String>();
        newWorMap.put("isEnd", "0");     //不是最后一个
        nowMap = newWorMap;
        System.out.println(stringStringHashMap);
        System.out.println(nowMap);
        System.out.println(newWorMap);
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
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(test.class);
    }

}
