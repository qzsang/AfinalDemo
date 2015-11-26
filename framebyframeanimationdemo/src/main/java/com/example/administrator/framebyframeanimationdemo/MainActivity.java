package com.example.administrator.framebyframeanimationdemo;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;

public class MainActivity extends AppCompatActivity {

    @ViewInject(id = R.id.animation, click = "onclick")
    Button animation;
    @ViewInject(id = R.id.img)
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FinalActivity.initInjectedView(this);

    }

    public void onclick(View v) {
        img.setBackgroundResource(R.animator.animation);
        AnimationDrawable animationDrawable = (AnimationDrawable)img.getBackground();
        animationDrawable.start();

    }
}
