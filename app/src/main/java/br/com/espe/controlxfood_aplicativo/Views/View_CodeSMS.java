package br.com.espe.controlxfood_aplicativo.Views;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import br.com.espe.controlxfood_aplicativo.R;

public class View_CodeSMS extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    String cellphone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_code_sms);
        createActionBar(toolbar);

        cellphone = getIntent().getExtras().getString("cellphone") != null ? getIntent().getExtras().getString("cellphone") : "";

    }

    private void createActionBar(Toolbar toolbar){
        Drawable backIconActionBar = getResources().getDrawable(R.drawable.ic_back_white);
        toolbar = findViewById(R.id.toolbar_code_sms);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(cellphone);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(backIconActionBar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));

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

    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
