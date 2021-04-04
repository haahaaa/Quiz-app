package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Finalscore extends AppCompatActivity {
    private TextView nametv,fscore;
    Button newquiz,finishbtn;
    public static final String EXTRA_TEXTSIX = "com.example.application.example.EXTRA_TEXTSIX";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalscore);

        Intent intent = getIntent();
        String text = intent.getStringExtra(question5.EXTRA_TEXTFIVE);
        nametv = findViewById(R.id.nametv);
        nametv.setText(text );


        int score = intent.getIntExtra(question5.EXTRA_FOUR, 0);
        fscore = findViewById(R.id.fscore);
        fscore.setText("Your final Score: " + score);

        newquiz = findViewById(R.id.newquiz);
        finishbtn = findViewById(R.id.finishbtn);

        newquiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restart();
            }
        });

        finishbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    public void restart() {
        String name = nametv.getText().toString();
        Intent i = new Intent(this,MainActivity.class);
        i.putExtra(EXTRA_TEXTSIX, name);
        startActivity(i);
        finish();

    }
}