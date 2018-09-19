package br.com.espe.controlxfood_aplicativo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.androidnetworking.AndroidNetworking;

import java.util.concurrent.TimeUnit;

import br.com.espe.controlxfood_aplicativo.Models.Grupos;
import br.com.espe.controlxfood_aplicativo.Services.GruposService;
import br.com.espe.controlxfood_aplicativo.Services.ProdutosService;
import br.com.espe.controlxfood_aplicativo.Views.View_Login;
import okhttp3.OkHttpClient;

public class Splash extends AppCompatActivity {

    int count;
    ProgressBar progress;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_splash);
        sharedPreferences = getSharedPreferences("intro", MODE_PRIVATE);
        count = 0;
        progress = findViewById(R.id.progress);
        progress.getProgressDrawable().setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_IN);
        new CountDownTimer(5000, 25){
            @Override
            public void onTick(long millisUntilFinished) {
                count++;
                progress.setProgress(count);
            }
            @Override
            public void onFinish() {
                if(sharedPreferences != null){
                    if(sharedPreferences.getInt("view_intro", 0) == 0){
                        startActivity(new Intent(getApplicationContext(), Intro.class));
                        finish();
                    }else{
                        startActivity(new Intent(getApplicationContext(), View_Login.class));
                        finish();
                    }
                }

            }
        }.start();
    }

}
