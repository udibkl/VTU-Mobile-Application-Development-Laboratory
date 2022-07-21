package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Handler customhandler= new Handler();
int i=0;
    TextView counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counter = findViewById(R.id.counter);
        Button start = findViewById(R.id.start);
        Button stop = findViewById(R.id.stop);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customhandler.postDelayed(timeThread,0);
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customhandler.removeCallbacks(timeThread);
            }
        });
    }
    private final Runnable timeThread = new Runnable() {
        @Override
        public void run() {

            counter.setText(""+i);
            customhandler.postDelayed(this,1000);
            i++;
        }
    };
}