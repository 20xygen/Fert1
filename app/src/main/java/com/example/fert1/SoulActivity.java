package com.example.fert1;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class SoulActivity extends Activity {

    ProgressBar progressBarC;
    ProgressBar progressBarL;
    SoulHolder soulHolder;
    CustomBottom customBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soul);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        soulHolder = new SoulHolder();
        soulHolder.setContext(this);
        soulHolder.createValuesSaver();
        soulHolder.loadAll();
        progressBarC = findViewById(R.id.progress_circular1);
        progressBarL = findViewById(R.id.progress_circular2);
        setProgress();
        customBottom = findViewById(R.id.bottom_in_soul);
        customBottom.setSelected(1);
        HelpOperator.create(this, "- Диаграммы   показывают     характер Фертаи чем значениебольше, тем     чаще происхо- дит шалость     этого типа.", 2);

        Toast toastAlready = Toast.makeText(getApplicationContext(),
                R.string.toast_already, Toast.LENGTH_SHORT);

        Intent intentCalc = new Intent(SoulActivity.this, NumpadActivity.class);
        Intent intentSettings = new Intent(SoulActivity.this, SettingsActivity.class);

        findViewById(R.id.soul_button).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                toastAlready.show();
            }});

        findViewById(R.id.numpad_button).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                startActivity(intentCalc);
            }});

        findViewById(R.id.settings_button).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                startActivity(intentSettings);
            }});

        findViewById(R.id.soul_button).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
//                ValuesHolder.setEditedByDialogSettings(false);
//                SoulHolder.setEditedByDialogSoul(true);
                NewCustomDialog.setTypeOfWaiting(2);
                startActivity(intentCalc);
                return false;
            }
        });

//        BottomNavigationView bottomNavigationView = (BottomNavigationView)
//                findViewById(R.id.bottom_navigation);
//
//        bottomNavigationView.setOnNavigationItemSelectedListener(
//                new BottomNavigationView.OnNavigationItemSelectedListener() {
//                    @Override
//                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                        switch (item.getItemId()) {
//                            case R.id.soul_menu:
//                                toastAlready.show();
//                                break;
//                            case R.id.calc_menu:
//                                startActivity(intentCalc);
//                                break;
//                            case R.id.settings_menu:
//                                startActivity(intentSettings);
//                                break;
//                        }
//                        return false;
//                    }
//                });
    }

    public void setProgress(){
        progressBarC.setProgress((int) (soulHolder.getChildishness()*50));
        progressBarL.setProgress((int) (soulHolder.getLaziness()*50));
    }
}