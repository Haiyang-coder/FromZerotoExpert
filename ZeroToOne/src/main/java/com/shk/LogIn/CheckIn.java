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
@WebServlet(value = "/FromZerotoExpert", loadOnStartup = 0)
public class CheckIn extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        String userName = null;
        //check whether user registered
        if(cookies == null){
            //if the user dont regiseter, regiseter now
            System.out.println("检测不到cookie，立即注册");
            req.setAttribute("isRegister",false);
            req.getRequestDispatcher("/Register").forward(req,resp);
        }

        for(Cookie cookie : cookies){
            if (cookie.getName().equals("user")){
                userName = cookie.getValue();
            }
        }

        if(userName == null){
            //if the user dont regiseter, regiseter now
            System.out.println("用户没有注册，立即注册");
            req.setAttribute("isRegister",false);
            req.getRequestDispatcher("/Register").forward(req,resp);
            //resp.sendRedirect("/Register");
        }else{
            System.out.println("用户已经注册");
            req.setAttribute("isRegister",true);
            req.getRequestDispatcher("/ShowPage").forward(req,resp);
        }

    }
}

