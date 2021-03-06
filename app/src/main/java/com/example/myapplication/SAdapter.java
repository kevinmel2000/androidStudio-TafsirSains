package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.LocalSocket;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;
import java.util.List;

import io.paperdb.Paper;

public class SAdapter extends PagerAdapter {

    private ArrayList<SModel> sModels;
    private LayoutInflater layoutInflater;
    private Context context;

    ImageView imageView;
    TextView title, string;
    Switch sw_gantiBahasa;
    private String judulBab;

    public SAdapter(ArrayList<SModel> sModels, Context context) {
        this.sModels = sModels;
        this.context = context;
    }

    @Override
    public int getCount() {
        return sModels.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_viewpager,container,false);

//        Paper.init(context);
//        String language = Paper.book().read("language");
//        if (language == null)
//            Paper.book().read("language","en");
//
//        updateView((String) Paper.book().read("language"));

        imageView = view.findViewById(R.id.img_viewpager);
        title = view.findViewById(R.id.text_viewpager);
        sw_gantiBahasa = view.findViewById(R.id.switch_bahasa);

        imageView.setImageResource(sModels.get(position).getImage());
        title.setText(sModels.get(position).getTitle());

        Log.d("arrayList", "instantiateItem: "+sModels.get(position).getTitle());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, ReadActivity.class);
                context.startActivity(i);
            }

        });

        container.addView(view,0 );
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
