package com.demo.mvpdemo01.model;

/**
 * Created by THF on 17/5/11.
 */

public interface IUser {

    public String getPhoneNumber();
    public String getPassword();
    public Boolean isLogin(String phone_num,String password);

}
