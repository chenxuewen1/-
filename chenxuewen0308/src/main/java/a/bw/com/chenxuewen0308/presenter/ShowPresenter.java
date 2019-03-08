package a.bw.com.chenxuewen0308.presenter;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

import a.bw.com.chenxuewen0308.bean.DataBean;
import a.bw.com.chenxuewen0308.interfac.ShowInterface;
import a.bw.com.chenxuewen0308.model.ShowModel;
import a.bw.com.chenxuewen0308.view.ShowView;

/*Time:2019/3/8
 *Author:chenxuewen
 *Description:展示逻辑
 */
public class ShowPresenter {
    protected Reference reference;
    private final ShowModel showModel;
    private final ShowInterface showInterface;

    public ShowPresenter(ShowInterface onResult){
        showModel = new ShowModel();
        showInterface = onResult;
    }
    public void showPreData() {
        showModel.showModelData();
        //接收并传入showInterface
        showModel.setShowLisener(new ShowModel.OnShowLisener() {
            @Override
            public void onResult(ArrayList<DataBean> data) {
                showInterface.onResult(data);
            }
        });
    }

    /**
     * 解绑
     */
    public void destroy() {
        if(reference!=null){
            reference.clear();
            reference=null;
        }
    }

    public void attach(ShowView showView) {
        reference=new WeakReference(showView);
    }
}
