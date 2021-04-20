package com.example.fert1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SoulActivity extends Activity {

    ProgressBar progressBarC;
    ProgressBar progressBarL;
    SoulHolder soulHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soul);

        soulHolder = new SoulHolder();
        progressBarC = findViewById(R.id.progress_circular1);
        progressBarL = findViewById(R.id.progress_circular2);
        setProgress();

        Toast toastAlready = Toast.makeText(getApplicationContext(),
                R.string.toast_already, Toast.LENGTH_SHORT);

        Intent intentCalc = new Intent(SoulActivity.this, NumpadActivity.class);
        Intent intentSettings = new Intent(SoulActivity.this, SettingsActivity.class);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.soul_menu:
                                toastAlready.show();
                                break;
                            case R.id.calc_menu:
                                startActivity(intentCalc);
                                break;
                            case R.id.settings_menu:
                                startActivity(intentSettings);
                                break;
                        }
                        return false;
                    }
                });
    }

    public void setProgress(){
        progressBarC.setProgress((int) (soulHolder.getChildishness()*50));
        progressBarL.setProgress((int) (soulHolder.getLaziness()*50));
    }
}