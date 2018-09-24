package br.com.espe.controlxfood_aplicativo.Views;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.espe.controlxfood_aplicativo.R;
import br.com.espe.controlxfood_aplicativo.Services.Service_Profile;
import br.com.espe.controlxfood_aplicativo.Utils.Alertas;
import br.com.espe.controlxfood_aplicativo.Utils.Keyboard;
import br.com.espe.controlxfood_aplicativo.Utils.LoadingViews;

public class View_Recuperar_Senha extends AppCompatActivity implements View.OnClickListener{

    Activity activity;
    Toolbar toolbar;

    TextInputLayout layout_email_recupera_senha;
    EditText edit_text_email_recupera_senha;
    Button button_recupera_senha;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_recuperar_senha);
        activity = this;
        createToolbar(toolbar);

        layout_email_recupera_senha = findViewById(R.id.layout_email_recupera_senha);
        edit_text_email_recupera_senha = findViewById(R.id.edit_text_email_recupera_senha);
        button_recupera_senha = findViewById(R.id.button_recupera_senha);
        button_recupera_senha.setOnClickListener(this);

    }

    private void createToolbar(Toolbar toolbar) {
        Drawable backIconActionBar = getResources().getDrawable(R.drawable.ic_back_white);
        toolbar = (Toolbar) findViewById(R.id.toolbar_recovery_pass);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.title_recovery_pass);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(backIconActionBar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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
            case R.id.button_recupera_senha:
                SolicitaRecuperaSenha();
                break;
        }
    }

    private void SolicitaRecuperaSenha() {
        String email = edit_text_email_recupera_senha.getText().toString().trim();
        if(email.isEmpty()){
            layout_email_recupera_senha.setErrorEnabled(true);
            layout_email_recupera_senha.setError("Informe seu email");
            edit_text_email_recupera_senha.requestFocus();
        }else{
            layout_email_recupera_senha.setErrorEnabled(false);
            LoadingViews.open(activity, false);
            new Service_Profile(activity).GetPassword(email);
            edit_text_email_recupera_senha.setText(null);
            Keyboard.close(activity, getWindow().getDecorView());
        }
    }


    @Override
    public void onBackPressed() {
        finish();
    }
}
