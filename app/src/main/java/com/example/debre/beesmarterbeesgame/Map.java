package com.example.debre.beesmarterbeesgame;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Összeszegelte debre  4/30/2017-án.
 */

public class Map {
    Bitmap myBmp;
    int x,y=0;
    int width,height;
    public Map (Bitmap myBmp,int width, int height){
        this.myBmp=myBmp;
        this.height=height;
        this.width=width;
    }
    public void draw(Canvas canvas){

        if (x+myBmp.getWidth()<width){
            x=width-myBmp.getWidth();
        }

        if (x>0){
            x=0;
        }

        if (y+myBmp.getHeight()<height){
            y=height-myBmp.getHeight();
        }

        if (y>0){
            y=0;
        }




        canvas.drawBitmap(myBmp,x,y,null);
    }
}
