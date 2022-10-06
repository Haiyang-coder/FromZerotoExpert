package com.shk.dao;

import com.shk.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author: sunhengkang
 * @date:2022/9/20
 */
@Mapper
public interface UserMapper {
    /**
     *
     * @param username
     * @param password
     * @return
     * 查询用户是否注册
     */
    @Select( "select * from user where username = #{username} and password = #{password};")
    User getUserByNameAndPassWord(@Param("username") String username,@Param("password") String password);

    /**
     *
     * @param username
     * @return
     * 查询用户名是否已经存在
     */
    @Select("select * from user where username = #{username};")
    User getUserByName(@Param("username") String username);

    /**
     *
     * @param username
     * @param password
     * @return
     * 插入数据库注册的新用户
     */
    @Insert("insert into user (id, username, password, user_nickname) values (null , #{username}, #{password}, #{nickname}) ")
    int insertUser(@Param("username") String username, @Param("password") String password, @Param("nickname")String nickname);
}
