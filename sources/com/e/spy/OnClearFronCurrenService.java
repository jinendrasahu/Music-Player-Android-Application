package com.e.spy;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class OnClearFronCurrenService extends Service {
    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        return 2;
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onTaskRemoved(Intent rootIntent) {
        stopSelf();
    }
}
