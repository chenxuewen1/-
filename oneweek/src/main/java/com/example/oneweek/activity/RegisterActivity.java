package com.example.oneweek.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.oneweek.MainActivity;
import com.example.oneweek.R;
import com.example.oneweek.presenter.RegisterPresenter;
import com.example.oneweek.utils.Util;
import com.example.oneweek.view.LoginView;

public class RegisterActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    private EditText reg_phone;
    private EditText reg_pwd;
    private RegisterPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //控件
        initView();
        //new他
        presenter = new RegisterPresenter(this);
    }
    /**
     *@time:2019/2/16
     *@author:
     *@name:chenxuewen
     *@description:找控件
     */
    private void initView() {
        reg_phone = findViewById(R.id.register_phone);
        reg_pwd = findViewById(R.id.register_pwd);
        findViewById(R.id.register_reg).setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        String reg_pwd1 = reg_pwd.getText().toString().trim();
        String reg_phone1 = reg_phone.getText().toString().trim();
        boolean b = Util.isMobileNO(reg_phone1);
        //验证
        if(reg_phone1.equals("") && reg_pwd1.equals("")){
            Toast.makeText(this, "手机或密码为空", Toast.LENGTH_SHORT).show();
            return;
        }else{
            if(!b){
                Toast.makeText(this, "手机号不正确", Toast.LENGTH_SHORT).show();
                return;
            }
            if(reg_pwd1.length()<3){
                Toast.makeText(this, "最少输入三位数", Toast.LENGTH_SHORT).show();
                return;
            }
            //传参
            presenter.sendParameters(reg_phone1,reg_pwd1);
        }
    }

    @Override
    public void view(String nickName) {

    }

    @Override
    public void regview(String status) {
        Log.i("stt",status);
        if(status.equals("0000")){
            Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(RegisterActivity.this,MainActivity.class));
        }if(status.equals("1001")){
            Toast.makeText(this, "该手机号已注册，不能重复注册！", Toast.LENGTH_SHORT).show();
        }
    }


}
