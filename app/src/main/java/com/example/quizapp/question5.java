package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class question5 extends AppCompatActivity {

    TextView fscore,nametv;
    String username;
    Button answer1, answer2,answer3, submitbtn;
    Integer finalscore;
    public static final String EXTRA_FOUR = "com.example.application.example.EXTRA_FOUR";
    public static final String EXTRA_TEXTFIVE = "com.example.application.example.EXTRA_TEXTFIVE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);

        Intent intent = getIntent();
        int score = intent.getIntExtra(question4.EXTRA_THREE, 0);
        String text = intent.getStringExtra(question4.EXTRA_TEXTFOUR);
        nametv = findViewById(R.id.nametv);
        nametv.setText(text );


        fscore = findViewById(R.id.fscore);
        fscore.setText(" "+ score);
        finalscore = score;


        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        submitbtn = findViewById(R.id.submitbtn);


        answer1.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                answer1.setBackgroundResource(R.drawable.answer_button_pressed);
                answer1.setSelected(true);
                answer2.setSelected(false);
                answer3.setSelected(false);
                if(answer1.isSelected())
                {
                    answer2.setBackgroundResource(R.drawable.answer_button);
                    answer3.setBackgroundResource(R.drawable.answer_button);
                }
            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                answer2.setBackgroundResource(R.drawable.answer_button_pressed);
                answer2.setSelected(true);
                answer1.setSelected(false);
                answer3.setSelected(false);
                if(answer2.isSelected())
                {
                    answer1.setBackgroundResource(R.drawable.answer_button);
                    answer3.setBackgroundResource(R.drawable.answer_button);
                }
            }
        });
        answer3.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                answer3.setBackgroundResource(R.drawable.answer_button_pressed);


                answer3.setSelected(true);
                answer1.setSelected(false);
                answer2.setSelected(false);
                if(answer3.isSelected())
                {
                    answer2.setBackgroundResource(R.drawable.answer_button);
                    answer1.setBackgroundResource(R.drawable.answer_button);
                }

            }
        });


        submitbtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {


                if(answer1.isSelected()){
                    answer1.setBackgroundResource(R.drawable.answer_correct);
                    finalscore += + 1 ;
                }
                else if(answer2.isSelected()){
                    answer1.setBackgroundResource(R.drawable.answer_correct);
                    answer2.setBackgroundResource(R.drawable.answer_wrong);
                    finalscore += 0;
                }
                else if(answer3.isSelected()){
                    answer1.setBackgroundResource(R.drawable.answer_correct);
                    answer3.setBackgroundResource(R.drawable.answer_wrong);
                    finalscore += 0;

                }
                submitbtn.setBackgroundResource(R.drawable.next_btn);
                submitbtn.setText("Next");
                submitbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openfinalscore();
                    }
                });
            }
        });

    }

    public void openfinalscore() {
        int Score = Integer.parseInt( finalscore.toString());
        Intent intent = new Intent(this, Finalscore.class);
        intent.putExtra(EXTRA_FOUR, Score);
        String username = nametv.getText().toString();
        intent.putExtra(EXTRA_TEXTFIVE, username);
        startActivity(intent);
        finish();
    }
}