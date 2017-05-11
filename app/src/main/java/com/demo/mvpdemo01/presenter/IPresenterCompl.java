package com.demo.mvpdemo01.presenter;

import com.demo.mvpdemo01.model.IUser;
import com.demo.mvpdemo01.model.IUserModle;
import com.demo.mvpdemo01.view.ILoginView;

/**
 * Created by THF on 17/5/11.
 */

public class IPresenterCompl implements IPresenter {
    private IUser iUser;
    private ILoginView iLoginView;
    public IPresenterCompl(ILoginView iLoginView){
        this.iLoginView = iLoginView;
        //初始化数据
        initUser();
    }

    private void initUser() {
        iUser = new IUserModle("phone_number","password");
    }

    @Override
    public void login(String phone_number, String password) {
        boolean islogin = iUser.isLogin(phone_number,password);
        iLoginView.LoginResult(islogin,"0");
    }
}
