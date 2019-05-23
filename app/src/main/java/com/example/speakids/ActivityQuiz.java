package com.example.speakids;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.speakids.utils.Question;

import java.util.ArrayList;
import java.util.List;

public class ActivityQuiz extends AppCompatActivity {

    TextView question;
    TextView questionInEnglish;
    RadioButton rbAnswer1, rbAnswer2, rbAnswer3, rbAnswer4;
    RadioGroup rgAnswers;
    int correctAnswer = R.id.rbAnswer1;
    int points = 0;

    List<Question> questions = new ArrayList<Question>(){
        {
            add(new Question("Cantores usam o microfone para:",
                    "Singers use the microphone to:", R.id.rbAnswer2,
                    "Sleep", "Sing", "Run", "Walk"));
            add(new Question("Qual é o nome do animal de estimação mais amado?",
                    "What is the name of the most beloved pet?", R.id.rbAnswer1,
                    "Dog", "Lion", "Butterfly", "Fis"));
            add(new Question("Qual a estação do ano representada pelo sol?",
                    "What season is represented by the sun?", R.id.rbAnswer4,
                    "Winter", "Spring", "Autumn", "Summer"));
            add(new Question("Qual objeto você usa para fazer as anotações da escola?",
                    "What object do you use to make school notes?",
                    R.id.rbAnswer3, "Pencil", "Scool", "Notebook", "Pen"));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        question = (TextView)findViewById(R.id.question);
        questionInEnglish = (TextView)findViewById(R.id.questionInEnglish);
        rbAnswer1 = (RadioButton)findViewById(R.id.rbAnswer1);
        rbAnswer2 = (RadioButton)findViewById(R.id.rbAnswer2);
        rbAnswer3 = (RadioButton)findViewById(R.id.rbAnswer3);
        rbAnswer4 = (RadioButton)findViewById(R.id.rbAnswer4);
        rgAnswers = (RadioGroup) findViewById(R.id.rgRespostas);
        buildQuestion();

        getSupportActionBar().setTitle("Quiz");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        buildQuestion();
    }

    public void btnReplyOnClick(View v){
        RadioButton rb = (RadioButton)findViewById(rgAnswers.getCheckedRadioButtonId());
        Intent intent = new Intent(this, ActivityAnswer.class);
        if(rgAnswers.getCheckedRadioButtonId() == correctAnswer) {
            intent.putExtra("acertou", true);
            points++;
        }
        else intent.putExtra("acertou", false);
        intent.putExtra("points", points);
        startActivity(intent);
        rb.setChecked(false);
    }

    private void buildQuestion(){
        if(questions.size() > 0) {
            Question q = questions.remove(0);
            question.setText(q.getQuestion());
            questionInEnglish.setText(q.getQuestionInEnglish());
            List<String> answer = q.getAnswers();
            rbAnswer1.setText(answer.get(0));
            rbAnswer2.setText(answer.get(1));
            rbAnswer3.setText(answer.get(2));
            rbAnswer4.setText(answer.get(3));
            correctAnswer = q.getCorrectAnswers();
            rgAnswers.setSelected(false);
        }
        else { // the questions are over
            Intent intent = new Intent(this, ActivityAnswer.class);
            intent.putExtra("points", points);
            startActivity(intent);
            finish();
        }
    }
}
