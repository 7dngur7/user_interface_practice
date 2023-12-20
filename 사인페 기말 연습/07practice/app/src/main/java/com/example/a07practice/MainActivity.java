package com.example.a07practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.example.a07practice.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());



        binding.bigPicture.setOnClickListener(this);
        binding.progress.setOnClickListener(this);
        binding.message.setOnClickListener(this);
        binding.remote.setOnClickListener(this);
        createNotificationChannel();
    }
    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library

    }


    @Override
    public void onClick(View view) {
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        NotificationCompat.Builder builder = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "my channel";
            String description ="my chennel description";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("my channel Id", name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            notificationManager.createNotificationChannel(channel);
             builder = new NotificationCompat.Builder(this,"my channel Id" );

        }

                builder.setSmallIcon(android.R.drawable.ic_notification_overlay);
                builder.setContentTitle("My notification");
                builder.setContentText("Hello World!");
                builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
                // Set the intent that will fire when the user taps the notification
                builder.setAutoCancel(true);
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_foreground);
            builder.setLargeIcon(bitmap);

            if(view == binding.bigPicture){
//                NotificationCompat.BigPictureStyle
            }
            else if(view == binding.remote){
                private static final String KEY_TEXT_REPLY = "key_text_reply";

                String replyLabel = getResources().getString(R.string.reply_label);
                RemoteInput remoteInput = new RemoteInput.Builder(KEY_TEXT_REPLY)
                        .setLabel(replyLabel)
                        .build();
            }

    }
}