package com.shk.mapper;

import com.shk.pojo.User;

/**
 * @author: sunhengkang
 * @date:2022/9/20
 */
public interface UserMapper {
    int insertUser();

    int updateUser();

    /**
     * 根据id 查询用户
     */
    User getUsername();

}
