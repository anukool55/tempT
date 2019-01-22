package com.example.anukool.tempt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
static TextView t1;
static EditText e1;
Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     
        t1=(TextView) findViewById(R.id.t1);
        b1=(Button)findViewById(R.id.b1);
        e1=(EditText) findViewById(R.id.e1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //creating an object of background class
                BackGround b=new BackGround();
                b.execute();
            }
        });

    }







}
