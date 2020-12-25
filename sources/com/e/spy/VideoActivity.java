package com.e.spy;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class VideoActivity extends AppCompatActivity {
    ArrayList<VideoModel> ArraayvideoModels;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_video);
        init();
    }

    private void init() {
        this.recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        this.layoutManager = new GridLayoutManager(getApplicationContext(), 2);
        this.recyclerView.setLayoutManager(this.layoutManager);
        this.ArraayvideoModels = new ArrayList<>();
        fetchVideoFromGallery();
    }

    private void fetchVideoFromGallery() {
        Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        Cursor cursor = getApplicationContext().getContentResolver().query(uri, new String[]{"_data", "bucket_display_name", "_id", "_data"}, (String) null, (String[]) null, "date_modified" + " DESC");
        int colum_index_data = cursor.getColumnIndexOrThrow("_data");
        int thumb = cursor.getColumnIndexOrThrow("_data");
        while (cursor.moveToNext()) {
            String absolutePathImage = cursor.getString(colum_index_data);
            VideoModel videoModel = new VideoModel();
            videoModel.setBool_selected(false);
            videoModel.setVideo_path(absolutePathImage);
            videoModel.setStr_thumb(cursor.getString(thumb));
            this.ArraayvideoModels.add(videoModel);
        }
        this.recyclerView.setAdapter(new VideoAdapter(getApplicationContext(), this.ArraayvideoModels, this));
    }
}
