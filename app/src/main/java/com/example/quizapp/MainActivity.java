package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private  Button btn;
    private EditText inputname;
    public static final String EXTRA_TEXT = "com.example.application.example.EXTRA_TEXT";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn = findViewById(R.id.startBtn);
        inputname = findViewById(R.id.inputname);

        Intent intent = getIntent();
        String text = intent.getStringExtra(Finalscore.EXTRA_TEXTSIX);
        inputname.setText(text);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openquestion1();
            }
        });
    }
    public void openquestion1() {
        String username = inputname.getText().toString();
        Intent i = new Intent(this,question1.class);
        i.putExtra(EXTRA_TEXT, username);


        startActivity(i);
        finish();
    }

}