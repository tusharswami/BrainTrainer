package com.example.tushar.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {
TextView timer, countdown,expression;
pl.droidsonroids.gif.GifTextView gifTextView;
pl.droidsonroids.gif.GifTextView timergif;
Button play, replay;
Button one,two,three,four;
int num1,num2,operator,result;
int buttonval;
ImageView score;
String exp;
String reward;
int total, correct=0;
int resultin;
    StringBuilder builder=new StringBuilder();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.setContentView(R.layout.activity_game);
        timer=findViewById(R.id.countdown);
        gifTextView=findViewById(R.id.playgif);
        gifTextView.setVisibility(View.VISIBLE);
        play=findViewById(R.id.play);
        play.setVisibility(View.VISIBLE);
        expression=findViewById(R.id.expression);


    }

    public void generate(){

        StringBuilder stringBuilder=new StringBuilder();

        num1 = (int)(Math.random()*32) + 1;
        num2 = (int)(Math.random()*32) + 1;
        stringBuilder.append(String.valueOf(num1));
        operator = new Random().nextInt(5);
        if(operator<=0){
            operator=1;
        }
        else if(operator>=5){
            operator=1;
        }
        if (operator == 1) {
            stringBuilder.append(" + ");
            result = num1 + num2;
        } else if (operator == 2) {
            stringBuilder.append(" - ");
            result = num1 - num2;
        } else if (operator == 3) {
            stringBuilder.append(" x ");
            result = num1 * num2;
        } else if (operator == 4) {
            Log.i("data",Integer.toString(num1) +" "+ num2);

            if(num1==num2){
                result=1;
            }
            else if(num1<num2){
                int temp=num1;
                num1=num2;
                num2=temp;
                result = num1 / num2;
            }
            stringBuilder.append(" / ");
            Log.i("data",Integer.toString(num1) +" "+ num2);


        }

        stringBuilder.append(String.valueOf(num2));
        exp=stringBuilder.append("").toString(); //String to display &&
        //Final result to be equated in result variable
        expression.setText(exp);


    }

    public void setButtonText(){

        buttonval = new Random().nextInt(5);
        int num3 = (int)(Math.random()*12) + 1;
        if(buttonval<=0){
            buttonval=1;
        }
        else if(buttonval>=5){
            buttonval=1;
        }

        if (buttonval == 1) {
            one=findViewById(R.id.one);
            one.setText(Integer.toString(result));
            two.setText(Integer.toString(result+num3+9));
            three.setText(Integer.toString(result*num3-2));
            four.setText(Integer.toString(result-num3));
            resultin=1;

        } else if (buttonval == 2) {
            two=findViewById(R.id.two);
            two.setText(Integer.toString(result));
            one.setText(Integer.toString(result*num3-2));
            three.setText(Integer.toString(result+num3+9));
            four.setText(Integer.toString(result-num3));
            resultin=2;
        } else if (buttonval == 3) {
            three=findViewById(R.id.three);
            three.setText(Integer.toString(result));
            one.setText(Integer.toString(result*num3-2));
            two.setText(Integer.toString(result-num3));
            four.setText(Integer.toString(result+num3+9));
            resultin=3;
        } else if (buttonval == 4) {
            four=findViewById(R.id.four);
            four.setText(Integer.toString(result));
            one.setText(Integer.toString(result+num3+9));
            two.setText(Integer.toString(result-num3));
            three.setText(Integer.toString(result*num3-2));
            resultin=4;
        }

    }

    public void one(View view){
        if(resultin==1){
            correct++;
            total++;
            generateScore();
        }
        else{
            total++;
            generateScore();
        }
        generate();
        setButtonText();
    }

    public void two(View view){
        if(resultin==2){
            correct++;
            total++;
            generateScore();

        }
        else{
            total++;
            generateScore();
        }
        generate();
        setButtonText();
    }

    public void three(View view){
        if(resultin==3){
            correct++;
            total++;
            generateScore();
        }
        else{
            total++;
            generateScore();
        }
        generate();
        setButtonText();
    }

    public void four(View view){
        if(resultin==4){
            correct++;
            total++;
            generateScore();
        }
        else{
            total++;
            generateScore();
        }
        generate();
        setButtonText();
    }

    public void generateScore(){

        TextView rewardtextview=findViewById(R.id.reward);
        rewardtextview.setText(correct+" / "+total);





    }

    public void counter(){
        CountDownTimer countDownTimer=new CountDownTimer(30000,1000) {
            int timeout=30;
            @Override
            public void onTick(long millisUntilFinished) {

                Log.i("counter value", String.valueOf(timer));
                timer.setText(String.valueOf(timeout));
                timeout--;
                if(timeout==1){
                    timergif=findViewById(R.id.replayplaygif);
                    timergif.setVisibility(View.VISIBLE);
                    replay=findViewById(R.id.playagain);
                    replay.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onFinish() {
                Log.i("finished", "We're done");
                timer.setText("Time's Up");
                expression.setVisibility(View.INVISIBLE);
                one.setVisibility(View.INVISIBLE);
                two.setVisibility(View.INVISIBLE);
                three.setVisibility(View.INVISIBLE);
                four.setVisibility(View.INVISIBLE);
                score.animate().translationYBy(-700).setDuration(500);
                score.animate().scaleX(2).setDuration(500);
                score.animate().scaleY(2).setDuration(500);
                TextView rewardtextview=findViewById(R.id.reward);
                rewardtextview.animate().translationYBy(-700).setDuration(500);
                rewardtextview.animate().scaleX(2).setDuration(500);
                rewardtextview.animate().scaleY(2).setDuration(500);



            }
        };

        countDownTimer.start();
    }



    public void play(View view) {
        ImageView appname=findViewById(R.id.appname);
        appname.setVisibility(View.INVISIBLE);
        TextView credit=findViewById(R.id.credit);
        credit.setVisibility(View.INVISIBLE);

        timergif=findViewById(R.id.replayplaygif);
        timergif.setVisibility(View.INVISIBLE);
        replay=findViewById(R.id.playagain);
        replay.setVisibility(View.INVISIBLE);
        gifTextView=findViewById(R.id.playgif);
        gifTextView.setVisibility(View.INVISIBLE);
        play=findViewById(R.id.play);
        play.setVisibility(View.INVISIBLE);
        timergif=findViewById(R.id.timergif);
        timergif.setVisibility(View.VISIBLE);
        countdown=findViewById(R.id.countdown);
        countdown.setVisibility(View.VISIBLE);

        one=findViewById(R.id.one);
        one.setVisibility(View.VISIBLE);
        two=findViewById(R.id.two);
        two.setVisibility(View.VISIBLE);
        three=findViewById(R.id.three);
        three.setVisibility(View.VISIBLE);
        four=findViewById(R.id.four);
        four.setVisibility(View.VISIBLE);

        score=findViewById(R.id.score);
        score.setVisibility(View.VISIBLE);

        generate();
        setButtonText();

        generateScore();

    }

    public void replay(View view) {

        correct=0;
        total=0;
        TextView replaytextview=findViewById(R.id.reward);
        replaytextview.setText(correct+" / "+total);
        score.animate().translationYBy(700).setDuration(200);
        score.animate().scaleX(1).setDuration(200);
        score.animate().scaleY(1).setDuration(200);
        TextView rewardtextview=findViewById(R.id.reward);
        rewardtextview.animate().translationYBy(700).setDuration(200);
        rewardtextview.animate().scaleX(1).setDuration(200);
        rewardtextview.animate().scaleY(1).setDuration(200);
        play(view);

    }
}
