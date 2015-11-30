package com.example.administrator.webandjsandcssdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;

public class MainActivity extends AppCompatActivity {


    @ViewInject(id = R.id.wv_web)
    WebView wv_web;
    @ViewInject(id = R.id.txt,click = "onclick")
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FinalActivity.initInjectedView(this);
        init();
    }

    public void init() {
        wv_web.getSettings().setJavaScriptEnabled(true);
        wv_web.loadUrl("file:///android_asset/www/test.html");
        wv_web.addJavascriptInterface(new JavaInterface(this), "android");
    }

    public void onclick (View v) {
        Log.i("test","test");
        wv_web.loadUrl("javascript:hideBtn()");
    }


    class JavaInterface {
        Context c;
        JavaInterface (Context c) {
            this.c = c;
        }

        @JavascriptInterface
        public void showToast(String str){
            Toast.makeText(c,str,Toast.LENGTH_LONG).show();
        }
    }


}