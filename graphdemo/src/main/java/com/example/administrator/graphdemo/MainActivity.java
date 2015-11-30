package com.example.administrator.graphdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;

public class MainActivity extends AppCompatActivity {

    @ViewInject(id = R.id.wv)WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FinalActivity.initInjectedView(this);

        init();
    }

    public void init() {

        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl("file:///android_asset/www/test.html");
    }


}
