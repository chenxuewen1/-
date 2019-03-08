package a.bw.com.chenxuewen0308.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

import a.bw.com.chenxuewen0308.R;
import a.bw.com.chenxuewen0308.bean.DataBean;

/*Time:2019/3/8
 *Author:chenxuewen
 *Description:一级列表的适配器
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    ArrayList<DataBean> dataBeans;

    public MyAdapter(Context context, ArrayList<DataBean> dataBeans) {
        this.context = context;
        this.dataBeans = dataBeans;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.item,null,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        String sellerName = dataBeans.get(i).getSellerName();
        myViewHolder.name.setText(sellerName);
        //创建线性布局
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        myViewHolder.rec.setLayoutManager(linearLayoutManager);
        ShowChildAdapter showChildAdapter = new ShowChildAdapter(context,dataBeans.get(i).getList());
        myViewHolder.rec.setAdapter(showChildAdapter);
        myViewHolder.checkBox.setChecked(dataBeans.get(i).isIscheckk());
    }

    @Override
    public int getItemCount() {
        return dataBeans.size();
    }
    /**
     * 复选框状态
     */
    public void isCheckData(boolean b) {
        for (int i = 0; i <dataBeans.size() ; i++) {
            dataBeans.get(i).setIscheckk(b);
        }
        //刷新适配器
        notifyDataSetChanged();
    }
    //自定义viewholder
    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private final TextView name;
        private final CheckBox checkBox;
        private final RecyclerView rec;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.item_name);
            checkBox = itemView.findViewById(R.id.item_checkbox);
            rec = itemView.findViewById(R.id.item_rec);
        }
    }

}
