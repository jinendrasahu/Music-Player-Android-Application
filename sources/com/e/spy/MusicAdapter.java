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
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.util.ArrayList;

public class MusicAdapter extends RecyclerView.Adapter<MyViewHolder> {
    /* access modifiers changed from: private */
    public ArrayList<MusicFiles> mFiles;
    /* access modifiers changed from: private */
    public Context mcontext;

    MusicAdapter(Context mcontext2, ArrayList<MusicFiles> mFiles2) {
        this.mcontext = mcontext2;
        this.mFiles = mFiles2;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(this.mcontext).inflate(R.layout.music_item, parent, false));
    }

    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.textView.setText(this.mFiles.get(position).getTitle());
        ImageLoader.getInstance().displayImage(getAlbumArist(this.mFiles.get(position).getAlbumId()).toString(), holder.imageView, new DisplayImageOptions.Builder().cacheInMemory(true).showImageOnLoading((int) R.drawable.ic_music).resetViewBeforeLoading(true).build());
        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.mcontext);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        holder.textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editor.putInt("pos", position);
                SharedPreferences.Editor editor = editor;
                MusicAdapter musicAdapter = MusicAdapter.this;
                editor.putString("alb", musicAdapter.getAlbumArist(((MusicFiles) musicAdapter.mFiles.get(position)).getAlbumId()).toString());
                editor.commit();
                if (AudioActivity.mediaPlayer.isPlaying()) {
                    AudioActivity.mediaPlayer.stop();
                    AudioActivity.mediaPlayer.release();
                    AudioActivity.mediaPlayer = MediaPlayer.create(MusicAdapter.this.mcontext, Uri.parse(((MusicFiles) MusicAdapter.this.mFiles.get(position)).getPath()));
                    AudioActivity.mediaPlayer.start();
                } else {
                    AudioActivity.mediaPlayer = MediaPlayer.create(MusicAdapter.this.mcontext, Uri.parse(((MusicFiles) MusicAdapter.this.mFiles.get(position)).getPath()));
                    AudioActivity.mediaPlayer.start();
                }
                AudioActivity.data = MusicAdapter.this.mFiles;
            }
        });
        holder.add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AudioActivity.filterFiles.add(MusicAdapter.this.mFiles.get(position));
                SharedPreferences.Editor editor = editor;
                editor.putString("plist", "" + ((MusicFiles) MusicAdapter.this.mFiles.get(position)).getId() + "," + sharedPreferences.getString("plist", ""));
                Toast.makeText(MusicAdapter.this.mcontext, sharedPreferences.getString("plist", ""), 0).show();
                editor.commit();
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
            this.textView = (TextView) itemView.findViewById(R.id.musicFileNae);
            this.imageView = (ImageView) itemView.findViewById(R.id.albumImg);
            this.add = (ImageView) itemView.findViewById(R.id.add);
        }
    }

    public void filterget(ArrayList<MusicFiles> musicFiles1) {
        this.mFiles = musicFiles1;
        notifyDataSetChanged();
    }
}
