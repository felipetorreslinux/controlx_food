package br.com.espe.controlxfood_aplicativo.Services;

import android.app.Activity;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.espe.controlxfood_aplicativo.API.API;
import br.com.espe.controlxfood_aplicativo.Utils.LoadingViews;

public class Service_Login {

    Activity activity;

    public Service_Login(Activity activity){
        this.activity = activity;
    }

    public void get (String login, String password){
        LoadingViews.open(activity, "Autorizando", false);
        AndroidNetworking.post(new API(activity).URL)
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
                            return;
                        default:
                            LoadingViews.close();
                            return;

                    }
                }catch (JSONException e){}
            }
            @Override
            public void onError(ANError anError) {
                new API(activity).ErrorServer(anError.getErrorCode());
            }
        });
    }
}
