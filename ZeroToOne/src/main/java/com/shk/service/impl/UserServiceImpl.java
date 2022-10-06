package com.shk.service.impl;

import com.shk.dao.UserMapper;
import com.shk.domain.User;
import com.shk.service.UserSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author: sunhengkang
 * @date:2022/10/6
 */
@Service
public class UserServiceImpl implements UserSerice {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserByNameAndPassWord(String username, String password) {

        return userMapper.getUserByNameAndPassWord(username, password);
    }

    @Override
    public User getUserByName(String username) {

        return userMapper.getUserByName(username);
    }

    @Override
    public int insertUser(String username, String password, String nickname) {
        int i = userMapper.insertUser(username, password, nickname);
        return  i;
    }
}
