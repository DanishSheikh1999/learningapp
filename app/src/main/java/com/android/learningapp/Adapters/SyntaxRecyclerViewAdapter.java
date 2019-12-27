package com.android.learningapp.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.android.learningapp.R;

import java.util.ArrayList;

public class SyntaxRecyclerViewAdapter extends RecyclerView.Adapter<SyntaxRecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "SyntaxViewAdapter";
    private ArrayList<String> TitleText;
    private ArrayList<String> DescriptionText;
    private ArrayList<String> HeadingText;
    private ArrayList<String> ImageURI;
    private Context mContext;
    private int Position;

    public SyntaxRecyclerViewAdapter(Context context, ArrayList<String> title, ArrayList<String> heading, ArrayList<String> description, ArrayList<String> image, int position) {
        mContext = context;
        this.ImageURI = image;
        this.DescriptionText = description;
        this.TitleText = title;
        this.HeadingText = heading;
        this.Position = position;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.syntax_slide_view, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        holder.TitleBox.setText(TitleText.get(Position));
        holder.HeadingBox.setText(HeadingText.get(Position));
        holder.DescriptionBox.setText(DescriptionText.get(Position));
        holder.ImageBox.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return 1;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView DescriptionBox;
        TextView TitleBox;
        TextView HeadingBox;
        ImageView ImageBox;

        public ViewHolder(View itemView) {
            super(itemView);
            DescriptionBox = itemView.findViewById(R.id.description);
            TitleBox = itemView.findViewById(R.id.title);
            HeadingBox = itemView.findViewById(R.id.heading);
            ImageBox = itemView.findViewById(R.id.code);
         }
    }
}
