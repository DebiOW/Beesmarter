package com.example.debre.beesmarterbeesgame.StartScreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.example.debre.beesmarterbeesgame.MainActivity;
import com.example.debre.beesmarterbeesgame.R;

public class StartScreenAct extends AppCompatActivity {

    public StartScreenAct(){

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_start_screen);
        ImageButton button = (ImageButton) findViewById(R.id.imageButton);
        button.setX(100);
        button.setY(100);

    button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    overridePendingTransition(0, 0);
                    startActivity(intent);
                }
            });


    }
}
