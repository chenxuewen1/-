package a.bw.com.chenxuewen0308.bean;

import java.util.ArrayList;

/*Time:2019/3/8
 *Author:chenxuewen
 *Description:
 */
public class JsonForm {
    private String code;
    private ArrayList<DataBean> data;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ArrayList<DataBean> getData() {
        return data;
    }

    public void setData(ArrayList<DataBean> data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public JsonForm(String code, ArrayList<DataBean> data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }
}
