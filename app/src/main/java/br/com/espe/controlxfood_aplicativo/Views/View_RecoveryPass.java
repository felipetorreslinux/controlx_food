package br.com.espe.controlxfood_aplicativo.Views;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import br.com.espe.controlxfood_aplicativo.R;
import br.com.espe.controlxfood_aplicativo.Utils.Alertas;

public class View_RecoveryPass extends AppCompatActivity implements View.OnClickListener{

    Toolbar toolbar;

    EditText text_recovery;
    FloatingActionButton button_send_recovery;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_recuperar_senha);
        
        createToolbar(toolbar);

        text_recovery = findViewById(R.id.text_recovery);

        button_send_recovery = findViewById(R.id.button_send_recovery);
        button_send_recovery.setOnClickListener(this);
        
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
            case R.id.button_send_recovery:
                sendRecovery();
                break;
        }
    }

    private void sendRecovery() {
        String text = text_recovery.getText().toString().trim();
        if(text.isEmpty()){
            Alertas.openToast(this, getString(R.string.info_not_text_recovery_pass), R.color.md_red);
        }else{

        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
