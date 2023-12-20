package com.foo.lab05da;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }

    private float initX;

    public interface OnLeftSwipeListener {
        void onLeftSwipe(MyView view);
    }

    private OnLeftSwipeListener listener;

    public void setOnLeftSwipeListener(MyView.OnLeftSwipeListener listener) {
        this.listener = listener;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            initX = event.getRawX();
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            float diffX = initX - event.getRawX();
            if (diffX > 30) {
                // 왼쪽
                Log.d("CJW", "왼쪽으로 화면을 밀었습니다.");
                listener.onLeftSwipe(this);
            } else if (diffX < -30) {
                // 오른쪽
                Log.d("CJW", "오른쪽으로 화면을 밀었습니다.");
            }
        }

        return true;
    }
}
