package com.shk.show;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author: sunhengkang
 * @date:2022/9/8
 */
@WebServlet(value = "/RegisterPage")
public class RegisterPage extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入 RegisterPage");
        String h1 = "嗨，欢迎再次来到 from zero to expert.xx";

        //Attention Creating PrintWriter must behind the Setting code
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<h1>"+ h1 + "</h1>");
    }
}
