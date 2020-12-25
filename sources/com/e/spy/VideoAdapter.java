package com.e.spy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import java.util.ArrayList;

public class VideoAdapter extends RecyclerView.Adapter<ViewHolder> {
    Activity activity;
    Context context;
    ArrayList<VideoModel> videoModelArrayList;

    public VideoAdapter(Context context2, ArrayList<VideoModel> videoModelArrayList2, Activity activity2) {
        this.context = context2;
        this.videoModelArrayList = videoModelArrayList2;
        this.activity = activity2;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_video, parent, false));
    }

    public void onBindViewHolder(ViewHolder holder, final int position) {
        RequestManager with = Glide.with(this.context);
        ((RequestBuilder) with.load("file://" + this.videoModelArrayList.get(position).getStr_thumb()).skipMemoryCache(false)).into(holder.imageView);
        holder.rl_select.setBackgroundColor(Color.parseColor("#FFFFFF"));
        holder.rl_select.setAlpha(0.0f);
        holder.rl_select.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(VideoAdapter.this.context, VideoPlayer.class);
                i.putExtra("video", VideoAdapter.this.videoModelArrayList.get(position).getVideo_path());
                VideoAdapter.this.activity.startActivity(i);
            }
        });
    }

    public int getItemCount() {
        return this.videoModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        RelativeLayout rl_select;

        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.iv_image);
            this.rl_select = (RelativeLayout) itemView.findViewById(R.id.rl_select);
        }
    }
}
