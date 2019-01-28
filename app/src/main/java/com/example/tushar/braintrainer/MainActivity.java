package com.example.tushar.braintrainer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.setContentView(R.layout.activity_main);

        Thread thread=new Thread(){
            public void run(){
                try{
                    sleep(3000);

                    Intent intent=new Intent(getBaseContext(),GameActivity.class);
                    startActivity(intent);
                    finish();
                }
                catch(Exception e){

                }
            }
        };
        thread.start();
    }
}
