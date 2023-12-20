package com.foo.alarm;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class AlarmReceiver extends BroadcastReceiver {

    private NotificationManagerCompat notificationManager;
    private final String CHANNEL_ID_2 = "CH2";

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "An alarm received!!", Toast.LENGTH_SHORT).show();
        Log.d("ALARM", "An alarm received!!");

        if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(context, "The notification can't be posted!!", Toast.LENGTH_SHORT).show();
            return;
        }

        notificationManager = NotificationManagerCompat.from(context);

        createNotificationChannel2();

        NotificationCompat.Builder builder = getNotificationBuilder(context);

        buildBasicNotification(context, builder);

        setHeadsUpNotification(builder);

        notificationManager.notify(222, builder.build());
    }

    // It's safe to call this repeatedly because creating an existing notification channel performs no operation.
    private void createNotificationChannel2() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelName = "My Channel Two";
            String channelDescription = "Description for My Channel Two";

            // 안드로이드 오레오 상위 버전에서 Heads Up 방식으로 알림을 띄우려면, IMPORTANCE_HIGH 로 설정해야 함
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID_2, channelName, NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription(channelDescription);

            notificationManager.createNotificationChannel(channel);
        }
    }

    private NotificationCompat.Builder getNotificationBuilder(Context context) {
        return new NotificationCompat.Builder(context, CHANNEL_ID_2);
    }

    private void buildBasicNotification(Context context, NotificationCompat.Builder builder) {
        Intent intent1 = new Intent(context, NotiActivity.class);
        PendingIntent pIntent1 = PendingIntent.getActivity(context, 10, intent1, PendingIntent.FLAG_IMMUTABLE);

        Bitmap largeIcon = BitmapFactory.decodeResource(context.getResources(), R.drawable.noti_large);

        // builder pattern
        builder.setSmallIcon(android.R.drawable.ic_notification_overlay)
                .setContentTitle("Content Title")
                .setContentText("Content Message")
                .setAutoCancel(true) // to automatically remove the notification when the user taps it.
                .setContentIntent(pIntent1)
                .setLargeIcon(largeIcon);
    }

    private void setHeadsUpNotification(NotificationCompat.Builder builder) {
        builder.setFullScreenIntent(builder.build().contentIntent, true);
    }
}