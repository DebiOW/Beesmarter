package com.example.debre.beesmarterbeesgame;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

/**
 * Összeszegelte debre  4/30/2017-án.
 */

public class MainThread extends Thread {
    public static final int max_fps=30;
    private double avgfps;
    private SurfaceHolder holder;
    private GamePanel gamePanel;
    private MainActivity mainActivity;
    private boolean running;
    public static Canvas canvas;

    public void setrunning(boolean running){
        this.running=running;

    }


    public MainThread(SurfaceHolder holder,GamePanel gamePanel){
        super();
        this.holder= holder;
        this.gamePanel=gamePanel;

    }
    @Override
    public void run(){
        long Startime;
        long timeMillis=1000/max_fps;
        long waittime;
        int framecount=0;
        long totaltime=0;
        long targettime=1000/max_fps;


        while (running){
            canvas=null;

            try{
                canvas=this.holder.lockCanvas();
                synchronized (holder){

                    this.gamePanel.update();
                    this.gamePanel.draw(canvas);
                    mainActivity.update();


                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                if (canvas!=null){
                    try{
                        holder.unlockCanvasAndPost(canvas);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                Startime= System.nanoTime();
                timeMillis=(System.nanoTime()-Startime)/1000000;
                waittime=targettime-timeMillis;
            }
            try{
                if (waittime>0){
                    this.sleep(waittime);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            totaltime= System.nanoTime()-Startime;
            framecount++;
            if(framecount==max_fps){
                avgfps=(totaltime*1/1000)*1/1000;
                avgfps=1000/avgfps;
                framecount=0;
                totaltime=0;

            }
        }
    }
}
