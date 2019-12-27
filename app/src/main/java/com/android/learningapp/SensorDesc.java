package com.android.learningapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Map;

public class SensorDesc extends AppCompatActivity implements View.OnClickListener {

    Button back;
    TextView desc, title;
    ImageView image;
    String sensorName;
    String Fdesc;
    String Fimag;
    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sensor_desc);
        Intent intent = getIntent();
        getData();
        sensorName = intent.getStringExtra("Sensor");
        back = findViewById(R.id.back_button);
        desc = findViewById(R.id.textSensor);
        title = findViewById(R.id.title);
        image = findViewById(R.id.sensor_image);
        back.setOnClickListener(this);

    }

    private void getData() {
        firebaseFirestore.collection("App Resources").document("Sensors").collection(sensorName).document("Sensor")
                .get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    assert document != null;
                    if (document.exists()) {
                        title.setText(sensorName);
                        Fdesc = document.getString("Description");
                        Fimag = document.getString("Image");
                        desc.setText(Fdesc);
                        Glide.with(SensorDesc.this).load(Fimag)
                                .into(image);
                    }
                } else {
                    Log.d("DEBUG Arduino", "Found null document");
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_button:
                startActivity(new Intent(SensorDesc.this, CodingBasics.class));
                finish();
                break;
        }
    }
}
