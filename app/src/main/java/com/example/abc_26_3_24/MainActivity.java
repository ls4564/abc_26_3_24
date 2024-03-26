package com.example.abc_26_3_24;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText eD1,eD2,eD3;
    Button randBtn,btn1;
    TextView tv1;
    Random rand = new Random();
    int rand_num;
    String st1,st2,st3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eD1 = findViewById(R.id.eD1);
        eD2 = findViewById(R.id.eD2);
        eD3 = findViewById(R.id.eD3);
        randBtn = findViewById(R.id.randBtn);
        btn1 = findViewById(R.id.btn1);
        tv1 = findViewById(R.id.tv1);


    }

    public void rand(View view) {
        st1 = eD1.getText().toString();
        st2 = eD2.getText().toString();
        st3 = eD3.getText().toString();
        if (st1.isEmpty()) {
            rand_num  = rand.nextInt(41)-20;
            eD1.setText("" + rand_num);
        }
        if (st2.isEmpty() && !st1.isEmpty()) {
            rand_num  = rand.nextInt(41)-20;
            eD2.setText("" + rand_num);
        }
        if (st3.isEmpty() && !st2.isEmpty() && !st1.isEmpty())
        {
            rand_num  = rand.nextInt(41)-20;
            eD3.setText("" + rand_num);
        }
    }
}