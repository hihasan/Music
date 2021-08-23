package com.hihasan.music.utils;


import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import static android.net.ConnectivityManager.CONNECTIVITY_ACTION;

public class MusicApplication extends Application {

    private static Context context;
    private static final String WIFI_STATE_CHANGE_ACTION = "android.net.wifi.WIFI_STATE_CHANGED";

    public void onCreate() {
        super.onCreate();

        MusicApplication.context = getApplicationContext();

        registerForNetworkChangeEvents(this);

    }

    public static Context getAppContext() {
        return MusicApplication.context;
    }


    public static String getResourceString(int resourceId){
        Context appContext = getAppContext();
        if(appContext == null) return null;
        Resources resources = appContext.getResources();
        return resources.getString(resourceId);
    }

    public static void registerForNetworkChangeEvents(final Context context) {
        NetworkStateChangeReceiver networkStateChangeReceiver = new NetworkStateChangeReceiver();
        context.registerReceiver(networkStateChangeReceiver, new IntentFilter(CONNECTIVITY_ACTION));
        context.registerReceiver(networkStateChangeReceiver, new IntentFilter(WIFI_STATE_CHANGE_ACTION));
    }
}
