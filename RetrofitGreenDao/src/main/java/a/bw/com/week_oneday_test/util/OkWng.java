package a.bw.com.week_oneday_test.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/*Time:2019/3/15
 *Author:chenxuewen
 *Description:
 */
public class OkWng {
    public static boolean isNetworkAvailable(Context context) {

        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo info = manager.getActiveNetworkInfo();

        if (info != null){

            return info.isAvailable();
        }

        return false;
    }

}
