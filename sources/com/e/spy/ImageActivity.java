package com.e.spy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.io.File;
import java.util.ArrayList;

public class ImageActivity extends AppCompatActivity {
    ArrayList<File> arrayList;
    GridView gridView;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_image);
        this.gridView = (GridView) findViewById(R.id.imagegrid);
        this.arrayList = imageReader(Environment.getExternalStorageDirectory());
        this.gridView.setAdapter(new gridAdapter());
        this.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                ImageActivity imageActivity = ImageActivity.this;
                Toast.makeText(imageActivity, "" + ImageActivity.this.arrayList.get(position).toString(), 0).show();
                Intent intent = new Intent(ImageActivity.this, ImageViewer.class);
                intent.putExtra("image", ImageActivity.this.arrayList.get(position).toString());
                ImageActivity.this.startActivity(intent);
            }
        });
    }

    private ArrayList<File> imageReader(File externalStorageDirectory) {
        ArrayList<File> b = new ArrayList<>();
        File[] files = externalStorageDirectory.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                b.addAll(imageReader(files[i]));
            } else if (files[i].getName().endsWith(".jpg")) {
                b.add(files[i]);
            }
        }
        return b;
    }

    public class gridAdapter extends BaseAdapter {
        public gridAdapter() {
        }

        public int getCount() {
            return ImageActivity.this.arrayList.size();
        }

        public Object getItem(int position) {
            return ImageActivity.this.arrayList.get(position);
        }

        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            if (0 != 0) {
                return null;
            }
            View view = ImageActivity.this.getLayoutInflater().inflate(R.layout.custom_image, parent, false);
            ((ImageView) view.findViewById(R.id.imageAdap)).setImageURI(Uri.parse(ImageActivity.this.arrayList.get(position).toString()));
            return view;
        }
    }
}
