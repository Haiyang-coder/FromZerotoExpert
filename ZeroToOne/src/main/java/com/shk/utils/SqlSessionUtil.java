package com.shk.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author: sunhengkang
 * @function : get the SqlSession
 * @date:2022/9/21
 */
public class SqlSessionUtil {
        //sqlSession工厂对象
        private static SqlSessionFactory factory = null;


    //加载类自动加载动态代码块
        static {
            try {
                //读取配置文件
                InputStream resource = Resources.getResourceAsStream("mybatis-config.xml");
                System.out.println(resource);
                //使用SqlSessionFactoryBuilder()创建SqlSessionFactory
                factory = new SqlSessionFactoryBuilder().build(resource);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        /**
         * 获取sqlsession对象的util方法
         * @return
         */
        public static SqlSession getSqlSession () {
            SqlSession session = null;
            if (factory != null) {
                //此处设置为非自动提交事务
                session = factory.openSession();
            }
            //返回sqlSession对象
            return session;
        }

       

}
