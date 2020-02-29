package ru.sergey.widget;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class flt extends Activity implements View.OnClickListener {

    private EditText Tw1, Tw2, Tw3, Tw4, Th1, Th2, Th3, Th4;
    private TextView result;


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
        result = findViewById(R.id.result);
//        Button butRes = findViewById(R.id.butOK);
//        butRes.setOnClickListener(this);

    }

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
