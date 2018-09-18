package br.com.espe.controlxfood.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.espe.controlxfood.Models.SlidesIntro;
import br.com.espe.controlxfood.R;

public class SlidesAdapter extends PagerAdapter {

    Activity activity;
    View view;
    List<SlidesIntro> lista_slides;

    public SlidesAdapter(Activity activity, List<SlidesIntro> lista_slides){
        this.activity = activity;
        this.lista_slides = lista_slides;
    }

    @Override
    public int getCount() {
        return lista_slides != null ? lista_slides.size() : 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view.equals(o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        view = LayoutInflater.from(activity).inflate(R.layout.item_slide_intro, container, false);
        SlidesIntro slidesIntro = lista_slides.get(position);

        TextView textView = view.findViewById(R.id.text_info_slide_intro);
        ImageView imageView = view.findViewById(R.id.image_slide_intro);

        textView.setText(slidesIntro.getInfo());

        container.addView(view, 0);
        return view;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object){
        container.removeView((View) object);
    }
}
