package com.example.signuplogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText email = findViewById(R.id.lemail);
        EditText password = findViewById(R.id.lpassword);
        Button signup = findViewById(R.id.loginbtn);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = email.getText().toString();
                String pass = password.getText().toString();
                if (validateEmail(pass)) {
                    Intent intent = new Intent(MainActivity.this, login.class);
                    intent.putExtra("mail", mail);
                    intent.putExtra("pass", pass);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a valid password!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    Pattern lowercase = Pattern.compile("^.*[a-z].*$");
    Pattern uppercase = Pattern.compile("^.*[A-Z].*$");
    Pattern number = Pattern.compile("^.*[0-9].*$");
    Pattern special = Pattern.compile("^.*[a-zA-Z0-9].*$");

    private boolean validateEmail(String pass) {
        if (pass.length() < 8) {
            return false;

        }
        if (!lowercase.matcher(pass).matches()) {
            return false;
        }
        if (!uppercase.matcher(pass).matches()) {
            return false;
        }
        if (!number.matcher(pass).matches()) {
            return false;
        }
        if (!special.matcher(pass).matches()) {
            return false;
        }
        return true;

    }
}