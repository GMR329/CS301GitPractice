package com.example.surfaceview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.SurfaceView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    //focus on memorizing
    //1) findViewById(R.id.something)
    //2) linking to listeners

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MySurfaceView theView = (MySurfaceView) findViewById(R.id.surfaceView);

        SeekBar mySeekBar = (SeekBar) findViewById(R.id.seekBar);

        // The view needs to know where the seekbar is to appropriately size the circle

        mySeekBar.setOnSeekBarChangeListener(theView);

//        theView.setOnTouchListener(theView);

    }
}