package com.justadeveloper96.helpers;

import android.support.v7.app.AppCompatActivity;

import com.justadeveloper96.helpers.helpers.AppModule;
import com.justadeveloper96.helpers.helpers.RetrofitModule;
import com.justadeveloper96.helpers.helpers.SharedPrefs;
import com.readystatesoftware.chuck.internal.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by harshith on 2/23/2018.
 */

@Singleton
@Component(modules = {AppModule.class, RetrofitModule.class})
public interface HelperComponent {
    Retrofit getRetrofit();
    SharedPrefs getPrefs();
}
