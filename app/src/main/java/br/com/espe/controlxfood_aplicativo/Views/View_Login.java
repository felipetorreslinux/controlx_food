package br.com.espe.controlxfood_aplicativo.Views;

import android.Manifest;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

import br.com.espe.controlxfood_aplicativo.R;
import br.com.espe.controlxfood_aplicativo.Services.Service_Login;
import br.com.espe.controlxfood_aplicativo.Utils.MaskCellPhone;

public class View_Login extends AppCompatActivity implements View.OnClickListener {

    static final int REQUEST_NOVO_USUARIO = 10;
    static final int REQUEST_RECOVERY_PASS = 20;

    AlertDialog alertDialog;
    Animation animation;
    CardView card_login;
    EditText login;
    EditText password;
    Button button_login;
    Button button_novo_usuario;
    TextView button_recovery_pass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_login);

        animation = new TranslateAnimation(0, 0, 2000, 0);
        animation.setDuration(1000);
        animation.setFillEnabled(true);
        card_login = findViewById(R.id.card_login);
        card_login.startAnimation(animation);

        login = findViewById(R.id.login);
        password = findViewById(R.id.password);

        button_recovery_pass = findViewById(R.id.button_recovery_pass);
        button_recovery_pass.setOnClickListener(this);

        button_login = findViewById(R.id.button_login);
        button_login.setOnClickListener(this);

        button_novo_usuario = findViewById(R.id.button_novo_usuario);
        button_novo_usuario.setOnClickListener(this);

        String email = login.getText().toString().trim();
        if(email.isEmpty()){
            getEmail();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.button_login:
                AuthLogin();
                break;

            case R.id.button_recovery_pass:
                startActivityForResult(new Intent(this, View_RecoveryPass.class), REQUEST_RECOVERY_PASS);
                break;

            case R.id.button_novo_usuario:
                startActivityForResult(new Intent(this, View_NovoUsuario.class), REQUEST_NOVO_USUARIO);
                break;
        }
    }

    private void AuthLogin() {
        String email = login.getText().toString().trim();
        String pass = password.getText().toString().trim();
        if(email.isEmpty()){

        }else if(pass.isEmpty()){

        }else {
            new Service_Login(this).get(email, pass);
        }
    }

    private void getEmail() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.GET_ACCOUNTS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.GET_ACCOUNTS}, 2);
            return;
        }

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Entrar com");
        List<String> emails = new ArrayList<>();
        emails.clear();
        ListView listView = new ListView(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(10, 10, 10, 10);
        listView.setLayoutParams(layoutParams);
        try {
            AccountManager accountManager = (AccountManager) getSystemService(ACCOUNT_SERVICE);
            Account[] itens = accountManager.getAccounts();
            if (itens.length > 0) {
                for (Account account : itens) {
                    if (account.type.equals("com.google")) {
                        emails.add(account.name);
                    }
                }
            } else {
                alertDialog.dismiss();
            }
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, emails);
            listView.setAdapter(arrayAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    alertDialog.dismiss();
                    String email = parent.getItemAtPosition(position).toString();
                    login.setText(email);
                    password.requestFocus(1);
                }
            });

            builder.setView(listView);
            builder.setPositiveButton("telefone", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    alertDialog.dismiss();
                    getPhone();
                }
            });
            builder.setNegativeButton("Voltar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    alertDialog.dismiss();
                    login.setText(null);
                }
            });
            alertDialog = builder.create();
            alertDialog.show();
        } catch (Exception e) {
        }
    }

    @SuppressLint("RestrictedApi")
    private void getPhone() {

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Entrar com");

        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_NUMBERS) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{
                    Manifest.permission.READ_SMS,
                    Manifest.permission.READ_PHONE_STATE
                    }, 1);
            return;
        }

        if(!telephonyManager.getLine1Number().isEmpty()){
            String number = telephonyManager.getLine1Number().substring(3);
            List<String> phone = new ArrayList<>();
            ListView listView = new ListView(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(10, 10, 10, 10);
            listView.setLayoutParams(layoutParams);
            phone.clear();
            phone.add(number);
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, phone);
            listView.setAdapter(arrayAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    alertDialog.dismiss();
                    String phone = parent.getItemAtPosition(position).toString();
                }
            });

            builder.setView(listView);
            builder.setPositiveButton("Email", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    alertDialog.dismiss();
                    getEmail();
                }
            });
            builder.setNegativeButton("Voltar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    alertDialog.dismiss();
                }
            });
            alertDialog = builder.create();
            alertDialog.show();
        }else{
            builder.setMessage("Informe seu telefone");
            final EditText editText = new EditText(this);
            editText.setHint("(11)12345-1231");
            editText.addTextChangedListener(MaskCellPhone.insert(editText));
            editText.setSingleLine();
            editText.setInputType(InputType.TYPE_CLASS_NUMBER);
            FrameLayout container = new FrameLayout(this);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            container.setLayoutParams(layoutParams);
            container.addView(editText);
            builder.setView(container, 26, 0, 26, 0);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    alertDialog.dismiss();
                    String phone = editText.getText().toString().trim();
                }
            });
            alertDialog = builder.create();
            alertDialog.show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode){
            case REQUEST_NOVO_USUARIO:
                getEmail();
                break;
            case REQUEST_RECOVERY_PASS:
                getEmail();
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_NUMBERS) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this,
                            new String[]{
                                    Manifest.permission.READ_SMS,
                                    Manifest.permission.READ_PHONE_STATE
                            }, 1);
                    return;
                }
                return;
            case 2:
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.GET_ACCOUNTS) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.GET_ACCOUNTS}, 2);
                    return;
                }
                return;
        }
    }
}
