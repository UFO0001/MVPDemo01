package com.demo.mvpdemo01.Login.model;

import com.demo.mvpdemo01.Bean.User;

/**
 * Created by UFO on 17/5/11.
 */

public interface IUserModel {

    void login(String phone_number,String password,LogCb callback);
    interface LogCb{
        void onSuccess(User user);
        void onFail(String message);
    }

}
