package com.android.learningapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class TasksScreen extends AppCompatActivity implements View.OnClickListener {
    private Button back;
    private String task;
    private TextView question;
    private ArrayList<String> LED = new ArrayList<String>();
    private ArrayList<String> Ultrasonic = new ArrayList<String>();
    private ArrayList<String> Potentiometer = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasks_screen);
        setAllTasksValues();
        back = findViewById(R.id.back_button);
        question = findViewById(R.id.question_statement);
        Intent intent = getIntent();
        task = intent.getStringExtra("GenericTask");
        Log.d("TASK", task);
        setQuestion(task);
        back.setOnClickListener(this);
    }

    private void setQuestion(String task) {
        switch (Integer.valueOf(task)) {
            case 00:
                question.setText(LED.get(0));
                break;
            case 01:
                question.setText(LED.get(1));
                break;
            case 02:
                question.setText(LED.get(2));
                break;
            case 10:
                question.setText(Ultrasonic.get(0));
                break;
            case 11:
                question.setText(Ultrasonic.get(1));
                break;
            case 20:
                question.setText(Potentiometer.get(0));
                break;
            case 21:
                question.setText(Potentiometer.get(1));
                break;
        }
    }

    private void setAllTasksValues() {
        LED.add("QUESTION: You need to blink a LED using any microcontroller and upload the task video on the telegram link given below. (Also you can try to increase the rate of blinking).");
        LED.add("QUESTION: You need to fade a LED using any microcontroller and upload the task video on the telegram link given below. (Also you can try to increase the rate of fading).");
        LED.add("QUESTION: You need to create different colors using RGB LED using any microcontroller and upload the task video on the telegram link given below.");
        Ultrasonic.add("QUESTION: You need to find the distance of the object infront of the ultrasonic sensor. Upload the task video on the telegram link given below.");
        Ultrasonic.add("QUESTION: You need to create  a RADAR system which can detect any object in its vicinity using the ultrasonic sensor. Upload the task video on the telegram link given below.");
        Potentiometer.add("QUESTION: You need to change the intensity of a LED using a potentiometer and upload the task video on the telegram link given below.");
        Potentiometer.add("QUESTION: You need to control the servo using a potentiometer and upload the task video on the telegram link given below.");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(TasksScreen.this, TabbedActivity.class));
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_button:
                startActivity(new Intent(TasksScreen.this, TabbedActivity.class));
                finish();
                break;
        }
    }
}
