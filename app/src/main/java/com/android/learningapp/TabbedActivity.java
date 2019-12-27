package com.android.learningapp;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.android.learningapp.Adapters.LockableViewPager;
import com.android.learningapp.Adapters.SectionsPagerAdapter;
import com.android.learningapp.Fragment.FragmentHome;
import com.android.learningapp.Fragment.FragmentSocial;
import com.android.learningapp.Fragment.FragmentTask;
import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseSequence;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseView;
import uk.co.deanwild.materialshowcaseview.ShowcaseConfig;


public class TabbedActivity extends AppCompatActivity implements View.OnClickListener,FragmentHome.TourGuide,FragmentTask.TourGuide{

    FirebaseFirestore firebaseFirestore;
    ImageButton home, task, social;
    LockableViewPager viewPager;
    ImageView profileImage;
    GoogleSignInAccount account;
    GoogleSignInClient client;
    GoogleSignInOptions gso;
    TextView Thome, Ttask, Tsocial;
    CardView tablayout;
    ConstraintLayout nav_menu;
    Button profile, logout, nav;
    Animation clockwise, anticlockise;
    int isNavOpen = 0;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_layout);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        firebaseFirestore = FirebaseFirestore.getInstance();
        account = GoogleSignIn.getLastSignedInAccount(this);
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        client = GoogleSignIn.getClient(this, gso);
        profileImage = findViewById(R.id.profile);
        Thome = findViewById(R.id.text_home);
        Ttask = findViewById(R.id.text_task);
        Tsocial = findViewById(R.id.text_social);
        tablayout = findViewById(R.id.tabs);
        nav_menu = findViewById(R.id.nav_menu);
        profile = findViewById(R.id.profile_shortcut);
        logout = findViewById(R.id.logout_shortcut);
        clockwise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_clockwise);
        anticlockise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_anticlockwise);
        assert account != null;
        Uri photo_url = account.getPhotoUrl();
        if (photo_url != null) {
            Glide.with(TabbedActivity.this).load(photo_url)
                    .into(profileImage);
        }
        viewPager = findViewById(R.id.view_pager);
        viewPager.setSwipeable(false);
        viewPager.setAdapter(sectionsPagerAdapter);
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        home = findViewById(R.id.home);
        task = findViewById(R.id.task);
        social = findViewById(R.id.social);
        nav = findViewById(R.id.nav_button);
        home.setOnClickListener(this);
        task.setOnClickListener(this);
        social.setOnClickListener(this);
        profileImage.setOnClickListener(this);
        nav.setOnClickListener(this);
        profile.setOnClickListener(this);
        logout.setOnClickListener(this);
        guide();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home:
                home();
                break;
            case R.id.task:
                task();
                break;
            case R.id.social:
                social();
                break;
            case R.id.profile:
            case R.id.profile_shortcut:
                startActivity(new Intent(this, ProfilePage.class));
                finish();
                break;
            case R.id.nav_button:
                isNavOpen = 1 - isNavOpen;
                if (isNavOpen == 1) {
                    tablayout.setVisibility(View.GONE);
                    viewPager.setVisibility(View.GONE);
                    nav_menu.setVisibility(View.VISIBLE);
                    nav.startAnimation(clockwise);
                } else {
                    tablayout.setVisibility(View.VISIBLE);
                    viewPager.setVisibility(View.VISIBLE);
                    nav_menu.setVisibility(View.GONE);
                    nav.startAnimation(anticlockise);
                }
                break;
            case R.id.logout_shortcut:
                client.signOut().addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        startActivity(new Intent(TabbedActivity.this, SplashScreen.class));
                        finish();
                    }
                });
                break;
        }
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Exit")
                .setMessage("Are you sure?")
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();
                    }
                }).setNegativeButton("no", null).show();
    }

    public void guide() {
        ShowcaseConfig config = new ShowcaseConfig();
        config.setDelay(500); // half second between each showcase view
        MaterialShowcaseSequence sequenceTask = new MaterialShowcaseSequence(this, "Tabs");

        sequenceTask.setConfig(config);

        sequenceTask.addSequenceItem(new MaterialShowcaseView.Builder(this)
                .setTarget(home)
                .setGravity(0)
                .setDismissText("OK")
                .setContentText("Click here to open the home tab")
                .withRectangleShape()
                .build());

        sequenceTask.addSequenceItem(new MaterialShowcaseView.Builder(this)
                .setTarget(profileImage)

                .setGravity(0)
                .setDismissText("OK")
                .setContentText("Click here to view your profile")
                .withRectangleShape()
                .build());
        sequenceTask.addSequenceItem(new MaterialShowcaseView.Builder(this)
                .setTarget(nav)
                .setGravity(0)
                .setDismissText("OK")
                .setContentText("Click here to logout")
                .withRectangleShape()
                .build());
        sequenceTask.start();
        sequenceTask.setOnItemDismissedListener(new MaterialShowcaseSequence.OnSequenceItemDismissedListener() {
            @Override
            public void onDismiss(MaterialShowcaseView itemView, int position) {
                if (position == 2) {
                    Log.d("Main_Activity","pos:3");
                    startTourHome();
                    viewPager.setCurrentItem(0);
                }
            }
        });
    }
    public void startTourHome() {
        String tag = "android:switcher:" + R.id.view_pager + ":" + 0;
        FragmentHome fragmentTasks = (FragmentHome) getSupportFragmentManager().findFragmentByTag(tag);
        fragmentTasks.updateTour(1);

    }
    public void startTourTasks() {
       task();
        ShowcaseConfig config = new ShowcaseConfig();
        config.setDelay(500); // half second between each showcase view
        MaterialShowcaseSequence sequence = new MaterialShowcaseSequence(this, "Task1");

        sequence.setConfig(config);
        sequence.addSequenceItem(new MaterialShowcaseView.Builder(this)
                .setTarget(task)
                .setGravity(0)
                .setDismissText("OK")
                .setContentText("Here you will find differnt tasks")
                .withRectangleShape()
                .build());
        sequence.start();
        sequence.setOnItemDismissedListener(new MaterialShowcaseSequence.OnSequenceItemDismissedListener() {
            @Override
            public void onDismiss(MaterialShowcaseView itemView, int position) {
                if (position == 0) {

        String tag = "android:switcher:" + R.id.view_pager + ":" + 1;
        FragmentTask fragmentTasks = (FragmentTask) getSupportFragmentManager().findFragmentByTag(tag);
        fragmentTasks.updateTour(2);}
                }
            });
    }
    public void startTourSocial() {
        social();
        ShowcaseConfig config = new ShowcaseConfig();
        config.setDelay(500); // half second between each showcase view
        MaterialShowcaseSequence sequence = new MaterialShowcaseSequence(this, "Social1");

        sequence.setConfig(config);
        sequence.addSequenceItem(new MaterialShowcaseView.Builder(this)
                .setTarget(social)
                .setGravity(0)
                .setDismissText("OK")
                .setContentText("Connect and Compete with your friends and learners from all over the world")
                .withRectangleShape()
                .build());
        sequence.start();
        sequence.setOnItemDismissedListener(new MaterialShowcaseSequence.OnSequenceItemDismissedListener() {
            @Override
            public void onDismiss(MaterialShowcaseView itemView, int position) {
                if (position == 0) {

                    String tag = "android:switcher:" + R.id.view_pager + ":" + 2;
                    FragmentSocial fragmentSocial = (FragmentSocial) getSupportFragmentManager().findFragmentByTag(tag);
                    fragmentSocial.updateTour(3);}
            }
        });
    }
    public  void home(){
        viewPager.setCurrentItem(0);
        home.setImageResource(R.drawable.ic_home_black_40dp);
        task.setImageResource(R.drawable.ic_build_black_24dp);
        social.setImageResource(R.drawable.ic_person_black_24dp);
        Thome.setVisibility(View.VISIBLE);
        Ttask.setVisibility(View.GONE);
        Tsocial.setVisibility(View.GONE);

    }
    public void task(){
        viewPager.setCurrentItem(1);
        home.setImageResource(R.drawable.ic_home_black_24dp);
        task.setImageResource(R.drawable.ic_build_black_40dp);
        social.setImageResource(R.drawable.ic_person_black_24dp);
        Thome.setVisibility(View.GONE);
        Ttask.setVisibility(View.VISIBLE);
        Tsocial.setVisibility(View.GONE);
    }
    public void social(){
        viewPager.setCurrentItem(2);
        home.setImageResource(R.drawable.ic_home_black_24dp);
        task.setImageResource(R.drawable.ic_build_black_24dp);
        social.setImageResource(R.drawable.ic_person_black_40dp);
        Thome.setVisibility(View.GONE);
        Ttask.setVisibility(View.GONE);
        Tsocial.setVisibility(View.VISIBLE);
    }
}
