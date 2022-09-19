package main.java.com.shk.LogIn;

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
@WebServlet(value = "/Register")
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("user", "test");
        cookie.setMaxAge(60 * 60 * 24);
        resp.addCookie(cookie);
        System.out.println("用户注册完成");
        req.getRequestDispatcher ("/ShowPage").forward(req,resp);


    }
}
