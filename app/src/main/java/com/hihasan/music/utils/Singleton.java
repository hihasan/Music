package com.hihasan.music.utils;

import android.content.Context;

import androidx.fragment.app.Fragment;

public class Singleton {

    private Context context;
    private Fragment whichFragmentItIs;
    private static Singleton ourInstance = new Singleton();

    private String phoneNumber;


    private Singleton() {
    }

    public static Singleton getInstance() {
        return ourInstance;
    }


    public Context getContext() {
        if (context == null) {
            throw new RuntimeException("Context is null in Singleton singleton. Check if setContext() is called properly.");
        }
        return context;
    }

    public void setContext(Context context) {
        this.context = context.getApplicationContext();
    }

    public Fragment getWhichFragmentItIs() {
        return whichFragmentItIs;
    }

    public void setWhichFragmentItIs(Fragment whichFragmentItIs) {
        this.whichFragmentItIs = whichFragmentItIs;
    }

    public static Singleton getOurInstance() {
        return ourInstance;
    }

    public static void setOurInstance(Singleton ourInstance) {
        Singleton.ourInstance = ourInstance;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
