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
    public int vel;
    public int velm;
    public int a=1;
    int dir = 0;


    public Frog(float x, float y, Bitmap bmp, Bitmap bmp2, int width, int height){
        this.bmp=bmp;
        this.bmp2=bmp2;
        frog = this;
        this.x = x;
        this.y = y;
        this.width=width;
        this.height=height;
        vel=width/70;
        velm=vel;

    }

    public void render(Canvas canvas){
        canvas.drawBitmap(bmp, x, y,null);



    }


    public void jump(){
        if(dir==0) {
            x -= vel * a;
        }
        if(dir==1) {
            x += vel * a;
        }
        if(dir==2) {
            y -= vel * a;
        }
        if(dir==3) {
            y += vel * a;
        }


//        if(newX - x > 0){
//           if(newX - x <= height/2 && newY - y <= height/2){
//              dx = newX;
//              dy = newY;
//
//
//    } else {
//        dx = newX - height/3;
//        dy = newY - height/3;
//
//    }
//} else {
//    if(newX - x <= -(height/2) && newY - y <= -(height/2)){
//        dx = -newX;
//        dy = -newY;
//
//
//    } else {
//        dx = newX + height / 3;
//        dy = newY + height / 3;
//    }
//
//}
//
//
//        x = dx;
//        y = dy;




    }





}
