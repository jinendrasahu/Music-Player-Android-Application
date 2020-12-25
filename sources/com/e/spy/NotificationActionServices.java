package com.e.spy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class NotificationActionServices extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        context.sendBroadcast(new Intent("JINU_NU").putExtra("actionnae", intent.getAction()));
    }
}
