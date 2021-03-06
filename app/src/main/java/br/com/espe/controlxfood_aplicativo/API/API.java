package br.com.espe.controlxfood_aplicativo.API;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.view.Menu;
import android.view.MenuItem;

import br.com.espe.controlxfood_aplicativo.R;
import br.com.espe.controlxfood_aplicativo.Utils.Alertas;

public class API {

    Activity activity;
    SharedPreferences sharedPreferences;

    public API(Activity activity){
        this.activity = activity;
        this.sharedPreferences = activity.getSharedPreferences("API", Context.MODE_PRIVATE);
    }

    public String URL = "http://192.168.15.220:200/v1";

    public String Server (){
        return sharedPreferences != null ? sharedPreferences.getString("maq_local", null) : null;
    }

    public boolean Wifi (){
        ConnectivityManager conectivtyManager = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conectivtyManager.getActiveNetworkInfo() != null
                && conectivtyManager.getActiveNetworkInfo().isAvailable()
                && conectivtyManager.getActiveNetworkInfo().isConnected()) {
            return true;
        } else {
            return false;
        }
    }

    public void ErrorServer(int code){
        switch (code){
            case 0:
                Alertas.openToast(activity, "Aparelho sem conexão com a internet", R.color.md_red);
                break;
        }
    }
}
