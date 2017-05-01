package com.example.debre.beesmarterbeesgame.ControlsFolder;


import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Összeszegelte debre  4/30/2017-án.
 */

public class Joystick {
    Bitmap big;
    Bitmap little;
    int width, height;
    public float x,y;
    public float nyx,nyy;
    float lx,ly;
    public int outputX=0;
    public int outputY=0;

    public Joystick(Bitmap big, Bitmap little,int width,int height){
        this.big=big;
        this.little=little;
        this.width=width;
        this.height=height;
        lx=width-10-big.getWidth();
        ly=height-10-big.getWidth();

    }
    public void update(){
        x-=little.getWidth()/2;
        y-=little.getHeight()/2;
        if(nyx-little.getWidth()/2<0){
            nyx=lx+big.getWidth()/2;

        }
        if(nyy-little.getWidth()/2<0){
            nyy=ly+big.getWidth()/2;
        }
        if (x<width-10-big.getWidth()&&x+little.getWidth()/2+1>0){
            x=width-10-big.getWidth();
        }


        if (y<height-10-big.getHeight()&&y+little.getHeight()/2+1>0){
            y=height-10-big.getHeight();
        }


        if (x<0&&y<0){
            x=lx-little.getWidth()/2+big.getWidth()/2;
            y=ly-little.getHeight()/2+big.getHeight()/2;
        }
        if(nyx>0) {
            outputX=(int)lx+big.getWidth()/2-(int)nyx;
        }
        if(nyy>0) {
            outputY=height-10-big.getHeight()/2-(int)nyy;
        }
    }
    public void draw(Canvas canvas){

        canvas.drawBitmap(big,lx,ly,null);
        canvas.drawBitmap(little,x,y,null);
    }

}
