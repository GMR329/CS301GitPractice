package com.example.surfaceview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Spot {

    //Instance Variables to represent a  circle
    private float cx;
    private float cy;
    private float radius;
    private Paint color;

    // ctor with a coordinate for parameters
    // Also may randomly pick a color
    public Spot(float cx, float cy){
        this.cx = cx;
        this.cy = cy;

        radius = 100;

        color = new Paint();

        int tmp = Color.rgb((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
        color.setColor(tmp);
    }

    // Know how to draw myself
    public void draw(Canvas canvas){
        canvas.drawCircle(cx, cy, radius, color);
    }

    public void setCx(float cx){

    }
}
