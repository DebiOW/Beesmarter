package com.example.debre.beesmarterbeesgame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Log;

import java.util.Random;

/**
 * Created by ptmi on 5/1/17.
 */

public class Flower {
    float x ,y;
    Bitmap bmp;


    public Flower(float x, float y,Bitmap bmp){
        this.x = x;
        this.y = y;
        this.bmp=bmp;

    }

    public void render(Canvas canvas){


        canvas.drawBitmap(bmp,x,y,null);
        Log.v("asd", Float.toString(x));


    }


}
