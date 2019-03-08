package a.bw.com.chenxuewen0308.model;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import a.bw.com.chenxuewen0308.bean.DataBean;
import a.bw.com.chenxuewen0308.bean.JsonForm;
import a.bw.com.chenxuewen0308.util.OkHttpUtil;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/*Time:2019/3/8
 *Author:chenxuewen
 *Description:获取网络数据
 */
public class ShowModel {
    private String url="http://172.17.8.100/ks/product/getCarts?uid=51";
    //定义接口
    public interface OnShowLisener{

        void onResult(ArrayList<DataBean> data);
    }
    //声明接口
    private OnShowLisener showLisener;
    //监听
    public void setShowLisener(OnShowLisener showLisener) {
        this.showLisener = showLisener;
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    String json = (String) msg.obj;
                    Gson gson = new Gson();
                    JsonForm jsonForm = gson.fromJson(json, JsonForm.class);
                    ArrayList<DataBean> data = jsonForm.getData();

                    if(showLisener!=null){
                        showLisener.onResult(data);
                    }
                    break;
            }
        }
    };
    public void showModelData() {
        //实现
        OkHttpUtil.getInsance().doGet(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //返回的数据
                String json = response.body().string();
                //Log.i("doget",json);
                Message message = new Message();
                message.what=0;
                message.obj=json;
                //发送消息
                handler.sendMessage(message);
            }
        });
    }
}
