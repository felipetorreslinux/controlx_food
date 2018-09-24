package br.com.espe.controlxfood_aplicativo.Views;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.com.espe.controlxfood_aplicativo.R;
import br.com.espe.controlxfood_aplicativo.Services.Service_Profile;
import br.com.espe.controlxfood_aplicativo.Utils.Keyboard;
import br.com.espe.controlxfood_aplicativo.Utils.LoadingViews;

public class View_Login extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;

    TextInputLayout layout_login;
    TextInputLayout layout_senha;

    EditText edit_text_login;
    EditText edit_text_senha;

    Button button_login;
    TextView button_recovery_pass_login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_login);
        createToolbar(toolbar);

        layout_login = findViewById(R.id.layout_login);
        layout_senha = findViewById(R.id.layout_senha);

        edit_text_login = findViewById(R.id.edit_text_login);
        edit_text_senha = findViewById(R.id.edit_text_senha);

        button_login = findViewById(R.id.button_login);
        button_login.setOnClickListener(this);
        button_recovery_pass_login = findViewById(R.id.button_recovery_pass_login);
        button_recovery_pass_login.setOnClickListener(this);

    }

    private void createToolbar(Toolbar toolbar) {
        Drawable backIconActionBar = getResources().getDrawable(R.drawable.ic_back_white);
        toolbar = findViewById(R.id.toolbar_login);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.title_login);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(backIconActionBar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        for(int i = 0; i < menu.size(); i++){
            Drawable drawable = menu.getItem(i).getIcon();
            if(drawable != null) {
                drawable.mutate();
                drawable.setColorFilter(getResources().getColor(R.color.colorWhite), PorterDuff.Mode.SRC_ATOP);
            }
        }
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_login:
                validaLogin();
                break;

            case R.id.button_recovery_pass_login:
                startActivity(new Intent(this, View_Recuperar_Senha.class));
                finish();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    private void validaLogin(){
        String login = edit_text_login.getText().toString().trim();
        String senha = edit_text_senha.getText().toString().trim();

        if(login.isEmpty()){
            layout_login.setErrorEnabled(true);
            layout_senha.setErrorEnabled(false);
            layout_login.setError("Informe seu login");
            edit_text_login.requestFocus();
        }else if(senha.isEmpty()){
            layout_login.setErrorEnabled(false);
            layout_senha.setErrorEnabled(true);
            layout_senha.setError("Informe sua senha");
            edit_text_senha.requestFocus();
        }else{
            layout_login.setErrorEnabled(false);
            layout_senha.setErrorEnabled(false);
            LoadingViews.open(this, false);
            new Service_Profile(this).GetLogin(login, senha);
            Keyboard.close(this, getWindow().getDecorView());
        }

    }
}
