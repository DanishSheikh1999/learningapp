package com.android.learningapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.mikhaellopez.circularimageview.CircularImageView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.Objects;

import static android.view.View.GONE;

public class ProfilePage extends AppCompatActivity implements View.OnClickListener {

    ImageButton edit, more;
    Button back;
    CircularImageView profileImage;
    TextView fullName, userName, Description, Email, Phone, fbStatus;
    GoogleSignInAccount googleSignInAccount;
    LinearLayout detailsExtra;
    EditText desc;
    FirebaseFirestore database = FirebaseFirestore.getInstance();
    String description = "";
    SharedPreferences localValues;
    private CardView facebook;
    private LoginButton fbLogin;
    private AccessToken mAccessToken;
    private CallbackManager callbackManager;
    private String UID = "";
    private String name;
    int detailOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_page);
        googleSignInAccount = GoogleSignIn.getLastSignedInAccount(this);
        UID = googleSignInAccount.getId();
        localValues = getSharedPreferences("Profile Details", MODE_PRIVATE);
        fullName = findViewById(R.id.fullname);
        userName = findViewById(R.id.username);
        Description = findViewById(R.id.descrtext);
        back = findViewById(R.id.back_button);
        fbStatus = findViewById(R.id.message);
        callbackManager = CallbackManager.Factory.create();
        edit = (ImageButton) findViewById(R.id.edit_fields);
        more = (ImageButton) findViewById(R.id.more_details);
        facebook = findViewById(R.id.facebook);
        fbLogin = findViewById(R.id.facebookLogin);
        Email = findViewById(R.id.email_id);
        Phone = findViewById(R.id.phone_num);
        detailsExtra = findViewById(R.id.extra_details);
        profileImage = findViewById(R.id.profile_image);
        fullName.setText(googleSignInAccount.getDisplayName());
        Email.setText(googleSignInAccount.getEmail());
        Phone.setText(googleSignInAccount.getId());
        Log.d("DEBUG", "About to call the checkDescription()");
        Description.setText(localValues.getString("Description", "Nothing is true, everything is permitted."));
        checkDescription();
        String un = "@" + (Objects.requireNonNull(googleSignInAccount.getGivenName())).toLowerCase();
        detailOpen = 0;
        userName.setText(un);
        assert googleSignInAccount != null;
        Uri photo_url = googleSignInAccount.getPhotoUrl();
        if (photo_url != null) {
            Glide.with(ProfilePage.this).load(photo_url)
                    .into(profileImage);
        }

        more.setOnClickListener(this);
        back.setOnClickListener(this);
        edit.setOnClickListener(this);
        facebook.setOnClickListener(this);
        if (isLoggedIn()) fbStatus.setText("Log OUT from facebook");
        else fbStatus.setText("Connect with facebook");
        fbLogin.setReadPermissions(Arrays.asList(
                "public_profile", "email"));
        fbLogin.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                mAccessToken = loginResult.getAccessToken();
                Log.d("Facebook Deb", mAccessToken.toString());
                Log.d("Facebook Deb", "Calling getUserProfile()");
                getUserProfile(mAccessToken);
            }

            @Override
            public void onCancel() {
                Log.d("Facebook Deb", "onCancel() executed");
            }

            @Override
            public void onError(FacebookException error) {
                Log.d("Facebook Deb", "onError() executed");
                Log.d("Facebook Deb", error.toString());
            }
        });
    }

    public boolean isLoggedIn() {
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        return accessToken != null;
    }

    private void getUserProfile(AccessToken currentAccessToken) {
        Log.d("Facebook Deb", "Inside getUserProfile()");
        Log.d("Facebook Deb", currentAccessToken.toString());
        GraphRequest request = GraphRequest.newMeRequest(
                currentAccessToken,
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        try {
                            name = object.getString("name");
                            //  email = object.getString("email");
                            //  gender = object.getString("gender");
                            //birthday = object.getString("birthday");
                            Log.d("Facebook Deb", name);
                            Toast.makeText(ProfilePage.this, name, Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.d("Facebook Deb", e.toString());
                        }
                    }
                });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,email,gender, birthday");
        request.setParameters(parameters);
        request.executeAsync();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @SuppressLint("ResourceAsColor")
    private void checkDescription() {
        Log.d("DEBUG", "Inside the checkDescription()");
        Log.d("DEBUG", UID);
        DocumentReference docRef = database.collection("Users").document(UID);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d("DEBUG", "DocumentSnapshot data: " + document.getData());
                        localValues.edit().putString("Description", document.getString("Description")).apply();
                        Description.setText(document.getString("Description"));
                        Log.d("DEBUG", description);
                    } else {
                        Log.d("DEBUG", "Found null document");
                    }
                } else {
                    Log.d("DEBUG", "Error finding the document");
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_button:
                startActivity(new Intent(ProfilePage.this, TabbedActivity.class));
                finish();
                break;
            case R.id.more_details:
                detailOpen = 1 - detailOpen;
                if (detailOpen == 1) {
                    more.setImageResource(R.drawable.ic_up_black_30dp);
                    detailsExtra.setVisibility(View.VISIBLE);
                } else {
                    more.setImageResource(R.drawable.ic_down_black_30dp);
                    detailsExtra.setVisibility(GONE);
                }
                break;
            case R.id.edit_fields:
                Toast.makeText(ProfilePage.this, "Edit button clicked", Toast.LENGTH_SHORT).show();
                addDescriptionPrompt();
                break;
            case R.id.facebook:
                fbLogin.performClick();
                break;
        }
    }

    public void addDescriptionPrompt() {
        LayoutInflater layoutInflater = LayoutInflater.from(ProfilePage.this);
        View promptsView = layoutInflater.inflate(R.layout.profile_card, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ProfilePage.this);
        alertDialogBuilder.setView(promptsView);
        desc = (EditText) promptsView.findViewById(R.id.about);
        alertDialogBuilder.setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                description = desc.getText().toString();
                addDescription(description);
            }
        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void addDescription(String description) {
        database.collection("Users").document(Objects.requireNonNull(googleSignInAccount.getId()))
                .update("Description", description);
        localValues.edit().putString("Description", description).apply();
        Description.setText(description);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(ProfilePage.this, TabbedActivity.class));
        finish();
    }
}
