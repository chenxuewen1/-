package com.example.oneweek.model;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/*Time:2019/2/16
 *Author:x
 *Name:chenxuewen
 *Description:
 */
public class LoginModel {
    /**
     * @time:2019/2/16
     * @author:
     * @name:chenxuewen
     * @description:接口回调
     */
    //定义接口
    public interface OnLoginLisenter {
        void onResult(String nickName);
    }

    //声明接口
    public OnLoginLisenter loginLisenter;

    //提供一个公共的设置监听方法
    public void setLoginLisenter(OnLoginLisenter loginLisenter) {
        this.loginLisenter = loginLisenter;
    }

    /**
     * @time:2019/2/16
     * @author:
     * @name:chenxuewen
     * @description:登录请求数据
     */
    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    //原生解析
                    String json = (String) msg.obj;
                    try {
                        JSONObject jsonObject = new JSONObject(json);
                        JSONObject result = jsonObject.getJSONObject("result");
                        String nickName = result.getString("nickName");
                        Log.i("sss", nickName);
                        //这里也就是传参
                        if (loginLisenter != null) {
                            //回调传参数据
                            loginLisenter.onResult(nickName);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    };

    public void login(String main_phonee, String main_pwd) {
        //创建网络请求对象
        OkHttpClient okHttpClient = new OkHttpClient
                .Builder()
                .connectTimeout(5000, TimeUnit.MILLISECONDS)
                .build();
        //request请求并封装参数
        FormBody formBody = new FormBody
                .Builder()
                .add("phone", main_phonee)
                .add("pwd", main_pwd)
                .build();
        //post请求
        Request request = new Request
                .Builder()
                .post(formBody)
                .url("http://172.17.8.100/small/user/v1/login")
                .build();
        Call call = okHttpClient.newCall(request);
        //执行异步请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            //此方法在子线程
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();

                Message message = new Message();
                message.what = 0;
                message.obj = json;
                handler.sendMessage(message);
            }
        });
    }
}
