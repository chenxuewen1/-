package a.bw.com.chenxuewen0308.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import a.bw.com.chenxuewen0308.R;
import a.bw.com.chenxuewen0308.bean.ComList;
import a.bw.com.chenxuewen0308.bean.DataBean;

/*Time:2019/3/8
 *Author:chenxuewen
 *Description:一级列表的适配器
 */
public class ShowChildAdapter extends RecyclerView.Adapter<ShowChildAdapter.MyViewHolder> {
    Context context;
    ArrayList<ComList> comLists;

    public ShowChildAdapter(Context context, ArrayList<ComList> comLists) {
        this.context = context;
        this.comLists = comLists;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.chid_item,null,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        String title = comLists.get(i).getTitle();
        String pricee = comLists.get(i).getPrice();
        String images = comLists.get(i).getImages();
        myViewHolder.name.setText(title);
        myViewHolder.price.setText("优惠价:￥"+pricee);
        Glide.with(context).load(images).into(myViewHolder.iamg);
    }

    @Override
    public int getItemCount() {
        return comLists.size();
    }

    //自定义viewholder
    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private final TextView name;
        private final CheckBox checkBox;
        private final TextView price;
        private final ImageView iamg;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.chiditem_name);
            checkBox = itemView.findViewById(R.id.chiditem_checkbox);
            price = itemView.findViewById(R.id.chiditem_price);
            iamg = itemView.findViewById(R.id.chiditem_image);
        }
    }
}
