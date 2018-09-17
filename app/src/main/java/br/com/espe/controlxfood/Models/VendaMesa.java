package br.com.espe.controlxfood.Models;

public class VendaMesa {
    int id;
    int garcon;
    int mesa;
    int grupo;
    String nome_grupo;
    String cor_grupo;
    int produto;
    String nome_produto;
    double preco_produto;
    int qtd_produto;
    double valor_total;

    public VendaMesa(int id, int garcon, int mesa, int grupo, String nome_grupo, String cor_grupo, int produto, String nome_produto, double preco_produto, int qtd_produto, double valor_total) {
        this.id = id;
        this.garcon = garcon;
        this.mesa = mesa;
        this.grupo = grupo;
        this.nome_grupo = nome_grupo;
        this.cor_grupo = cor_grupo;
        this.produto = produto;
        this.nome_produto = nome_produto;
        this.preco_produto = preco_produto;
        this.qtd_produto = qtd_produto;
        this.valor_total = valor_total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGarcon() {
        return garcon;
    }

    public void setGarcon(int garcon) {
        this.garcon = garcon;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public String getNome_grupo() {
        return nome_grupo;
    }

    public void setNome_grupo(String nome_grupo) {
        this.nome_grupo = nome_grupo;
    }

    public String getCor_grupo() {
        return cor_grupo;
    }

    public void setCor_grupo(String cor_grupo) {
        this.cor_grupo = cor_grupo;
    }

    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
        this.produto = produto;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public double getPreco_produto() {
        return preco_produto;
    }

    public void setPreco_produto(double preco_produto) {
        this.preco_produto = preco_produto;
    }

    public int getQtd_produto() {
        return qtd_produto;
    }

    public void setQtd_produto(int qtd_produto) {
        this.qtd_produto = qtd_produto;
    }

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }
}
