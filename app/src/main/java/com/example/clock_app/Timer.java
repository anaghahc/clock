package com.example.clock_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Timer extends AppCompatActivity {
    TextView textView;
    Button button;
    EditText enterTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

//        textView = findViewById(R.id.text_view);
        button = (Button) findViewById(R.id.button3);
        enterTime = (EditText) findViewById(R.id.editTextTime);
//        String myEditValue = enterTime.getText().toString();

       // button.setOnClickListener(new View.OnClickListener() {
          //  @Override

            //public void onClick(View view) {
                //int value = Integer.parseInt(enterTime.getText().toString());
                long duration = TimeUnit.MINUTES.toMillis(1);
                new CountDownTimer(duration, 1000) {
                    //int second = value*60;
                    //int second=60;
                    @Override
                    public void onTick(long l) {

                        String sDuration = String.format((Locale.ENGLISH), "%02d : %02d", 0, 0);
                        textView.setText(sDuration);

                    }

                    @Override
                    public void onFinish() {
                        textView.setVisibility(View.GONE);
                        Toast.makeText(getApplicationContext(), "Timer has ended", Toast.LENGTH_LONG).show();
                    }
                }.start();
            //}
        };


    }
