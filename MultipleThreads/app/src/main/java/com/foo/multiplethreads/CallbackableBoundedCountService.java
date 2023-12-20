package com.foo.multiplethreads;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class CallbackableBoundedCountService extends Service {
    private final IBinder binder = new ServiceBinder();

    private Thread counter;

    private int count;

    private CallbackableServiceActivity.CountChangedListener countChangedListener;

    public CallbackableBoundedCountService() {
    }

    @Override
    public void onDestroy() {
        stopCounting();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (counter == null) {
            counter = new Thread(new Runnable() {
                @Override
                public void run() {
                    Log.d("CallbackableBoundedCountService", Integer.toString(count));
                    if (countChangedListener != null) countChangedListener.countChanged(count);

                    while (true) {

                        try {
                            Thread.sleep(1000);
                            Log.d("CallbackableBoundedCountService", Integer.toString(++count));
                            if (countChangedListener != null) countChangedListener.countChanged(count);
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

    void setOnCountChangedListener(CallbackableServiceActivity.CountChangedListener listener) {
        this.countChangedListener = listener;
    }

    void stopCounting() {
        if (counter != null) {
            counter.interrupt();
            counter = null;
            count = 0;
            if (countChangedListener != null) countChangedListener.countChanged(count);
        }
    }

    class ServiceBinder extends Binder {
        CallbackableBoundedCountService getService() {
            return CallbackableBoundedCountService.this;
        }
    }
}