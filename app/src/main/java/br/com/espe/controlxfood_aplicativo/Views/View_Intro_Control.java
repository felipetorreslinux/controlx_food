package br.com.espe.controlxfood_aplicativo.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import br.com.espe.controlxfood_aplicativo.R;

public class View_Intro_Control extends AppCompatActivity implements View.OnClickListener {

    Animation animation_logo;
    Animation animation_buttons;
    ImageView imagem_logo;
    LinearLayout box_buttons;

    TextView button_abre_login;
    TextView button_abre_cadastro;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_login_control);

        button_abre_login = findViewById(R.id.button_abre_login);
        button_abre_login.setOnClickListener(this);
        button_abre_cadastro = findViewById(R.id.button_abre_cadastro);
        button_abre_cadastro.setOnClickListener(this);

    }

    @Override
    protected void onResume(){
        AnimationImageLogo();
        AnimationButtons();
        super.onResume();
    }

    private void AnimationImageLogo(){
        imagem_logo = findViewById(R.id.imagem_logo);
        animation_logo = new TranslateAnimation(0,0,-3000,0);
        animation_logo.setDuration(500);
        animation_logo.setFillEnabled(true);
        imagem_logo.startAnimation(animation_logo);
    }

    private void AnimationButtons(){
        box_buttons = findViewById(R.id.box_buttons);
        animation_buttons = new TranslateAnimation(0,0,3000,0);
        animation_buttons.setDuration(750);
        animation_buttons.setFillEnabled(true);
        box_buttons.startAnimation(animation_buttons);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_abre_login:
                Intent login = new Intent(this, View_Login.class);
                startActivity(login);
                break;

            case R.id.button_abre_cadastro:
                Intent cadastro = new Intent(this, View_NovoUsuario.class);
                startActivity(cadastro);
                break;
        }
    }


}
