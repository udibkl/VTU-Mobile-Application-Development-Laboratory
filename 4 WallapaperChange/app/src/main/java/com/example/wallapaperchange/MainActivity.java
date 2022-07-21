package com.example.wallapaperchange;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.Timer;
import java.util.*;

public class MainActivity extends AppCompatActivity {
//5 declarations
    Timer mytimer;
    WallpaperManager wpm;
    int prev=1;
    Drawable drawable;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.button);

        mytimer=new Timer();
        wpm=WallpaperManager.getInstance(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                wallChange();
            }

        });


        }
        private void wallChange()
        {
      mytimer.schedule(new TimerTask() {
          @Override
          public void run() {
              if(prev==1)
              {
                  drawable=getResources().getDrawable(R.drawable.one);
                  prev=2;
              }
              else if(prev==2)
              {
                  drawable=getResources().getDrawable(R.drawable.two);
                  prev=3;
              }
             else if(prev==3)
              {
                  //add image and change filename
                  drawable=getResources().getDrawable(R.drawable.one);
                  prev=4;
              }
             else if(prev==4)
              {
                  //add image and change filename
                  drawable=getResources().getDrawable(R.drawable.two);
                  prev=5;
              }
              else if(prev==5)
              {
                  //add image and change filename
                  drawable=getResources().getDrawable(R.drawable.one);
                  prev=1;
              }
              Bitmap wallpaper = ((BitmapDrawable)drawable).getBitmap();
              try {
                  wpm.setBitmap(wallpaper);
              } catch (IOException e) {
                  e.printStackTrace();
              }

          }
      },0,30000);

    }

}