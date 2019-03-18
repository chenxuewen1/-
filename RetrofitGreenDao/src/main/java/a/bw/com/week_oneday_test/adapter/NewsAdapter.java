package a.bw.com.week_oneday_test.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import a.bw.com.week_oneday_test.R;
import a.bw.com.week_oneday_test.bean.JsonBean;
import a.bw.com.week_oneday_test.geen.NewsGreenDao;

/*Time:2019/3/16
 *Author:chenxuewen
 *Description:新闻适配器
 */
public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<NewsGreenDao> data;

    public NewsAdapter(Context context, List<NewsGreenDao> data) {
        this.context = context;
        this.data = data;
    }
    private final static int TYPE_CONTENT=0;//正常内容
    private final static int TYPE_FOOTER=1;//加载View
    @Override
    public int getItemViewType(int position) {
        if (position==data.size()){
            return TYPE_FOOTER;
        }
        return TYPE_CONTENT;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i==TYPE_FOOTER){
            View view = LayoutInflater.from(context).inflate(R.layout.activity_main_foot, null, false);
            return new FootViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.newsadapter_layout, null, false);
            MyViewHolder myViewHolder = new MyViewHolder(view);
            return myViewHolder;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (getItemViewType(i)==TYPE_FOOTER){

        }
        else{
            MyViewHolder myViewHolder= (MyViewHolder) viewHolder;
            String title = data.get(i).getTitle();
            myViewHolder.title.setText(title);
            String url="https://i3.wp.com/dingyue.nosdn.127.net/RkxtljzfBkUSPrwLxxClJ7d5lKMp=1VDIvRABKDOAkez51538883650518.gif";
            Uri parse = Uri.parse(url);
            DraweeController controller = Fresco.newDraweeControllerBuilder()
                    .setUri(parse)
                    .setAutoPlayAnimations(true)
                    .build();
            myViewHolder.imag.setController(controller);
        }

    }

    @Override
    public int getItemCount() {
        return data.size()+1;
    }


    //自定义适配器
    public class MyViewHolder extends RecyclerView.ViewHolder{

        private final TextView title;
        private final SimpleDraweeView imag;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.news_title);
            imag = itemView.findViewById(R.id.news_imag);
        }
    }
    private class FootViewHolder extends RecyclerView.ViewHolder{
        ContentLoadingProgressBar contentLoadingProgressBar;
        public FootViewHolder(View itemView) {
            super(itemView);
            contentLoadingProgressBar=itemView.findViewById(R.id.pb_progress);
        }
    }
}
