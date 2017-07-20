package com.example.ma.lecture7;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by MA on 7/7/2017.
 */

public class ImageSliderAdapter extends PagerAdapter {
    ImageView imageview;
    TabLayout tabs;
    Context context;

    public ImageSliderAdapter(Context context, ArrayList<Integer> img) {
        this.context = context;
        this.img = img;
    }

    ArrayList<Integer> img;
    @Override
    public int getCount() {
        return img.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);


    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       View v =inflater.inflate(R.layout.image_slider_layout,container, false);
        imageview = (ImageView)v.findViewById(R.id.imageslider);
        imageview.setImageResource(img.get(position));

        ViewPager vp=(ViewPager) container;
        tabs=(TabLayout)v.findViewById(R.id.tabDots);
        tabs.setupWithViewPager(vp,true);
        vp.addView(v,0);
        return v;


    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager vp=(ViewPager) container;
        View v=(View) object;
        vp.removeView(v);
    }
}
