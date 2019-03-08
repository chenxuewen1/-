package a.bw.com.chenxuewen0308.bean;

import java.util.ArrayList;

/*Time:2019/3/8
 *Author:chenxuewen
 *Description:
 */
public class DataBean {
    private ArrayList<ComList> list;
    private String sellerName;
    private String sellerid;
    private boolean ischeckk=false;

    public boolean isIscheckk() {
        return ischeckk;
    }

    public void setIscheckk(boolean ischeckk) {
        this.ischeckk = ischeckk;
    }

    public ArrayList<ComList> getList() {
        return list;
    }

    public void setList(ArrayList<ComList> list) {
        this.list = list;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerid() {
        return sellerid;
    }

    public void setSellerid(String sellerid) {
        this.sellerid = sellerid;
    }

    public DataBean(ArrayList<ComList> list, String sellerName, String sellerid) {
        this.list = list;
        this.sellerName = sellerName;
        this.sellerid = sellerid;
    }
}
