package com.demo.mvpdemo01.Login.presenter;


import com.demo.mvpdemo01.Bean.User;
import com.demo.mvpdemo01.Login.model.IUserModel;
import com.demo.mvpdemo01.Login.model.IUserModelImpl;
import com.demo.mvpdemo01.Login.view.ILoginView;

/**
 * Created by UFO on 17/5/11.
 */

public class IPresenterCompl implements IPresenter {
    private ILoginView mILoginView;
    private IUserModelImpl mIUserModelImpl;
    public IPresenterCompl(ILoginView iLoginView, IUserModelImpl iUserModelImpl){
        this.mILoginView = iLoginView;
        this.mIUserModelImpl = iUserModelImpl;
    }
    @Override
    public void login(String phone_number, String password) {
        //Presenter处理View路由过来的用户操作
        //将其转化成相对的命令 传给Model来做数据操作
        mIUserModelImpl.login(phone_number,password, new IUserModel.LogCb() {
            @Override
            public void onSuccess(User user) {
                //Model层数据操作后 将结果返回给Presenter
                //再由Presenter来通知View去更新UI通知用户数据操作的结果
                mILoginView.showLoginSuccessMsg(user);
            }

            @Override
            public void onFail(String message) {
                mILoginView.showLoginFailMsg(message);
            }
        });
    }

//    private IUserModel iUser;
//    private ILoginView iLoginView;
//    public IPresenterCompl(ILoginView iLoginView){
//        this.iLoginView = iLoginView;
//        //初始化数据
//        initUser();
//    }
//
//    private void initUser() {
//        iUser = new IUserModelImpl("phone_number","password");
//    }
//
//    @Override
//    public void login(String phone_number, String password) {
//        boolean islogin = iUser.isLogin(phone_number,password);
//
//    }
}
