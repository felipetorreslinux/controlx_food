package br.com.espe.controlxfood.API;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.view.Menu;
import android.view.MenuItem;

import br.com.espe.controlxfood.R;

public class API {

    Activity activity;
    SharedPreferences sharedPreferences;

    public API(Activity activity){
        this.activity = activity;
        this.sharedPreferences = activity.getSharedPreferences("API", Context.MODE_PRIVATE);
    }

    public String Server (){
        return sharedPreferences != null ? sharedPreferences.getString("maq_local", null) : null;
    }

    public void Wifi (Menu menu){
        MenuItem itemWifi = menu.findItem(R.id.wifi_login);
        ConnectivityManager conectivtyManager = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conectivtyManager.getActiveNetworkInfo() != null
                && conectivtyManager.getActiveNetworkInfo().isAvailable()
                && conectivtyManager.getActiveNetworkInfo().isConnected()) {
            itemWifi.setIcon(activity.getResources().getDrawable(R.drawable.ic_wifi_on_orange));
        } else {
            itemWifi.setIcon(activity.getResources().getDrawable(R.drawable.ic_wifi_off_orange));
        }
    }
}
