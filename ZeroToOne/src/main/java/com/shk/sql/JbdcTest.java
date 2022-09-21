package com.shk.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.format.SignStyle;

/**
 * @author: sunhengkang
 * @date:2022/9/17
 */
public class JbdcTest {
    public static void main(String[] args) throws Exception{
        //注册驱动
        //Class.forName("com.mysql.jdbc.Driver");

        //获取链接对象
        String url = "jdbc:mysql://127.0.0.1:3306/dbone?useSSL=false";
        String userName = "root";
        String passWord = "shkwmnm7010500";
        Connection conn = DriverManager.getConnection(url,userName,passWord);

        //定义sql语句
        String sql = "update account set money = 6000 where id = 1";

        //获取执行sql语句的对象
        Statement stmt = conn.createStatement();

        //执行sql语句，返回受影响的行数
        int cont = stmt.executeUpdate(sql);

        //获取处理结果
        System.out.println(cont);

        //释放资源
        stmt.close();
        conn.close();

    }
}
