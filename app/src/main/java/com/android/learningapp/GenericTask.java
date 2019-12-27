package com.android.learningapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.github.chrisbanes.photoview.PhotoView;
import com.jmedeisis.draglinearlayout.DragLinearLayout;


public class GenericTask extends AppCompatActivity{
    CardView t1,i1, t2, t3, t4,sol,question;
    TextView t5,ques,o1,o2,o3,o4,o5,sll;
    DragLinearLayout dr;
    CardView mcq;
    ProgressBar progressBar;
    RadioButton mcq1,mcq2,mcq3,mcq4;
    PhotoView photoView ;
    PhotoView photoView1 ;
    LinearLayout lastslidetask;
    int counter=1;
    int intentPassedVal=6;         //Akshaaaaaaaaatttttttt
    // this value needs to be changed for launching different tasks
   /* values kuch is prakaar
    intentPassedVal=1; Led Blinking
    intentPassedVal=2;   LED fade
    intentPassedVal=3;   LED mixing
    intentPassedVal=4;   Potentiometer Serial
    intentPassedVal=5;   Potentiometer led
    intentPassedVal=6;   Switch serial
    intentPassedVal=7;   Switch LED
    */



    int counterx=1;
    at.markushi.ui.CircleButton b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.generic_task);
        final DragLinearLayout dragLinearLayout = (DragLinearLayout) findViewById(R.id.container);

      //  PhotoView photoView = (PhotoView) findViewById(R.id.Blink);

        counter=1;
        t1 = findViewById(R.id.ink1);
        mcq=findViewById(R.id.mcq);
        mcq1=findViewById(R.id.mcq1);
        mcq2=findViewById(R.id.mcq2);
        mcq3=findViewById(R.id.mcq3);
        mcq4=findViewById(R.id.mcq4);
        ques=findViewById(R.id.ques);
        sol=findViewById(R.id.solution);
        dr=findViewById(R.id.container);
        lastslidetask=findViewById(R.id.lastslidetask);
        photoView = (PhotoView) findViewById(R.id.circuit);
        photoView1 = (PhotoView) findViewById(R.id.codedisp);
        t2 = findViewById(R.id.ink2);
        t3 = findViewById(R.id.ink3);
        i1 = findViewById(R.id.ink4);
        t4 = findViewById(R.id.ink5);
        t5 = findViewById(R.id.ink6);
        b1 = findViewById(R.id.btn);

        progressBar=findViewById(R.id.progress_bar);
        o1=findViewById(R.id.o1);
        o2=findViewById(R.id.o2);
        o3=findViewById(R.id.o3);
        o4=findViewById(R.id.o4);
        o5=findViewById(R.id.o5);
        sll=findViewById(R.id.sll);


        question=findViewById(R.id.question);
        if(intentPassedVal==1)  //LedBlinking
        progressBar.setMax(8);
        else if(intentPassedVal==2)//Led fading
        { ques.setText("Arrange the following steps in correct order for changing the brightness of LED");
        o1.setText("Upload the code and observer the output");
        o2.setText("analog write different values from 0 to 1023 on the GPIO pin.");
        o3.setText("start void loop()");
        o4.setText("Declare the pin to which led is connected as output in the code.");
        o5.setText("Connect LED to the node");
        t5.setText("");}
        else if(intentPassedVal==3)//Led Mixing
        { ques.setText("Arrange the syntax of for loop in correct order");
            o1.setText("{  }");
            o2.setText("i++)");
            o3.setText("i<10;");
            o4.setText("int i=0;");
            o5.setText("for(");
            t5.setText("");
            progressBar.setMax(4);
        }
        else if(intentPassedVal==4)//Potentiometer serial monitor
        { ques.setText("Arrange the following in correct order");
            o1.setText("}");
            o2.setText("; Serial.begin(9600);");
            o3.setText("pinMode(A0,INPUT)");
            o4.setText("{");
            o5.setText("void setup()");
            t5.setText("");
            progressBar.setMax(13);
        }
        else if(intentPassedVal==5)//Potentiometer led
        { ques.setText("Arrange the following in correct order to control led brightness with potentiometer");
            o1.setText("Upload the code and observe the output.");
            o2.setText("analogWrite the value on the LED.");
            o3.setText("Store the read value in a variable.");
            o4.setText("analogRead the value from the potentiometer.");
            o5.setText("Make the required circuit.");
            t5.setText("");
            progressBar.setMax(9);
        }
        else if(intentPassedVal==6)//Switch serial monitor
        { ques.setText("Arrange the following in correct order");
            o1.setText("}");
            o2.setText("; Serial.begin(9600);");
            o3.setText("pinMode(D1,INPUT)");
            o4.setText("{");
            o5.setText("void setup()");
            t5.setText("");
            progressBar.setMax(13);
        }
        else if(intentPassedVal==7)//Switch led
        {     ques.setText("Arrange the following in correct order to control an led with a switch");
            o1.setText("Upload the code and observe the output.");
            o2.setText("digitalWrite the value on the LED.");
            o3.setText("Store the read value in a variable.");
            o4.setText("digitalRead the value from the Switch.");
            o5.setText("Make the required circuit.");
            t5.setText("");
            progressBar.setMax(9);
        }


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           if(intentPassedVal==1) {     //led blinking

               if (counter == 1) {
                   Log.d("hel", "onClick: clik");
                   if (dragLinearLayout.getChildAt(0).getId() == R.id.ink5 &&
                           dragLinearLayout.getChildAt(1).getId() == R.id.ink4 &&
                           dragLinearLayout.getChildAt(2).getId() == R.id.ink3 &&
                           dragLinearLayout.getChildAt(3).getId() == R.id.ink2) {
                       Log.d("hel", "onSwap: true");
                       t5.setText("Correct");
                       //     b1.setText("Next");


                   } else {
                       t5.setText("Incorrect");
                       sol.setVisibility(View.VISIBLE);
                       dr.setVisibility(View.GONE);
                       // b1.setText("Next");

                   }

                   progressBar.setProgress(counter);
                   counter++;
               } else if (counter == 2) {
                   sol.setVisibility(View.GONE);
                   dr.setVisibility(View.GONE);
                   mcq.setVisibility(View.VISIBLE);
                   ques.setText("If you write pinMode(D2,OUTPUT) in the void setup(), you'll have to connect the longer leg of your LED to: ");
                   mcq1.setText("D1 pin of the NODE MCU");
                   mcq2.setText("2 pin of the NODE MCU");
                   mcq3.setText("D2 pin of the NODE MCU");
                   mcq4.setText("E2 pin of NODE MCU");
                   t5.setText("");
                   counter++;
                   progressBar.setProgress(counter);
               } else if (counter == 3) {
                   if (mcq3.isChecked()) {
                       t5.setText("Correct");
                       counter++;
                       progressBar.setProgress(counter);
                   } else {
                       t5.setText("Incorrect. Correct answer is D2");
                       counter++;
                       progressBar.setProgress(counter);
                   }


               } else if (counter == 4) {

                   ques.setText("Which function will you use to produce 3.3V voltage at D7 GPIO pin:  ");
                   mcq1.setText("analogWrite(D7,512);");
                   mcq2.setText("analogWrite(D7,LOW);");
                   mcq3.setText("digitalWrite(D7,LOW);");
                   mcq4.setText("digitalWrite(D7,HIGH);");
                   t5.setText("");
                   counter++;
                   progressBar.setProgress(counter);


               } else if (counter == 5) {
                   if (mcq4.isChecked()) {
                       t5.setText("Correct");
                       counter++;
                       progressBar.setProgress(counter);

                   } else {
                       t5.setText("Incorrect. Correct answer is digitalWrite(D7,HIGH);");
                       counter++;
                       progressBar.setProgress(counter);
                   }


               } else if (counter == 6) {
                   sol.setVisibility(View.GONE);
                   dr.setVisibility(View.VISIBLE);
                   mcq.setVisibility(View.GONE);
                   ques.setText("arrange the following in correct order to light up led for 100 milliseconds and switch off for 1 sec. while blinking.");
                   o1.setText("digitalWrite(D2,LOW);");
                   o2.setText("digitalWrite(D2,High);");
                   o3.setText("void loop(){");
                   o4.setText("delay(1000);}");
                   o5.setText("delay(100);");
                   t5.setText("");
                   Log.d("hel", "onClick: clik");
                   counter++;
                   progressBar.setProgress(counter);
               } else if (counter == 7) {
                   if (dragLinearLayout.getChildAt(0).getId() == R.id.ink3 &&
                           dragLinearLayout.getChildAt(1).getId() == R.id.ink2 &&
                           dragLinearLayout.getChildAt(2).getId() == R.id.ink5 &&
                           dragLinearLayout.getChildAt(3).getId() == R.id.ink1) {
                       Log.d("hel", "onSwap: true");
                       t5.setText("Correct");
                       //     b1.setText("Next");
                       progressBar.setProgress(counter);
                       counter++;

                   } else {
                       t5.setText("Incorrect");
                       sll.setText("void loop(){\ndigitalWrite(D2,High);\ndelay(100);\ndigitalWrite(D2,LOW);\ndelay(1000);}");
                       sol.setVisibility(View.VISIBLE);
                       dr.setVisibility(View.GONE);
                       // b1.setText("Next");
                       progressBar.setProgress(counter);
                       counter++;
                   }
               }
               else if (counter == 8) {


                   t5.setText("Type the above code yourself for better learning.");
                   sol.setVisibility(View.GONE);
                   dr.setVisibility(View.GONE);
                   question.setVisibility(View.GONE);
                   lastslidetask.setVisibility(View.VISIBLE);
                   photoView.setImageResource(R.drawable.ledblinkcircuit);
                   photoView1.setImageResource(R.drawable.blikncode);

               }



           }

           else if (intentPassedVal==2){            //led fading



               if (counter == 1) {

                   Log.d("hel", "onClick: clik");
                   if (dragLinearLayout.getChildAt(0).getId() == R.id.ink5 &&
                           dragLinearLayout.getChildAt(1).getId() == R.id.ink4 &&
                           dragLinearLayout.getChildAt(2).getId() == R.id.ink3 &&
                           dragLinearLayout.getChildAt(3).getId() == R.id.ink2) {
                       Log.d("hel", "onSwap: true");
                       t5.setText("Correct");
                       //     b1.setText("Next");


                   } else {
                       t5.setText("Incorrect");
                       sll.setText("Connect LED to the node\nDeclare the pin to which led is connected as output in the code.\nstart void loop()\nanalog write different values from 0 to 1023 on the GPIO pin.\nUpload the code and observer the output");
                       sol.setVisibility(View.VISIBLE);
                       dr.setVisibility(View.GONE);
                       // b1.setText("Next");
                       progressBar.setProgress(counter);
                       // b1.setText("Next");

                   }
                   counter++;
                   progressBar.setProgress(counter);
               } else if (counter == 2) {
                   sol.setVisibility(View.GONE);
                   dr.setVisibility(View.GONE);
                   mcq.setVisibility(View.VISIBLE);
                   ques.setText("If you write pinMode(D2,OUTPUT) in the void setup(), you'll have to connect the longer leg of your LED to: ");
                   mcq1.setText("D1 pin of the NODE MCU");
                   mcq2.setText("2 pin of the NODE MCU");
                   mcq3.setText("D2 pin of the NODE MCU");
                   mcq4.setText("E2 pin of NODE MCU");
                   t5.setText("");
                   counter++;
                   progressBar.setProgress(counter);
               } else if (counter == 3) {
                   if (mcq3.isChecked()) {
                       t5.setText("Correct");
                       counter++;
                       progressBar.setProgress(counter);
                   } else {
                       t5.setText("Incorrect. Correct answer is D2");
                       counter++;
                       progressBar.setProgress(counter);
                   }


               } else if (counter == 4) {

                   ques.setText("Which function will you use to produce 3.3V voltage at D7 GPIO pin:  ");
                   mcq1.setText("analogWrite(D7,1023);");
                   mcq2.setText("analogWrite(D7,LOW);");
                   mcq3.setText("analogWrite(D7,512);");
                   mcq4.setText("digitalWrite(D7,LOW);");
                   t5.setText("");
                   progressBar.setProgress(counter);
                   counter++;

               } else if (counter == 5) {
                   if (mcq1.isChecked()) {
                       t5.setText("Correct");
                       counter++;
                       progressBar.setProgress(counter);

                   } else {
                       t5.setText("Incorrect. Correct answer is analogWrite(D7,1023);");
                       counter++;
                       progressBar.setProgress(counter);
                   }
               }

//               } else if (counter == 6) {
//                   sol.setVisibility(View.GONE);
//                   dr.setVisibility(View.VISIBLE);
//                   mcq.setVisibility(View.GONE);
//                   ques.setText("arrange the following in correct order to light up led for 100 milliseconds and switch off for 1 sec. while blinking.");
//                   o1.setText("digitalWrite(D2,LOW);");
//                   o2.setText("digitalWrite(D2,High);");
//                   o3.setText("void loop(){");
//                   o4.setText("delay(1000);}");
//                   o5.setText("delay(100);");
//                   t5.setText("");
//                   Log.d("hel", "onClick: clik");
//                   counter++;
//                   progressBar.setProgress(counter);
//               } else if (counter == 7) {
//                   if (dragLinearLayout.getChildAt(0).getId() == R.id.ink3 &&
//                           dragLinearLayout.getChildAt(1).getId() == R.id.ink2 &&
//                           dragLinearLayout.getChildAt(2).getId() == R.id.ink5 &&
//                           dragLinearLayout.getChildAt(3).getId() == R.id.ink1) {
//                       Log.d("hel", "onSwap: true");
//                       t5.setText("Correct");
//                       //     b1.setText("Next");
//                       progressBar.setProgress(counter);
//                       counter++;
//
//                   } else {
//                       t5.setText("Incorrect");
//                       sll.setText("void loop(){\ndigitalWrite(D2,High);\ndelay(100);\ndigitalWrite(D2,LOW);\ndelay(1000);}");
//                       sol.setVisibility(View.VISIBLE);
//                       dr.setVisibility(View.GONE);
//                       // b1.setText("Next");
//                       progressBar.setProgress(counter);
//                       counter++;
//                   }
//               }
               else if (counter == 6) {
                   t5.setText("Type the above code yourself for better learning.");
                   sol.setVisibility(View.GONE);
                   dr.setVisibility(View.GONE);
                   mcq.setVisibility(View.GONE);
                   question.setVisibility(View.GONE);
                   lastslidetask.setVisibility(View.VISIBLE);
                   photoView.setImageResource(R.drawable.ledblinkcircuit);
                   photoView1.setImageResource(R.drawable.ledfade);

               }
           }

           else if (intentPassedVal==3){            //led mixing



               if (counter == 1) {
                   ques.setText("Arrange the syntax of for loop in correct order");
                   o1.setText("{  }");
                   o2.setText("i++)");
                   o3.setText("i<10;");
                   o4.setText("int i=0;");
                   o5.setText("for(");
                   t5.setText("");
                   Log.d("hel", "onClick: clik");
                   if (dragLinearLayout.getChildAt(0).getId() == R.id.ink5 &&
                           dragLinearLayout.getChildAt(1).getId() == R.id.ink4 &&
                           dragLinearLayout.getChildAt(2).getId() == R.id.ink3 &&
                           dragLinearLayout.getChildAt(3).getId() == R.id.ink2) {
                       Log.d("hel", "onSwap: true");
                       t5.setText("Correct");
                       //     b1.setText("Next");


                   } else {
                       t5.setText("Incorrect");
                       sll.setText("for(\nint i=0;\ni<10;\ni++)\n{  }");
                       sol.setVisibility(View.VISIBLE);
                       dr.setVisibility(View.GONE);
                       // b1.setText("Next");
                       progressBar.setProgress(counter);
                       // b1.setText("Next");

                   }
                   counter++;
                   progressBar.setProgress(counter);
               } else if (counter == 2) {
                   sol.setVisibility(View.GONE);
                   dr.setVisibility(View.GONE);
                   mcq.setVisibility(View.VISIBLE);
                   ques.setText("In a for loop if you want to increment variable i by 5 units after every iteration you will use: ");
                   mcq1.setText("i=i+0.5");
                   mcq2.setText("i=i+5");
                   mcq3.setText("i=i+50");
                   mcq4.setText("i=i+0.05");
                   t5.setText("");
                   counter++;
                   progressBar.setProgress(counter);
               } else if (counter == 3) {
                   if (mcq2.isChecked()) {
                       t5.setText("Correct");
                       counter++;
                       progressBar.setProgress(counter);
                   } else {
                       t5.setText("Incorrect. Correct answer is i=i+5");
                       counter++;
                       progressBar.setProgress(counter);
                   }


               } else if (counter == 4) {

                   t5.setText("Type the above code yourself for better learning.");
                   sol.setVisibility(View.GONE);
                   mcq.setVisibility(View.GONE);
                   dr.setVisibility(View.GONE);
                   question.setVisibility(View.GONE);
                   lastslidetask.setVisibility(View.VISIBLE);
                   photoView.setImageResource(R.drawable.ledblinkcircuit);
                   photoView1.setImageResource(R.drawable.blikncode);


               } else if (counter == 5) {



               }
           }

           else if (intentPassedVal==4){            //Potentiometer Serial Monitor



               if (counter == 1) {


                   Log.d("hel", "onClick: clik");
                   if (dragLinearLayout.getChildAt(0).getId() == R.id.ink5 &&
                           dragLinearLayout.getChildAt(1).getId() == R.id.ink4 &&
                           dragLinearLayout.getChildAt(2).getId() == R.id.ink3 &&
                           dragLinearLayout.getChildAt(3).getId() == R.id.ink2) {
                       Log.d("hel", "onSwap: true");
                       t5.setText("Correct");
                       //     b1.setText("Next");


                   } else {
                       t5.setText("Incorrect");
                       sll.setText("void setup()\n{\npinMode(A0,INPUT)\n; Serial.begin(9600);\n}");
                       sol.setVisibility(View.VISIBLE);
                       dr.setVisibility(View.GONE);
                       // b1.setText("Next");
                       progressBar.setProgress(counter);
                       // b1.setText("Next");

                   }
                   counter++;
                   progressBar.setProgress(counter);
               } else if (counter == 2) {
                   sol.setVisibility(View.GONE);
                   dr.setVisibility(View.GONE);
                   mcq.setVisibility(View.VISIBLE);
                   ques.setText("If you write pinMode(A0,INPUT) in the void setup(), you'll have to connect the middle leg of your potentiometer to: ");
                   mcq1.setText("D1 pin of the NODE MCU");
                   mcq2.setText("A0 pin of the NODE MCU");
                   mcq3.setText("D2 pin of the NODE MCU");
                   mcq4.setText("E2 pin of NODE MCU");
                   t5.setText("");
                   counter++;
                   progressBar.setProgress(counter);
               } else if (counter == 3) {
                   if (mcq2.isChecked()) {
                       t5.setText("Correct");
                       counter++;
                       progressBar.setProgress(counter);
                   } else {
                       t5.setText("Incorrect. Correct answer is A0");
                       counter++;
                       progressBar.setProgress(counter);
                   }


               } else if (counter == 4) {

                   ques.setText("Which function will you use to read the analog values produced at pin A0 by the potentiometer:  ");
                   mcq1.setText("analogWrite(D7,1023);");
                   mcq2.setText("analogRead(A0,LOW);");
                   mcq3.setText("analogRead(A0);");
                   mcq4.setText("analogRead(A0,HIGH);");
                   t5.setText("");
                   progressBar.setProgress(counter);
                   counter++;

               } else if (counter == 5) {
                   if (mcq3.isChecked()) {
                       t5.setText("Correct");
                       counter++;
                       progressBar.setProgress(counter);

                   } else {
                       t5.setText("Incorrect. Correct answer is analogRead(A0); Always remeber this function takes only one argument.");
                       counter++;
                       progressBar.setProgress(counter);
                   }
               }

               else if (counter == 6) {

                   ques.setText("Which function is used to print values on the serial monitor? ");
                   mcq1.setText("Serial.cout()");
                   mcq2.setText("Serial.println(\" \");");
                   mcq3.setText("Serial.write();");
                   mcq4.setText("write();");
                   t5.setText("");
                   progressBar.setProgress(counter);
                   counter++;

               } else if (counter == 7) {
                   if (mcq2.isChecked()) {
                       t5.setText("Correct");
                       counter++;
                       progressBar.setProgress(counter);

                   } else {
                       t5.setText("Incorrect. Correct answer is Serial.println(\" \");");
                       counter++;
                       progressBar.setProgress(counter);
                   }
               }

               else if (counter == 8) {

                   ques.setText("what is the key board shortcut to open Serial monitor  ");
                   mcq1.setText("ctrl/cmd + shift + k");
                   mcq2.setText("ctrl/cmd + shift + l");
                   mcq3.setText("ctrl/cmd + shift + s");
                   mcq4.setText("ctrl/cmd + shift + m");
                   t5.setText("");
                   progressBar.setProgress(counter);
                   counter++;

               } else if (counter == 9) {
                   if (mcq4.isChecked()) {
                       t5.setText("Correct");
                       counter++;
                       progressBar.setProgress(counter);

                   } else {
                       t5.setText("Incorrect, correct answer is ctrl/cmd + shift + m");
                       counter++;
                       progressBar.setProgress(counter);
                   }
               }
               else if (counter == 10) {

                   ques.setText("If you write Serial.begin(9600); in your void setup() then at what baudrate will you set your serial monitor ");
                   mcq1.setText("11500");
                   mcq2.setText("9600");
                   mcq3.setText("34400");
                   mcq4.setText("100");
                   t5.setText("");
                   progressBar.setProgress(counter);
                   counter++;

               } else if (counter == 11) {
                   if (mcq2.isChecked()) {
                       t5.setText("Correct");
                       counter++;
                       progressBar.setProgress(counter);

                   } else {
                       t5.setText("Incorrect, Correct answer is 9600");
                       counter++;
                       progressBar.setProgress(counter);
                   }
               }


//               } else if (counter == 6) {
//                   sol.setVisibility(View.GONE);
//                   dr.setVisibility(View.VISIBLE);
//                   mcq.setVisibility(View.GONE);
//                   ques.setText("arrange the following in correct order to light up led for 100 milliseconds and switch off for 1 sec. while blinking.");
//                   o1.setText("digitalWrite(D2,LOW);");
//                   o2.setText("digitalWrite(D2,High);");
//                   o3.setText("void loop(){");
//                   o4.setText("delay(1000);}");
//                   o5.setText("delay(100);");
//                   t5.setText("");
//                   Log.d("hel", "onClick: clik");
//                   counter++;
//                   progressBar.setProgress(counter);
//               } else if (counter == 7) {
//                   if (dragLinearLayout.getChildAt(0).getId() == R.id.ink3 &&
//                           dragLinearLayout.getChildAt(1).getId() == R.id.ink2 &&
//                           dragLinearLayout.getChildAt(2).getId() == R.id.ink5 &&
//                           dragLinearLayout.getChildAt(3).getId() == R.id.ink1) {
//                       Log.d("hel", "onSwap: true");
//                       t5.setText("Correct");
//                       //     b1.setText("Next");
//                       progressBar.setProgress(counter);
//                       counter++;
//
//                   } else {
//                       t5.setText("Incorrect");
//                       sll.setText("void loop(){\ndigitalWrite(D2,High);\ndelay(100);\ndigitalWrite(D2,LOW);\ndelay(1000);}");
//                       sol.setVisibility(View.VISIBLE);
//                       dr.setVisibility(View.GONE);
//                       // b1.setText("Next");
//                       progressBar.setProgress(counter);
//                       counter++;
//                   }
//               }
               else if (counter == 12) {
                   t5.setText("After uploading the code open Serial monitor > set baudrate at 9600 > turn the knob of potentiometer and observe the output");
                   sol.setVisibility(View.GONE);
                   dr.setVisibility(View.GONE);
                   mcq.setVisibility(View.GONE);
                   question.setVisibility(View.GONE);
                   lastslidetask.setVisibility(View.VISIBLE);
                   photoView.setImageResource(R.drawable.potenserial);
                   photoView1.setImageResource(R.drawable.potencode);

               }
           }



           else if (intentPassedVal==5){            //Potentiometer led



               if (counter == 1) {


                   ques.setText("Arrange the following in correct order to control led brightness with potentiometer");
                   o1.setText("Upload the code and observe the output.");
                   o2.setText("analogWrite the value on the LED.");
                   o3.setText("Store the read value in a variable.");
                   o4.setText("analogRead the value from the potentiometer.");
                   o5.setText("Make the required circuit.");
                   t5.setText("");

                   Log.d("hel", "onClick: clik");
                   if (dragLinearLayout.getChildAt(0).getId() == R.id.ink5 &&
                           dragLinearLayout.getChildAt(1).getId() == R.id.ink4 &&
                           dragLinearLayout.getChildAt(2).getId() == R.id.ink3 &&
                           dragLinearLayout.getChildAt(3).getId() == R.id.ink2) {
                       Log.d("hel", "onSwap: true");
                       t5.setText("Correct");
                       //     b1.setText("Next");


                   } else {
                       t5.setText("Incorrect");
                       sll.setText("Make the required circuit.\nanalogRead the value from the potentiometer.\nStore the read value in a variable.\nanalogWrite the value on the LED.\nUpload the code and observe the output.");
                       sol.setVisibility(View.VISIBLE);
                       dr.setVisibility(View.GONE);
                       // b1.setText("Next");
                       progressBar.setProgress(counter);
                       // b1.setText("Next");

                   }
                   counter++;
                   progressBar.setProgress(counter);
               } else if (counter == 2) {
                   sol.setVisibility(View.GONE);
                   dr.setVisibility(View.GONE);
                   mcq.setVisibility(View.VISIBLE);
                   ques.setText("If you write pinMode(A0,INPUT) in the void setup(), you'll have to connect the middle leg of your potentiometer to: ");
                   mcq1.setText("D1 pin of the NODE MCU");
                   mcq2.setText("A0 pin of the NODE MCU");
                   mcq3.setText("D2 pin of the NODE MCU");
                   mcq4.setText("E2 pin of NODE MCU");
                   t5.setText("");
                   counter++;
                   progressBar.setProgress(counter);
               } else if (counter == 3) {
                   if (mcq2.isChecked()) {
                       t5.setText("Correct");
                       counter++;
                       progressBar.setProgress(counter);
                   } else {
                       t5.setText("Incorrect. Correct answer is A0");
                       counter++;
                       progressBar.setProgress(counter);
                   }


               } else if (counter == 4) {

                   ques.setText("In void setup which pin will be declared as input.  ");
                   mcq1.setText("The longer leg of the LED.");
                   mcq2.setText("The shorter leg of the LED.");
                   mcq3.setText("Output pin of the potentiometer.");
                   mcq4.setText("Power pin of the potentiometer.");
                   t5.setText("");
                   progressBar.setProgress(counter);
                   counter++;

               } else if (counter == 5) {
                   if (mcq3.isChecked()) {
                       t5.setText("Correct");
                       counter++;
                       progressBar.setProgress(counter);

                   } else {
                       t5.setText("Incorrect. Correct answer is Output pin of the potentiometer.");
                       counter++;
                       progressBar.setProgress(counter);
                   }
               }

               else if (counter == 6) {

                   ques.setText("In void setup() which pin will be declared as output. ");
                   mcq1.setText("The longer leg of the LED.");
                   mcq2.setText("The shorter leg of the LED.");
                   mcq3.setText("Output pin of the potentiometer.");
                   mcq4.setText("Power pin of the potentiometer.");
                   t5.setText("");
                   progressBar.setProgress(counter);
                   counter++;

               } else if (counter == 7) {
                   if (mcq1.isChecked()) {
                       t5.setText("Correct");
                       counter++;
                       progressBar.setProgress(counter);

                   } else {
                       t5.setText("Incorrect. Correct answer is The longer leg of the LED.");
                       counter++;
                       progressBar.setProgress(counter);
                   }
               }




               else if (counter == 8) {
                   t5.setText("After uploading the code turn the knob of potentiometer and observe the led");
                   sol.setVisibility(View.GONE);
                   dr.setVisibility(View.GONE);
                   mcq.setVisibility(View.GONE);
                   question.setVisibility(View.GONE);
                   lastslidetask.setVisibility(View.VISIBLE);
                   photoView.setImageResource(R.drawable.potenledcircuit);
                   photoView1.setImageResource(R.drawable.potenledcode);

               }
           }

           else if (intentPassedVal==6){            //Switch Serial Monitor



               if (counter == 1) {


                   Log.d("hel", "onClick: clik");
                   if (dragLinearLayout.getChildAt(0).getId() == R.id.ink5 &&
                           dragLinearLayout.getChildAt(1).getId() == R.id.ink4 &&
                           dragLinearLayout.getChildAt(2).getId() == R.id.ink3 &&
                           dragLinearLayout.getChildAt(3).getId() == R.id.ink2) {
                       Log.d("hel", "onSwap: true");
                       t5.setText("Correct");
                       //     b1.setText("Next");


                   } else {
                       t5.setText("Incorrect");
                       sll.setText("void setup()\n{\npinMode(D1,INPUT)\n; Serial.begin(9600);\n}");
                       sol.setVisibility(View.VISIBLE);
                       dr.setVisibility(View.GONE);
                       // b1.setText("Next");
                       progressBar.setProgress(counter);
                       // b1.setText("Next");

                   }
                   counter++;
                   progressBar.setProgress(counter);
               } else if (counter == 2) {
                   sol.setVisibility(View.GONE);
                   dr.setVisibility(View.GONE);
                   mcq.setVisibility(View.VISIBLE);
                   ques.setText("If you write pinMode(D1,INPUT) in the void setup(), you'll have to connect one leg of your Switch to: ");
                   mcq1.setText("D1 pin of the NODE MCU");
                   mcq2.setText("A0 pin of the NODE MCU");
                   mcq3.setText("D2 pin of the NODE MCU");
                   mcq4.setText("E2 pin of NODE MCU");
                   t5.setText("");
                   counter++;
                   progressBar.setProgress(counter);
               } else if (counter == 3) {
                   if (mcq1.isChecked()) {
                       t5.setText("Correct");
                       counter++;
                       progressBar.setProgress(counter);
                   } else {
                       t5.setText("Incorrect. Correct answer is D1");
                       counter++;
                       progressBar.setProgress(counter);
                   }


               } else if (counter == 4) {

                   ques.setText("Which function will you use to read the didital values produced at pin D1 by the Switch:  ");
                   mcq1.setText("analogWrite(D7,1023);");
                   mcq2.setText("digitalRead(D1,High);");
                   mcq3.setText("digitalRead(D1);");
                   mcq4.setText("analogRead(A0,HIGH);");
                   t5.setText("");
                   progressBar.setProgress(counter);
                   counter++;

               } else if (counter == 5) {
                   if (mcq3.isChecked()) {
                       t5.setText("Correct");
                       counter++;
                       progressBar.setProgress(counter);

                   } else {
                       t5.setText("Incorrect. Correct answer is digitalRead(D1); Always remeber this function takes only one argument.");
                       counter++;
                       progressBar.setProgress(counter);
                   }
               }

               else if (counter == 6) {

                   ques.setText("Which function is used to print values on the serial monitor? ");
                   mcq1.setText("Serial.cout()");
                   mcq2.setText("Serial.println(\" \");");
                   mcq3.setText("Serial.write();");
                   mcq4.setText("write();");
                   t5.setText("");
                   progressBar.setProgress(counter);
                   counter++;

               } else if (counter == 7) {
                   if (mcq2.isChecked()) {
                       t5.setText("Correct");
                       counter++;
                       progressBar.setProgress(counter);

                   } else {
                       t5.setText("Incorrect. Correct answer is Serial.println(\" \");");
                       counter++;
                       progressBar.setProgress(counter);
                   }
               }

               else if (counter == 8) {

                   ques.setText("what is the key board shortcut to open Serial monitor  ");
                   mcq1.setText("ctrl/cmd + shift + k");
                   mcq2.setText("ctrl/cmd + shift + l");
                   mcq3.setText("ctrl/cmd + shift + s");
                   mcq4.setText("ctrl/cmd + shift + m");
                   t5.setText("");
                   progressBar.setProgress(counter);
                   counter++;

               } else if (counter == 9) {
                   if (mcq4.isChecked()) {
                       t5.setText("Correct");
                       counter++;
                       progressBar.setProgress(counter);

                   } else {
                       t5.setText("Incorrect, correct answer is ctrl/cmd + shift + m");
                       counter++;
                       progressBar.setProgress(counter);
                   }
               }
               else if (counter == 10) {

                   ques.setText("If you write Serial.begin(9600); in your void setup() then at what baudrate will you set your serial monitor ");
                   mcq1.setText("11500");
                   mcq2.setText("9600");
                   mcq3.setText("34400");
                   mcq4.setText("100");
                   t5.setText("");
                   progressBar.setProgress(counter);
                   counter++;

               } else if (counter == 11) {
                   if (mcq2.isChecked()) {
                       t5.setText("Correct");
                       counter++;
                       progressBar.setProgress(counter);

                   } else {
                       t5.setText("Incorrect, Correct answer is 9600");
                       counter++;
                       progressBar.setProgress(counter);
                   }
               }



               else if (counter == 12) {
                   t5.setText("After uploading the code open Serial monitor > set baudrate at 9600 > turn the knob of potentiometer and observe the output");
                   sol.setVisibility(View.GONE);
                   dr.setVisibility(View.GONE);
                   mcq.setVisibility(View.GONE);
                   question.setVisibility(View.GONE);
                   lastslidetask.setVisibility(View.VISIBLE);
                   photoView.setImageResource(R.drawable.switchcircuit);
                   photoView1.setImageResource(R.drawable.switchserial);

               }
           }


           else if (intentPassedVal==7){            //Switch led



               if (counter == 1) {


                   ques.setText("Arrange the following in correct order to control an led with a switch");
                   o1.setText("Upload the code and observe the output.");
                   o2.setText("digitalWrite the value on the LED.");
                   o3.setText("Store the read value in a variable.");
                   o4.setText("digitalRead the value from the Switch.");
                   o5.setText("Make the required circuit.");
                   t5.setText("");

                   Log.d("hel", "onClick: clik");
                   if (dragLinearLayout.getChildAt(0).getId() == R.id.ink5 &&
                           dragLinearLayout.getChildAt(1).getId() == R.id.ink4 &&
                           dragLinearLayout.getChildAt(2).getId() == R.id.ink3 &&
                           dragLinearLayout.getChildAt(3).getId() == R.id.ink2) {
                       Log.d("hel", "onSwap: true");
                       t5.setText("Correct");
                       //     b1.setText("Next");


                   } else {
                       t5.setText("Incorrect");
                       sll.setText("Make the required circuit.\ndigitalRead the value from the Switch.\nStore the read value in a variable.\ndigitalWrite the value on the LED.\nUpload the code and observe the output.");
                       sol.setVisibility(View.VISIBLE);
                       dr.setVisibility(View.GONE);
                       // b1.setText("Next");
                       progressBar.setProgress(counter);
                       // b1.setText("Next");

                   }
                   counter++;
                   progressBar.setProgress(counter);
               } else if (counter == 2) {
                   sol.setVisibility(View.GONE);
                   dr.setVisibility(View.GONE);
                   mcq.setVisibility(View.VISIBLE);
                   ques.setText("If you write pinMode(D1,INPUT) in the void setup(), you'll have to connect one leg of your switch to: ");
                   mcq1.setText("D1 pin of the NODE MCU");
                   mcq2.setText("A0 pin of the NODE MCU");
                   mcq3.setText("D2 pin of the NODE MCU");
                   mcq4.setText("E2 pin of NODE MCU");
                   t5.setText("");
                   counter++;
                   progressBar.setProgress(counter);
               } else if (counter == 3) {
                   if (mcq1.isChecked()) {
                       t5.setText("Correct");
                       counter++;
                       progressBar.setProgress(counter);
                   } else {
                       t5.setText("Incorrect. Correct answer is D1");
                       counter++;
                       progressBar.setProgress(counter);
                   }


               } else if (counter == 4) {

                   ques.setText("In void setup which pin will be declared as input.  ");
                   mcq1.setText("The longer leg of the LED.");
                   mcq2.setText("The shorter leg of the LED.");
                   mcq3.setText("Any pin of the switch.");
                   mcq4.setText("Power pin of the switch.");
                   t5.setText("");
                   progressBar.setProgress(counter);
                   counter++;

               } else if (counter == 5) {
                   if (mcq3.isChecked()) {
                       t5.setText("Correct");
                       counter++;
                       progressBar.setProgress(counter);

                   } else {
                       t5.setText("Incorrect. Correct answer is Any pin of the switch.");
                       counter++;
                       progressBar.setProgress(counter);
                   }
               }

               else if (counter == 6) {

                   ques.setText("In void setup() which pin will be declared as output. ");
                   mcq1.setText("The longer leg of the LED.");
                   mcq2.setText("The shorter leg of the LED.");
                   mcq3.setText("Output pin of the potentiometer.");
                   mcq4.setText("Power pin of the potentiometer.");
                   t5.setText("");
                   progressBar.setProgress(counter);
                   counter++;

               } else if (counter == 7) {
                   if (mcq1.isChecked()) {
                       t5.setText("Correct");
                       counter++;
                       progressBar.setProgress(counter);

                   } else {
                       t5.setText("Incorrect. Correct answer is The longer leg of the LED.");
                       counter++;
                       progressBar.setProgress(counter);
                   }
               }




               else if (counter == 8) {
                   t5.setText("After uploading the code turn the switch on/off and observe the led.");
                   sol.setVisibility(View.GONE);
                   dr.setVisibility(View.GONE);
                   mcq.setVisibility(View.GONE);
                   question.setVisibility(View.GONE);
                   lastslidetask.setVisibility(View.VISIBLE);
                   photoView.setImageResource(R.drawable.potenledcircuit);
                   photoView1.setImageResource(R.drawable.potenledcode);

               }
           }

            }
        });



        // set all children draggable except the first (the header)
        for (int i = 0; i < dragLinearLayout.getChildCount(); i++) {
            View child = dragLinearLayout.getChildAt(i);
            dragLinearLayout.setViewDraggable(child, child); // the child is its own drag handle
            Log.d("hel", "onCreate: " + dragLinearLayout.getChildAt(0).getId());
        }

        dragLinearLayout.setOnViewSwapListener(new DragLinearLayout.OnViewSwapListener() {
            @Override
            public void onSwap(View firstView, int firstPosition,
                               View secondView, int secondPosition) {
                if (dragLinearLayout.getChildAt(0).getId() == R.id.ink5 &&
                        dragLinearLayout.getChildAt(1).getId() == R.id.ink4 &&
                        dragLinearLayout.getChildAt(2).getId() == R.id.ink3 &&
                        dragLinearLayout.getChildAt(3).getId() == R.id.ink2) {
                    Log.d("hel", "onSwap: true");
                }

                // update data, etc..
            }
        });



    }





}
