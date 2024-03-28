package com.example.abc_26_3_24;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.lang.Math;

import androidx.appcompat.app.AppCompatActivity;

public class Calculated_page extends AppCompatActivity {
    TextView tv2,tv3;
    double x1,x2;
    String st1,st2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculated_page);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        Intent gi = getIntent();
        double a = gi.getDoubleExtra("a",-1);
        double b = gi.getDoubleExtra("b",-1);
        double c = gi.getDoubleExtra("c",-1);

        x1 =  (-b + Math.sqrt(b*b -4*a*c))/2*a;
        x2 =  (-b - Math.sqrt(b*b -4*a*c))/2*a;
        tv2.setText("X2: "+x2);
        tv3.setText("X1: "+x1);

    }

    public void ret(View view, Intent gi)
    {
        st1 = String.valueOf(x1);
        st1 = String.valueOf(x2);
        if(!st1.equals("NaN"))
        {
            gi.putExtra("X1",x1);
        }
        if(st2.equals("NaN"))
        {
            gi.putExtra("X2",x2);
        }
        setResult(RESULT_OK,gi);
        finish();
    }
}