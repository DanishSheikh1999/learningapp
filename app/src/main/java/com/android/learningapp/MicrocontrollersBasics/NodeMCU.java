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

public class NodeMCU extends AppCompatActivity implements View.OnClickListener {
    Button button,button2,button3,button4,button5,button6,button7,button8,close;
    Dialog MyDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nodemcu);

        button = findViewById(R.id.reset);
        button2 = findViewById(R.id.pins);
        button3 = findViewById(R.id.esp);
        button4 = findViewById(R.id.flash);
        button5 = findViewById(R.id.usbport);


        button.setOnClickListener((View.OnClickListener) this);
        button2.setOnClickListener((View.OnClickListener) this);
        button3.setOnClickListener((View.OnClickListener) this);
        button4.setOnClickListener((View.OnClickListener) this);
        button5.setOnClickListener((View.OnClickListener) this);
        Toast.makeText(NodeMCU.this, "Click on orangedots ", Toast.LENGTH_SHORT).show();


    }

    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.usbport:
                MyCustomAlertDialog();
                break;
            case R.id.pins:
                pins();
                break;
            case R.id.esp:
                esp();
                break;
            case R.id.flash:
                flash();
                break;
            case R.id.reset:
                reset();
                break;

        }
    }

    public void MyCustomAlertDialog() {
        MyDialog = new Dialog(NodeMCU.this);
        MyDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        MyDialog.setContentView(R.layout.microcontrollercontent);

        MyDialog.setTitle("My Custom Dialog");

        TextView t1,t2;
        ImageView i1;

        t1=MyDialog.findViewById(R.id.heading);
        i1=MyDialog.findViewById(R.id.img);
        t2=MyDialog.findViewById(R.id.desc);


        t1.setText("USB PORT");
        i1.setImageResource(R.drawable.usbportnode);
        t2.setText("Power to the ESP8266 NodeMCU is supplied via the on-board MicroB USB connector. Alternatively, if you have a regulated 5V voltage source, the VIN pin can be used to directly supply the ESP8266 and its peripherals. NODE MCU is programmed after connecting it to a pc through a data cable.");


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
        MyDialog = new Dialog(NodeMCU.this);
        MyDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        MyDialog.setContentView(R.layout.microcontrollercontent);
        MyDialog.setTitle("My Custom Dialog");


        TextView t1,t2;
        ImageView i1;

        t1=MyDialog.findViewById(R.id.heading);
        i1=MyDialog.findViewById(R.id.img);
        t2=MyDialog.findViewById(R.id.desc);


        t1.setText("Pin out");
        i1.setImageResource(R.drawable.pinsnode);
        t2.setText("GPIO pins in Node MCU are named as D0,D1,D3,...,D10 and A0. Out of which D0 is a digital pin. D1 to D10 are PWM pins and A0 is analog pin. Except GPIO pins Node MCU has 3.3V and Gnd pins. ");

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


    public void reset() {
        MyDialog = new Dialog(NodeMCU.this);
        MyDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        MyDialog.setContentView(R.layout.microcontrollercontent);
        MyDialog.setTitle("My Custom Dialog");


        TextView t1,t2;
        ImageView i1;

        t1=MyDialog.findViewById(R.id.heading);
        i1=MyDialog.findViewById(R.id.img);
        t2=MyDialog.findViewById(R.id.desc);


        t1.setText("RESET BUTTON");
        i1.setImageResource(R.drawable.reset);
        t2.setText("Restarts the uploaded program from the beginning.");

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

    public void esp() {
        MyDialog = new Dialog(NodeMCU.this);
        MyDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        MyDialog.setContentView(R.layout.microcontrollercontent);
        MyDialog.setTitle("My Custom Dialog");


        TextView t1,t2;
        ImageView i1;

        t1=MyDialog.findViewById(R.id.heading);
        i1=MyDialog.findViewById(R.id.img);
        t2=MyDialog.findViewById(R.id.desc);


        t1.setText("Esp module");
        i1.setImageResource(R.drawable.espnode);
        t2.setText("This is the same Esp module which provides Wifi connectivity to our micro-controller board.");

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
    public void flash() {
        MyDialog = new Dialog(NodeMCU.this);
        MyDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        MyDialog.setContentView(R.layout.microcontrollercontent);
        MyDialog.setTitle("My Custom Dialog");


        TextView t1,t2;
        ImageView i1;

        t1=MyDialog.findViewById(R.id.heading);
        i1=MyDialog.findViewById(R.id.img);
        t2=MyDialog.findViewById(R.id.desc);


        t1.setText("FLASH BUTTON");
        i1.setImageResource(R.drawable.flash);
        t2.setText("You need to hold flash and press reset to get it into upload mode. Some boards like NodeMCU and Wemos have a USB to serial adapter onboard which does it automatically.");

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