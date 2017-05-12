package com.example.debre.beesmarterbeesgame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.media.MediaPlayer;

/**
 * Created by ptmi on 5/1/17.
 */

public class Bee/*Smarter*/ { // pluszpont helye: _________
    public float x = 50,y = 50;
    Bitmap bmp;
    int width, height;
    public static Bee bee;




    public Bee(float x, float y, Bitmap bmp, int width, int height){
        bee = this;
        this.bmp=bmp;
        this.x = x;
        this.y = y;
        this.width=width;
        this.height=height;

    }





    public void render(Canvas canvas){
        if (x<0){
            x=0;
        }
        if (x+bmp.getWidth()>width){
            x=width-bmp.getWidth();
        }
        if (y<0){
            y=0;
        }
        if (y+bmp.getHeight()>height){
            y=height-bmp.getHeight();
        }
        canvas.drawBitmap(bmp, x, y,null);



    }



}
