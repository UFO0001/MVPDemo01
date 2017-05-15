package com.demo.mvpdemo01.Application;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.demo.mvpdemo01.Utils.AllToast;

/**
 * Created by UFO on 17/5/11.
 */

public class MyApplication extends Application{

    private static Context context;

    private final Handler myHandler = new Handler();
    private AllToast allToast;
    private static MyApplication myInstance;

    public static void setMyInstance(MyApplication myInstance) {
        MyApplication.myInstance = myInstance;
    }

    public static MyApplication getMyInstance() {
        return myInstance;
    }

    @Override
    public void onCreate() {
        context = getApplicationContext();

        setMyInstance(this);
        allToast = new AllToast(this);
        Log.i("TAG","主线程"+Thread.currentThread().getId());
    }
    public Handler getMyHandler(){
        return myHandler;
    }
    public void toastShowByBuilder(final AllToast.Builder builder){
        if(Looper.myLooper()!=Looper.getMainLooper()){
            getMyHandler().post(new Runnable() {
                @Override
                public void run() {
                    allToast.toastShow(builder);
                }
            });
        }else{
            allToast.toastShow(builder);
        }
    }
    public static Context getContext(){
        return context;
    }
}










