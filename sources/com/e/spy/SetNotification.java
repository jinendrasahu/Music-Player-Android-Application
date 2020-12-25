package com.e.spy;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.media.app.NotificationCompat;

public class SetNotification {
    public static final String ACTION_NEXT = "next";
    public static final String ACTION_PLAY = "play";
    public static final String ACTION_PREX = "PREV";
    public static final String CHANNEL_ID = "channel1";
    public static Notification notification;

    public static void createNotification(Context context, int num) {
        PendingIntent pendingIntentPrev;
        int drw_prev;
        int drw_next;
        PendingIntent pendingIntentNext;
        Context context2 = context;
        int i = num;
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
            MediaSessionCompat mediaSessionCompat = new MediaSessionCompat(context2, "tag");
            Bitmap icon = BitmapFactory.decodeResource(context.getResources(), R.drawable.pic1);
            if (i == 0) {
                pendingIntentPrev = null;
                drw_prev = 0;
            } else {
                pendingIntentPrev = PendingIntent.getBroadcast(context2, 0, new Intent(context2, NotificationActionServices.class).setAction(ACTION_PREX), 134217728);
                drw_prev = R.drawable.ic_prev;
            }
            PendingIntent pendingIntentPlay = PendingIntent.getBroadcast(context2, 0, new Intent(context2, NotificationActionServices.class).setAction(ACTION_PLAY), 134217728);
            if (AudioActivity.musicFiles.size() - 1 == i) {
                pendingIntentNext = null;
                drw_next = 0;
            } else {
                pendingIntentNext = PendingIntent.getBroadcast(context2, 0, new Intent(context2, NotificationActionServices.class).setAction(ACTION_NEXT), 134217728);
                drw_next = R.drawable.ic_next;
            }
            notification = new NotificationCompat.Builder(context2, CHANNEL_ID).setSmallIcon(R.drawable.ic_head).setContentTitle(AudioActivity.musicFiles.get(i).getTitle()).setContentText(AudioActivity.musicFiles.get(i).getArtist()).setLargeIcon(icon).setOnlyAlertOnce(true).setShowWhen(false).addAction(drw_prev, "Previous", pendingIntentPrev).addAction(R.drawable.ic_play, "Play", pendingIntentPlay).addAction(drw_next, "Next", pendingIntentNext).setStyle(new NotificationCompat.MediaStyle().setShowActionsInCompactView(0, 1, 2).setMediaSession(mediaSessionCompat.getSessionToken())).setPriority(-1).build();
            notificationManagerCompat.notify(1, notification);
        }
    }
}
