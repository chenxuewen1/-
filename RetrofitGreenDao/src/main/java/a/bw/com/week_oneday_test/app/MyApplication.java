package a.bw.com.week_oneday_test.app;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.facebook.drawee.backends.pipeline.Fresco;

import a.bw.com.week_oneday_test.gen.DaoMaster;
import a.bw.com.week_oneday_test.gen.DaoSession;

/*Time:2019/3/16
 *Author:chenxuewen
 *Description:
 */
public class MyApplication extends Application {
    //饿汉
    public static MyApplication instance;
    private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mdaoMaster;
    private DaoSession mdaoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        instance=this;
        setDatabase();
    }
    /**
     * 饿汉
     */
    public static MyApplication getInstances(){
        return instance;
    }
    /**
     * 设置greendao
     */
    private void setDatabase() {
        // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        mHelper = new DaoMaster.DevOpenHelper(this, "notes-db", null);
        db = mHelper.getWritableDatabase();
        mdaoMaster = new DaoMaster(this.db);
        mdaoSession = mdaoMaster.newSession();
    }
    public DaoSession getDaoSession(){
        return mdaoSession;
    }
    public SQLiteDatabase getDb(){
        return db;
    }
}
