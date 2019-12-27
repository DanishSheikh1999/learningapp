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


public class Arduino extends AppCompatActivity implements View.OnClickListener {
    Button button,button2,button3,button4,button5,button6,button7,button8,close;
    Dialog MyDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arduino);

        button = findViewById(R.id.PowerSupplyJack);
        button2 = findViewById(R.id.usbport);
        button3 = findViewById(R.id.resetbutton);
        button4=findViewById(R.id.digitalpins);
        button5=findViewById(R.id.rxtx);
        button6=findViewById(R.id.atmega328);
        button7=findViewById(R.id.analogpins);
        button8=findViewById(R.id.voltagepins);

        button.setOnClickListener((View.OnClickListener) this);
        button2.setOnClickListener((View.OnClickListener) this);
        button3.setOnClickListener((View.OnClickListener) this);
        button4.setOnClickListener((View.OnClickListener) this);
        button5.setOnClickListener((View.OnClickListener) this);
        button6.setOnClickListener((View.OnClickListener) this);
        button7.setOnClickListener((View.OnClickListener) this);
        button8.setOnClickListener((View.OnClickListener) this);
        Toast.makeText(Arduino.this, "Click on orangedots ", Toast.LENGTH_SHORT).show();


    }

    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.PowerSupplyJack:
                MyCustomAlertDialog();
                break;
            case R.id.usbport:
                usb();
                break;
            case R.id.resetbutton:
                resetbutton();
                break;
            case R.id.digitalpins:
                digitalpins();
                break;
            case R.id.rxtx:
                rxtx();
                break;
            case R.id.atmega328:
                atmega328();
                break;
            case R.id.analogpins:
                analog();
                break;
            case R.id.voltagepins:
                voltage();
                break;


        }
    }

    public void MyCustomAlertDialog() {
        MyDialog = new Dialog(Arduino.this);
        MyDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        MyDialog.setContentView(R.layout.microcontrollercontent);

        MyDialog.setTitle("My Custom Dialog");

        TextView t1,t2;
        ImageView i1;

        t1=MyDialog.findViewById(R.id.heading);
        i1=MyDialog.findViewById(R.id.img);
        t2=MyDialog.findViewById(R.id.desc);


        t1.setText("POWER SUPPLY JACK");
        i1.setImageResource(R.drawable.powerjack);
        t2.setText("Accepts 5.5mm/2.1 mm DC Barrel Plug,Recommended Voltage:9V-12V @ 2A");


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
    public void usb() {
        MyDialog = new Dialog(Arduino.this);
        MyDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        MyDialog.setContentView(R.layout.microcontrollercontent);
        MyDialog.setTitle("My Custom Dialog");


        TextView t1,t2;
        ImageView i1;

        t1=MyDialog.findViewById(R.id.heading);
        i1=MyDialog.findViewById(R.id.img);
        t2=MyDialog.findViewById(R.id.desc);


        t1.setText("USB SERIAL PORT");
        i1.setImageResource(R.drawable.usbport);
        t2.setText("The USB Port is used to connect the board with your computer, and also to exchange data with it.");

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


    public void resetbutton() {
        MyDialog = new Dialog(Arduino.this);
        MyDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        MyDialog.setContentView(R.layout.microcontrollercontent);
        MyDialog.setTitle("My Custom Dialog");


        TextView t1,t2;
        ImageView i1;

        t1=MyDialog.findViewById(R.id.heading);
        i1=MyDialog.findViewById(R.id.img);
        t2=MyDialog.findViewById(R.id.desc);


        t1.setText("RESET BUTTON");
        i1.setImageResource(R.drawable.resetbutton);
        t2.setText("The reset button restarts your program from the beginning.");

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

    public void digitalpins() {
        MyDialog = new Dialog(Arduino.this);
        MyDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        MyDialog.setContentView(R.layout.microcontrollercontent);
        MyDialog.setTitle("My Custom Dialog");


        TextView t1,t2;
        ImageView i1;

        t1=MyDialog.findViewById(R.id.heading);
        i1=MyDialog.findViewById(R.id.img);
        t2=MyDialog.findViewById(R.id.desc);


        t1.setText("DIGITAL PINS");
        i1.setImageResource(R.drawable.digitalpins);
        t2.setText("The pins on the Arduino can be configured as either inputs or outputs. The pins 3,5,6,9,10 and 11 are PWM enabled i.e. these pins can mimic analog output and input using pulse width modulation. PWM is achieved by rapidly varying the output between high and low for the desired percentage of time.");

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

    public void rxtx() {
        MyDialog = new Dialog(Arduino.this);
        MyDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        MyDialog.setContentView(R.layout.microcontrollercontent);
        MyDialog.setTitle("My Custom Dialog");


        TextView t1,t2;
        ImageView i1;

        t1=MyDialog.findViewById(R.id.heading);
        i1=MyDialog.findViewById(R.id.img);
        t2=MyDialog.findViewById(R.id.desc);


        t1.setText("Rx and tx PINS");
        i1.setImageResource(R.drawable.rxtx);
        t2.setText("0 and 1 digital pins are Rx and Tx pins used for serial communication between 2 microcontrollers or other programmable modules.");

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

    public void atmega328() {
        MyDialog = new Dialog(Arduino.this);
        MyDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        MyDialog.setContentView(R.layout.microcontrollercontent);
        MyDialog.setTitle("My Custom Dialog");


        TextView t1,t2;
        ImageView i1;

        t1=MyDialog.findViewById(R.id.heading);
        i1=MyDialog.findViewById(R.id.img);
        t2=MyDialog.findViewById(R.id.desc);


        t1.setText("IC");
        i1.setImageResource(R.drawable.ic);
        t2.setText("Arduino UNO uses Atmega 328 IC which is the processing and storage unit of the Arduino board.");

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

    public void analog() {
        MyDialog = new Dialog(Arduino.this);
        MyDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        MyDialog.setContentView(R.layout.microcontrollercontent);
        MyDialog.setTitle("My Custom Dialog");


        TextView t1,t2;
        ImageView i1;

        t1=MyDialog.findViewById(R.id.heading);
        i1=MyDialog.findViewById(R.id.img);
        t2=MyDialog.findViewById(R.id.desc);


        t1.setText("ANALOG PINS");
        i1.setImageResource(R.drawable.analogpins);
        t2.setText("A0 to A5 are the analog pins of arduino uno. These pins can be configured as analog input or analog outputs receiving or sending values from 0 - 255.");

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

    public void voltage() {
        MyDialog = new Dialog(Arduino.this);
        MyDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        MyDialog.setContentView(R.layout.microcontrollercontent);
        MyDialog.setTitle("My Custom Dialog");


        TextView t1,t2;
        ImageView i1;

        t1=MyDialog.findViewById(R.id.heading);
        i1=MyDialog.findViewById(R.id.img);
        t2=MyDialog.findViewById(R.id.desc);


        t1.setText("VOLTAGE PINS");
        i1.setImageResource(R.drawable.voltage);
        t2.setText("5V pins give out a 5 volt signal, 3.3v pins give 3.3 volt signal, and GND are ground pins which are forever at 0 volts.");

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