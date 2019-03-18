package a.bw.com.week_oneday_test.geen;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

/*Time:2019/3/16
 *Author:chenxuewen
 *Description:
 */
@Entity
public class NewsGreenDao {
    private String title;
    @Transient
    private int tempUsageCount; // not persisted  
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    @Generated(hash = 1668447341)
    public NewsGreenDao(String title) {
        this.title = title;
    }
    @Generated(hash = 1995163167)
    public NewsGreenDao() {
    }

}
