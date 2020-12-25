package com.e.spy;

import android.os.Bundle;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;

public class VideoPlayer extends AppCompatActivity {
    VideoView videoView;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_video_player);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String path = extras.getString("video");
            this.videoView = (VideoView) findViewById(R.id.player);
            this.videoView.setVideoPath(path);
            this.videoView.start();
        }
    }
}
