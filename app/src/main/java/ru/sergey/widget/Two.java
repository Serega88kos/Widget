package ru.sergey.widget;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.IBinder;
import android.text.InputType;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Locale;

public class Two extends Service implements View.OnClickListener {

    private EditText Tw1, Tw2, Tw3, Tw4, Th1, Th2, Th3, Th4;
    private TextView result;

    private WindowManager windowManager;
    private LinearLayout chatHead;
    private WindowManager.LayoutParams params;



    @SuppressLint({"ClickableViewAccessibility", "InflateParams"})
    @Override
    public void onCreate() {
        super.onCreate();
        Tw1.findViewById(R.id.w1);
        Tw2.findViewById(R.id.w2);
        Tw3.findViewById(R.id.w3);
        Tw4.findViewById(R.id.w4);
        Th1.findViewById(R.id.h1);
        Th2.findViewById(R.id.h2);
        Th3.findViewById(R.id.h3);
        Th4.findViewById(R.id.h4);
        result.findViewById(R.id.result);

        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            params = new WindowManager.LayoutParams(
                    WindowManager.LayoutParams.WRAP_CONTENT,
                    WindowManager.LayoutParams.WRAP_CONTENT,
                    WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                    WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                    PixelFormat.TRANSLUCENT);
        }
        else
            params = new WindowManager.LayoutParams(
                    WindowManager.LayoutParams.WRAP_CONTENT,
                    WindowManager.LayoutParams.WRAP_CONTENT,
                    WindowManager.LayoutParams.TYPE_PHONE,
                    WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                    PixelFormat.TRANSLUCENT);


        params.gravity = Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL;
        params.x = 100;
        params.y = 100;

        chatHead = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.float_layout, null);

        chatHead.setOnTouchListener(new View.OnTouchListener() {
            private int initialX;
            private int initialY;
            private float initialTouchX;
            private float initialTouchY;
            //           private boolean shouldClick;


            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        //                       shouldClick = true;
                        initialX = params.x;
                        initialY = params.y;
                        initialTouchX = event.getRawX();
                        initialTouchY = event.getRawY();
                        return true;
                    case MotionEvent.ACTION_UP:
//                        if(shouldClick)
                        v.performClick();
                        return true;
                    case MotionEvent.ACTION_MOVE:
                        //                       shouldClick = false;
                        params.x = initialX + (int) (event.getRawX() - initialTouchX);
                        params.y = initialY + (int) (event.getRawY() - initialTouchY);
                        windowManager.updateViewLayout(chatHead, params);
                        return true;
                }
                return false;
            }

        });

        windowManager.addView(chatHead, params);
        //      Intent intent = new Intent(this, flt.class);
        //      startActivity(intent);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (chatHead != null)
            windowManager.removeView(chatHead);
    }




    @Override
    public IBinder onBind(Intent intent) {return null;}

    @Override
    public void onClick(View v) {
        int w2, w3, w4, h2, h3, h4;
        double calc;

        if (TextUtils.isEmpty(Tw1.getText().toString()) ||
                TextUtils.isEmpty(Tw2.getText().toString()) ||
                TextUtils.isEmpty(Tw3.getText().toString()) ||
                TextUtils.isEmpty(Tw4.getText().toString()) ||
                TextUtils.isEmpty(Th1.getText().toString()) ||
                TextUtils.isEmpty(Th2.getText().toString()) ||
                TextUtils.isEmpty(Th3.getText().toString()) ||
                TextUtils.isEmpty(Th4.getText().toString())) {
            return;
        }

        w2 = Integer.parseInt(Tw2.getText().toString());
        Tw2.setInputType(InputType.TYPE_CLASS_NUMBER);
        w3 = Integer.parseInt(Tw3.getText().toString());
        Tw3.setInputType(InputType.TYPE_CLASS_NUMBER);
        w4 = Integer.parseInt(Tw4.getText().toString());
        Tw4.setInputType(InputType.TYPE_CLASS_NUMBER);
        h2 = Integer.parseInt(Th2.getText().toString());
        Th2.setInputType(InputType.TYPE_CLASS_NUMBER);
        h3 = Integer.parseInt(Th3.getText().toString());
        Th3.setInputType(InputType.TYPE_CLASS_NUMBER);
        h4 = Integer.parseInt(Th4.getText().toString());
        Th4.setInputType(InputType.TYPE_CLASS_NUMBER);

        calc = ((w2 + w3 + w4 + h2 + h3 + h4) / (double) 60)-2.51;
        result.setText(String.format(Locale.getDefault(),"%.0f", Math.floor(calc)));
    }
}
