package com.demo.mvpdemo01.Login.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.mvpdemo01.Application.MyApplication;
import com.demo.mvpdemo01.Bean.User;
import com.demo.mvpdemo01.Login.model.IUserModelImpl;
import com.demo.mvpdemo01.Login.presenter.IPresenter;
import com.demo.mvpdemo01.Login.presenter.IPresenterCompl;
import com.demo.mvpdemo01.R;
import com.demo.mvpdemo01.Utils.AllToast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener,ILoginView{
    private EditText et_phone_number,et_password;
    private Button btn_login;
    private IPresenter iPresenter;
    private TextView tv_forget,tv_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        initView();
        iPresenter = new IPresenterCompl(this,new IUserModelImpl());
    }

    private void initView() {
        et_phone_number = (EditText) findViewById(R.id.et_phone_num);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        tv_forget = (TextView) findViewById(R.id.tv_forget_password);
        tv_register = (TextView) findViewById(R.id.tv_regidter);
        btn_login.setOnClickListener(this);
        tv_register.setOnClickListener(this);
        tv_forget.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                String phonenum = et_phone_number.getText().toString().trim();
                String password = et_password.getText().toString().trim();
                iPresenter.login(phonenum,password);
                break;
            case R.id.tv_forget_password:
                Toast.makeText(this,"忘记密码啦",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_regidter:
               // Toast.makeText(this,"注册喽",Toast.LENGTH_LONG).show();
//                AllToast.Builder builder = new AllToast.Builder(LoginActivity.this).setGravity(AllToast.GRAVITY_BOTTOM).setCustomerView(customview);
//                MyApplication.getMyInstance().toastShowByBuilder(builder);
                AllToast.Builder builder = new AllToast.Builder(LoginActivity.this).setGravity(AllToast.GRAVITY_CENTER).setFirstText("提醒").setSecondText("注册喽");
                MyApplication.getMyInstance().toastShowByBuilder(builder);
                break;
            default:
                break;
        }
    }


    @Override
    public void showLoginSuccessMsg(User logsuc_user) {
        //在Presenter中调用，会通知View更新UI来提示用户数据操作的结果
        Toast.makeText(getApplicationContext(),logsuc_user.getPhone_number()+"登录成功",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showLoginFailMsg(String errorMsg) {
        Toast.makeText(getApplicationContext(),"log fail"+errorMsg,Toast.LENGTH_SHORT).show();
    }
}
















