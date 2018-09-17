package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.udacity.gradle.builditbigger.androidviewjokes.ShowJokeActivity;

public class MainActivity extends AppCompatActivity implements OnTaskCompleted {

    public static String sJoke;

    private Button mJokebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mJokebtn = findViewById(R.id.joke_btn);
        mJokebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                tellJoke(view);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void tellJoke(View view) {
//        String joke = jokes.getJoke();
        EndPointAsyncTask myEndPointAsyncTask = new EndPointAsyncTask(MainActivity.this);
        myEndPointAsyncTask.execute();
//        Toast.makeText(this, sJoke, Toast.LENGTH_SHORT).show();


    }

    @Override
    public void OnTaskCompleted(String sJoke) {
        Intent intent = new Intent(this, ShowJokeActivity.class);
        intent.putExtra(ShowJokeActivity.JOKE_EXTRA, sJoke);
        startActivity(intent);
    }
}
