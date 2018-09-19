package br.com.espe.controlxfood_aplicativo.Models;

public class Grupos {
    int id;
    String nome;
    String cor;

    public Grupos(int id, String nome, String cor) {
        this.id = id;
        this.nome = nome;
        this.cor = cor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
