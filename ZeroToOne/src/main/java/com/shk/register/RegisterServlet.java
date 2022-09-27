package com.shk.register;

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
 * @date:2022/9/22
 */
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //获取sqlsession
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkUserIsExist(username);

        //判断用户用户名是否重复
        if (user != null){
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter writer = resp.getWriter();
            writer.println("用户名已经存在了");
        }else {
            mapper.insertUser(username, password);
            sqlSession.commit();
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter writer = resp.getWriter();
            writer.println("注册成功");
        }
       sqlSession.close();

    }
}
