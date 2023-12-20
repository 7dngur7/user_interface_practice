package com.foo.lab07;

import android.app.NotificationManager;
import android.app.RemoteInput;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.core.app.NotificationManagerCompat;

public class NotiReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String replyTxt =
                RemoteInput.getResultsFromIntent(intent).getCharSequence("message").toString();

        Log.d("kkang", "receiver...." + replyTxt);
    }
}