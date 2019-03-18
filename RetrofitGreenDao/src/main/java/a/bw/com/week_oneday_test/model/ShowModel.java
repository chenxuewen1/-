package a.bw.com.week_oneday_test.model;


import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.List;

import a.bw.com.week_oneday_test.api.Api;
import a.bw.com.week_oneday_test.api.ApiServer;
import a.bw.com.week_oneday_test.bean.JsonBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*Time:2019/3/16
 *Author:chenxuewen
 *Description:
 */
public class ShowModel {
    //http://mnews.gw.com.cn/wap/data/news/news/mobile/jbgg/page_1.json
    //定义接口
    public interface onShowListener{
        void onResult(List<JsonBean> json);
    }
    //声明接口
    private onShowListener showListener;
    //监听
    public void setShowListener(onShowListener showListener) {
        this.showListener = showListener;
    }

    /**
     * 获取网络数据
     * @param page
     */
    public void showModelData(int page) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.newsUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //java动态代理方式获取代理对象
        ApiServer apiServer = retrofit.create(ApiServer.class);
        //通过代理方式对对象执行get请求返回call
        Call<List<JsonBean>> call = apiServer.getNews(page);
        call.enqueue(new Callback<List<JsonBean>>() {
            @Override
            public void onResponse(Call<List<JsonBean>> call, Response<List<JsonBean>> response) {
                List<JsonBean> json = response.body();

                if(showListener!=null){
                    showListener.onResult(json);
                }
            }

            @Override
            public void onFailure(Call<List<JsonBean>> call, Throwable t) {
                Log.i("erroro","失败了");
            }
        });
    }
}
