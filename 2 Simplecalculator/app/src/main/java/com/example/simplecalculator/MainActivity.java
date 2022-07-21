package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView result;
    EditText txt1,txt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result);
        Button clear = findViewById(R.id.clear);
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        Button plus = findViewById(R.id.add);
        Button sub = findViewById(R.id.sub);
        Button mul = findViewById(R.id.mul);
        Button div = findViewById(R.id.div);

        plus.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
String a= txt1.getText().toString();
String b=txt2.getText().toString();
        add(a,b);
    }
});

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a= txt1.getText().toString();
                String b=txt2.getText().toString();
                sub(a,b);
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a= txt1.getText().toString();
                String b=txt2.getText().toString();
                mul(a,b);
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a= txt1.getText().toString();
                String b=txt2.getText().toString();
                div(a,b);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               result.setText("");
            }
        });

    }

    public void add(String a,String b)
    {

result.setText("Ans:"+(Integer.parseInt(a)+Integer.parseInt(b)));
    }
    public void sub(String a,String b)
    {
        result.setText("Ans:"+(Integer.parseInt(a)-Integer.parseInt(b)));
    }
    public void mul(String a,String b)
    {
        result.setText("Ans:"+(Integer.parseInt(a)*Integer.parseInt(b)));
    }
    public void div(String a,String b)
    {
        int a1 = Integer.parseInt(a);
        int a2 = Integer.parseInt(b);
        float resultt= a1/a2;

        result.setText("Ans:"+resultt);

    }
}