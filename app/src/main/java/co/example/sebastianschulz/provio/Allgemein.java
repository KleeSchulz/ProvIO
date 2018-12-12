package co.example.sebastianschulz.provio;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.widget.Toast;

public class Allgemein extends Application {


    private static Context mContext;
    public static Context activityPlaceholder;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }


    public static Context getContext() {
        return mContext;
    }


    public static void toastshort(Context context,String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

    public static void toastlong(Context context,String text) {
        Toast.makeText(context, text, Toast.LENGTH_LONG);
    }
}
