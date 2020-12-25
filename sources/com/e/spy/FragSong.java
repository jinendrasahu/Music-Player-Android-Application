package com.e.spy;

import android.content.ContentUris;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;

public class FragSong extends Fragment {
    SharedPreferences.Editor editor;
    private MusicAdapter musicAdapter;
    int num = -1;
    private RecyclerView recyclerView;
    boolean repeat = false;
    SharedPreferences sharedPreferences;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewv = inflater.inflate(R.layout.fragment_frag_song, container, false);
        this.recyclerView = (RecyclerView) viewv.findViewById(R.id.recycleview);
        this.recyclerView.setHasFixedSize(true);
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        initi();
        if (AudioActivity.musicFiles.size() >= 1) {
            this.musicAdapter = new MusicAdapter(getContext(), AudioActivity.musicFiles);
            this.recyclerView.setAdapter(this.musicAdapter);
            this.recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        }
        AudioActivity.editText.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void afterTextChanged(Editable s) {
                FragSong.this.filterBro(s.toString());
            }
        });
        AudioActivity.mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                if (!FragSong.this.repeat) {
                    FragSong.this.newSong();
                } else {
                    FragSong.this.again();
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

    /* access modifiers changed from: private */
    public void filterBro(String item) {
        ArrayList<MusicFiles> adapters = new ArrayList<>();
        Iterator<MusicFiles> it = AudioActivity.musicFiles.iterator();
        while (it.hasNext()) {
            MusicFiles mf = it.next();
            if (mf.getTitle().toLowerCase().contains(item.toLowerCase())) {
                adapters.add(mf);
            }
        }
        this.musicAdapter.filterget(adapters);
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
}
