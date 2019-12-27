package com.android.learningapp.MicrocontrollersBasics;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.learningapp.R;


public class ESP extends AppCompatActivity implements View.OnClickListener {
    Button button,button2,button3,button4,button5,button6,button7,button8,close;
    Dialog MyDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esp8266);

        button = findViewById(R.id.ic);
        button2 = findViewById(R.id.pins);


        button.setOnClickListener((View.OnClickListener) this);
        button2.setOnClickListener((View.OnClickListener) this);
        Toast.makeText(ESP.this, "Click on orangedots ", Toast.LENGTH_SHORT).show();


    }

    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.ic:
                MyCustomAlertDialog();
                break;
            case R.id.pins:
                pins();
                break;

        }
    }

    public void MyCustomAlertDialog() {
        MyDialog = new Dialog(ESP.this);
        MyDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        MyDialog.setContentView(R.layout.microcontrollercontent);

        MyDialog.setTitle("My Custom Dialog");

        TextView t1,t2;
        ImageView i1;

        t1=MyDialog.findViewById(R.id.heading);
        i1=MyDialog.findViewById(R.id.img);
        t2=MyDialog.findViewById(R.id.desc);


        t1.setText("ESP8266 IC CHIP");
        i1.setImageResource(R.drawable.espic);
        t2.setText("ESP8266 is a highly integrated chip designed for the needs of a new connected world. It offers a complete and self-contained Wi-Fi networking solution, allowing it to either host the application or to offload all Wi-Fi networking functions from another application processor.\n" +
                "\n");


        close = (Button) MyDialog.findViewById(R.id.close);

        close.setEnabled(true);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDialog.cancel();
            }
        });

        MyDialog.show();
    }
    public void pins() {
        MyDialog = new Dialog(ESP.this);
        MyDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        MyDialog.setContentView(R.layout.microcontrollercontent);
        MyDialog.setTitle("My Custom Dialog");


        TextView t1,t2;
        ImageView i1;

        t1=MyDialog.findViewById(R.id.heading);
        i1=MyDialog.findViewById(R.id.img);
        t2=MyDialog.findViewById(R.id.desc);


        t1.setText("Pin out");
        i1.setImageResource(R.drawable.pins);
        t2.setText("");

        close = (Button) MyDialog.findViewById(R.id.close);

        close.setEnabled(true);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDialog.cancel();
            }
        });

        MyDialog.show();
    }


}