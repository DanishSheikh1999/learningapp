package com.android.learningapp.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.learningapp.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class SensorRecViewAdapter extends RecyclerView.Adapter<SensorRecViewAdapter.ViewHolder> {

    private static final String TAG = "SensorRecViewAdapter";
    private ArrayList<String> TitleText;
    private ArrayList<String> PurposeText;
    private ArrayList<String> DescriptionText;
    private ArrayList<String> ImageURI;
    private Context mContext;
    private SensorTaskRecViewAdapter recyclerViewAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<String> Tasks = new ArrayList<String>();

    private int isOpen = 0;

    public SensorRecViewAdapter(Context context, ArrayList<String> title, ArrayList<String> purpose, ArrayList<String> description, ArrayList<String> image) {
        this.mContext = context;
        this.ImageURI = image;
        this.PurposeText = purpose;
        this.DescriptionText = description;
        this.TitleText = title;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sensor_recycler_view, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        holder.DescriptionBox.setText(DescriptionText.get(position));
        holder.TitleBox.setText(TitleText.get(position));
        holder.PurposeBox.setText(PurposeText.get(position));
        holder.Sensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isOpen = 1 - isOpen;
                getTasks(position+1);
                if (isOpen == 0) {
                    holder.DescriptionBox.setVisibility(View.VISIBLE);
                    holder.holderLayout.setVisibility(View.VISIBLE);
                } else {
                    holder.DescriptionBox.setVisibility(View.GONE);
                    holder.holderLayout.setVisibility(View.GONE);
                }
            }
        });
        Glide.with(mContext).load(ImageURI.get(position))
                .into(holder.ImageBox);
        recyclerViewAdapter = new SensorTaskRecViewAdapter(mContext, Tasks, position);
        layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        holder.recyclerView.setLayoutManager(layoutManager);
        holder.recyclerView.setAdapter(recyclerViewAdapter);
    }

    private void getTasks(int topic) {
        switch (topic) {
            case 1:
                Tasks.clear();
                Tasks.add("LED Blinking");
                Tasks.add("LED Fading");
                Tasks.add("LED Mixing");
                break;
            case 2:
                Tasks.clear();
                Tasks.add("Basic Distance Finding");
                Tasks.add("RADAR Making");
                break;
            case 3:
                Tasks.clear();
                Tasks.add("Varying LED intensity");
                Tasks.add("Controlling Servo Motors");
                break;
        }
    }

    @Override
    public int getItemCount() {
        return TitleText.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView DescriptionBox;
        TextView TitleBox;
        ImageView ImageBox;
        TextView PurposeBox;
        CardView Sensor;
        RecyclerView recyclerView;
        LinearLayout holderLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            PurposeBox = itemView.findViewById(R.id.purpose);
            DescriptionBox = itemView.findViewById(R.id.short_description_of_sensor);
            TitleBox = itemView.findViewById(R.id.name_of_the_sensor);
            ImageBox = itemView.findViewById(R.id.sensor_image);
            Sensor = itemView.findViewById(R.id.sensor);
            recyclerView = itemView.findViewById(R.id.recyclerViewTasks);
            holderLayout = itemView.findViewById(R.id.recyclerViewLayout);
        }
    }
}
