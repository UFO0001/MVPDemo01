package com.demo.mvpdemo01.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.mvpdemo01.R;
import com.demo.mvpdemo01.presenter.IPresenter;
import com.demo.mvpdemo01.presenter.IPresenterCompl;

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
        iPresenter = new IPresenterCompl(this);
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
                Toast.makeText(this,"忘记密码啦",Toast.LENGTH_LONG).show();
                break;
            case R.id.tv_regidter:
                Toast.makeText(this,"注册喽",Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
    }

    @Override
    public void LoginResult(boolean ret, String code) {
        Toast.makeText(this,""+ret+code,Toast.LENGTH_LONG).show();
        if (ret == true){
            Toast.makeText(this,"登录成功",Toast.LENGTH_LONG).show();
            //进行跳转
        }else{
            if(code == "0"){
                Toast.makeText(this,"手机号码未注册",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,"其他原因",Toast.LENGTH_LONG).show();
            }
        }
    }
}
