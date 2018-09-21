package br.com.espe.controlxfood_aplicativo.Utils;

import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import br.com.espe.controlxfood_aplicativo.R;

public class Alertas {

    public static void openToast(Activity activity, String message, int color){
        View view = activity.getLayoutInflater().inflate(R.layout.toast_orange, null);
        LinearLayout box_toast = view.findViewById(R.id.box_toast);
        box_toast.setBackgroundColor(activity.getResources().getColor(color));
        TextView textView = view.findViewById(R.id.text_toast);
        textView.setText(message);
        Toast toast = new Toast(activity);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(view);
        toast.show();
    }

}
