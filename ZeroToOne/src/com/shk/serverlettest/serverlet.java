package com.shk.serverlettest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author: sunhengkang
 * @date:2022/9/6
 */
public class serverlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String h1 = "<h1 style='color:red'>"+ "嗨，欢迎您来到 from zero to expert."+ "</h1>";
        PrintWriter writer = response.getWriter();
        //response ot the brower of  this HTML statement
        writer.println(h1);
    }
}
