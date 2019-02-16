package com.example.oneweek.model;

import android.os.Handler;
import android.os.Message;

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
public class RegisterModel {
    //定义接口
    public interface OnRegisterLisenter{

        void onResult(String status);
    }
    //声明接口
    public OnRegisterLisenter registerLisenter;
    //设置公共监听
    public void setRegisterLisenter(OnRegisterLisenter registerLisenter) {
        this.registerLisenter = registerLisenter;
    }

    /**
     *@time:2019/2/16
     *@author:
     *@name:chenxuewen
     *@description:handler请求
     */
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    String json = (String) msg.obj;
                    //原生解析
                    try {
                        JSONObject jsonObject = new JSONObject(json);
                        String message = jsonObject.getString("message");
                        String status = jsonObject.getString("status");
                        if(registerLisenter!=null){
                            registerLisenter.onResult(status);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    break;
            }
        }
    };
    public void register(String reg_phone1, String reg_pwd1) {
        //创建请求对象
        OkHttpClient okHttpClient = new OkHttpClient
                .Builder()
                .connectTimeout(5000,TimeUnit.MILLISECONDS)
                .build();
        //创建并封装参数
        FormBody formBody = new FormBody
                .Builder()
                .add("phone",reg_phone1)
                .add("pwd",reg_pwd1)
                .build();
        //post请求
        Request request = new Request
                .Builder()
                .post(formBody)
                .url("http://172.17.8.100/small/user/v1/register")
                .build();
        //执行异步请求
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            //此方法在子线程
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Message message = new Message();
                message.obj=json;
                message.what=0;
                //发送消磁
                handler.sendMessage(message);
            }
        });
    }
}
