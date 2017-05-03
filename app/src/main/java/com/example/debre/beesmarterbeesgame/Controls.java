package com.example.debre.beesmarterbeesgame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.debre.beesmarterbeesgame.ControlsFolder.Joystick;

import java.util.Random;

/**
 * Összeszegelte debre  4/30/2017-án.
 */

class Controls {
    Bitmap cb1;
    Bitmap cb2;
    Bitmap stop;
    Random rnd = new Random();
    Flower flower;
    int width,height;
    int x,y;
    int jx,jy;
    private Joystick joystick;
    private Map map;
    Paint paint= new Paint();
    public Controls(Bitmap cb1,Bitmap cb2, Bitmap stop, int width, int height){
        this.cb1=cb1;
        this.cb2=cb2;
        this.stop=stop;
        this.width=width;
        this.height=height;
        joystick= new Joystick(cb1,cb2,width,height);

    }
    public void update(){
        joystick.x=x;
        joystick.y=y;
        joystick.update();
        jx=joystick.outputX;
        jy=joystick.outputY;
        joystick.nyx=x;
        joystick.nyy=y;

    }
    public void draw(Canvas canvas){
        joystick.draw(canvas);
        paint.setColor(255);
    }
}
