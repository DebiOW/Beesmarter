package com.example.debre.beesmarterbeesgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;


public class MainActivity extends AppCompatActivity {

    public static MainActivity mainActivity;
    Intent i;
    GamePanel gamePanel;
    public int speed;
    DeathActivity deathActivity;

    public MainActivity(){
        mainActivity=this;


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        i = new Intent(MainActivity.this, DeathActivity.class);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            speed = extras.getInt(("speed"));
            //The key argument here must match that used in the other activity
        }
        setContentView(new GamePanel(this));


        int mUIFlag = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

        getWindow().getDecorView().setSystemUiVisibility(mUIFlag);




    }
    public void intent(){
        i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        overridePendingTransition(0, 0);
        startActivity(i);
        finish();


    }

    @Override
    protected void onPause() {
        super.onPause();
        GamePanel.gamePanel.song.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        GamePanel.gamePanel.song.start();
    }
}
