package com.example.debre.beesmarterbeesgame;

import android.graphics.Canvas;

import com.example.debre.beesmarterbeesgame.ControlsFolder.Joystick;

/**
 * Created by ptmi on 5/1/17.
 */

public class Bee {
    Joystick joystick;
    public float x = 50,y = 50,newX,newY;
    GamePanel gamePanel;




    public Bee(float x, float y){
        this.x = x;
        this.y = y;

    }

    public void collision(){




    }
    public void update(){
        newX = x - joystick.outputX;
        newY = y - joystick.outputY;



    }



    public void render(Canvas canvas){
        canvas.drawBitmap(gamePanel.bee, newX, newY,null);



    }



}
