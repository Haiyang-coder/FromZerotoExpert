package com.shk.pojo;

/**
 * @author: sunhengkang
 * @data:用户数据信息
 * @date:2022/9/20
 */
public class User {
    private Integer id;
    private String userName;
    private String password;
    private String userNickName;

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public User(Integer id, String userName, String password, String userNickName) {
        this.userName = userName;
        this.password = password;
        this.id = id;
        this.userNickName = userNickName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", userNickName='" + userNickName + '\'' +
                '}';
    }
}
