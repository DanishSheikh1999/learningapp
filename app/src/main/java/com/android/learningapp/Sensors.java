package com.android.learningapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


public class Sensors extends AppCompatActivity implements View.OnClickListener {

    Button back;
    CardView led, potentiometer, ultrasonic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_sensors);
        back = findViewById(R.id.back_button);
        led = findViewById(R.id.led);
        potentiometer = findViewById(R.id.potentio);
        ultrasonic = findViewById(R.id.ultrasonic);
        back.setOnClickListener(this);
        led.setOnClickListener(this);
        potentiometer.setOnClickListener(this);
        ultrasonic.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_button:
                startActivity(new Intent(Sensors.this, TabbedActivity.class));
                finish();
                break;
            case R.id.potentio:
                Intent intent1 = new Intent(Sensors.this, SensorDesc.class);
                intent1.putExtra("Sensor", "Potentiometer");
                startActivity(intent1);
                break;
            case R.id.led:
                Intent intent2 = new Intent(Sensors.this, SensorDesc.class);
                intent2.putExtra("Sensor", "LED");
                startActivity(intent2);
                break;
            case R.id.ultrasonic:
                Intent intent3 = new Intent(Sensors.this, SensorDesc.class);
                intent3.putExtra("Sensor", "Ultrasonic");
                startActivity(intent3);
                break;
        }
    }
}
