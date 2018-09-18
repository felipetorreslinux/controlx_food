package br.com.espe.controlxfood.Services;

import java.util.ArrayList;
import java.util.List;

import br.com.espe.controlxfood.Models.Produtos;

public class ProdutosService {

    public void adicionaProdutos (List<Produtos> produtos){
        produtos.clear();
        Produtos carne_de_sol = new Produtos(1, 3, "Carne de Sol", "", 59.9, "");
        Produtos picanha = new Produtos(2, 3, "Picanha Argentina", "", 89.9, "");
        Produtos maminha = new Produtos(3, 3, "Maminha Completa", "",  79.9, "");
        Produtos coca_cola = new Produtos(4, 1, "Coca Cola Lata", "", 9.9, "");
        Produtos calabresa = new Produtos(5, 2, "Calabresa com Fritas", "", 29.9, "");
        Produtos codorna = new Produtos(6, 2, "Codorna Frita", "", 19.9, "");
        produtos.add(carne_de_sol);
        produtos.add(picanha);
        produtos.add(maminha);
        produtos.add(coca_cola);
        produtos.add(calabresa);
        produtos.add(codorna);
    }


    public void consulta(List<Produtos> produtos, int code){
        List<String> venda = new ArrayList<>();
        for(int i = 0; i < produtos.size(); i++){
            Produtos prod = produtos.get(i);
            if(prod.getId() == code){
                venda.add(prod.getNome());
                return;
            }
        }
    }
}
