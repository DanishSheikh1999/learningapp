package com.android.learningapp.MicrocontrollersBasics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import com.android.learningapp.Adapters.SlidesPagerAdapter;
import com.android.learningapp.CodingBasics;
import com.android.learningapp.R;


public class Breadboard extends AppCompatActivity implements View.OnClickListener {


    private ViewPager mPager;
    private int[] layouts = {R.layout.breadboard0,R.layout.breadboard1,R.layout.breadboard2},pro={33,66,100};
    private SlidesPagerAdapter mpagerAdapter;

    private LinearLayout Dots_Layout;
    private ImageView[] dots;
    private Button BnNext,BnSkip;
    // private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_breadboard);


        mPager =(ViewPager)findViewById(R.id.viewPager);
        //progressBar=(ProgressBar)findViewById(R.id.progress) ;
        mpagerAdapter=new SlidesPagerAdapter(layouts,this);
        mPager.setAdapter(mpagerAdapter);

        Dots_Layout=(LinearLayout)findViewById(R.id.dotsLayout);
        BnNext=(Button)findViewById(R.id.bnNext);
        BnSkip=(Button)findViewById(R.id.bnSkip);

        BnNext.setOnClickListener(this);
        BnSkip.setOnClickListener(this);


        createDots(0);

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                createDots(position);
                if(position==layouts.length-1)
                {
                    BnSkip.setText("Next");
                    BnSkip.setVisibility(View.VISIBLE);
                }
                else {
                    // BnNext.setText("Next");
                    BnSkip.setVisibility(View.INVISIBLE);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void createDots(int current_position)
    {
        if(Dots_Layout!=null)
            Dots_Layout.removeAllViews();

        dots= new ImageView[layouts.length];

        for(int i=0;i<layouts.length;i++)
        {
            dots[i]=new ImageView(this);
            if(i==current_position)
            {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.active_dots));
                //    progressBar.setProgress(pro[i]);
            }
            else
            {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.default_dots));
            }

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(15,0,15,0);

            Dots_Layout.addView(dots[i],params);
        }
    }

    @Override
    public void onClick(View view) {

        switch(view.getId())
        {
          /*  case R.id.bnNext:
                loadNextSlide();
                break;*/
            case R.id.bnSkip:
                loadHome();
                break;
        }



    }

    private void loadHome()
    {
        startActivity(new Intent(this, CodingBasics.class));
        finish();
    }

    private void loadNextSlide()
    {
        int next_slide=mPager.getCurrentItem()+1;

        if(next_slide<layouts.length)
        {
            mPager.setCurrentItem(next_slide);
        }
        else
        {
            loadHome();
        }
    }
}