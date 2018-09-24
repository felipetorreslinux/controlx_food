package br.com.espe.controlxfood_aplicativo.Services;

import android.app.Activity;
import android.content.Intent;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.espe.controlxfood_aplicativo.API.API;
import br.com.espe.controlxfood_aplicativo.R;
import br.com.espe.controlxfood_aplicativo.Utils.Alertas;
import br.com.espe.controlxfood_aplicativo.Utils.LoadingViews;
import br.com.espe.controlxfood_aplicativo.Views.View_Venda;

public class Service_Profile {

    Activity activity;

    public Service_Profile(Activity activity){
        this.activity = activity;
    }

    public void GetLogin (String login, String password){
        AndroidNetworking.post(new API(activity).URL+"/cliente/login")
        .addBodyParameter("login", login)
        .addBodyParameter("password", password)
        .setPriority(Priority.HIGH)
        .build()
        .getAsJSONObject(new JSONObjectRequestListener() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    String status = response.getString("status");
                    switch (status){
                        case "success":
                            LoadingViews.close();
                            activity.startActivity(new Intent(activity, View_Venda.class));
                            activity.finishAffinity();
                            return;
                        default:
                            LoadingViews.close();
                            Alertas.openToast(activity, activity.getString(R.string.info_login_invalido), R.color.md_red);
                            return;

                    }
                }catch (JSONException e){}
            }
            @Override
            public void onError(ANError anError) {
                LoadingViews.close();
                new API(activity).ErrorServer(anError.getErrorCode());
            }
        });
    }

    public void GetPassword (String email){
        AndroidNetworking.post(new API(activity).URL+"")
                .addBodyParameter("email", email)
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String status = response.getString("status");
                            switch (status){
                                case "success":
                                    LoadingViews.close();
                                    return;
                                default:
                                    LoadingViews.close();
                                    Alertas.openToast(activity, response.getString("message"), R.color.md_red);
                                    return;

                            }
                        }catch (JSONException e){}
                    }
                    @Override
                    public void onError(ANError anError) {
                        LoadingViews.close();
                        new API(activity).ErrorServer(anError.getErrorCode());
                    }
                });
    }
}
