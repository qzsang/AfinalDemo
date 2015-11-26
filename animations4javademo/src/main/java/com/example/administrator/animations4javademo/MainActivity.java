package com.example.administrator.animations4javademo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
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
        AnimationSet as = new AnimationSet(true);

        switch (v.getId()) {
            case R.id.btn_tween_alpha:
                AlphaAnimation aa = new AlphaAnimation(0f, 1f);
                aa.setDuration(2000);
                as.addAnimation(aa);
                break;

            case R.id.btn_tween_rotate:
                RotateAnimation ra = new RotateAnimation(0f, 360f,
                        Animation.RELATIVE_TO_PARENT, 1f,
                        Animation.RELATIVE_TO_PARENT, 0f);
                ra.setDuration(2000);
                as.addAnimation(ra);
                break;

            case R.id.btn_tween_scale:
                ScaleAnimation sa = new ScaleAnimation(1f, 0.5f,//x  从1到0.5
                        1f, 0.5f,//y  从1到0.5
                        Animation.RELATIVE_TO_SELF, 1, Animation.RELATIVE_TO_SELF, 1);//参考点
                sa.setDuration(2000);
                as.setFillAfter(true);//停留在结束位置
                as.setFillBefore(false);
                sa.setRepeatCount(2);//重复2次
                as.setStartOffset(200);//0.2秒后执行
                as.addAnimation(sa);
                break;

            case R.id.btn_tween_translate:
                TranslateAnimation ts = new TranslateAnimation(0,1,
                        0,1,
                        Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,1);
                ts.setDuration(2000);
                as.addAnimation(ts);
                break;


        }

        img.startAnimation(as);

    }

}
