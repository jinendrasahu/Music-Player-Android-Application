package com.e.spy;

import android.content.ContentUris;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GridAdapter extends RecyclerView.Adapter<MyViewHolder> {
    /* access modifiers changed from: private */
    public ArrayList<MusicFiles> mFiles;
    /* access modifiers changed from: private */
    public Context mcontext;

    GridAdapter(Context mcontext2, ArrayList<MusicFiles> mFiles2) {
        this.mcontext = mcontext2;
        this.mFiles = mFiles2;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(this.mcontext).inflate(R.layout.card_item, parent, false));
    }

    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.textView.setText(this.mFiles.get(position).getTitle());
        ImageLoader.getInstance().displayImage(getAlbumArist(this.mFiles.get(position).getAlbumId()).toString(), holder.imageView, new DisplayImageOptions.Builder().cacheInMemory(true).showImageOnLoading((int) R.drawable.pic1).resetViewBeforeLoading(true).build());
        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.mcontext);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        holder.add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                List<String> list = new ArrayList<>(Arrays.asList(sharedPreferences.getString("plist", "").split(",")));
                list.remove("" + ((MusicFiles) GridAdapter.this.mFiles.get(position)).getId());
                editor.putString("plist", String.join(",", list));
                editor.commit();
                AudioActivity.filterFiles.remove(GridAdapter.this.mFiles.get(position));
                AudioActivity.data = AudioActivity.filterFiles;
                GridAdapter.this.notifyDataSetChanged();
            }
        });
        holder.textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editor.putInt("pos", position);
                SharedPreferences.Editor editor = editor;
                GridAdapter gridAdapter = GridAdapter.this;
                editor.putString("alb", gridAdapter.getAlbumArist(((MusicFiles) gridAdapter.mFiles.get(position)).getAlbumId()).toString());
                editor.commit();
                if (AudioActivity.mediaPlayer.isPlaying()) {
                    AudioActivity.mediaPlayer.stop();
                    AudioActivity.mediaPlayer.release();
                    AudioActivity.mediaPlayer = MediaPlayer.create(GridAdapter.this.mcontext, Uri.parse(((MusicFiles) GridAdapter.this.mFiles.get(position)).getPath()));
                    AudioActivity.mediaPlayer.start();
                } else {
                    AudioActivity.mediaPlayer = MediaPlayer.create(GridAdapter.this.mcontext, Uri.parse(((MusicFiles) GridAdapter.this.mFiles.get(position)).getPath()));
                    AudioActivity.mediaPlayer.start();
                }
                AudioActivity.data = GridAdapter.this.mFiles;
            }
        });
    }

    /* access modifiers changed from: private */
    public Uri getAlbumArist(long albumId) {
        return ContentUris.withAppendedId(Uri.parse("content://media/external/audio/albumart"), albumId);
    }

    public int getItemCount() {
        return this.mFiles.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView add;
        ImageView imageView;
        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textView = (TextView) itemView.findViewById(R.id.names);
            this.imageView = (ImageView) itemView.findViewById(R.id.cards);
            this.add = (ImageView) itemView.findViewById(R.id.add);
        }
    }
}
