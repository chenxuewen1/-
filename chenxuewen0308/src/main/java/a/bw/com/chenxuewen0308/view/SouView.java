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
public class SouView extends LinearLayout {
    private Button sou;
    private EditText name;
    public SouView(Context context) {
        super(context);
    }

    public SouView(final Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.souview_layout,null,false);
        addView(view);
        sou = view.findViewById(R.id.souview_sou);
        name = view.findViewById(R.id.souview_name);
        sou.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String trim = name.getText().toString().trim();
                Toast.makeText(context, trim, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public SouView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
