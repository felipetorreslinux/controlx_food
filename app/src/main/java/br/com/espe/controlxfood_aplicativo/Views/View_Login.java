package br.com.espe.controlxfood_aplicativo.Views;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import br.com.espe.controlxfood_aplicativo.R;

public class View_Login extends AppCompatActivity implements View.OnClickListener {

    Animation animation;
    CardView card_login;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_login);

        animation = new TranslateAnimation(0,0,2000,0);
        animation.setDuration(1000);
        animation.setFillEnabled(true);
        card_login = findViewById(R.id.card_login);
        card_login.startAnimation(animation);

    }

    @Override
    public void onClick(View v) {

    }
}
