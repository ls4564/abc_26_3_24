package com.example.abc_26_3_24;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 69;
    EditText eD1,eD2,eD3;
    Button randBtn,btn1;
    TextView tv1,tv4;
    Random rand = new Random();
    int rand_num;
    double a,b,c;
    double ans1,ans2;
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
        tv4 = findViewById(R.id.tv4);


    }
    protected void onActivityResult(int source, int result, @Nullable Intent data_back){
        super.onActivityResult(source, result, data_back);
        if (source == REQUEST_CODE) {
            if (result == Activity.RESULT_OK) {
                if (data_back != null) {
                    ans1 = data_back.getDoubleExtra("X1", -1);
                    ans2 = data_back.getDoubleExtra("X2", -1);
                    tv1.setText("X1" +  ans1);
                    tv4.setText("X1" +  ans2);
                }
            }
        }
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

    public void Calculated(View view) {
        st1 = eD1.getText().toString();
        st2 = eD2.getText().toString();
        st3 = eD3.getText().toString();
        if(!st3.isEmpty() && !st2.isEmpty() && !st1.isEmpty())
        {
            a = Double.parseDouble(st1);
            b = Double.parseDouble(st2);
            c = Double.parseDouble(st3);
            Intent si = new Intent(this, Calculated_page.class);
            si.putExtra("a",a);
            si.putExtra("b",b);
            si.putExtra("c",c);
            startActivityForResult(si,REQUEST_CODE);
        }
        else
        {
            Toast.makeText(this, "Enter in all a b c", Toast.LENGTH_SHORT);
        }
    }
}