package com.foo.multiplethreads;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

// https://developer.android.com/guide/components/services?hl=ko#java
public class UnboundedCountService extends Service {

    private Thread counter;

    public UnboundedCountService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        if (counter == null) {
            counter = new Thread(new Runnable() {
                @Override
                public void run() {
                    int count = 0;

                    Log.d("UnboundedCountService", Integer.toString(count));

                    while (true) {

                        try {
                            Thread.sleep(1000);
                            Log.d("UnboundedCountService", Integer.toString(++count));
                        } catch (InterruptedException e) { break; }

                    }
                }
            });

            counter.start();
        }

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        counter.interrupt();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}