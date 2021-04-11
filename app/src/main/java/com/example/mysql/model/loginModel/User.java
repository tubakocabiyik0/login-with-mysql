package com.example.mysql.model.loginModel;

public class User {
    private String name;
    private String pass;
    private int result_code;
    public String getName()
    {
        return name;
    }
    public int getResult_code()
    {
        return result_code;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public User(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public User() {
    }
}
