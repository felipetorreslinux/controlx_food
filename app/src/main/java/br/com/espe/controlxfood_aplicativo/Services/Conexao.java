package br.com.espe.controlxfood_aplicativo.Services;


import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.widget.ImageView;

import java.util.Timer;

import br.com.espe.controlxfood_aplicativo.R;


public class Conexao {

    Activity activity;
    Handler mHandler;
    ImageView imageView;

    public Conexao(Activity activity) {
        this.activity = activity;
        this.mHandler = new Handler();
        this.imageView = activity.findViewById(R.id.image_conexao);
        mHandler.post(UICONEXAO);
    }

    private final Runnable UICONEXAO = new Runnable() {
        public void run() {
            check ();
            mHandler.postDelayed(UICONEXAO, 1000);
        }
    };


    public void check (){
        ConnectivityManager connectivityManager = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        if(isConnected){
            imageView.setImageResource(R.drawable.ic_online);
        }else{
            imageView.setImageResource(R.drawable.ic_offline);
        }
    }

}
