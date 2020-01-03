package com.venu.smilykiddos;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity  {


    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp = MediaPlayer.create(this, R.raw.hg);

        SurfaceView sv = (SurfaceView) findViewById(R.id.surfaceView1);
        SurfaceHolder holder = sv.getHolder();
        holder.addCallback(new SurfaceHolder.Callback(){
            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) { }

            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                mp.setDisplay(holder);
                mp.start();
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) { }
        });

    }

    @Override
    protected void onPause(){
        super.onPause();

        if(null != mp) mp.release();
        mp = null;
    }
}
