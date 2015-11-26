package com.example.administrator.animationlayoutcontroller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @ViewInject(id = R.id.lv_list)
    ListView lv_list;
    @ViewInject(id = R.id.btn_start,click = "onclick")
    Button btn_start;
    @ViewInject(id = R.id.btn_delete,click = "onclick")
    Button btn_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FinalActivity.initInjectedView(this);

    }

    ArrayList<String> list = new ArrayList<String>();
    public ArrayAdapter<String> getListAdapter () {
        list.add("1111");
        list.add("2222");
        list.add("3333");
        list.add("4444");
        list.add("5555");
        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this,R.layout.list_layout) {

            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public View getView(final int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    convertView = View.inflate(getContext(),R.layout.list_layout,null);
                }
                TextView text = (TextView) convertView.findViewById(R.id.txt);
                text.setText(list.get(position));
                text.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.unalpha);
                        animation.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {
                                list.remove(position);
                                ((ArrayAdapter) MainActivity.this.lv_list.getAdapter()).notifyDataSetChanged();
                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {

                            }
                        });
                        v.startAnimation(animation);
                    }
                });

                return convertView;
            }
        };
        return listAdapter;
    }


    public void onclick(View v) {
        switch (v.getId()) {
            case R.id.btn_delete:
                list.clear();
                ArrayAdapter<String> listAdapter = (ArrayAdapter<String>)lv_list.getAdapter();
                listAdapter.notifyDataSetChanged();
                break;

            case R.id.btn_start :
                lv_list.setAdapter(getListAdapter());
                break;
        }

    }


}
