package com.example.administrator.afinaldemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.FinalBitmap;
import net.tsz.afinal.FinalDb;
import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.annotation.view.ViewInject;
import net.tsz.afinal.http.AjaxCallBack;

import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @ViewInject(id=R.id.btn,click="btnClick") Button btn;
    @ViewInject(id=R.id.txt)TextView txt;
    @ViewInject(id=R.id.img)ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FinalActivity.initInjectedView(this);

    }

    public void btnClick(View v){
        bitmap();
    }

    //FinalBitmap 使用方法
    public void bitmap(){
        FinalBitmap fb = FinalBitmap.create(this);//初始化FinalBitmap模块
        fb.configLoadingImage(R.mipmap.ic_launcher);
        //
        fb.display(img,"http://img0.bdstatic.com/img/image/shouye/sheying1124.jpg");

    }
    //网络请求测试
    public void httpTest(){
        FinalHttp fh = new FinalHttp();

        fh.get("http://www.baidu.com/", new AjaxCallBack(){

            @Override
            public void onSuccess(Object o) {
                txt.setText(o == null ? "null" : o.toString());
            }

            @Override
            public void onFailure(Throwable t, int errorNo, String strMsg) {
                txt.setText("Throwable:"+t.toString()+";errorNo:"+errorNo+";strMsg:"+strMsg);
            }
        });

    }

    //数据库测试
    public void dbTest(){
        FinalDb db = FinalDb.create(this);
        User user = new User();
        user.setEmail("afinal@tsz.net");
        user.setName("qzsang");
        user.setRegisterDate(new Date());
        List<User> userList = db.findAllByWhere(User.class,"name = 'qzsang'");

        txt.setText(userList.toString());
    }
}
