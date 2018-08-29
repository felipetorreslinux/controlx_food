package br.com.espe.controlxfood.Views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import br.com.espe.controlxfood.R;

public class View_Login extends AppCompatActivity implements View.OnClickListener {

    ImageView imagem_configuracoes;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_login);

        imagem_configuracoes = findViewById(R.id.imagem_configuracoes);
        imagem_configuracoes.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imagem_configuracoes:
                break;
        }
    }
}
