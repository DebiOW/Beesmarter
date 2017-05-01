package com.example.debre.beesmarterbeesgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Összeszegelte debre  4/30/2017-án.
 */

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback{
    private MainThread thread;
    private Map map;
    private Controls controls;
    Bitmap myBmp;
    Bitmap myBmp1;
    Bitmap myBmp2;
    Bitmap myBmp3;
    Bitmap bee;
    Bee meh;
    int r;
    int a;
    public float nyX,nyY;
    public GamePanel (Context context){
        super(context);
        getHolder().addCallback(this);
        setFocusable(true);
        thread= new MainThread(getHolder(),this);
        myBmp=BitmapFactory.decodeResource(context.getResources(),R.drawable.asd);
        myBmp1=BitmapFactory.decodeResource(context.getResources(),R.drawable.bigfixcircle);
        myBmp2=BitmapFactory.decodeResource(context.getResources(),R.drawable.littlecircle);
        myBmp3=BitmapFactory.decodeResource(context.getResources(),R.drawable.pause);
        bee = BitmapFactory.decodeResource(context.getResources(),R.drawable.bee);


    }

    public void surfaceChanged(SurfaceHolder holder,int format,int width,int height) {
        myBmp=Bitmap.createScaledBitmap(myBmp,width*2,height*2,true);
        map=new Map(myBmp,width,height);
        myBmp1=Bitmap.createScaledBitmap(myBmp1,width/5,width/5,true);
        myBmp2=Bitmap.createScaledBitmap(myBmp2,width/9,width/9,true);
        controls=new Controls(myBmp1,myBmp2,myBmp3,width,height);
        meh=new Bee(width/2,height/2,bee);
    }




    public void surfaceCreated(SurfaceHolder holder){
        thread.setrunning(true);
        thread.start();
    }



    public void surfaceDestroyed(SurfaceHolder holder){
        boolean retry=true;
        while (true){
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



    public void update(){

        controls.update();
        if (r==1){
            controls.x=(int)nyX;
            controls.y=(int)nyY;
        }
        if (r==0){
            controls.x=-1;
            controls.y=-1;
        }
        map.x+=controls.jx;
        map.y+=controls.jy;
        meh.x = meh.x - controls.jx;
        meh.y = meh.y - controls.jy;
    }
    public void draw(Canvas canvas){
        super.draw(canvas);
        map.draw(canvas);
        meh.render(canvas);
        controls.draw(canvas);
    }
}
