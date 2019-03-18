package a.bw.com.week_oneday_test.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import a.bw.com.week_oneday_test.geen.NewsGreenDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "NEWS_GREEN_DAO".
*/
public class NewsGreenDaoDao extends AbstractDao<NewsGreenDao, Void> {

    public static final String TABLENAME = "NEWS_GREEN_DAO";

    /**
     * Properties of entity NewsGreenDao.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Title = new Property(0, String.class, "title", false, "TITLE");
    };


    public NewsGreenDaoDao(DaoConfig config) {
        super(config);
    }
    
    public NewsGreenDaoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"NEWS_GREEN_DAO\" (" + //
                "\"TITLE\" TEXT);"); // 0: title
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"NEWS_GREEN_DAO\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, NewsGreenDao entity) {
        stmt.clearBindings();
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(1, title);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, NewsGreenDao entity) {
        stmt.clearBindings();
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(1, title);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public NewsGreenDao readEntity(Cursor cursor, int offset) {
        NewsGreenDao entity = new NewsGreenDao( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0) // title
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, NewsGreenDao entity, int offset) {
        entity.setTitle(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(NewsGreenDao entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(NewsGreenDao entity) {
        return null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
