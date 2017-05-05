package com.example.debre.beesmarterbeesgame;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by ptmi on 5/1/17.
 */

public class Frog {
    public float x = 40,y = 40;
    Bitmap bmp;
    Bitmap bmp2;
    int width, height;
    public static Frog frog;
    float newX, newY, dx, dy;
    int dir = 0;


    public Frog(float x, float y, Bitmap bmp, Bitmap bmp2, int width, int height){
        this.bmp=bmp;
        this.bmp2=bmp2;
        frog = this;
        this.x = x;
        this.y = y;
        this.width=width;
        this.height=height;


    }

    public void render(Canvas canvas){
        if(newX - x < x){
            canvas.drawBitmap(bmp2, x, y,null);
        } else {
            canvas.drawBitmap(bmp, x, y,null);
        }




    }


    public void jump(){
        if(newX - x > 0){
           if(newX - x <= height/2 && newY - y <= height/2){
              dx = newX;
              dy = newY;


    } else {
        dx = newX - height/3;
        dy = newY - height/3;

    }
} else {
    if(newX - x <= -(height/2) && newY - y <= -(height/2)){
        dx = -newX;
        dy = -newY;


    } else {
        dx = newX + height / 3;
        dy = newY + height / 3;
    }

}


        x = dx;
        y = dy;




    }





}
