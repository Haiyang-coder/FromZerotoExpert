package com.shk.register;

import com.shk.mapper.SensitiveMapper;
import com.shk.mapper.UserMapper;
import com.shk.pojo.User;
import com.shk.utils.CheckPasswordUtil;
import com.shk.utils.SensitivewordFilter;
import com.shk.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

/**
 * @author: sunhengkang
 * @date:2022/9/22
 */
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String nickname = req.getParameter("nickname");


        //获取sqlsession
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkUserIsExist(username);

        //密码强度检测
        int status = CheckPasswordUtil.checkPasswod(password);

        switch (status){
            case CheckPasswordUtil.PS_EASY:
                writer.println("密码太简单");
                break;
            case CheckPasswordUtil.PS_NOTRULE:
                writer.println("密码有特殊字符");
                break;
            case CheckPasswordUtil.PS_SHORT:
                writer.println("密码太短了");
                break;
            default:
                break;
        }
        
        //用户名检测
        Set<String> wordSet = SensitivewordFilter.getSensitiveWordSet();
        SensitivewordFilter.init(wordSet);
        boolean contains = SensitivewordFilter.contains(nickname);
        if (contains){
            writer.println("昵名不合规");
        }

        //判断用户用户名是否重复
        if (user != null){
            writer.println("用户名已经存在了");
        }else {
            mapper.insertUser(username, password, nickname);
            sqlSession.commit();
            writer.println("注册成功");
        }
       sqlSession.close();

    }
}
