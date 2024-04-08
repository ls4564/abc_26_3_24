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
    boolean b1,b2;
    Intent gi;
    double a,b,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculated_page);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        gi = getIntent();
        a = gi.getDoubleExtra("a",-1);
        b = gi.getDoubleExtra("b",-1);
        c = gi.getDoubleExtra("c",-1);

        x1 =  (-b + Math.sqrt(b*b -4*a*c))/2*a;
        x2 =  (-b - Math.sqrt(b*b -4*a*c))/2*a;
        tv2.setText(String.format("X: %.1f",x1));
        tv3.setText(String.format("X: %.1f",x2));
    }

    public void returned(View view)
    {
        st1 = String.valueOf(x1);
        st2 = String.valueOf(x2);

        if ((b*b +(-4*a*c)) > 0){
            gi.putExtra("X1",x1);
            b1 = true;
            b2 = true;
            gi.putExtra("X2",x2);
        }
        else if ((b*b +(-4*a*c)) == 0){
            b2 = true;
            gi.putExtra("X2",x2);
        }




        gi.putExtra("b1",b1);
        gi.putExtra("b2",b2);
        setResult(RESULT_OK,gi);
        finish();

    }
}