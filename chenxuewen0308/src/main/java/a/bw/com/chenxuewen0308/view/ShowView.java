package a.bw.com.chenxuewen0308.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.util.ArrayList;

import a.bw.com.chenxuewen0308.R;
import a.bw.com.chenxuewen0308.adapter.MyAdapter;
import a.bw.com.chenxuewen0308.bean.DataBean;
import a.bw.com.chenxuewen0308.interfac.ShowInterface;
import a.bw.com.chenxuewen0308.presenter.ShowPresenter;
/**
 *@time:2019/3/8
 *@author: chenxuewen
 *@description:view展示层
 */
public class ShowView extends AppCompatActivity implements ShowInterface {

    private ShowPresenter showPresenter;
    private RecyclerView rec;
    private CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_view);
        showPresenter = new ShowPresenter(this);
        //找控件
        initView();
        initData();
    }

    /**
     * 数据
     */
    private void initData() {
        showPresenter.showPreData();
        //创建线性布局
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //设置布局
        rec.setLayoutManager(linearLayoutManager);
        showPresenter.attach(this);
    }

    /**
     * 控件
     */
    private void initView() {
        rec = findViewById(R.id.show_recv);
        checkBox = findViewById(R.id.show_checkbox);
    }
    /**
     * 返回来的数据
     * @param data
     */
    @Override
    public void onResult(ArrayList<DataBean> data) {
        /*String sellerName = data.get(1).getSellerName();
        Log.i("sss",sellerName);*/
        //适配器
        final MyAdapter myAdapter = new MyAdapter(ShowView.this,data);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean b = checkBox.isChecked();
                if(b){
                    myAdapter.isCheckData(true);
                }else{
                    myAdapter.isCheckData(false);
                }
            }
        });
        rec.setAdapter(myAdapter);
    }
    //优化mvp泄漏
    @Override
    protected void onDestroy() {
        super.onDestroy();
        showPresenter.destroy();
        Log.i("destroy","销毁了");
    }


}
