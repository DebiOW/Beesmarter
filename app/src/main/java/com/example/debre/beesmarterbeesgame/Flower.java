package com.example.debre.beesmarterbeesgame;

import android.graphics.Canvas;
import android.util.Log;

import java.util.Random;

/**
 * Created by ptmi on 5/1/17.
 */

public class Flower {
    float x ,y;
    int width, height;
    GamePanel gamePanel;
    Controls controls;
    Random rnd = new Random();


    public Flower(float x, float y){
        this.x = x;
        this.y = y;

    }

    public void update(){





    }

    public void render(Canvas canvas){

      /*  int r = rnd.nextInt(4);
        if(r == 1){
            canvas.drawBitmap(gamePanel.flower1,x,y,null);
        } else if(r == 2){
            canvas.drawBitmap(gamePanel.flower2,x,y,null);
        } else {
            canvas.drawBitmap(gamePanel.flower3,x,y,null);
        }
*/
        canvas.drawBitmap(gamePanel.flower1,x,y,null);
        Log.v("asd", Float.toString(x));


    }


}
