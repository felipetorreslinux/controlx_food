package br.com.espe.controlxfood.Views;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import br.com.espe.controlxfood.R;

public class View_Login extends AppCompatActivity implements View.OnClickListener {
    
    Toolbar toolbar;

    TextInputLayout layout_login;
    TextInputLayout layout_password;

    EditText login;
    EditText password;

    Button button_login;
    BottomSheetDialog bottomSheetDialog;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_login);
        createToolbar(toolbar);

        layout_login = findViewById(R.id.layout_login);
        layout_password = findViewById(R.id.layout_password);

        login = findViewById(R.id.login);
        password = findViewById(R.id.password);

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

            case R.id.server_host:
                infoServer();
                break;

            case R.id.recovery_pass_login:
                startActivity(new Intent(this, View_RecoveryPass.class));
                break;

            case R.id.configuracoes_login:

                break;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.button_login:
                loginApp();
                break;
        }
    }

    private void loginApp() {
        String login_app = login.getText().toString().trim();
        String pass_app = password.getText().toString().trim();
        if(login_app.isEmpty()){
            layout_login.setErrorTextColor(ColorStateList.valueOf(getResources().getColor(R.color.md_red)));
            layout_login.setErrorEnabled(true);
            layout_login.setError("Informe seu login");
            layout_password.setErrorEnabled(false);
            login.requestFocus();
        }else if(pass_app.isEmpty()){
            layout_password.setErrorTextColor(ColorStateList.valueOf(getResources().getColor(R.color.md_red)));
            layout_password.setErrorEnabled(true);
            layout_password.setError("Informe sua senha");
            layout_login.setErrorEnabled(false);
            password.requestFocus();
        }else{
            layout_login.setErrorEnabled(false);
            layout_password.setErrorEnabled(false);
            startActivity(new Intent(this, View_Venda.class));
            finish();
        }
    }

    private void infoServer(){
        bottomSheetDialog = new BottomSheetDialog(this);
        View view = getLayoutInflater().inflate(R.layout.view_server_hosting, null);
        bottomSheetDialog.setContentView(view);
        bottomSheetDialog.show();

        final TextInputLayout textInputLayout = view.findViewById(R.id.layout_ip_server);
        final EditText editText = view.findViewById(R.id.ip_server);
        final Button button = view.findViewById(R.id.button_connect_server);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String server = editText.getText().toString().trim();
                if(server.isEmpty()){
                    textInputLayout.setErrorTextColor(ColorStateList.valueOf(getResources().getColor(R.color.md_red)));
                    textInputLayout.setErrorEnabled(true);
                    textInputLayout.setError(getString(R.string.info_error_label_server));
                    editText.requestFocus();
                    bottomSheetDialog.setCancelable(true);
                    editText.setFocusable(true);
                }else{
                    textInputLayout.setErrorEnabled(false);
                    textInputLayout.setError(null);
                    button.setText("Conectando servidor....");
                    bottomSheetDialog.setCancelable(false);
                    editText.setFocusable(false);
                }
            }
        });
    }
}
