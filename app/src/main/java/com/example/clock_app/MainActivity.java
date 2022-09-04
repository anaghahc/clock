package com.example.clock_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button1,button2,button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1=(Button) findViewById(R.id.button4);
        button2=(Button) findViewById(R.id.button2);
        button3=(Button) findViewById(R.id.stop_watch);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity3();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity4();
            }
        });
    }


    public void openActivity2(){
        Intent intent=new Intent(this, World_Clock.class);
        startActivity(intent);
    }
    public void openActivity3(){
        Intent intent=new Intent(this, timer.class);
        startActivity(intent);
    }
    public void openActivity4(){
        Intent intent=new Intent(this, stop_watch.class);
        startActivity(intent);
    }
}