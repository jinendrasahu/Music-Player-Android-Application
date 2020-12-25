package com.e.spy;

import android.content.ContentUris;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import java.util.concurrent.TimeUnit;

public class FragPlaying extends Fragment {
    TextView artist;
    ImageView back;
    SeekBar bar;
    SharedPreferences.Editor editor;
    ImageView far;
    Handler handler = new Handler();
    ImageView imageView;
    boolean isPlaying = false;
    TextView name;
    int num = -1;
    ImageView pause;
    ImageView play;
    int position = 0;
    ImageView repe;
    boolean repeat = false;
    SharedPreferences sharedPreferences;
    TextView timer;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frag_playing, container, false);
        this.name = (TextView) view.findViewById(R.id.name);
        this.artist = (TextView) view.findViewById(R.id.artst);
        this.timer = (TextView) view.findViewById(R.id.timer);
        this.play = (ImageView) view.findViewById(R.id.play);
        this.back = (ImageView) view.findViewById(R.id.back);
        this.far = (ImageView) view.findViewById(R.id.far);
        this.bar = (SeekBar) view.findViewById(R.id.bar);
        this.pause = (ImageView) view.findViewById(R.id.pause);
        this.repe = (ImageView) view.findViewById(R.id.repeat);
        this.pause.setVisibility(8);
        this.imageView = (ImageView) view.findViewById(R.id.cover);
        this.repe.setAlpha(0.7f);
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        this.artist.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), "font/Ubuntu-Title.ttf"));
        this.name.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), "font/Righteous-Regular.ttf"));
        initi();
        this.bar.setMax(AudioActivity.mediaPlayer.getDuration());
        int duration = AudioActivity.mediaPlayer.getDuration();
        if (AudioActivity.mediaPlayer.isPlaying()) {
            duration = AudioActivity.mediaPlayer.getCurrentPosition();
        }
        String mDuration = convertDuration(duration);
        this.bar.setProgress(AudioActivity.mediaPlayer.getCurrentPosition());
        this.timer.setText(mDuration);
        this.play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FragPlaying.this.play.setVisibility(8);
                FragPlaying.this.pause.setVisibility(0);
                AudioActivity.mediaPlayer.start();
                FragPlaying.this.bar.setMax(AudioActivity.mediaPlayer.getDuration());
                FragPlaying.this.handler.postDelayed(AudioActivity.runnable, 0);
                SetNotification.createNotification(FragPlaying.this.getContext(), FragPlaying.this.num);
            }
        });
        this.pause.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FragPlaying.this.pause.setVisibility(8);
                FragPlaying.this.play.setVisibility(0);
                AudioActivity.mediaPlayer.pause();
                FragPlaying.this.handler.removeCallbacks(AudioActivity.runnable);
            }
        });
        this.far.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int currentPos = AudioActivity.mediaPlayer.getCurrentPosition();
                int cDuration = AudioActivity.mediaPlayer.getDuration();
                if (AudioActivity.mediaPlayer.isPlaying() && cDuration != currentPos) {
                    int currentPos2 = currentPos + BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT;
                    FragPlaying.this.timer.setText(FragPlaying.this.convertDuration(currentPos2));
                    AudioActivity.mediaPlayer.seekTo(currentPos2);
                }
            }
        });
        this.back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int currentPos = AudioActivity.mediaPlayer.getCurrentPosition();
                int duration = AudioActivity.mediaPlayer.getDuration();
                if (AudioActivity.mediaPlayer.isPlaying() && currentPos > 5000) {
                    int currentPos2 = currentPos - 5000;
                    FragPlaying.this.timer.setText(FragPlaying.this.convertDuration(currentPos2));
                    AudioActivity.mediaPlayer.seekTo(currentPos2);
                }
            }
        });
        AudioActivity.runnable = new Runnable() {
            public void run() {
                FragPlaying.this.timer.setText(FragPlaying.this.convertDuration(AudioActivity.mediaPlayer.getCurrentPosition()));
                FragPlaying.this.bar.setProgress(AudioActivity.mediaPlayer.getCurrentPosition());
                FragPlaying.this.handler.postDelayed(this, 500);
            }
        };
        this.bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    AudioActivity.mediaPlayer.seekTo(progress);
                }
                FragPlaying.this.timer.setText(FragPlaying.this.convertDuration(AudioActivity.mediaPlayer.getCurrentPosition()));
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.repe.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FragPlaying fragPlaying = FragPlaying.this;
                fragPlaying.editor = fragPlaying.sharedPreferences.edit();
                if (!FragPlaying.this.repeat) {
                    FragPlaying.this.repe.setAlpha(1.0f);
                    FragPlaying.this.editor.putBoolean("repeat", true);
                    FragPlaying.this.editor.commit();
                    FragPlaying.this.repeat = true;
                    AudioActivity.mediaPlayer.setLooping(true);
                    return;
                }
                FragPlaying.this.repe.setAlpha(0.7f);
                FragPlaying.this.editor.putBoolean("repeat", false);
                FragPlaying.this.editor.commit();
                FragPlaying.this.repeat = false;
                AudioActivity.mediaPlayer.setLooping(false);
            }
        });
        AudioActivity.mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                if (!FragPlaying.this.repeat) {
                    FragPlaying.this.newSong();
                } else {
                    again();
                }
            }

            private void again() {
                AudioActivity.mediaPlayer.release();
                AudioActivity.mediaPlayer = MediaPlayer.create(FragPlaying.this.getContext(), Uri.parse(AudioActivity.data.get(FragPlaying.this.num).getPath()));
                AudioActivity.mediaPlayer.start();
            }
        });
        getContext().startService(new Intent(getContext(), OnClearFronCurrenService.class));
        return view;
    }

    /* access modifiers changed from: private */
    public String convertDuration(int duration) {
        return String.format("%02d:%02d", new Object[]{Long.valueOf(TimeUnit.MILLISECONDS.toMinutes((long) duration)), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds((long) duration)), Long.valueOf(TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) duration)))});
    }

    public void onStart() {
        super.onStart();
        this.handler.postDelayed(AudioActivity.runnable, 0);
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

    public void initi() {
        this.num = this.sharedPreferences.getInt("pos", this.num);
        this.repeat = this.sharedPreferences.getBoolean("repeat", this.repeat);
        String alm = this.sharedPreferences.getString("alb", "");
        if (this.num == -1 || alm == "") {
            this.name.setText("Unknown Name");
            this.artist.setText("Unknown Artist");
            return;
        }
        if (AudioActivity.data.get(this.num).getArtist() != null) {
            TextView textView = this.artist;
            textView.setText("" + AudioActivity.data.get(this.num).getArtist());
        }
        TextView textView2 = this.name;
        textView2.setText("" + AudioActivity.data.get(this.num).getTitle());
        ImageLoader.getInstance().displayImage(alm, this.imageView, new DisplayImageOptions.Builder().cacheInMemory(true).showImageOnLoading((int) R.drawable.pic1).resetViewBeforeLoading(true).build());
    }

    private Uri getAlbumArist(long albumId) {
        return ContentUris.withAppendedId(Uri.parse("content://media/external/audio/albumart"), albumId);
    }

    public void Next() {
        Toast.makeText(getContext(), "Yo bro", 0).show();
    }
}
