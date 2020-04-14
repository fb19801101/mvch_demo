package com.mvc.bean;

/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-02-24 20:09
 */
public class LoginBean {
    private String username = null;
    private String password = null;

    public void LoginBean() {
        username = "admin";
        password = "123456";
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public  boolean checkLogin() {
        String _username = "admin";
        String _passeord = "123456";
        if (username.equals(_username) && password.equals(_passeord)) {
            return true;
        } else {
            return false;
        }
    }
}
