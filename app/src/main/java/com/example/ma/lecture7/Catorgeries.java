package com.example.ma.lecture7;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by MA on 6/24/2017.
 */

public class Catorgeries extends Fragment {
    RecyclerView catorgerylist;
    ArrayList<catorgery> catorgeries;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.catorgeries_fragment_layout,container,false);
        catorgerylist=(RecyclerView) v.findViewById(R.id.catorgerylist);
        catorgerylist.setLayoutManager(new LinearLayoutManager(getActivity()));
        catorgeries=new ArrayList<>();
        catorgery cat=new catorgery("Mobiles",R.drawable.mobiles);
        catorgery catorgery=new catorgery("Computers",R.drawable.computer);
        catorgeries.add(cat);
        catorgeries.add(catorgery);
        catorgerylist.setAdapter(new catorgerylistadapter(catorgeries,getActivity()));
        return v;
    }
}
