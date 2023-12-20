package com.foo.multiplethreads;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

// https://developer.android.com/guide/components/bound-services?hl=ko#java
public class BoundedCountService extends Service {

    private final IBinder binder = new ServiceBinder();

    private Thread counter;

    private int count;

    public BoundedCountService() {}

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (counter == null) {
            counter = new Thread(new Runnable() {
                @Override
                public void run() {
                    Log.d("BoundedCountService", Integer.toString(count));

                    while (true) {

                        try {
                            Thread.sleep(1000);
                            Log.d("BoundedCountService", Integer.toString(++count));
                        } catch (InterruptedException e) {
                            break;
                        }

                    }
                }
            });

            counter.start();
        }

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        stopCounting();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    int getCurrentCount() {
        return count;
    }

    void stopCounting() {
        if (counter != null) {
            counter.interrupt();
            counter = null;
            count = 0;
        }
    }

    class ServiceBinder extends Binder {
        BoundedCountService getService() {
            return BoundedCountService.this;
        }
    }
}