package com.android.learningapp.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.android.learningapp.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";
    private ArrayList<String> TitleText;
    private ArrayList<String> DescriptionText;
    private ArrayList<String> ImageURI;
    private Context mContext;
    private int Position;

    public RecyclerViewAdapter(Context context, ArrayList<String> title, ArrayList<String> description, ArrayList<String> image, int position) {
        mContext = context;
        this.ImageURI = image;
        this.DescriptionText = description;
        this.TitleText = title;
        this.Position = position;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.latest_gadgets_card, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        holder.DescriptionBox.setText(DescriptionText.get(Position));
        holder.TitleBox.setText(TitleText.get(Position));
        Glide.with(mContext).load(ImageURI.get(Position))
                .into(holder.ImageBox);
        holder.cardViewLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, DescriptionText.get(Position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    //private ArrayList<String> ImageURI;
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView DescriptionBox;
        TextView TitleBox;
        ImageView ImageBox;
        CardView cardViewLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            DescriptionBox = itemView.findViewById(R.id.card_desc);
            TitleBox = itemView.findViewById(R.id.card_title);
            ImageBox = itemView.findViewById(R.id.card_image);
            cardViewLayout = itemView.findViewById(R.id.latest_cardview);
        }
    }
}
