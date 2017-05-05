package com.example.debre.beesmarterbeesgame.StartScreen;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.debre.beesmarterbeesgame.GamePanel;
import com.example.debre.beesmarterbeesgame.MainActivity;
import com.example.debre.beesmarterbeesgame.R;
import com.example.debre.beesmarterbeesgame.SettingsActivity;

import java.util.Set;

public class StartScreenAct extends AppCompatActivity {

    SettingsActivity settingsActivity;
    public static StartScreenAct startScreenAct;
    public int prog=1;


    public StartScreenAct(){
        startScreenAct = this;



    }
    public int speed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_start_screen);

        int mUIFlag = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

        getWindow().getDecorView().setSystemUiVisibility(mUIFlag);

        ImageButton button = (ImageButton) findViewById(R.id.imageButton);
        ImageButton button1 = (ImageButton) findViewById(R.id.imageButton3);
        TextView textView=(TextView) findViewById(R.id.textView5);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            speed = extras.getInt(("speed"));
            //The key argument here must match that used in the other activity
        }
        textView.setText(Integer.toString(speed));


    button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    intent.putExtra("speed",speed);
                    overridePendingTransition(0, 0);
                    startActivity(intent);
                }
            });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StartScreenAct.this, SettingsActivity.class);
                startActivity(i);
            }
        });



    }
}
