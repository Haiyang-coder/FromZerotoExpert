package com.shk.controller;

import com.shk.domain.User;
import com.shk.service.UserSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: sunhengkang
 * @date:2022/10/6
 */
@Controller
public class LoginController {

    @Autowired
    private UserSerice userSerice;
    @RequestMapping("/FromZerotoExpert/register.html")
    @ResponseBody
    private void ShowLoginPage() throws IOException {
        //获取request对象
        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest req = attributes.getRequest();
        HttpServletResponse resp = attributes.getResponse();

        resp.sendRedirect("/login.html");
    }

    @RequestMapping("/LoginServlet")
    @ResponseBody
    private String CheckUserRegister(){
        //获取request对象
        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest req = attributes.getRequest();
        HttpServletResponse resp = attributes.getResponse();

        //1.接收前端传来的用户名和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //2.使用mybatis查询数据库
        User user = userSerice.getUserByNameAndPassWord(username, password);
        //3.判断数据库查询结果
        if (user != null){
            return "登陆成功";
        }else {
            return "登录失败";
        }

    }
}
