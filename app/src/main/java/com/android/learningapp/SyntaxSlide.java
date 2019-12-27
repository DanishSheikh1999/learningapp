package com.android.learningapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.android.learningapp.Adapters.SyntaxPagerAdapter;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class SyntaxSlide extends AppCompatActivity implements View.OnClickListener {
    private ViewPager viewPager;
    private int[] layouts = {R.layout.syntax_slide_recycler, R.layout.syntax_slide_recycler, R.layout.syntax_slide_recycler};
    private SyntaxPagerAdapter syntaxPagerAdapter;
    private LinearLayout Dots_Layout;
    private ImageView[] dots;
    private Button BnSkip;
    FirebaseFirestore firebaseFirestore;
    private ArrayList<String> Title = new ArrayList<String>();
    private ArrayList<String> Description = new ArrayList<String>();
    private ArrayList<String> Image = new ArrayList<String>();
    private ArrayList<String> Heading = new ArrayList<String>();
    private ArrayList<String> AllTopic = new ArrayList<String>();
    private Context context = SyntaxSlide.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.syntax_slides);
        Intent intent =getIntent();
        firebaseFirestore = FirebaseFirestore.getInstance();
        String topic = intent.getStringExtra("Topic");
        initializeArrayList(topic);
        viewPager = (ViewPager) findViewById(R.id.viewPagerSyntax);
        syntaxPagerAdapter = new SyntaxPagerAdapter(layouts, context, Title, Heading, Description, Image);
        viewPager.setAdapter(syntaxPagerAdapter);

        Dots_Layout = (LinearLayout) findViewById(R.id.dotsLayout);
        BnSkip = (Button) findViewById(R.id.bnSkip);

        BnSkip.setOnClickListener(this);
        createDots(0);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                createDots(position);
                if (position == layouts.length - 1) {
                    BnSkip.setText("Next");
                    BnSkip.setVisibility(View.VISIBLE);
                } else {
                    BnSkip.setVisibility(View.INVISIBLE);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
//
//    private void getAllTopic(){
//
//    }

    private void initializeArrayList(String topic) {
        Title.add(topic);
        Title.add(topic);
        Title.add(topic);
        Heading.add("Description");
        Heading.add("Syntax");
        Heading.add("Example");
        Description.add("Here comes the description of the "+ topic);
        Description.add("Here comes the syntax of the "+ topic);
        Description.add("Here comes the example of the "+ topic);
//        firebaseFirestore.collection("App Resources").document("Arduino Programming")
//                .collection("Detailed Topics").document(topic).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                DocumentSnapshot document = task.getResult();
//                Description.add(document.getString("Description"));
//                Description.add(document.getString("Syntax"));
//                Description.add(document.getString("Example"));
//            }
//        });

        Image.add("First Image");
        Image.add("Second Image");
        Image.add("Third Image");
    }

    private void createDots(int current_position) {
        if (Dots_Layout != null)
            Dots_Layout.removeAllViews();

        dots = new ImageView[layouts.length];

        for (int i = 0; i < layouts.length; i++) {
            dots[i] = new ImageView(this);
            if (i == current_position) {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.active_dots));
                //    progressBar.setProgress(pro[i]);
            } else {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.default_dots));
            }

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(15, 0, 15, 0);

            Dots_Layout.addView(dots[i], params);
        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.bnSkip:
                loadHome();
                break;
        }
    }

    private void loadHome() {
        startActivity(new Intent(this, CodingBasics.class));
        finish();
    }

}
