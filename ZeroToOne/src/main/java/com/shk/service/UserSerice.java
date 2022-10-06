package com.shk.service;

import com.shk.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * @author: sunhengkang
 * @date:2022/10/6
 */
public interface UserSerice {
    //检查是否登陆过页面
    User getUserByNameAndPassWord( String username, String password);

    //检查用户是否存在
    User getUserByName( String username);

    //插入数据库注册的新用户
    int insertUser(String username, String password, String nickname);


}
