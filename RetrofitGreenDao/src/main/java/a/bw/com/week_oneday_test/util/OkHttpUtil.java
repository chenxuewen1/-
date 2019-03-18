package a.bw.com.week_oneday_test.util;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/*Time:2019/3/13
 *Author:chenxuewen
 *Description:单列模式
 */
public class OkHttpUtil {
    public static OkHttpUtil okHttpUtil;
    public OkHttpUtil(){}
    public static synchronized OkHttpUtil getInance(){
        if(okHttpUtil==null){
            //双重锁
            synchronized (OkHttpUtil.class){
                if(okHttpUtil==null){
                    okHttpUtil=new OkHttpUtil();
                }
            }
        }
        return okHttpUtil;
    }
    /**
     * 应用拦截器
     */
    public OkHttpClient getOkHttpClient(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request().newBuilder()
                                .addHeader("sessionId", "sessionId")
                                .addHeader("userId", "userId")
                                .build();
                        return chain.proceed(request);
                    }
                })
                .build();
        return okHttpClient;
    }

    /**
     * get请求
     * @param url
     * @param callback
     */
    public void doGet(String url , Callback callback){
        OkHttpClient okHttpClient = getOkHttpClient();
        Request request = new Request.Builder().get().url(url).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }
    public void doGet1(String url , Callback callback){
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        Request request = new Request.Builder().get().url(url).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }
}
