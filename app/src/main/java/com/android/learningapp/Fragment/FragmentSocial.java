package com.android.learningapp.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.android.learningapp.R;
import com.facebook.CallbackManager;

import uk.co.deanwild.materialshowcaseview.MaterialShowcaseSequence;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseView;
import uk.co.deanwild.materialshowcaseview.ShowcaseConfig;

public class FragmentSocial extends Fragment implements View.OnClickListener {

    CardView facebookLogin;
    CallbackManager callbackManager;
    Button leaderboard,weekly;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //      FacebookSdk.sdkInitialize(getApplicationContext());
        //      callbackManager = CallbackManager.Factory.create();
        //      facebookLogin.setOnClickListener(this);
//        btnFBLogin.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
//            @Override
//            public void onSuccess(LoginResult loginResult) {
//                tvLoginResult.setText( "Success Login" + "\n"+
//                        "User = " + loginResult.getAccessToken().getUserId() + "\n" +
//                        "Token = " + loginResult.getAccessToken().getToken()
//                );
//            }
//
//            @Override
//            public void onCancel() {
//
//            }
//
//            @Override
//            public void onError(FacebookException e) {
//
//            }
//        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_social, container, false);
        leaderboard=view.findViewById(R.id.leaderboard);
        weekly=view.findViewById(R.id.weekly);
        return view;
    }

    @Override
    public void onClick(View v) {
    }
    public void guide() {
        Log.d("Inside the guide","Social/-guide");
        ShowcaseConfig config = new ShowcaseConfig();
        config.setDelay(500); // half second between each showcase view
        MaterialShowcaseSequence sequence = new MaterialShowcaseSequence(getActivity(), "Social");

        sequence.setConfig(config);
        sequence.addSequenceItem(new MaterialShowcaseView.Builder(getActivity())
                .setTarget(leaderboard)
                .setGravity(0)
                .setDismissText("OK")
                .setContentText("Here you will find the scores of others around the world and be able to compete with them")
                .withRectangleShape()
                .build());
        sequence.addSequenceItem(new MaterialShowcaseView.Builder(getActivity())
                .setTarget(weekly)
                .setGravity(0)
                .setDismissText("OK")
                .setContentText("Check your weekly activities here")
                .withRectangleShape()
                .build());


        sequence.start();

    }
    public void updateTour(int pos){
        Log.d("Inside the fragment","Task"+pos);
        if(pos==3){
            guide();
        }


    }

}
