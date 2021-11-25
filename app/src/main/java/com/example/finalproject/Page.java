package com.example.finalproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.logging.SimpleFormatter;

public class Page extends AppCompatActivity implements View.OnClickListener {
    private TextView home;
    private TextView image;
    private TextView music;
    private TextView me;
    private FragmentManager manager;
    private FragmentTransaction ft;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page);
        initView();
        manager=getSupportFragmentManager();
        ft=manager.beginTransaction();
        PageImage fg=new PageImage();
        ft.replace(R.id.fragment,fg);
        ft.commit();
    }

    private void initView() {
//        home = (TextView) findViewById(R.id.home);
        image = (TextView) findViewById(R.id.image);
        music = (TextView) findViewById(R.id.music);
        me = (TextView) findViewById(R.id.me);

//        home.setOnClickListener(this);
        image.setOnClickListener(this);
        music.setOnClickListener(this);
        me.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
//            case R.id.home:
//                setColor();
//                home.setTextColor(Color.WHITE);
//                home.setBackgroundColor(Color.argb(255,114,213,141));
//                ft=manager.beginTransaction();
//                PageHome fg01=new PageHome();
//                ft.replace(R.id.fragment,fg01);
//                ft.commit();
//                break;
            case R.id.music:
                setColor();
                music.setTextColor(Color.WHITE);
                music.setBackgroundColor(Color.argb(255,114,213,141));
                ft=manager.beginTransaction();
                PageMusic fg02=new PageMusic();
                ft.replace(R.id.fragment,fg02);
                ft.commit();
                break;
            case R.id.image:
                setColor();
                image.setTextColor(Color.WHITE);
                image.setBackgroundColor(Color.argb(255,114,213,141));
                ft=manager.beginTransaction();
                PageImage fg03=new PageImage();
                ft.replace(R.id.fragment,fg03);
                ft.commit();
                break;
            case R.id.me:
                setColor();
                me.setTextColor(Color.WHITE);
                me.setBackgroundColor(Color.argb(255,114,213,141));
                ft=manager.beginTransaction();
                Page_Me fg04=new Page_Me();
                chuanzhi();
                ft.commit();
                break;
        }
    }

private void setColor(){
//      home.setTextColor(Color.BLACK);
        music.setTextColor(Color.BLACK);
        image.setTextColor(Color.BLACK);
        me.setTextColor(Color.BLACK);
//      home.setBackgroundColor(Color.argb(0,0,0,0));
        music.setBackgroundColor(Color.argb(0,0,0,0));
        image.setBackgroundColor(Color.argb(0,0,0,0));
        me.setBackgroundColor(Color.argb(0,0,0,0));
}
public void chuanzhi(){
        Intent intent=getIntent();
        Bundle bundle = new Bundle();
        bundle.putString("stu_name", intent.getStringExtra("stu_name"));
        bundle.putString("stu_number", intent.getStringExtra("stu_number"));
        Page_Me fragment = new Page_Me();
        fragment.setArguments(bundle);
        ft.add(R.id.fragment,fragment);
}
}
