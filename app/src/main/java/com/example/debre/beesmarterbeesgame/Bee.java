package com.example.debre.beesmarterbeesgame;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.example.debre.beesmarterbeesgame.ControlsFolder.Joystick;

/**
 * Created by ptmi on 5/1/17.
 */

public class Bee {
    public float x = 50,y = 50;
    Bitmap bmp;



    public Bee(float x, float y, Bitmap bmp){
        this.bmp=bmp;
        this.x = x;
        this.y = y;

    }

    public void collision(){




    }




    public void render(Canvas canvas){
        canvas.drawBitmap(bmp, x, y,null);



    }



}
