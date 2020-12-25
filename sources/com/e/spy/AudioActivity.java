package com.e.spy;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class AudioActivity extends AppCompatActivity implements Playable {
    static ArrayList<MusicFiles> data;
    static EditText editText;
    static ArrayList<MusicFiles> filterFiles;
    private static List<String> flist;
    static MediaPlayer mediaPlayer;
    static ArrayList<MusicFiles> musicFiles;
    static NotificationManager notificationManager;
    static int num1 = -1;
    static Runnable runnable;
    MeowBottomNavigation bottomNavigation;
    BroadcastReceiver broadcastReceiver;
    ChipNavigationBar chipNavigationBar;
    Fragment fragment;
    Handler handler = new Handler();
    int times = 0;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_audio);
        musicFiles = getAllAudio(this);
        data = musicFiles;
        editText = (EditText) findViewById(R.id.searchid);
        editText.setVisibility(8);
        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(this));
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String mList = sharedPreferences.getString("plist", "");
        num1 = sharedPreferences.getInt("pos", -1);
        if (num1 == -1) {
            num1 = 0;
        }
        try {
            if (mediaPlayer != null) {
                mediaPlayer.release();
            } else {
                String filePath = musicFiles.get(num1).getPath();
                mediaPlayer = new MediaPlayer();
                mediaPlayer.setDataSource(filePath);
                mediaPlayer.prepare();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        flist = Arrays.asList(mList.split(","));
        Toast.makeText(this, "" + flist.toString(), 0).show();
        filterFiles = filterAudio(this);
        this.chipNavigationBar = (ChipNavigationBar) findViewById(R.id.topm);
        this.chipNavigationBar.setItemSelected(R.id.play, true);
        this.chipNavigationBar.setOnItemSelectedListener((ChipNavigationBar.OnItemSelectedListener) new ChipNavigationBar.OnItemSelectedListener() {
            public void onItemSelected(int i) {
                if (AudioActivity.this.chipNavigationBar.getSelectedItemId() != R.id.search) {
                    AudioActivity.editText.setVisibility(8);
                }
                switch (i) {
                    case R.id.play /*2131165395*/:
                        AudioActivity.editText.setVisibility(8);
                        AudioActivity.this.bottomNavigation.show(2, true);
                        AudioActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.frame, new FragPlaying()).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();
                        return;
                    case R.id.playlist /*2131165397*/:
                        AudioActivity.this.bottomNavigation.show(3, true);
                        AudioActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.frame, new FragPlaylist()).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();
                        return;
                    case R.id.search /*2131165418*/:
                        AudioActivity.editText.setVisibility(0);
                        return;
                    case R.id.song /*2131165437*/:
                        AudioActivity.editText.setVisibility(8);
                        AudioActivity.this.bottomNavigation.show(1, true);
                        AudioActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.frame, new FragSong()).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();
                        return;
                    default:
                        return;
                }
            }
        });
        this.bottomNavigation = (MeowBottomNavigation) findViewById(R.id.bottomNavigation);
        this.bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_home));
        this.bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_play));
        this.bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_playlist));
        this.bottomNavigation.show(2, true);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        FragPlaying fragPlaying = new FragPlaying();
        this.fragment = fragPlaying;
        beginTransaction.replace(R.id.frame, fragPlaying).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();
        this.bottomNavigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            public Unit invoke(MeowBottomNavigation.Model model) {
                AudioActivity.editText.setVisibility(8);
                int id = model.getId();
                if (id == 1) {
                    AudioActivity.this.chipNavigationBar.setItemSelected(R.id.song, true);
                    AudioActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.frame, new FragSong()).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();
                    return null;
                } else if (id == 2) {
                    AudioActivity.this.chipNavigationBar.setItemSelected(R.id.play, true);
                    AudioActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.frame, new FragPlaying()).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();
                    return null;
                } else if (id != 3) {
                    return null;
                } else {
                    AudioActivity.this.chipNavigationBar.setItemSelected(R.id.playlist, true);
                    AudioActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.frame, new FragPlaylist()).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();
                    return null;
                }
            }
        });
        this.bottomNavigation.setOnShowListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            public Unit invoke(MeowBottomNavigation.Model model) {
                return null;
            }
        });
        if (Build.VERSION.SDK_INT >= 26) {
            createChannel();
        }
        runnable = new Runnable() {
            public void run() {
                AudioActivity.this.handler.postDelayed(this, 500);
                AudioActivity.this.times = AudioActivity.mediaPlayer.getCurrentPosition();
            }
        };
        this.broadcastReceiver = new BroadcastReceiver() {
            /* JADX WARNING: Removed duplicated region for block: B:17:0x0041  */
            /* JADX WARNING: Removed duplicated region for block: B:24:0x0060  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onReceive(android.content.Context r6, android.content.Intent r7) {
                /*
                    r5 = this;
                    android.os.Bundle r0 = r7.getExtras()
                    java.lang.String r1 = "actionnae"
                    java.lang.String r0 = r0.getString(r1)
                    int r1 = r0.hashCode()
                    r2 = 2464307(0x259a33, float:3.45323E-39)
                    r3 = 2
                    r4 = 1
                    if (r1 == r2) goto L_0x0034
                    r2 = 3377907(0x338af3, float:4.733456E-39)
                    if (r1 == r2) goto L_0x002a
                    r2 = 3443508(0x348b34, float:4.825382E-39)
                    if (r1 == r2) goto L_0x0020
                L_0x001f:
                    goto L_0x003e
                L_0x0020:
                    java.lang.String r1 = "play"
                    boolean r1 = r0.equals(r1)
                    if (r1 == 0) goto L_0x001f
                    r1 = r4
                    goto L_0x003f
                L_0x002a:
                    java.lang.String r1 = "next"
                    boolean r1 = r0.equals(r1)
                    if (r1 == 0) goto L_0x001f
                    r1 = r3
                    goto L_0x003f
                L_0x0034:
                    java.lang.String r1 = "PREV"
                    boolean r1 = r0.equals(r1)
                    if (r1 == 0) goto L_0x001f
                    r1 = 0
                    goto L_0x003f
                L_0x003e:
                    r1 = -1
                L_0x003f:
                    if (r1 == 0) goto L_0x0060
                    if (r1 == r4) goto L_0x004c
                    if (r1 == r3) goto L_0x0046
                    goto L_0x0066
                L_0x0046:
                    com.e.spy.AudioActivity r1 = com.e.spy.AudioActivity.this
                    r1.onTrackNext()
                    goto L_0x0066
                L_0x004c:
                    android.media.MediaPlayer r1 = com.e.spy.AudioActivity.mediaPlayer
                    boolean r1 = r1.isPlaying()
                    if (r1 == 0) goto L_0x005a
                    com.e.spy.AudioActivity r1 = com.e.spy.AudioActivity.this
                    r1.onTrackPause()
                    goto L_0x0066
                L_0x005a:
                    com.e.spy.AudioActivity r1 = com.e.spy.AudioActivity.this
                    r1.onTrackPlay()
                    goto L_0x0066
                L_0x0060:
                    com.e.spy.AudioActivity r1 = com.e.spy.AudioActivity.this
                    r1.onTrackPrev()
                L_0x0066:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.e.spy.AudioActivity.AnonymousClass5.onReceive(android.content.Context, android.content.Intent):void");
            }
        };
        registerReceiver(this.broadcastReceiver, new IntentFilter("JINU_NU"));
        startService(new Intent(this, OnClearFronCurrenService.class));
    }

    private void createChannel() {
        NotificationChannel channel = new NotificationChannel(SetNotification.CHANNEL_ID, "JINU", 2);
        notificationManager = (NotificationManager) getSystemService(NotificationManager.class);
        NotificationManager notificationManager2 = notificationManager;
        if (notificationManager2 != null) {
            notificationManager2.createNotificationChannel(channel);
        }
        SetNotification.createNotification(this, num1);
    }

    public void onTrackPrev() {
        SetNotification.createNotification(this, num1 - 1);
        num1 -= 2;
    }

    public void onTrackPlay() {
        SetNotification.createNotification(this, num1);
        mediaPlayer.start();
    }

    public void onTrackPause() {
        SetNotification.createNotification(this, num1);
        mediaPlayer.pause();
    }

    public void onTrackNext() {
        SetNotification.createNotification(this, num1 + 1);
    }

    public void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT >= 26) {
            notificationManager.cancelAll();
        }
        unregisterReceiver(this.broadcastReceiver);
    }

    public static ArrayList<MusicFiles> getAllAudio(Context context) {
        ArrayList<MusicFiles> tempAudioList = new ArrayList<>();
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor c = context.getContentResolver().query(uri, new String[]{"album", "title", "duration", "_data", "artist", "_id", "album_id"}, (String) null, (String[]) null, (String) null);
        if (c != null) {
            while (c.moveToNext()) {
                String album = c.getString(0);
                String title = c.getString(1);
                String duration = c.getString(2);
                String path = c.getString(3);
                String artist = c.getString(4);
                String str = path;
                String str2 = title;
                String str3 = artist;
                String str4 = album;
                String str5 = duration;
                tempAudioList.add(new MusicFiles(str, str2, str3, str4, str5, Long.valueOf(c.getLong(5)).longValue(), Long.valueOf(c.getLong(6)).longValue()));
            }
            c.close();
        }
        return tempAudioList;
    }

    public static ArrayList<MusicFiles> filterAudio(Context context) {
        ArrayList<MusicFiles> tempAudioList = new ArrayList<>();
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor c = context.getContentResolver().query(uri, new String[]{"album", "title", "duration", "_data", "artist", "_id", "album_id"}, (String) null, (String[]) null, (String) null);
        if (c != null) {
            while (c.moveToNext()) {
                String album = c.getString(0);
                String title = c.getString(1);
                String duration = c.getString(2);
                String path = c.getString(3);
                String artist = c.getString(4);
                Long id = Long.valueOf(c.getLong(5));
                String str = path;
                String str2 = title;
                String str3 = artist;
                String str4 = album;
                String str5 = duration;
                MusicFiles musicFiles2 = new MusicFiles(str, str2, str3, str4, str5, id.longValue(), Long.valueOf(c.getLong(6)).longValue());
                if (flist.contains(id.toString())) {
                    tempAudioList.add(musicFiles2);
                }
            }
            c.close();
        }
        return tempAudioList;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
    }
}
