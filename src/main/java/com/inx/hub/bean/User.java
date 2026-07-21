package com.inx.hub.bean;

/**
 * @Author huangjinping1000@163.com
 * @Description
 * @Date 12/15/21
 **/

public class User {
    private String name;
    private String testFlag;
    private transient String password="123";

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTestFlag() {
        return testFlag;
    }

    public void setTestFlag(String testFlag) {
        this.testFlag = testFlag;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", testFlag='" + testFlag + '\'' +
                '}';
    }
}
