package com.demo.mvpdemo01.model;

import android.util.Log;

/**
 * Created by THF on 17/5/11.
 */

public class IUserModle implements IUser{
    private String phone_number;
    private String password;
    public IUserModle(String phone_number,String password){
        this.phone_number = phone_number;
        this.password = password;
    }
    //重写接口的方法
    @Override
    public String getPhoneNumber() {
        return phone_number;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Boolean isLogin(String phone_num, String password) {
        Log.d("phone01",phone_num);
        Log.d("phone02",phone_number);
        Log.d("password01",password);
        Log.d("password02",this.password);
        if(this.phone_number.equals(phone_num)&&this.password.equals(password)){
            return true;
        }
        return false;
    }
}
