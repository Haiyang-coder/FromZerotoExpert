package com.shk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author: sunhengkang
 * @date:2022/10/6
 */

@Controller
public class FirstOpenController {

//    private static HttpServletRequest req;
//    private static HttpServletResponse resp;


    @RequestMapping("/FromZerotoExpert")
    @ResponseBody
    private void firstLoginCheck() throws ServletException, IOException {
        String userName = null;
        //获取request对象
        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest req = attributes.getRequest();
        HttpServletResponse resp = attributes.getResponse();
        //获取Cookies
        Cookie[] cookies = req.getCookies();
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

    @RequestMapping("/Register")
    @ResponseBody
    private void Register() throws ServletException, IOException {
        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest req = attributes.getRequest();
        HttpServletResponse resp = attributes.getResponse();

        Cookie cookie = new Cookie("user", "test");
        cookie.setMaxAge(60 * 60 * 24);
        resp.addCookie(cookie);
        System.out.println("用户注册完成");
        req.getRequestDispatcher ("/ShowPage").forward(req,resp);
    }

    @RequestMapping("/ShowPage")
    @ResponseBody
    private String ShowPage(){
        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest req = attributes.getRequest();
        HttpServletResponse resp = attributes.getResponse();

        String h1 = "嗨，欢迎来到 from zero to expert.xx";
        String h2 = "嗨，欢迎再次来到 from zero to expert.xx";


        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        Boolean isRegister = (Boolean) req.getAttribute("isRegister");
        if(isRegister){
            return h2;
        }else {
            return h1;
        }


    }

}
