package com.example.surfaceview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MySurfaceView extends SurfaceView
        implements SeekBar.OnSeekBarChangeListener, View.OnTouchListener {

    private float radius;
    // 1 NEED a way to remember each spot to draw (each circle)
    // Have a spot class

    // 2 Need an arraylist (or array) to hold all of the spots
    private ArrayList<Spot> spots;

    public MySurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);

        spots = new ArrayList<>();
//        spots.add(new Spot(50, 50));

        setOnTouchListener(this);

        // VERY CRITICAL
        setWillNotDraw(false); //not, not draw. Should draw something.

        radius = 100.f;
    }

    protected void onDraw(Canvas canvas){

        // Draw each spot from spots
        for(Spot spot : spots){
            spot.draw(canvas);
        }

        //Threading: Trying to run multiple things at the same time
        //Must be on worrying about user and their input
        //Must be other threads that aren't sitting there waiting for the user
        //Needs to display data, etc.
        //This is why draw shouldn't be overridden. Implement on functions because
        //they link into automatic threading

        /**
        Paint red = new Paint();
        red.setColor(Color.RED);
        canvas.drawCircle(100.0f, 100.0f, radius, red);

        /** draw a shaka
        Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.shakas);

        Paint black = new Paint();
        black.setColor(Color.BLACK);
        canvas.drawBitmap(image, 150.f, 250.f, black);
         */
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        radius = progress;
        invalidate(); // The current render is now invalid, please call draw soon
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {}

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {}

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        if(event.getActionMasked() == MotionEvent.ACTION_DOWN){
            // 0 find the coordinate of the touch event
            float x = event.getX();
            float y = event.getY();
            // 1 create a spot
            Spot newSpot = new Spot(x, y);
            // 2 add spot to spots ArrayList
            spots.add(newSpot);
            // 3 Let myself know that  should draw the new spot
            invalidate();
        }


        return true;
    }
}
