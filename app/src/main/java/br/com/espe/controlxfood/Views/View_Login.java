package br.com.espe.controlxfood.Views;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import br.com.espe.controlxfood.API.API;
import br.com.espe.controlxfood.R;

public class View_Login extends AppCompatActivity implements View.OnClickListener {

    API api;
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_login);
        api = new API(this);
        createToolbar(toolbar);
    }

    private void createToolbar(Toolbar toolbar) {
        toolbar = (Toolbar) findViewById(R.id.actionbar_login);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_login, menu);
        api.Wifi(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.wifi_login:

                break;
        }
        return true;
    }

    @Override
    public void onClick(View v) {

    }
}
