package com.udacity.gradle.builditbigger;

import android.content.Intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.udacity.gradle.builditbigger.androidviewjokes.ShowJokeActivity;



public class MainActivity extends AppCompatActivity {
    public static String sJoke;
    private InterstitialAd mInterstitialAd;
    Button mJokebtn;

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

    public void tellJoke(View view) {
//        String joke = jokes.getJoke();
        new EndPointAsyncTask().execute(this);
//        Toast.makeText(this, sJoke, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ShowJokeActivity.class);
        intent.putExtra(ShowJokeActivity.JOKE_EXTRA, sJoke);
        startActivity(intent);

    }

//class EndPointAsyncTask extends AsyncTask<Context, Void, String>{
//    private MyApi myApiService = null;
//    private Context context;
//    @Override
//    protected String doInBackground(Context... params) {
//        if(myApiService == null) {  // Only do this once
//            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
//                    new AndroidJsonFactory(), null)
//                    // options for running against local devappserver
//                    // - 10.0.2.2 is localhost's IP address in Android emulator
//                    // - turn off compression when running against local devappserver
//                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
//                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
//                        @Override
//                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
//                            abstractGoogleClientRequest.setDisableGZipContent(true);
//                        }
//                    });
//            // end options for devappserver
//
//            myApiService = builder.build();
//        }
//
//        context = params[0];
////        String name = params[0];
//
//        try {
//            return myApiService.getJoke().execute().getData();
//        } catch (IOException e) {
//            return e.getMessage();
//        }
//    }
//
//    @Override
//    protected void onPostExecute(String joke){
//        sJoke = joke;
////        Toast.makeText(context, sJoke, Toast.LENGTH_LONG).show();
//    }
//}

}
