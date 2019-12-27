package com.android.learningapp.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.learningapp.Adapters.SensorRecViewAdapter;
import com.android.learningapp.R;

import java.util.ArrayList;

import uk.co.deanwild.materialshowcaseview.MaterialShowcaseSequence;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseView;
import uk.co.deanwild.materialshowcaseview.ShowcaseConfig;

public class FragmentTask extends Fragment {
    private TourGuide tourGuide;
    private RecyclerView recyclerView;
    private SensorRecViewAdapter recyclerViewAdapter;
    private Context context;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<String> Title = new ArrayList<String>();
    private ArrayList<String> Purpose = new ArrayList<String>();
    private ArrayList<String> Description = new ArrayList<String>();
    private ArrayList<String> Image = new ArrayList<String>();
    private CardView sensor_week;
    private View v;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            tourGuide = (FragmentTask.TourGuide) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException("Error in retrieving data. Please try again.");
        }
    }
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

    }

    private void getValues(){
        Title.add("LED");
        Title.add("Ultrasonic");
        Title.add("Potentiometer");
        Purpose.add("Emits Light.");
        Purpose.add("Finds distance.");
        Purpose.add("Varies Resistance.");
        Description.add("A light-emitting diode is a semiconductor light source that emits light when current flows through it.");
        Description.add("Ultrasonic sensors measure distances based on transmitting and receiving ultrasonic signals. ");
        Description.add("A potentiometer is a three-terminal resistor with a sliding or rotating contact that forms an adjustable voltage divider");
        Image.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTTIsyQW1aDXV7X-oQmZytXjtYfj3NeApr0HmB0Zy-J7Y0CRgsN&s");
        Image.add("https://cdn.shopify.com/s/files/1/0672/9409/products/hc-sr04-ultrasonic-module-ultrasonic-sensor_1024x1024.jpg?v=1564132976");
        Image.add("https://upload.wikimedia.org/wikipedia/commons/0/0a/Electronic-Component-Potentiometer.jpg");
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_task, container, false);
        getValues();
        context = getContext();
        recyclerView = view.findViewById(R.id.recyclerViewSensor);
        recyclerViewAdapter = new SensorRecViewAdapter(context, Title, Purpose, Description, Image);
        layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);

        sensor_week = view.findViewById(R.id.sensor_of_the_week);
        return view;
    }
    public void guide() {
        Log.d("Inside the guide","Task/-guide");
         // half second between each showcase view
        MaterialShowcaseSequence sequence = new MaterialShowcaseSequence(getActivity(), "Task");
        sequence.addSequenceItem(new MaterialShowcaseView.Builder(getActivity())
                .setTarget(sensor_week)
                .setGravity(0)
                .setDismissText("OK")
                .setDelay(500)
                .setContentText("You will get tasks on different sensors every week")
                .withRectangleShape()
                .build());
        sequence.addSequenceItem(new MaterialShowcaseView.Builder(getActivity())
                .setTarget(recyclerView.getLayoutManager().findViewByPosition(0))
                .setGravity(0)
                .setTargetTouchable(true)
                .setDismissText("OK")
                .setContentText("Click on LED to view the tasks")
                .withRectangleShape()
                .setDelay(500)
                .build());
        sequence.addSequenceItem(new MaterialShowcaseView.Builder(getActivity())
                .setTarget(recyclerView.getLayoutManager().findViewByPosition(0))
                .setGravity(0)
                .setDismissText("OK")
                .setContentText("Complete these tasks to earn points")
                .withRectangleShape()
                .setDelay(2000)
                .build());


        sequence.start();
        sequence.setOnItemDismissedListener(new MaterialShowcaseSequence.OnSequenceItemDismissedListener() {
            @Override
            public void onDismiss(MaterialShowcaseView itemView, int position) {
                if (position == 2) {
                    tourGuide.startTourSocial();

                }
            }
        });
    }
    public void updateTour(int pos){
        Log.d("Inside the fragment","Task"+pos);
        if(pos==2){
            guide();
        }

    }

    public interface TourGuide {
        void startTourSocial( );

    }
}
