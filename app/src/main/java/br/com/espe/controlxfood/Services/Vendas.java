package br.com.espe.controlxfood.Services;

import android.app.Activity;
import android.support.design.widget.Snackbar;
import android.widget.TextView;

import br.com.espe.controlxfood.BancoSQL.BancoServices;
import br.com.espe.controlxfood.R;

public class Vendas {

    Activity activity;
    TextView letreiro_info;

    public Vendas(Activity activity){
        this.activity = activity;
        this.letreiro_info = activity.findViewById(R.id.letreiro_info);
    }

    public void lancaProdutoMesa(String register, String[] garcon, String[] mesa){
        if(!register.contains("x")){
            letreiro_info.setText(R.string.error_code_venda);
        }else{
            letreiro_info.setText(null);
            String[] itens = register.split("x");
            String produto = itens[0].replaceAll(" ","");
            String qtd = itens[1].replaceAll(" ","");
            if(produto.isEmpty()){
                letreiro_info.setText(R.string.info__not_labal_produto);
            }else if(qtd.isEmpty()){
                letreiro_info.setText(R.string.info_not_qtd_produto);
            }else{

            }
        }


    }

}
