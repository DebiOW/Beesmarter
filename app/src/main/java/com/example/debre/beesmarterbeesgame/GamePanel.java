package com.example.debre.beesmarterbeesgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


import com.example.debre.beesmarterbeesgame.StartScreen.StartScreenAct;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Összeszegelte debre  4/30/2017-án.
 */

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback{
    private MainThread thread;
    private Map map;
    private DeathActivity deathActivity;
    private Controls controls;
    int screenWidth, screenHeight;
    Bitmap myBmp;
    public boolean dead = false;
    Bitmap myBmp1;
    Bitmap myBmp2;
    Bitmap myBmp3;
    Bitmap bee;
    Bitmap flower1;
    Bitmap flower2;
    Bitmap flower3;
    Bitmap frog;
    Bitmap frog2;
    Bee meh;
    private Frog beka;
    int bx,by;
    int jx,jy;
    int tick = 0;
    public static GamePanel gamePanel;


    List<Flower> flowers=new ArrayList<>();
    Random rnd = new Random();
    int r;
    int a;
    int score = 1;
    public float nyX,nyY;
    public GamePanel (Context context){
        super(context);
        getHolder().addCallback(this);
        setFocusable(true);
        gamePanel = this;
        thread= new MainThread(getHolder(),this);
        myBmp=BitmapFactory.decodeResource(context.getResources(),R.drawable.asd);
        myBmp1=BitmapFactory.decodeResource(context.getResources(),R.drawable.bigfixcircle);
        myBmp2=BitmapFactory.decodeResource(context.getResources(),R.drawable.littlecircle);
        myBmp3=BitmapFactory.decodeResource(context.getResources(),R.drawable.pause);
        bee = BitmapFactory.decodeResource(context.getResources(),R.drawable.bee);
        frog = BitmapFactory.decodeResource(context.getResources(),R.drawable.frog);
        frog2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.frog2);
       flower1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.flower1);
      flower2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.flower2);
        flower3= BitmapFactory.decodeResource(context.getResources(),R.drawable.flower3);







    }

    public void surfaceChanged(SurfaceHolder holder,int format,int width,int height) {
        myBmp=Bitmap.createScaledBitmap(myBmp,width*2,height*2,true);
        map=new Map(myBmp,width,height);
        myBmp1=Bitmap.createScaledBitmap(myBmp1,width/5,width/5,true);
        myBmp2=Bitmap.createScaledBitmap(myBmp2,width/9,width/9,true);
        controls=new Controls(myBmp1,myBmp2,myBmp3,width,height);
        beka = new Frog(5, 5, frog,frog2, width,height);
        screenHeight=height;
        screenWidth=width;
        bee=Bitmap.createScaledBitmap(bee,width/9,height/4,true);
        meh=new Bee(width/2,height/2,bee,width,height);



    }




    public void surfaceCreated(SurfaceHolder holder){
        thread.setrunning(true);
        thread.start();
    }



    public void surfaceDestroyed(SurfaceHolder holder){
        if (true){
            try {
                thread.setrunning(false);
                thread.join();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }



    public boolean onTouchEvent(MotionEvent event){

        a=event.getPointerCount();
            nyX = event.getX();
            nyY = event.getY();
        r=1;

        if (    event.getAction() == MotionEvent.ACTION_UP ||
                event.getAction() == MotionEvent.ACTION_POINTER_UP)

        {r=0;}
        return true;

    }



    public void update() throws InterruptedException {
        beka.newX = meh.x;
        beka.newY = meh.y;
        tick++;
        jx=controls.jx/5* StartScreenAct.startScreenAct.prog;
        jy=controls.jy/5* StartScreenAct.startScreenAct.prog;
        if (beka.x+frog.getWidth()>map.x+myBmp.getWidth()){
            beka.x=map.x+myBmp.getWidth()-frog.getWidth();
        }
        if (beka.x<map.x){
            beka.x=map.x;
        }


        if(dead){
            MainActivity.mainActivity.intent();
            thread.setrunning(false);


        }
        if(tick ==30){
            if (meh.x-beka.x>meh.y-beka.y) {
                if (meh.x - beka.x < 0) {
                    beka.vel = -5;
                } else {
                    beka.vel = 5;
                }
                beka.dir=0;
            }


            if (meh.x-beka.x<meh.y-beka.y) {
                if (meh.y - beka.y < 0) {
                    beka.vel = -5;
                } else {
                    beka.vel = 5;
                }
                beka.dir=1;
            }



        }

        if (tick>45&&tick<60){
            a-=1;
            beka.jump();
        }
        if(tick ==60){

            tick=0;
            beka.a=1;
            beka.vel=5;

        }





        controls.update();
        if (flowers.size()<10) {
            int vx,vy;
            vx=rnd.nextInt(map.x+myBmp.getWidth());
            vy=map.y+rnd.nextInt(myBmp.getHeight());
            if(rnd.nextInt(4) == 1){
                flowers.add(new Flower(vx,vy,vx-map.x,vy-map.y, flower1));
            } else if(rnd.nextInt(4) == 2){
                flowers.add(new Flower(vx,vy,vx-map.x,vy-map.y, flower2));
            } else {
                flowers.add(new Flower(vx,vy,vx-map.x,vy-map.y, flower3));
            }
        }
        if (r==1){
            controls.x=(int)nyX;
            controls.y=(int)nyY;
        }
        if (r==0){
            controls.x=-1;
            controls.y=-1;
        }

        if(meh.x-jx<screenWidth/2&&map.x==0
                || meh.x-jx>screenWidth/2&&map.x+myBmp.getWidth()==screenWidth) {
            meh.x = meh.x - jx;
        }else {
            map.x += jx;
            beka.x += jx;
        }

        for(int i=0;i<flowers.size();i++){
            Flower flowerx=flowers.get(i);
           if(meh.x + bee.getWidth() >= flowerx.x&&meh.x<= flowerx.x+flower1.getWidth()&&meh.y + bee.getHeight() >= flowerx.y&&meh.y<= flowerx.y+flower1.getHeight()) {
            score += 1;
            flowers.remove(i);





           }
        }


            for(int i=0;i<flowers.size();i++) {
                Flower flowerx = flowers.get(i);
                if (flowerx.x>map.x+myBmp.getWidth()||flowerx.y>map.y+myBmp.getHeight()||flowerx.x+flowerx.bmp.getWidth()<map.x||flowerx.y+flowerx.bmp.getHeight()<map.y) {
                    flowers.remove(i);
                    score++;


                }
            }


        if(meh.y-jy<screenHeight/2&&map.y==0
                ||meh.y-jy>screenHeight/2&&map.y+myBmp.getHeight()==screenHeight) {
            meh.y = meh.y - jy;
        }else {
            map.y += jy;
            beka.y += jy;
        }


        if (beka.x<map.x){
            beka.x=map.x;
        }
        if (beka.y<map.y){
            beka.y=map.y;
        }
        if (beka.x+beka.bmp.getWidth()>map.x+map.myBmp.getWidth()){
            beka.x=map.x+map.myBmp.getWidth()-beka.bmp.getWidth();
        }
        if (beka.y+beka.bmp.getHeight()>map.y+map.myBmp.getHeight()){
            beka.y=map.y+map.myBmp.getHeight()-beka.bmp.getHeight();
        }




        if(meh.x + bee.getWidth() >=beka.x&& meh.x<=beka.x+frog.getWidth()&&meh.y + bee.getHeight() >= beka.y&&meh.y<= beka.y+frog.getHeight()) {
            dead = true;




        }
        for(int i=0;i<flowers.size();i++){
            flowers.get(i).x=map.x+flowers.get(i).rx;
            flowers.get(i).y=map.y+flowers.get(i).ry;
        }
    }
    public void draw(Canvas canvas){
        super.draw(canvas);
        map.draw(canvas);

        for(int i=0;i<flowers.size();i++){
            flowers.get(i).render(canvas);
        }
        meh.render(canvas);
        controls.draw(canvas);
        beka.render(canvas);
//asd
    }
}
