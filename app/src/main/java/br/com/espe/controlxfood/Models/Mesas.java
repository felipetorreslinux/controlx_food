package br.com.espe.controlxfood.Models;

public class Mesas {

    int id;
    int mesa;
    int status;

    public Mesas(int id, int mesa, int status) {
        this.id = id;
        this.mesa = mesa;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
