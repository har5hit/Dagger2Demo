package com.justadeveloper96.gallery;

import android.app.Application;

import com.justadeveloper96.helpers.Module.AppModule;
import com.justadeveloper96.helpers.Module.RetrofitModule;

/**
 * Created by user on 2/23/2018.
 */

public class MyApplication extends Application {

    private AppComponent mHelperComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        /*mHelperComponent= DaggerHelperComponent.builder().appModule(new AppModule(this))
                .retrofitModule(new RetrofitModule("http://5953711dda900e00116e1716.mockapi.io/",null,null))
                .build();*/
        mHelperComponent= DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .retrofitModule(new RetrofitModule("http://5953711dda900e00116e1716.mockapi.io/",null,null))
                .build();
    }

    public AppComponent getmHelperComponent() {
        return mHelperComponent;
    }
}
