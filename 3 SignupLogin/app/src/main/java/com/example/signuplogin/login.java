
package com.example.signuplogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
public int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText email = findViewById(R.id.lemail);
        EditText password = findViewById(R.id.lpassword);
        Button login = findViewById(R.id.loginbtn);
        String semail = getIntent().getStringExtra("mail");
        String spass = getIntent().getStringExtra("pass");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
if(semail.equals(email.getText().toString())&&spass.equals(password.getText().toString()))
                {
                    //login success
                    Intent i = new Intent(login.this,MainActivity2.class);
                    startActivity(i);
                }
else
{

    if(count>=3)
    {
        Toast.makeText(login.this, "Too many attempts!!!", Toast.LENGTH_SHORT).show();
        login.setEnabled(false);
    }
    else
    {
        count++;
        Toast.makeText(login.this, "Email/Password incorrect!!!", Toast.LENGTH_SHORT).show();
    }

}
            }
        });
    }

}