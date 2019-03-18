package a.bw.com.week_oneday_test.presenter;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.List;

import a.bw.com.week_oneday_test.acitvity.MainActivity;
import a.bw.com.week_oneday_test.bean.JsonBean;
import a.bw.com.week_oneday_test.view.CallInface;
import a.bw.com.week_oneday_test.model.ShowModel;

/*Time:2019/3/16
 *Author:chenxuewen
 *Description:
 */
public class ShowPresenter {

    private final ShowModel showModel;
    private final CallInface callInface;
    protected Reference reference;
    public ShowPresenter(CallInface onResult){
        showModel = new ShowModel();
        callInface = onResult;
    }
    public void showPreData(int page) {
        showModel.showModelData(page);
        showModel.setShowListener(new ShowModel.onShowListener() {
            @Override
            public void onResult(List<JsonBean> json) {
                callInface.onResult(json);
            }
        });
    }

    public void attach(MainActivity mainActivity) {
        reference= new WeakReference(mainActivity);
    }
    //内存泄漏
    public void destroy() {
        if(reference!=null){
            reference.clear();
            reference=null;
        }
    }
}
