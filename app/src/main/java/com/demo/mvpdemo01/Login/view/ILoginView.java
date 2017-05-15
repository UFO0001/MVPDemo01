package com.demo.mvpdemo01.Login.view;

import com.demo.mvpdemo01.Bean.User;

/**
 * Created by UFO on 17/5/11.
 */

public interface ILoginView {

    void showLoginSuccessMsg(User logsuc_user);
    void showLoginFailMsg(String errorMsg);

}
