package br.com.espe.controlxfood.Services;

import java.util.ArrayList;
import java.util.List;

import br.com.espe.controlxfood.Models.Grupos;

public class GruposService {

    public void adicionaGrupos(List<Grupos> grupos){
        grupos.clear();
        Grupos bebidas = new Grupos(1, "Bebidas", "#D50000");
        Grupos petiscos = new Grupos(2, "Petiscos", "#FFD600");
        Grupos comidas = new Grupos(3, "Comidas", "#76FF03");
        grupos.add(bebidas);
        grupos.add(petiscos);
        grupos.add(comidas);
    }

}
