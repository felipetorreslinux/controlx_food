package br.com.espe.controlxfood.Views;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.espe.controlxfood.Models.Grupos;
import br.com.espe.controlxfood.Models.Produtos;
import br.com.espe.controlxfood.Models.VendaMesa;
import br.com.espe.controlxfood.R;
import br.com.espe.controlxfood.Services.GruposService;
import br.com.espe.controlxfood.Services.ProdutosService;

public class View_Venda extends AppCompatActivity implements View.OnClickListener {

    TextView item_garcon;
    TextView item_mesa;

    TextView letreiro_info;
    EditText venda_register;

    List<Grupos> grupos = new ArrayList<Grupos>();
    List<Produtos> produtos = new ArrayList<Produtos>();
    List<String> lista_venda_register = new ArrayList<>();

    List<VendaMesa> vendas = new ArrayList<VendaMesa>();

    ImageView number00;
    ImageView number01;
    ImageView number02;
    ImageView number03;
    ImageView number04;
    ImageView number05;
    ImageView number06;
    ImageView number07;
    ImageView number08;
    ImageView number09;

    ImageView image_remove;
    ImageView image_igual;

    Vibrator vibrator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_venda);
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        new GruposService().adicionaGrupos(grupos);
        new ProdutosService().adicionaProdutos(produtos);


        item_garcon = findViewById(R.id.item_garcon);
        item_mesa = findViewById(R.id.item_mesa);

        letreiro_info = findViewById(R.id.letreiro_info);
        venda_register = findViewById(R.id.venda_register);

        number00 = findViewById(R.id.number_0);
        number00.setOnClickListener(this);
        number01 = findViewById(R.id.number_1);
        number01.setOnClickListener(this);
        number02 = findViewById(R.id.number_2);
        number02.setOnClickListener(this);
        number03 = findViewById(R.id.number_3);
        number03.setOnClickListener(this);
        number04 = findViewById(R.id.number_4);
        number04.setOnClickListener(this);
        number05 = findViewById(R.id.number_5);
        number05.setOnClickListener(this);
        number06 = findViewById(R.id.number_6);
        number06.setOnClickListener(this);
        number07 = findViewById(R.id.number_7);
        number07.setOnClickListener(this);
        number08 = findViewById(R.id.number_8);
        number08.setOnClickListener(this);
        number09 = findViewById(R.id.number_9);
        number09.setOnClickListener(this);

        image_remove = findViewById(R.id.image_remove);
        image_remove.setOnClickListener(this);

        image_igual = findViewById(R.id.image_igual);
        image_igual.setOnClickListener(this);

        validGarconMesa();

        new ProdutosService().consulta(produtos, 5);

    }

    private void validGarconMesa(){
        String garcon = item_garcon.getText().toString().trim();
        String mesa = item_mesa.getText().toString().trim();
        if(garcon.isEmpty()){
            letreiro_info.setText(R.string.info_labal_garcon);
        }else if(mesa.isEmpty()){
            letreiro_info.setText(R.string.info_labal_mesa);
        }else{
            letreiro_info.setText(R.string.info_labal_produto);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.number_0:
                lista_venda_register.add("0");
                updateList();
                break;
            case R.id.number_1:
                lista_venda_register.add("1");
                updateList();
                break;

            case R.id.number_2:
                lista_venda_register.add("2");
                updateList();
                break;

            case R.id.number_3:
                lista_venda_register.add("3");
                updateList();
                break;

            case R.id.number_4:
                lista_venda_register.add("4");
                updateList();
                break;

            case R.id.number_5:
                lista_venda_register.add("5");
                updateList();
                break;

            case R.id.number_6:
                lista_venda_register.add("6");
                updateList();
                break;

            case R.id.number_7:
                lista_venda_register.add("7");
                updateList();
                break;

            case R.id.number_8:
                lista_venda_register.add("8");
                updateList();
                break;

            case R.id.number_9:
                lista_venda_register.add("9");
                updateList();
                break;

            case R.id.image_remove:
                removeItem();
                break;

            case R.id.image_igual:
                igualFunc();
                break;
        }
    }

    private void updateList(){
        String valor = lista_venda_register.toString().replace("[", "").replace("]", "").replace(",", "");
        venda_register.setText(valor);
    }

    private void removeItem(){
        if (lista_venda_register.size() > 0){
            lista_venda_register.remove(lista_venda_register.size() -1);
            updateList();
        }
    }

    private void igualFunc(){
        final String register = venda_register.getText().toString().trim();
        String garcon = item_garcon.getText().toString().trim();
        String mesa = item_mesa.getText().toString().trim();

        if(garcon.isEmpty()){
            if(register.isEmpty()){
                letreiro_info.setText(R.string.info_not_labal_garcon);
                vibrator.vibrate(500);
            }else{
                item_garcon.setText("G - " + register);
                letreiro_info.setText(R.string.info_labal_mesa);
                venda_register.setText(null);
                lista_venda_register.clear();
            }
        }else if(mesa.isEmpty()){
            if(register.isEmpty()){
                letreiro_info.setText(R.string.info_not_labal_mesa);
                vibrator.vibrate(500);
            }else {
                item_mesa.setText("M - " + register);
                letreiro_info.setText(R.string.info_labal_produto);
                venda_register.setText(null);
                lista_venda_register.clear();
            }
        }else{
            int code = Integer.parseInt(venda_register.getText().toString().trim().replace(" ", ""));
            boolean sim = produtos.contains(code);
        }
    }


}
