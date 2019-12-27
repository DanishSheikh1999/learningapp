package com.android.learningapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.learningapp.MicrocontrollersBasics.Arduino;
import com.android.learningapp.MicrocontrollersBasics.ESP;
import com.android.learningapp.MicrocontrollersBasics.NodeMCU;


public class Microcontrollers extends AppCompatActivity implements View.OnClickListener {

    Button back;
    CardView esp, node, arduino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_microcontroller);
        back = findViewById(R.id.back_button);
        esp = findViewById(R.id.esp8266);
        node = findViewById(R.id.nodemcu);
        arduino = findViewById(R.id.arduino);
        back.setOnClickListener(this);
        esp.setOnClickListener(this);
        node.setOnClickListener(this);
        arduino.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_button:
                startActivity(new Intent(Microcontrollers.this, TabbedActivity.class));
                finish();
                break;
            case R.id.esp8266: startActivity(new Intent(Microcontrollers.this, ESP.class));
            finish();
            break;
            case R.id.nodemcu: startActivity(new Intent(Microcontrollers.this, NodeMCU.class));
                finish();
                break;
            case R.id.arduino: startActivity(new Intent(Microcontrollers.this, Arduino.class));
                finish();
                break;
        }
    }
}
