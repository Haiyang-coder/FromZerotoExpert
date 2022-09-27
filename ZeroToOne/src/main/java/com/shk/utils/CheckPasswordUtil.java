package com.shk.utils;

/**
 * @author: sunhengkang
 * @date:2022/9/22
 */
public class CheckPasswordUtil {
    //数字
    private static final String NUMBER = ".*\\d+.*";
    //小写字母
    private static final String UPPERCASE = ".*[A-Z]+.*";
    //大写字母
    private static final String LOWERCASE = ".*[a-z]+.*";
    //特殊符号
    private static final String SYMBOL = ".*[~!@#$%^&*()_+|<>,.?/:;'\\[\\]{}\"]+.*";
    //错误原因
    public static final int PS_SHORT = 1;
    public static final int SUCCESS = 0;
    public static final int PS_EASY = 3;
    public static final int PS_NOTRULE = 2;

    /**
     *
     * @param password
     * @return 0:密码格式正确 1.长度违规 2.含有特殊字符 3.数字，小写，大写不足两个
     */
    public static int checkPasswod(String password){
        int passwordLenth = password.length();
        //判断密码长度
        if(passwordLenth < 6 || passwordLenth > 15){
            return PS_SHORT;
        }

        //判断是否由字母，数字，特殊字符组成
        int i = 0;
        if (password.matches(NUMBER)) i++;
        if (password.matches(LOWERCASE))i++;
        if (password.matches(UPPERCASE)) i++;
        if (password.matches(SYMBOL)) return PS_NOTRULE;
        if (i  < 2 )  return PS_EASY ;
        return SUCCESS;

    }
}
