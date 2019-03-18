package a.bw.com.week_oneday_test.acitvity;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bawei.swiperefreshlayoutlibrary.SwipyRefreshLayout;
import com.bawei.swiperefreshlayoutlibrary.SwipyRefreshLayoutDirection;

import java.util.ArrayList;
import java.util.List;

import a.bw.com.week_oneday_test.JiaZai;
import a.bw.com.week_oneday_test.R;
import a.bw.com.week_oneday_test.adapter.NewsAdapter;
import a.bw.com.week_oneday_test.app.MyApplication;
import a.bw.com.week_oneday_test.bean.JsonBean;
import a.bw.com.week_oneday_test.geen.NewsGreenDao;
import a.bw.com.week_oneday_test.gen.NewsGreenDaoDao;
import a.bw.com.week_oneday_test.view.CallInface;
import a.bw.com.week_oneday_test.presenter.ShowPresenter;
import a.bw.com.week_oneday_test.util.OkWng;

public class MainActivity extends AppCompatActivity implements CallInface {

    private ShowPresenter showPresenter;
    private boolean b;
    private int page=1;
    private RecyclerView rec;
    private List<NewsGreenDao> list=null;
    private SwipeRefreshLayout ren;
    private Handler handler = new Handler();
    private NewsGreenDaoDao db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showPresenter = new ShowPresenter(this);
        rec = findViewById(R.id.recy);
        ren = findViewById(R.id.renovate);
         db = MyApplication.getInstances().getDaoSession().getNewsGreenDaoDao();
        //创建布局
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //设置布局
        rec.setLayoutManager(linearLayoutManager);
        //添加分割线
        rec.addItemDecoration(new DividerItemDecoration(MainActivity.this,DividerItemDecoration.VERTICAL));
        b = OkWng.isNetworkAvailable(this);
        if(b){
            Toast.makeText(this, "有网", Toast.LENGTH_SHORT).show();
            showPresenter.showPreData(page);
        }else{
            Toast.makeText(this, "没网", Toast.LENGTH_SHORT).show();
            List<NewsGreenDao> list1=db.loadAll();
            NewsAdapter newsAdapter = new NewsAdapter(MainActivity.this, list1);
            rec.setAdapter(newsAdapter);
        }
        //设置模式
        ren.setColorSchemeResources(R.color.colorAccent,R.color.colorPrimary,R.color.colorPrimaryDark);
        ren.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if(b){
                    page=1;
                    Toast.makeText(MainActivity.this, "刷新成功", Toast.LENGTH_SHORT).show();
                    showPresenter.showPreData(page);
                }else{
                    Toast.makeText(MainActivity.this, "网络悄悄的走了", Toast.LENGTH_SHORT).show();
                }
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ren.setRefreshing(false);
                    }
                },2000);
            }
        });
        rec.addOnScrollListener(new JiaZai() {
            @Override
            protected void onLoading(int countItem, int lastItem) {
                if(b){
                    page++;
                    Toast.makeText(MainActivity.this, "加载成功", Toast.LENGTH_SHORT).show();
                    showPresenter.showPreData(page);
                }else{
                    Toast.makeText(MainActivity.this, "网络悄悄的走了", Toast.LENGTH_SHORT).show();
                }
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ren.setRefreshing(false);
                    }
                },2000);
            }
        });
        showPresenter.attach(MainActivity.this);
    }


    @Override
    public void onResult(List<JsonBean> json) {
        List<NewsGreenDao> data = json.get(0).getData();
        if(page==1){
            list=new ArrayList<>();
            db.deleteAll();
            for (int i = 0; i <data.size() ; i++) {
                String title = data.get(i).getTitle();
                db.insert(new NewsGreenDao(title));
            }

        }
        list.addAll(data);
        //Log.i("sss",data.toString());
        NewsAdapter newsAdapter = new NewsAdapter(MainActivity.this, list);
        rec.setAdapter(newsAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showPresenter.destroy();
        Log.i("sss","销毁了");
    }
}
