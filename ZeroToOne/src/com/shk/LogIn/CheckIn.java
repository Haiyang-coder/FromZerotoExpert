package com.shk.LogIn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: sunhengkang
 * @date:2022/9/8
 */
@WebServlet(value = "/CheckIn",loadOnStartup = 1)
public class CheckIn extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        String userName = null;
        for(Cookie cookie : cookies){
            if (cookie.getName().equals("user")){
                userName = cookie.getValue();
            }
        }
        if(userName == null){
            //if the user dont regiseter, regiseter now
            System.out.println("用户没有注册，立即注册");
            req.getRequestDispatcher("/Register").forward(req,resp);
        }else{
            System.out.println("用户已经注册");
            req.getRequestDispatcher("/FromZerotoExpert");
        }

    }
}
