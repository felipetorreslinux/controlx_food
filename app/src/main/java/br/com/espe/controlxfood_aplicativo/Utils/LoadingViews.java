package br.com.espe.controlxfood_aplicativo.Utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.renderscript.Type;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import br.com.espe.controlxfood_aplicativo.R;

public class LoadingViews {

    static AlertDialog.Builder builder;
    static AlertDialog alertDialog;

    public static void open(Activity activity, boolean cancelled){
        builder = new AlertDialog.Builder(activity, R.style.CustomDialog);
        View view = activity.getLayoutInflater().inflate(R.layout.view_loading, null);
        builder.setView(view);
        builder.setCancelable(cancelled);
        alertDialog = builder.create();
        alertDialog.show();
    }

    public static void close(){
        alertDialog.dismiss();
    }

}
