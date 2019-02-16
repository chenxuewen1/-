package com.example.oneweek.presenter;

import android.util.Log;

import com.example.oneweek.model.LoginModel;
import com.example.oneweek.view.LoginView;

/*Time:2019/2/16
 *Author:x
 *Name:chenxuewen
 *Description:
 */
public class LoginPresenter  {

    private final LoginModel loginModel;
    private final LoginView loginView;

    //在构造方法中实列model
    public LoginPresenter(LoginView view) {
        loginModel = new LoginModel();
        loginView = view;
    }

    public void sendParameter(String main_phonee, String main_pwd) {
        loginModel.login(main_phonee, main_pwd);
        //接收回传过来的数据
        loginModel.setLoginLisenter(new LoginModel.OnLoginLisenter() {
            @Override
            public void onResult(String nickName) {
                loginView.view(nickName);
            }
        });

    }



}
