package com.example.debre.beesmarterbeesgame;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by ptmi on 5/1/17.
 */

public class Frog {
    public float x = 40,y = 40;
    Bitmap bmp;
    int width, height;

    public Frog(float x, float y, Bitmap bmp, int width, int height){
        this.bmp=bmp;
        this.x = x;
        this.y = y;
        this.width=width;
        this.height=height;


    }

    public void render(Canvas canvas){
        canvas.drawBitmap(bmp, x, y,null);



    }




}
