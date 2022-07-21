package com.example.exp1visitingcard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txt= findViewById(R.id.textView2);
        //write your desired details...
        txt.setText("Name: Someone \n Phone: 1510254\n Address: Somewhere in the world :)");
    }
}