package com.e.spy;

import android.content.ContentUris;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragPlaylist extends Fragment {
    SharedPreferences.Editor editor;
    private GridAdapter musicAdapter;
    int num = -1;
    private RecyclerView recyclerView;
    boolean repeat = false;
    SharedPreferences sharedPreferences;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewv = inflater.inflate(R.layout.fragment_frag_playlist, container, false);
        this.recyclerView = (RecyclerView) viewv.findViewById(R.id.plist);
        this.recyclerView.setHasFixedSize(true);
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        initi();
        adapt();
        AudioActivity.mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                if (!FragPlaylist.this.repeat) {
                    FragPlaylist.this.newSong();
                } else {
                    FragPlaylist.this.again();
                }
            }
        });
        return viewv;
    }

    /* access modifiers changed from: private */
    public void again() {
        AudioActivity.mediaPlayer.release();
        AudioActivity.mediaPlayer = MediaPlayer.create(getContext(), Uri.parse(AudioActivity.data.get(this.num).getPath()));
        AudioActivity.mediaPlayer.start();
    }

    public void newSong() {
        this.num++;
        if (this.num == AudioActivity.data.size()) {
            this.num = 0;
        }
        this.editor = this.sharedPreferences.edit();
        this.editor.putInt("pos", this.num);
        this.editor.putString("alb", getAlbumArist(AudioActivity.data.get(this.num).getAlbumId()).toString());
        this.editor.commit();
        initi();
        AudioActivity.mediaPlayer.release();
        AudioActivity.mediaPlayer = MediaPlayer.create(getContext(), Uri.parse(AudioActivity.data.get(this.num).getPath()));
        AudioActivity.mediaPlayer.start();
    }

    private Uri getAlbumArist(long albumId) {
        return ContentUris.withAppendedId(Uri.parse("content://media/external/audio/albumart"), albumId);
    }

    public void initi() {
        this.num = this.sharedPreferences.getInt("pos", this.num);
        this.repeat = this.sharedPreferences.getBoolean("repeat", this.repeat);
    }

    public void adapt() {
        if (AudioActivity.filterFiles.size() >= 1) {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, 1, false);
            this.musicAdapter = new GridAdapter(getContext(), AudioActivity.filterFiles);
            this.recyclerView.setLayoutManager(gridLayoutManager);
            this.recyclerView.setAdapter(this.musicAdapter);
        }
    }
}
