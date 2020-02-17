package ru.sergey.widget;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class flt extends Activity implements View.OnClickListener {

    private WindowManager windowManager;
    private LinearLayout chatHead;
    private WindowManager.LayoutParams params;

    private EditText Tw1, Tw2, Tw3, Tw4, Th1, Th2, Th3, Th4;
    private TextView minlvl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Tw1 = findViewById(R.id.w1);
        Tw2 = findViewById(R.id.w2);
        Tw3 = findViewById(R.id.w3);
        Tw4 = findViewById(R.id.w4);
        Th1 = findViewById(R.id.h1);
        Th2 = findViewById(R.id.h2);
        Th3 = findViewById(R.id.h3);
        Th4 = findViewById(R.id.h4);
        minlvl = findViewById(R.id.minlvl);
        Button butRes = findViewById(R.id.butRes);
        butRes.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int w2, w3, w4, h2, h3, h4;
        double calc;
        double mincalc;

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
        w3 = Integer.parseInt(Tw3.getText().toString());
        w4 = Integer.parseInt(Tw4.getText().toString());
        h2 = Integer.parseInt(Th2.getText().toString());
        h3 = Integer.parseInt(Th3.getText().toString());
        h4 = Integer.parseInt(Th4.getText().toString());

        calc = (w2 + w3 + w4 + h2 + h3 + h4) / (double) 60;
        mincalc = calc - 2.51;
        minlvl.setText(String.format("%.0f", Math.floor(mincalc)));
    }
}
