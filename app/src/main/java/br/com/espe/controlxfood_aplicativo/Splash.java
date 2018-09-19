package br.com.espe.controlxfood_aplicativo;

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

import br.com.espe.controlxfood_aplicativo.Models.Grupos;
import br.com.espe.controlxfood_aplicativo.Services.GruposService;
import br.com.espe.controlxfood_aplicativo.Services.ProdutosService;
import br.com.espe.controlxfood_aplicativo.Views.View_Login;

public class Splash extends AppCompatActivity {

    int count;
    ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_splash);
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
                startActivity(new Intent(getApplicationContext(), Intro.class));
                finish();
            }
        }.start();
    }

}
