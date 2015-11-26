package com.example.administrator.animations4xmldemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;

public class MainActivity extends AppCompatActivity {

    @ViewInject(id = R.id.btn_tween_alpha, click = "onclick")
    Button btn_tween_alpha;
    @ViewInject(id = R.id.btn_tween_translate, click = "onclick")
    Button btn_tween_translate;
    @ViewInject(id = R.id.btn_tween_rotate, click = "onclick")
    Button btn_tween_rotate;
    @ViewInject(id = R.id.btn_tween_scale, click = "onclick")
    Button btn_tween_scale;
    @ViewInject(id = R.id.img)
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FinalActivity.initInjectedView(this);

    }

    public void onclick(View v) {
        Animation a = null;

        switch (v.getId()) {
            case R.id.btn_tween_alpha:
                a = AnimationUtils.loadAnimation(this,R.anim.alpha);
                break;

            case R.id.btn_tween_rotate:
                a = AnimationUtils.loadAnimation(this,R.anim.rotate);
                break;

            case R.id.btn_tween_scale:
                a = AnimationUtils.loadAnimation(this,R.anim.scale);
                break;

            case R.id.btn_tween_translate:
                a = AnimationUtils.loadAnimation(this,R.anim.translate);
                break;


        }

        img.startAnimation(a);

    }
}
