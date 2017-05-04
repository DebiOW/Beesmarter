package com.example.debre.beesmarterbeesgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.debre.beesmarterbeesgame.StartScreen.StartScreenAct;

public class SettingsActivity extends AppCompatActivity {

    SeekBar seekBar;
    public int speed;
    ImageButton button;
    public int prog = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setMax(10);
        button= (ImageButton) findViewById(R.id.imageButton4);




        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.v("asd", Integer.toString(progress));
                prog = progress;
                speed=prog;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SettingsActivity.this, StartScreenAct.class);
                i.putExtra("speed",speed);
                startActivity(i);
            }
        });




    }
}
