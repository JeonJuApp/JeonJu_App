package org.androidtown.jeonjuro2018;

import android.content.Context;
import android.content.Intent;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;


import android.widget.TextView;


import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context mContext;
    ArrayList<TourInfo> tourInfoArrayList;

    public MyAdapter(Context context, ArrayList<TourInfo> items) {
        this.mContext = context;
        this.tourInfoArrayList = items;

    }

    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_row, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final TourInfo data = tourInfoArrayList.get(position);
        MyViewHolder myViewHolder = (MyViewHolder) holder;

        Glide.with(mContext)
                .load(data.getUrl()).asBitmap()
                .fitCenter()
                .into(((MyViewHolder) holder).tourPicture);
        myViewHolder.tourName.setText(tourInfoArrayList.get(position).tourName);
        myViewHolder.tourLocation.setText(tourInfoArrayList.get(position).tourLocation);
        myViewHolder.tourContent.setText(tourInfoArrayList.get(position).dataContent);
        myViewHolder.homepage.setText(tourInfoArrayList.get(position).homepage);
        myViewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, LocationDialog.class);
                intent.putExtra("name", data.getTourName());
                intent.putExtra("location", data.getTourLocation()+"\n" + data.getHomepage());
                intent.putExtra("url", data.getUrl());
                intent.putExtra("dataContent", data.getDataContent());
              
                mContext.startActivity(intent);
            }
        });

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_row, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return tourInfoArrayList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView tourPicture;
        TextView tourName;
        TextView tourLocation;

        LinearLayout linearLayout;
        TextView tourContent;
        TextView homepage;

        public MyViewHolder(View view) {
            super(view);
            tourPicture = view.findViewById(R.id.tour_picture);
            tourName = view.findViewById(R.id.tour_name);
            tourLocation = view.findViewById(R.id.tour_location);
            linearLayout = view.findViewById(R.id.linear);
            tourContent = view.findViewById(R.id.tour_content);
            homepage = view.findViewById(R.id.tour_homepage)
        }
    }

}

        }

    }

}

