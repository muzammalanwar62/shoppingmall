package com.example.ma.lecture7;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by MA on 6/24/2017.
 */

public class Mainpage extends Fragment {
    ViewPager viewPager;
    RecyclerView latestlist,discountlist;
    ArrayList<latest_product> arrayList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ArrayList<Integer> arr=new ArrayList<>();
        View v = inflater.inflate(R.layout.mainpage_layout,container,false);

        viewPager = (ViewPager)v.findViewById(R.id.pager);
        latestlist= (RecyclerView) v.findViewById(R.id.latestproductsrecycler);
        discountlist= (RecyclerView) v.findViewById(R.id.discountproductsrecycler);
        latestlist.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        discountlist.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        arrayList=new ArrayList<>();
        latest_product p1=new latest_product(R.drawable.mobile,"s3","15000");
        latest_product p2=new latest_product(R.drawable.mobiles,"s7","25000");
        latest_product p3=new latest_product(R.drawable.computer,"mac","25000");
        arrayList.add(p1);
        arrayList.add(p2);
        arrayList.add(p3);
        arr.add(R.drawable.mobile);
        arr.add(R.drawable.mobiles);
        arr.add(R.drawable.computer);
        latestlist.setAdapter(new latest_product_adapter(arrayList,getActivity()));
       discountlist.setAdapter(new Discount_adapter(arrayList,getActivity()));
        ImageSliderAdapter adapter = new ImageSliderAdapter(getActivity(),arr);
        viewPager.setAdapter(adapter);
        return v;
    }
}
