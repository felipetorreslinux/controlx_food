package br.com.espe.controlxfood_aplicativo.FireBase;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;
import com.google.firebase.FirebaseApp;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class FireApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(120,TimeUnit.SECONDS)
                .writeTimeout(120, TimeUnit.SECONDS)
                .build();
        AndroidNetworking.initialize(getApplicationContext(), okHttpClient);
        FirebaseApp.initializeApp(this);
    }
}
