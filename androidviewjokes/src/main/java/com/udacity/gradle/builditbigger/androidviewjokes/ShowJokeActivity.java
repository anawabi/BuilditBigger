package com.udacity.gradle.builditbigger.androidviewjokes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowJokeActivity extends AppCompatActivity {
    public static final String JOKE_EXTRA = "The_Joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_joke);

       TextView mJokeTv = findViewById(R.id.viewjoke_tv);

        Bundle mBundle = getIntent().getExtras();
        if(mBundle != null && mBundle.containsKey(JOKE_EXTRA)){
            mJokeTv.setText(mBundle.getString(JOKE_EXTRA));
        }
    }
}
