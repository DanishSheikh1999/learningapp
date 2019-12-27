package com.android.learningapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.android.learningapp.GenericTask;
import com.android.learningapp.R;

import java.util.ArrayList;

public class SensorTaskRecViewAdapter extends RecyclerView.Adapter<SensorTaskRecViewAdapter.ViewHolder> {

    private static final String TAG = "SensorTaskRecView";
    private ArrayList<String> Tasks;
    private Context mContext;
    private int pos;

    public SensorTaskRecViewAdapter(Context context, ArrayList<String> tasks, int position) {
        this.mContext = context;
        this.Tasks = tasks;
        this.pos = position;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sensor_tasks_rec_view, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        holder.taskView.setText(Tasks.get(position));
        holder.task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, GenericTask.class);
                intent.putExtra("GenericTask", pos + "" + position);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return Tasks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView taskView;
        CardView task;

        public ViewHolder(View itemView) {
            super(itemView);
            task = itemView.findViewById(R.id.sensor);
            taskView = itemView.findViewById(R.id.text_task);
        }
    }
}
