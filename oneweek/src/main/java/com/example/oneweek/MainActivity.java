package com.example.oneweek;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.oneweek.activity.QQActivity;
import com.example.oneweek.activity.RegisterActivity;
import com.example.oneweek.presenter.LoginPresenter;
import com.example.oneweek.utils.Util;
import com.example.oneweek.view.LoginView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, LoginView {

    private EditText main_phone;
    private EditText main_password;
    private TextView te;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_phone = findViewById(R.id.main_phone);
        main_password = findViewById(R.id.main_password);
        te = findViewById(R.id.main_ss);
         findViewById(R.id.main_regiser).setOnClickListener(this);

        findViewById(R.id.main_login).setOnClickListener(this);
        presenter = new LoginPresenter(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.main_login :
                String main_pwd = main_password.getText().toString().trim();
                String main_phonee = main_phone.getText().toString().trim();
                boolean b = Util.isMobileNO(main_phonee);
                //验证
                if(main_phonee.equals("") && main_pwd.equals("")){
                    Toast.makeText(this, "手机或密码为空", Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    if(!b){
                        Toast.makeText(this, "手机号不正确", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if(main_pwd.length()<3){
                        Toast.makeText(this, "最少输入三位数", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    //传参
                    presenter.sendParameter(main_phonee,main_pwd);
                }
                break;
            case R.id.main_regiser :
                startActivity(new Intent(MainActivity.this,RegisterActivity.class));
                break;
        }
    }

    @Override
    public void view(String nickName) {
        Log.i("xxx", nickName);
        te.setText(nickName);
        startActivity(new Intent(MainActivity.this,QQActivity.class));
    }

    @Override
    public void regview(String status) {

    }
}
