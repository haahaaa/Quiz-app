package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class question1 extends AppCompatActivity {


    private TextView nametv, value;
    Button answer1, answer2, answer3, submitbtn;
    public static final String EXTRA_finalscore = "com.example.application.example.EXTRA_finalscore";
    public static final String EXTRA_TEXTONE = "com.example.application.example.EXTRA_TEXT";

    Integer finalscore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        Intent intent = getIntent();
        String text = intent.getStringExtra(MainActivity.EXTRA_TEXT);
        nametv = findViewById(R.id.nametv);

        nametv.setText(text);

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
                     finalscore = 1;
                }
                else if(answer2.isSelected()){
                    answer1.setBackgroundResource(R.drawable.answer_correct);
                    answer2.setBackgroundResource(R.drawable.answer_wrong);
                     finalscore = 0;
                }
                else if(answer3.isSelected()){
                    answer1.setBackgroundResource(R.drawable.answer_correct);
                    answer3.setBackgroundResource(R.drawable.answer_wrong);
                     finalscore = 0;

                }

                submitbtn.setBackgroundResource(R.drawable.next_btn);
                submitbtn.setText("Next");
                submitbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        openquestion2();

                    }
                });
            }
        });

    }
    public void openquestion2(){

        int Score = Integer.parseInt( finalscore.toString());
        Intent intent = new Intent(this, question2.class);
        intent.putExtra(EXTRA_finalscore, Score);
        String username = nametv.getText().toString();
        intent.putExtra(EXTRA_TEXTONE,username);
        startActivity(intent);
        finish();
    }

}