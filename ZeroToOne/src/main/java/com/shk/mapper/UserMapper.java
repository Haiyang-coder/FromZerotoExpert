package com.shk.mapper;

import com.shk.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

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
    /**
     * 根据用户名返回用户的信息
     */
    User getUserByUsername(String userName);
    /**
     * 检查用户名和密码是否正确
     */
    User checkLogin(Map<String, Object> map);

    /**
     *
     * 当传入的参数是实体类的对象的时候
     */
    int insertUserByUser(User user);

    /**
     * 通过注解来自定义参数名
     */
    @Select( "select * from user where username = #{username} and password = #{password};")
    User checkLogin(@Param("username") String username,@Param("password") String password);
}
