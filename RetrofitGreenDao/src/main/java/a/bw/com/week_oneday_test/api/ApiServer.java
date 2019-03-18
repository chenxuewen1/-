package a.bw.com.week_oneday_test.api;

import java.util.List;

import a.bw.com.week_oneday_test.bean.JsonBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/*Time:2019/3/16
 *Author:chenxuewen
 *Description:
 */
public interface ApiServer {
    //http://mnews.gw.com.cn/wap/data/news/news/mobile/jbgg/page_1.json
    @GET("page_{page}.json")
    Call<List<JsonBean>> getNews(@Path("page")int page);
}
