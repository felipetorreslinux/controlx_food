package br.com.espe.controlxfood.BancoSQL;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BancoCore extends SQLiteOpenHelper {



    public BancoCore(Context context) {
        super(context, "controlxfood.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        TABLE_GARCON(database);
        TABLE_GRUPOS(database);
        TABLE_PRODUTOS(database);
        TABLE_COMANDA(database);
        TABLE_MESA(database);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL("DROP TABLE garcon");
        database.execSQL("DROP TABLE produtos");
        database.execSQL("DROP TABLE grupos");
        database.execSQL("DROP TABLE comanda");
        database.execSQL("DROP TABLE mesa");
        onCreate(database);
    }

    private void TABLE_GARCON (SQLiteDatabase database){
        database.execSQL("CREATE TABLE garcon (" +
                "_id PRIMARY KEY," +
                "id_garcon INTEGER," +
                "nome TEXT," +
                "telefone TEXT)");
    }

    private void TABLE_PRODUTOS (SQLiteDatabase database){
        database.execSQL("CREATE TABLE produtos (" +
                "_id INTEGER PRIMARY KEY," +
                "id_produto INTEGER," +
                "grupo INTEGER," +
                "nome TEXT," +
                "descricao TEXT," +
                "preco TEXT," +
                "imagem TEXT)");
    }

    private void TABLE_MESA (SQLiteDatabase database){
        database.execSQL("CREATE TABLE mesas (" +
                "_id INTEGER PRIMARY KEY," +
                "id_mesa INTEGER," +
                "mesa INTEGER," +
                "status INTEGER)");
    }

    private void TABLE_GRUPOS (SQLiteDatabase database){
        database.execSQL("CREATE TABLE grupos(" +
                "_id INTEGER PRIMARY KEY," +
                "nome TEXT," +
                "cor TEXT)");
    }

    private void TABLE_COMANDA (SQLiteDatabase database){
        database.execSQL("CREATE TABLE comanda(" +
                "_id INTEGER PRIMARY KEY," +
                "garcon INTEGER," +
                "mesa INTEGER," +
                "produto INTEGER," +
                "valor TEXT," +
                "qtd INTEGER," +
                "data TEXT," +
                "status TEXT)");
    }
}
