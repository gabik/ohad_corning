package com.corning.ohad.corning;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new SleepTask().execute();
    }

    private void close_splash() {
        Intent intent = new Intent(this, SlidersActivity.class);
        startActivity(intent);
        finish();
    }

    private class SleepTask extends AsyncTask<Void, Void, Void> {
        protected Void doInBackground(Void... v) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Log.w("Sleep", "Interrupted");
            }
            return null;
        }

        protected void onPostExecute(Void v) {
            close_splash();
        }
    }

}
