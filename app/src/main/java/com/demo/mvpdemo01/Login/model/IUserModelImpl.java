package com.demo.mvpdemo01.Login.model;

import android.text.TextUtils;
import android.util.Log;

import com.demo.mvpdemo01.Bean.User;

/**
 * Created by UFO on 17/5/11.
 */

public class IUserModelImpl implements IUserModel {
    @Override
    public void login(String phone_number, String password, LogCb callback) {
        //在实际应用中 不仅仅是 phoneNumber password这两项
        if(TextUtils.equals(phone_number,"001")&&TextUtils.equals(password,"01")){
            User user = new User("001","01");
            callback.onSuccess(user);
        }else{
            callback.onFail("登录失败");
        }
    }
//    private String phone_number;
//    private String password;
//    public IUserModelImpl(String phone_number, String password){
//        this.phone_number = phone_number;
//        this.password = password;
//    }
    //重写接口的方法
//    @Override
//    public String getPhoneNumber() {
//        return phone_number;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public Boolean isLogin(String phone_num, String password) {
//        Log.d("phone01",phone_num);
//        Log.d("phone02",phone_number);
//        Log.d("password01",password);
//        Log.d("password02",this.password);
//        if(this.phone_number.equals(phone_num)&&this.password.equals(password)){
//            return true;
//        }
//        return false;
//    }
}















