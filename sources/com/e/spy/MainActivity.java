package com.e.spy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    Button audio;
    Button image;
    Button video;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_main);
        if (!(ContextCompat.checkSelfPermission(this, "android.permission.READ_EXTERNAL_STORAGE") == 0 && ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0 && ContextCompat.checkSelfPermission(this, "android.permission.MEDIA_CONTENT_CONTROL") == 0 && ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_MEDIA_LOCATION") == 0)) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.MEDIA_CONTENT_CONTROL", "android.permission.ACCESS_MEDIA_LOCATION"}, 102);
        }
        this.video = (Button) findViewById(R.id.video);
        this.video.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, VideoActivity.class));
                MainActivity.this.finish();
            }
        });
        this.image = (Button) findViewById(R.id.image);
        this.image.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, ImageActivity.class));
                MainActivity.this.finish();
            }
        });
        this.audio = (Button) findViewById(R.id.audio);
        this.audio.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, AudioActivity.class));
                MainActivity.this.finish();
            }
        });
    }
}
