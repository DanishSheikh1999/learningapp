package com.android.learningapp.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.android.learningapp.Adapters.CardViewAdapter;
import com.android.learningapp.CodingBasics;
import com.android.learningapp.Microcontrollers;
import com.android.learningapp.R;
import com.android.learningapp.Sensors;

import java.util.ArrayList;

import uk.co.deanwild.materialshowcaseview.MaterialShowcaseSequence;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseView;
import uk.co.deanwild.materialshowcaseview.ShowcaseConfig;


public class FragmentHome extends Fragment implements View.OnClickListener {
    private TourGuide tourGuide;
    private CardView codingBasics, microControllers, sensors;
    private ViewPager viewPager;
    private CardViewAdapter adapter;
    private Context context;
    private int[] layouts = {R.layout.latest_gadgets, R.layout.latest_gadgets, R.layout.latest_gadgets};
    private ArrayList<String> Title = new ArrayList<String>();
    private ArrayList<String> Description = new ArrayList<String>();
    private ArrayList<String> Image = new ArrayList<String>();
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            tourGuide = (TourGuide) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException("Error in retrieving data. Please try again.");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
    }

    void getValues() {
        Title.add("Raspberry PI 4");
        Title.add("Google Sadia");
        Title.add("Google Quantum Computing");
        Description.add("Raspberry Pi 4 comes with Gigabit Ethernet, along with onboard wireless networking and Bluetooth.");
        Description.add("Stadia,a new game streaming platform from Google that doesn't require an expensive console or PC.");
        Description.add("Running on the laws of quantum physics opposed to the classical computers running on classical physics.");
        Image.add("https://firebasestorage.googleapis.com/v0/b/iot-learning-application.appspot.com/o/Project%20Resources%2FLatest%20Gadgets%2FRaspberry%20PI%204.png?alt=media&token=cd187a58-2da1-4909-912b-40189b24e34e");
        Image.add("https://firebasestorage.googleapis.com/v0/b/iot-learning-application.appspot.com/o/Project%20Resources%2FLatest%20Gadgets%2FGoogle%20Sadia.png?alt=media&token=3c6b19d7-d08f-4d46-bb68-ae8ed186d940");
        Image.add("https://firebasestorage.googleapis.com/v0/b/iot-learning-application.appspot.com/o/Project%20Resources%2FLatest%20Gadgets%2FGoogle%20Quantum%20Computing.png?alt=media&token=13770447-39ea-401f-accc-0a9a6c31c7e7");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        codingBasics = view.findViewById(R.id.coding_basics);
        microControllers = view.findViewById(R.id.boards_basic);
        sensors = view.findViewById(R.id.sensors_basic);
        viewPager = view.findViewById(R.id.latest_gadgets_viewpager);
        getValues();
        adapter = new CardViewAdapter(layouts, context, Title, Description, Image);
        codingBasics.setOnClickListener(this);
        microControllers.setOnClickListener(this);
        sensors.setOnClickListener(this);
        viewPager.setAdapter(adapter);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.coding_basics:
                startActivity(new Intent(context, CodingBasics.class));
                break;
            case R.id.boards_basic:
                startActivity(new Intent(context, Microcontrollers.class));
                break;
            case R.id.sensors_basic:
                startActivity(new Intent(context, Sensors.class));
                break;
        }
    }

    public void guide() {
        Log.d("Inside the guide","HOME/-guide");
        ShowcaseConfig config = new ShowcaseConfig();
        //config.setDelay(2000); // half second between each showcase view
        MaterialShowcaseSequence sequence = new MaterialShowcaseSequence(getActivity(), "Home");

        sequence.setConfig(config);
        sequence.addSequenceItem(new MaterialShowcaseView.Builder(getActivity())
                .setTarget(viewPager)
                .setGravity(0)
                .withRectangleShape()
                .setDelay(500)
                .setDismissText("OK")
                .setContentText("Explore the new")
                .build());
        sequence.addSequenceItem(new MaterialShowcaseView.Builder(getActivity())
                .setTarget(viewPager)
                .setGravity(0)
                .withRectangleShape()
                .setDismissText("OK")
                .setDelay(600)
                .setContentText("Swipe to change")
                .build());

        sequence.addSequenceItem(new MaterialShowcaseView.Builder(getActivity())
                .setTarget(codingBasics)
                .setGravity(0)
                .setDelay(2000)
                .setDismissText("OK")
                .setContentText("Learn the basics of coding here")
                .withRectangleShape()
                .build());

        sequence.addSequenceItem(new MaterialShowcaseView.Builder(getActivity())
                .setTarget(microControllers)
                .setTargetTouchable(true)
                .setGravity(0)
                .setDelay(500)
                .setDismissText("OK")
                .setContentText("Click here to know more about Microcontrollers.")
                .withRectangleShape()
                .build());

        sequence.addSequenceItem(new MaterialShowcaseView.Builder(getActivity())
                .setTarget(sensors)
                .setGravity(0)
                .setDelay(500)
                .setDismissText("OK")
                .setContentText("Learn about the sensors that you will be working with.")
                .withRectangleShape()
                .build());
        sequence.start();
        sequence.setOnItemDismissedListener(new MaterialShowcaseSequence.OnSequenceItemDismissedListener() {
            @Override
            public void onDismiss(MaterialShowcaseView itemView, int position) {
                if (position==0)
                    viewPager.setCurrentItem(1);
                if (position == 4) {
                    tourGuide.startTourTasks();
                }
            }
        });
    }

    public void updateTour(int pos){
        Log.d("Inside the fragment","HOME");
        if(pos==1){
            guide();
        }
    }
    public interface TourGuide {
        void startTourTasks( );

    }
}
