package com.survey.survetestnew;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);


        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "1290");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "nks");
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
/*********/
        mFirebaseAnalytics.setUserProperty("USER_ID", "1234");
        mFirebaseAnalytics.setUserProperty("APP_VERSION", "v1.0");
        Bundle params2 = new Bundle();
        params2.putString("App_Open", "1");
        mFirebaseAnalytics.logEvent("App_Open", params2);
/*************/

    }
}
