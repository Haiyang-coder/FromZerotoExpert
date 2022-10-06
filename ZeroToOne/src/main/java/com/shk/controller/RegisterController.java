package com.shk.controller;

import com.shk.domain.DisallowWord;
import com.shk.domain.User;
import com.shk.service.SensitiveService;
import com.shk.service.UserSerice;
import com.shk.utils.CheckPasswordUtil;
import com.shk.utils.SensitivewordFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Set;

/**
 * @author: sunhengkang
 * @date:2022/10/6
 */
@Controller
public class RegisterController {

    @Autowired
    private UserSerice userSerice;
    @Autowired
    private SensitiveService sensitiveService;

    @RequestMapping("/RegisterServlet")
    @ResponseBody
    private String registerUser(){
        //获取request对象
        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest req = attributes.getRequest();
        HttpServletResponse resp = attributes.getResponse();

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String nickname = req.getParameter("nickname");

        User user = userSerice.getUserByName(username);

        //密码强度检测
        int status = CheckPasswordUtil.checkPasswod(password);

        switch (status){
            case CheckPasswordUtil.PS_EASY:
                return "密码太简单";
            case CheckPasswordUtil.PS_NOTRULE:
                return "密码有特殊字符";
            case CheckPasswordUtil.PS_SHORT:
                return "密码太短了";
            default:
                break;
        }

        //用户名检测
        List<DisallowWord> disallowWords = sensitiveService.getdisallowWord();
        Set<String> wordSet = SensitivewordFilter.getSensitiveWordSet(disallowWords);
        SensitivewordFilter.init(wordSet);
        boolean contains = SensitivewordFilter.contains(nickname);
        if (contains){
            return "昵名不合规";
        }

        //判断用户用户名是否重复
        if (user != null){
            return "用户名已经存在了";
        }else {
            userSerice.insertUser(username, password, nickname);

            return "注册成功";
        }
    }
}
