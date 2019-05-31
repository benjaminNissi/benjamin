package com.example.realm;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Music extends AppCompatActivity {
    TextView Play;
    TextView Stop;
    ProgressBar progressBar;
    View mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Play = (TextView) findViewById(R.id.Play);
        Stop = (TextView) findViewById(R.id.Stop);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.logout) {
            Toast.makeText(getApplicationContext(), "logout selected", Toast.LENGTH_SHORT).show();
        }
        else if (id==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


}
