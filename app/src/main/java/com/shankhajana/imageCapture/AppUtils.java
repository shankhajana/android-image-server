package com.shankhajana.imageCapture;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class AppUtils {
    public static final String SHARED_PREF_KEY = "SHARED_PREF_KEY";
    public static final String IS_FIRST_RUN = "IS_FIRST_RUN";

    public static SharedPreferences sharedPrefs;

    public static boolean isFirstRun(Context context){
        sharedPrefs = context.getSharedPreferences(AppUtils.SHARED_PREF_KEY, MODE_PRIVATE);
        return sharedPrefs.getBoolean(AppUtils.IS_FIRST_RUN, Boolean.TRUE);
    }

    public static void setFirstRun(Context context,Boolean bool) {
        Log.i("AppUtils","set first run flag");
        sharedPrefs = context.getSharedPreferences(SHARED_PREF_KEY,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putBoolean(IS_FIRST_RUN,bool);
        editor.commit();
    }
}
