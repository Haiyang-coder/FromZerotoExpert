package main.java.com.shk.show;

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
@WebServlet(value = "/ShowPage")
public class ShowPage extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入 ShowPage");
        String h1 = "嗨，欢迎来到 from zero to expert.xx";
        String h2 = "嗨，欢迎再次来到 from zero to expert.xx";


        //req.getRequestDispatcher("/CheckIn").forward(req,resp);

        //System.out.println("检查完成");
        //Attention Creating PrintWriter must behind the Setting code
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        Boolean isRegister = (Boolean) req.getAttribute("isRegister");
        if(isRegister){
            resp.getWriter().println("<h1>"+ h2 + "</h1>");
        }else {
            resp.getWriter().println("<h1>"+ h1 + "</h1>");
        }

    }
}
