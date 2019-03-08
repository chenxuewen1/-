package a.bw.com.chenxuewen0308.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import a.bw.com.chenxuewen0308.R;

/*Time:2019/3/8
 *Author:chenxuewen
 *Description:
 */
public class ZiView extends LinearLayout {

    private Button jia;
    private Button jian;
    private EditText num;
    public ZiView(Context context) {
        super(context);
    }

    public ZiView(final Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.ziitem_layout,null,false);
        addView(view);
        jia = view.findViewById(R.id.ziitem_jia);
        jian = view.findViewById(R.id.ziitem_jian);
        num = view.findViewById(R.id.ziitem_num);
        //开始为1
        num.setText("1");
        //加
        jia.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                int trim = Integer.parseInt(num.getText().toString().trim());
                trim++;
                num.setText(trim+"");
            }
        });
        //减
        jian.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                int trim = Integer.parseInt(num.getText().toString().trim());
                trim--;
                if(trim<=0){
                    Toast.makeText(context, "最低为一件商品", Toast.LENGTH_SHORT).show();
                    return;
                }
                num.setText(trim+"");
            }
        });
    }

    public ZiView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
