package com.example.clock_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import io.github.krtkush.lineartimer.LinearTimer;
import io.github.krtkush.lineartimer.LinearTimerView;

public class timer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

    }
    public void setValue(View v){


        EditText seconds=(EditText) findViewById(R.id.seconds);
        EditText minutes=(EditText) findViewById(R.id.minutes);
        EditText hours=(EditText) findViewById(R.id.hours);
        long timeinseconds=0;

        String toSeconds=seconds.getText().toString();
        String toMinutes=minutes.getText().toString();
        String toHours=hours.getText().toString();

        timeinseconds=Long.parseLong(toSeconds)+Long.parseLong(toHours)*3600+60*Long.parseLong(toMinutes);

        LinearTimerView linearTimerView = (LinearTimerView)
                findViewById(R.id.linearTimer);
        LinearTimer linearTimer = new LinearTimer.Builder()
                .linearTimerView(linearTimerView)
                .duration(timeinseconds * 1000)
                .build();

                linearTimer.startTimer();

        // Restart the timer.
        findViewById(R.id.restartTimer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearTimer.restartTimer();
            }
        });

// Pause the timer
        findViewById(R.id.pauseTimer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    linearTimer.pauseTimer();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                    Toast.makeText(timer.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

// Resume the timer
        findViewById(R.id.resumeTimer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    linearTimer.resumeTimer();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                    Toast.makeText(timer.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

// Reset the timer
        findViewById(R.id.resetTimer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    linearTimer.resetTimer();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                    Toast.makeText(timer.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}