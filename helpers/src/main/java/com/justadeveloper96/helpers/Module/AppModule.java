package com.justadeveloper96.helpers.Module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sankalp on 21/2/17.
 */
@Module
public class AppModule {
    Application mApp;

    public AppModule(Application application)
    {
        this.mApp=application;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return mApp.getApplicationContext();
    }

    @Provides
    @Singleton
    public Application provideAppInstance() {
        return mApp;
    }


    @Provides
    @Singleton
    SharedPrefs provideSharedPrefs() {
        return new SharedPrefs(mApp);
    }
}
