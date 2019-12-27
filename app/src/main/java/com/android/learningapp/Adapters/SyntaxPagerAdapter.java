package com.android.learningapp.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import com.android.learningapp.R;

import java.util.ArrayList;

public class SyntaxPagerAdapter extends PagerAdapter {

    private int[] layouts;
    private LayoutInflater layoutInflater;
    private Context context;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;
    private SyntaxRecyclerViewAdapter recyclerAdapter;
    private ArrayList<String> Title;
    private ArrayList<String> Description;
    private ArrayList<String> Image;
    private ArrayList<String> Heading;


    public SyntaxPagerAdapter(int[] layouts, Context context, ArrayList<String> title, ArrayList<String> heading, ArrayList<String> description, ArrayList<String> image)
    {
        this.layouts= layouts;
        this.context=context;
        this.Title = title;
        this.Heading = heading;
        this.Description = description;
        this.Image = image;
        layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return layouts.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem( ViewGroup container, int position) {
        View view= layoutInflater.inflate(layouts[position],container,false);
        container.addView((view));
        recyclerView = view.findViewById(R.id.recyclerViewSyntax);
        recyclerAdapter = new SyntaxRecyclerViewAdapter(context, Title, Heading, Description, Image, position);
        layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerAdapter);
        return view;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        View view=(View)object;
        container.removeView(view);
    }
}
