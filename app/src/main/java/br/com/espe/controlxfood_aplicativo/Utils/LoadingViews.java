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

    private RenderScript rs;
    private static final boolean IS_BLUR_SUPPORTED = Build.VERSION.SDK_INT >= 17;
    private static final int MAX_RADIUS = 25;
    static AlertDialog.Builder builder;
    static AlertDialog alertDialog;

    public static void open(Activity activity, String message, boolean cancelled){
        builder = new AlertDialog.Builder(activity, R.style.CustomDialog);
        View view = activity.getLayoutInflater().inflate(R.layout.view_loading, null);
        RelativeLayout view_loadind = view.findViewById(R.id.view_loadind);
        TextView text_loading = view.findViewById(R.id.text_loading);
        text_loading.setText(message);
        builder.setView(view);
        builder.setCancelable(cancelled);
        alertDialog = builder.create();
        alertDialog.show();
    }

    public static void close(){
        alertDialog.dismiss();
    }

    public static Bitmap getBitmapFromView(View view) {
        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bitmap);
        view.layout(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        view.draw(c);
        return bitmap;
    }

}
