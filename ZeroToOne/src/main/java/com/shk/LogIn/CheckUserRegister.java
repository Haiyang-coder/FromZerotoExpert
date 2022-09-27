package com.shk.LogIn;

import com.shk.mapper.UserMapper;
import com.shk.pojo.User;
import com.shk.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author: sunhengkang
 * @date:2022/9/21
 */
public class CheckUserRegister extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接收前端传来的用户名和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //2.使用mybatis查询数据库
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLogin(username, password);
        sqlSession.close();
        //3.判断数据库查询结果
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if (user != null){
            writer.println("登陆成功");
        }else {
            writer.println("登录失败");
        }


    }
}
