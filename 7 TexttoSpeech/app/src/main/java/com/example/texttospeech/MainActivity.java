package com.example.texttospeech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
EditText txt;
TextToSpeech t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
  txt = findViewById(R.id.txt);
  t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
      @Override
      public void onInit(int i) {
          if(i!=TextToSpeech.ERROR)
          {
              t1.setLanguage(Locale.UK);
          }
      }
  });

    }
public void convert(View view)
{
    String s1= txt.getText().toString();
    t1.speak(s1,TextToSpeech.QUEUE_FLUSH,null);
}



}