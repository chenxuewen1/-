package com.example.oneweek.presenter;

import com.example.oneweek.model.RegisterModel;
import com.example.oneweek.view.LoginView;

/*Time:2019/2/16
 *Author:x
 *Name:chenxuewen
 *Description:
 */
public class RegisterPresenter {

    private final RegisterModel registerModel;
    private final LoginView regview1;

    public RegisterPresenter(LoginView regview){
        registerModel = new RegisterModel();
        regview1 = regview;
    }
    /**
     *@time:2019/2/16
     *@author:
     *@name:chenxuewen
     *@description:传过来的数据
     */
    public void sendParameters(String reg_phone1, String reg_pwd1) {
        registerModel.register(reg_phone1,reg_pwd1);
        registerModel.setRegisterLisenter(new RegisterModel.OnRegisterLisenter() {
            @Override
            public void onResult(String status) {
                regview1.regview(status);
            }
        });
    }
}
