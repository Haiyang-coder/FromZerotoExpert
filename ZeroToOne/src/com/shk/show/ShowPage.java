package com.shk.show;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author: sunhengkang
 * @date:2022/9/8
 */
@WebServlet(value = "/FromZerotoExpert")
public class ShowPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //the first setp : check whether the user is already registered
        System.out.println("jinru show page");
        req.getRequestDispatcher("/CheckIn").forward(req,resp);
        String h1 = "嗨，欢迎来到 from zero to expert.xx";
        //Attention Creating PrintWriter must behind the Setting code
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<h1>"+ h1 + "</h1>");
        //response ot the brower of  this HTML statement
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
    }
}