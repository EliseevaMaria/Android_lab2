package com.example.eliseeva.lab1;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.SeekBar;


public class ColorPicker extends AppCompatActivity {

    RelativeLayout colorLayout;
    SeekBar redSeekBar, greenSeekBar, blueSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_picker);

        colorLayout = (RelativeLayout) findViewById(R.id.color);

        redSeekBar = (SeekBar) findViewById(R.id.seekBarR);
        greenSeekBar = (SeekBar) findViewById(R.id.seekBarG);
        blueSeekBar = (SeekBar) findViewById(R.id.seekBarB);

        redSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int color = ((ColorDrawable)colorLayout.getBackground()).getColor();

                int green = (color >> 8) & 0xFF;
                int blue = (color >> 0) & 0xFF;

                colorLayout.setBackgroundColor(Color.argb(255, progress, green, blue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        greenSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int color = ((ColorDrawable)colorLayout.getBackground()).getColor();

                int red = (color >> 16) & 0xFF;
                int blue = (color >> 0) & 0xFF;

                colorLayout.setBackgroundColor(Color.argb(255, red, progress, blue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        blueSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int color = ((ColorDrawable)colorLayout.getBackground()).getColor();

                int red = (color >> 16) & 0xFF;
                int green = (color >> 8) & 0xFF;

                colorLayout.setBackgroundColor(Color.argb(255, red, green, progress));
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
