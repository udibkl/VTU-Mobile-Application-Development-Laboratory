package com.example.callnsave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText num = findViewById(R.id.txt);
        Button call = findViewById(R.id.call);
        Button save = findViewById(R.id.save);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numberText = num.getText().toString();
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel"+numberText));
                startActivity(i);

            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numberText = num.getText().toString();
                Intent i = new Intent(Intent.ACTI);
            }
        });
    }
}