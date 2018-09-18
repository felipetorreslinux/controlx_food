package br.com.espe.controlxfood;

import android.content.Intent;
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

import br.com.espe.controlxfood.Models.Grupos;
import br.com.espe.controlxfood.Services.GruposService;
import br.com.espe.controlxfood.Services.ProdutosService;
import br.com.espe.controlxfood.Views.View_Login;

public class Splash extends AppCompatActivity {

    int count;
    ImageView imagelogo;
    ProgressBar progress;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_splash);
        count = 0;
        imagelogo = findViewById(R.id.imagelogo);
        progress = findViewById(R.id.progress);
        progress.getProgressDrawable().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_rotate);
        imagelogo.startAnimation(animation);
        new CountDownTimer(5000, 25){
            @Override
            public void onTick(long millisUntilFinished) {
                count++;
                progress.setProgress(count);
            }

            @Override
            public void onFinish() {
                imagelogo.clearAnimation();
                startActivity(new Intent(getApplicationContext(), Intro.class));
                finish();
            }
        }.start();


//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                startActivity(new Intent(Splash.this, View_Login.class));
//                finish();
//            }
//        }, 5000);

    }
}
