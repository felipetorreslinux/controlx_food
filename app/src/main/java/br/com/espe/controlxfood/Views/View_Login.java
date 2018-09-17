package br.com.espe.controlxfood.Views;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import br.com.espe.controlxfood.R;

public class View_Login extends AppCompatActivity implements View.OnClickListener {
    
    Toolbar toolbar;
    Button button_login;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_login);
        createToolbar(toolbar);

        button_login = findViewById(R.id.button_login);
        button_login.setOnClickListener(this);
    }

    private void createToolbar(Toolbar toolbar) {
        toolbar = findViewById(R.id.toolbar_login);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.configuracoes_login:

                break;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_login:
                startActivity(new Intent(this, View_Venda.class));
                finish();
                break;
        }
    }
}
