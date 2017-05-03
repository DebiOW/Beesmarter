package com.example.debre.beesmarterbeesgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;

import com.example.debre.beesmarterbeesgame.StartScreen.StartScreenAct;

public class SettingsActivity extends AppCompatActivity {

    SeekBar seekBar;
    GamePanel gamePanel;
    int prog = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setMax(10);




        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.v("asd", Integer.toString(progress));
                prog = progress;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });





    }
}
