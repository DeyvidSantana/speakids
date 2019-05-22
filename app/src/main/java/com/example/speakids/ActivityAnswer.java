package com.example.speakids;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityAnswer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        getSupportActionBar().hide();

        ImageView imgAnswer = (ImageView)findViewById(R.id.imgAnswer);
        TextView answer = (TextView)findViewById(R.id.answer);
        Button btnReplyAgain = (Button)findViewById(R.id.btnReplyAgain);

        Intent intent = getIntent();
        int points = intent.getIntExtra("points", 0);

        if(intent.hasExtra("acertou")) {
            btnReplyAgain.setVisibility(View.INVISIBLE);
            boolean acertou = intent.getBooleanExtra("acertou", false);
            if (acertou) {
                imgAnswer.setImageResource(R.drawable.ok);
                answer.setText("Acertou! Pontos: " + points);
            } else {
                imgAnswer.setImageResource(R.drawable.error);
                answer.setText("Errou! Pontos: " + points);
            }

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finish();
                }
            });
            thread.start();
        }
        else{
            btnReplyAgain.setVisibility(View.VISIBLE);
            answer.setText("Fez " + points + " pontos!");

            if(points >= 3)
                imgAnswer.setImageResource(R.drawable.happy);
            else
                imgAnswer.setImageResource(R.drawable.sad);
        }
    }

    public void btnReplyAgainOnClick(View v){
        Intent intent = new Intent(this, ActivityQuiz.class);
        startActivity(intent);
        finish();
    }
}
