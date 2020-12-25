package com.e.spy;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class ImageViewer extends AppCompatActivity {
    ImageView imageView;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_image_viewer);
        this.imageView = (ImageView) findViewById(R.id.showimage);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.imageView.setImageURI(Uri.parse(extras.getString("image")));
        }
    }
}
