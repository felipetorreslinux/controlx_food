package br.com.espe.controlxfood_aplicativo.BancoSQL;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import br.com.espe.controlxfood_aplicativo.Models.Garcon;
import br.com.espe.controlxfood_aplicativo.Models.Grupos;
import br.com.espe.controlxfood_aplicativo.Models.Mesas;
import br.com.espe.controlxfood_aplicativo.Models.Produtos;

public class BancoServices {

    Activity activity;
    SQLiteDatabase database;
    BancoCore bancoCore;

    public BancoServices(Activity activity){
        this.activity = activity;
        bancoCore = new BancoCore(activity);
        database = bancoCore.getWritableDatabase();
    }

    public void adicionarGarcon (Garcon garcon){
        ContentValues contentValues = new ContentValues();
        contentValues.put("id_garcon", garcon.getId());
        contentValues.put("nome", garcon.getNome());
        contentValues.put("telefone", garcon.getTelefone());

        Cursor cursor = database.rawQuery("SELECT * FROM garcon WHERE id_garcon = ?", new String[]{String.valueOf(garcon.getId())});
        if(cursor != null){
            if(cursor.getCount() > 0){
                database.update("garcon", contentValues, "id_garcon = ?", new String[]{String.valueOf(garcon.getId())});
            }else{
                database.insert("garcon", null, contentValues);
            }
        }

    }

    public void adicionarMesa(Mesas mesas){
        ContentValues contentValues = new ContentValues();
        contentValues.put("id_mesa", mesas.getId());
        contentValues.put("mesa", mesas.getMesa());
        contentValues.put("status", mesas.getStatus());

        Cursor cursor = database.rawQuery("SELECT * FROM mesas WHERE id_mesa = ?", new String[]{String.valueOf(mesas.getId())});
        if(cursor != null){
            if(cursor.getCount() > 0){
                database.update("mesas", contentValues, "id_mesa = ?", new String[]{String.valueOf(mesas.getId())});
            }else{
                database.insert("mesas", null, contentValues);
            }
        }
    }

    public void adicionarGrupos(Grupos grupos){
        ContentValues contentValues = new ContentValues();
        contentValues.put("nome", grupos.getNome());
        contentValues.put("cor", grupos.getCor());
        Cursor cursor = database.rawQuery("SELECT * FROM grupos WHERE nome = ?", new String[]{grupos.getNome()});
        if(cursor != null){
            if(cursor.getCount() > 0){
                database.update("grupos", contentValues, "nome = ?", new String[]{grupos.getNome()});
            }else{
                database.insert("grupos", null, contentValues);
            }
        }
    }

    public void adicionaProdutos(Produtos produtos){
        ContentValues contentValues = new ContentValues();
        contentValues.put("id_produto", produtos.getId());
        contentValues.put("grupo", produtos.getGrupo());
        contentValues.put("nome", produtos.getNome());
        contentValues.put("descricao", produtos.getDescricao());
        contentValues.put("preco", produtos.getPreco());
        contentValues.put("imagem", produtos.getImagem());

        Cursor cursor = database.rawQuery("SELECT * FROM produtos WHERE id_produto = ?", new String[]{String.valueOf(produtos.getId())});
        if(cursor != null){
            if(cursor.getCount() > 0){
                database.update("produtos", contentValues, "id_produto = ?", new String[]{String.valueOf(produtos.getId())});
            }else{
                database.insert("produtos", null, contentValues);
            }
        }
    }

}
