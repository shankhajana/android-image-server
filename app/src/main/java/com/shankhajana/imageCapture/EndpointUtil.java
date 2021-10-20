package com.shankhajana.imageCapture;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class EndpointUtil {
    public static final String SHARED_PREF_KEY = "SHARED_PREF_KEY";
    public static final String BASE_ENDPOINT_KEY = "BASE_ENDPOINT_KEY";
    private static final String EMPTY_STRING = "";
    public static final String SAVE_IMAGE_URI = "%s/save-image";
    public static final String GALLERY_URI = "%s/gallery";
    public static final String GET_IMAGE_URI = "%s/get-image/%s";

    public static SharedPreferences sharedPrefs;

    public static String getBaseURI(Context context){
        sharedPrefs = context.getSharedPreferences(EndpointUtil.SHARED_PREF_KEY, MODE_PRIVATE);
        String baseURI = sharedPrefs.getString(EndpointUtil.BASE_ENDPOINT_KEY, EMPTY_STRING);
        if(baseURI.isEmpty()){
            Log.e("Util","base uri is empty");
        } else{
            Log.i("Util",baseURI);
        }
        return baseURI;
    }

    public static void saveBaseURI(Context context,String enteredValue){
        sharedPrefs = context.getSharedPreferences(SHARED_PREF_KEY,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString(EndpointUtil.BASE_ENDPOINT_KEY, enteredValue);
        editor.commit();
    }

    public static String getGalleryEndpoint(Context context){
        return String.format(GALLERY_URI,getBaseURI(context));
    }

    public static String getSaveImageUrlEndpoint(Context context){
        return String.format(SAVE_IMAGE_URI,getBaseURI(context));
    }

    public static String getImageUrlEndpoint(Context context, String imageId){
        return String.format(GET_IMAGE_URI,getBaseURI(context),imageId);
    }
}
