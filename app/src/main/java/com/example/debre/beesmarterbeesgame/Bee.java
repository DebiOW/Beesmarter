package com.example.debre.beesmarterbeesgame;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by ptmi on 5/1/17.
 */

public class Bee {
    public float x = 50,y = 50;
    Bitmap bmp;
    int width, height;



    public Bee(float x, float y, Bitmap bmp, int width, int height){
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
