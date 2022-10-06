package com.shk;

import com.shk.dao.UserMapper;


import com.shk.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;


/**
 * @author: sunhengkang
 * @date:2022/9/20
 */
@SpringBootTest
public class mybatis {

    @Autowired
    UserServiceImpl user;
    @Test
    public void myBatistest() throws IOException {

        int i = user.insertUser("dfed22d", "33d3", "eed");
        System.out.println(i);
    }


}
