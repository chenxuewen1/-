package a.bw.com.chenxuewen0308.util;

import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

/*Time:2019/3/8
 *Author:chenxuewen
 *Description:单列模式
 */
public class OkHttpUtil {
    public static OkHttpUtil okHttpUtil=null;
    private OkHttpUtil(){}
    public static synchronized OkHttpUtil getInsance(){
        if(okHttpUtil==null){
            //双重判断
            synchronized (OkHttpUtil.class){
                if(okHttpUtil==null){
                    okHttpUtil=new OkHttpUtil();
                }
            }
        }
        return okHttpUtil;
    }
    //get请求
    public void doGet(String url, Callback callback){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5000,TimeUnit.MILLISECONDS)
                .build();
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }
}
