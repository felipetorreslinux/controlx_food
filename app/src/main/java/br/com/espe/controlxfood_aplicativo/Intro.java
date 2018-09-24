package br.com.espe.controlxfood_aplicativo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tmall.ultraviewpager.UltraViewPager;
import com.tmall.ultraviewpager.transformer.UltraScaleTransformer;

import java.util.ArrayList;
import java.util.List;

import br.com.espe.controlxfood_aplicativo.Adapter.SlidesAdapter;
import br.com.espe.controlxfood_aplicativo.Models.SlidesIntro;
import br.com.espe.controlxfood_aplicativo.Views.View_Intro_Control;

public class Intro extends AppCompatActivity {

    SharedPreferences.Editor editor;
    Animation animation;
    List<SlidesIntro> slides = new ArrayList<>();
    LinearLayout box_slides_intro;
    UltraViewPager ultraviewpager;

    TextView button_next_slide;
    TextView title_slide;
    TextView subtitle_slide;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_intro);
        editor = getSharedPreferences("intro", MODE_PRIVATE).edit();

        animation = new TranslateAnimation(0,0,2000,0);
        animation.setFillEnabled(true);
        animation.setDuration(750);
        box_slides_intro = findViewById(R.id.box_slides_intro);
        box_slides_intro.startAnimation(animation);

        title_slide = findViewById(R.id.title_slide);
        subtitle_slide = findViewById(R.id.subtitle_slide);
        button_next_slide = findViewById(R.id.button_next_slide);
        button_next_slide.setText("Próximo");

        ultraviewpager = findViewById(R.id.ultraviewpager);
        mSlides();
    }

    private void mSlides(){

        slides.clear();

        SlidesIntro slid01 = new SlidesIntro(1, getString(R.string.slide_info_01), R.drawable.logo, "Inovador", "Sai na frente em tecnologia");
        SlidesIntro slid02 = new SlidesIntro(2, getString(R.string.slide_info_01), R.drawable.logo, "Automatizado", "Tenha tudo controle total");
        SlidesIntro slid03 = new SlidesIntro(3, getString(R.string.slide_info_01), R.drawable.logo, "Realidade", "Tempo que para ser você mesmo");
        SlidesIntro slid04 = new SlidesIntro(4, getString(R.string.slide_info_01), R.drawable.logo, "Conquista", "Entre na era do desenvolvimento");

        slides.add(slid01);
        slides.add(slid02);
        slides.add(slid03);
        slides.add(slid04);

        SlidesAdapter slidesAdapter = new SlidesAdapter(this, slides);
        ultraviewpager.setAdapter(slidesAdapter);
        ultraviewpager.setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL);
        ultraviewpager.initIndicator();
        ultraviewpager.getIndicator()
                .setOrientation(UltraViewPager.Orientation.HORIZONTAL)
                .setFocusColor(getResources().getColor(R.color.colorAccent))
                .setNormalColor(getResources().getColor(R.color.colorGray ))
                .setRadius((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics()));
        ultraviewpager.getIndicator().setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
        ultraviewpager.getIndicator().setMargin(0,25, 0 ,25);
        ultraviewpager.getIndicator().build();
        ultraviewpager.setInfiniteLoop(false);
        ultraviewpager.setPageTransformer(false, new UltraScaleTransformer());

        ultraviewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                final SlidesIntro intro = slides.get(position);
                switch (position){
                    case 0:
                        title_slide.setText(intro.getTitle());
                        subtitle_slide.setText(intro.getSubtitle());
                        button_next_slide.setText("Próximo");
                        button_next_slide.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ultraviewpager.setCurrentItem(2);
                            }
                        });
                        break;
                    case 1:
                        title_slide.setText(intro.getTitle());
                        subtitle_slide.setText(intro.getSubtitle());
                        button_next_slide.setText("Próximo");
                        button_next_slide.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ultraviewpager.setCurrentItem(3);
                            }
                        });
                        break;
                    case 2:
                        title_slide.setText(intro.getTitle());
                        subtitle_slide.setText(intro.getSubtitle());
                        button_next_slide.setText("Próximo");
                        button_next_slide.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ultraviewpager.setCurrentItem(3);
                            }
                        });
                        break;
                    case 3:
                        title_slide.setText(intro.getTitle());
                        subtitle_slide.setText(intro.getSubtitle());
                        button_next_slide.setText("Entrar");
                        button_next_slide.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                closeSlides();
                            }
                        });
                        break;
                }
            }
            @Override
            public void onPageSelected(int position) {}
            @Override
            public void onPageScrollStateChanged(int state) {}
        });

    }

    private void closeSlides(){
        animation = new TranslateAnimation(0,0,0,2000);
        animation.setDuration(750);
        animation.setFillEnabled(true);
        box_slides_intro.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }
            @Override
            public void onAnimationEnd(Animation animation) {
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                params.setMargins(0,2000,0,0);
                box_slides_intro.setLayoutParams(params);
                editor.putInt("view_intro", 1);
                editor.commit();
                startActivity(new Intent(Intro.this, View_Intro_Control.class));
                finish();
            }
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

}
