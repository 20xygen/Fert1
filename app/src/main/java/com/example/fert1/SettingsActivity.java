package com.example.fert1;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SettingsActivity extends Activity {

    Parameter parameter1;
    Parameter parameter2;
    Parameter parameter3;
    Parameter parameter4;
    ValuesHolder valuesHolder;
    CustomBottom customBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        parameter1 = findViewById(R.id.parameter1);
        parameter2 = findViewById(R.id.parameter2);
        parameter3 = findViewById(R.id.parameter3);
        parameter4 = findViewById(R.id.parameter4);
        valuesHolder = new ValuesHolder();
        valuesHolder.setContext(this);
        valuesHolder.createValuesSaver();
        valuesHolder.loadAll();
        customBottom = findViewById(R.id.bottom_in_settings);
        customBottom.setSelected(3);

        parameter1.setParameterName("Имя");
        parameter2.setParameterName("Высота плитки");
        //parameter2.setBroken();
        parameter3.setParameterName("Ширина плитки");
        //parameter3.setBroken();
        parameter4.setParameterName("Размер текста");
        //parameter1.setTextSize(ValuesHolder.getTextSize());
        //parameter2.setTextSize(ValuesHolder.getTextSize());
        //parameter3.setTextSize(ValuesHolder.getTextSize());
        //parameter4.setTextSize(ValuesHolder.getTextSize());
        //parameter4.setBroken();


        parameter1.setParameterValue(ValuesHolder.getName());
        parameter2.setParameterValue(ValuesHolder.getImageY());
        parameter3.setParameterValue(ValuesHolder.getImageX());
        parameter4.setParameterValue(ValuesHolder.getTextSize());

        parameter2.setMin(20);
        parameter2.setMax(145);
        parameter3.setMin(20);
        parameter3.setMax(145);
        parameter4.setMin(5);
        parameter4.setMax(70);

        Toast toastAlready = Toast.makeText(getApplicationContext(),
                "Настройки сохранены", Toast.LENGTH_SHORT);

        Intent intentCalc = new Intent(SettingsActivity.this, NumpadActivity.class);
        Intent intentSoul = new Intent(SettingsActivity.this, SoulActivity.class);

        findViewById(R.id.soul_button).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                updateValues();
                startActivity(intentSoul);
            }});

        findViewById(R.id.numpad_button).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                updateValues();
                startActivity(intentCalc);
            }});

        findViewById(R.id.settings_button).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                updateValues();
                toastAlready.show();
            }});

//        BottomNavigationView bottomNavigationView = (BottomNavigationView)
//                findViewById(R.id.bottom_navigation);

//        bottomNavigationView.setOnNavigationItemSelectedListener(
//                new BottomNavigationView.OnNavigationItemSelectedListener() {
//                    @Override
//                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                        switch (item.getItemId()) {
//                            case R.id.soul_menu:
////                                ValuesHolder.setName(parameter1.getParameterValue());
////                                ValuesHolder.setImageY(Integer.parseInt(parameter2.getParameterValue()));
////                                ValuesHolder.setImageX(Integer.parseInt(parameter3.getParameterValue()));
////                                ValuesHolder.setTextSize(Integer.parseInt(parameter4.getParameterValue()));
////                                ValuesHolder.makeUpdated();
//                                updateValues();
//                                startActivity(intentSoul);
//                                break;
//                            case R.id.calc_menu:
////                                ValuesHolder.makeUpdated();
////                                ValuesHolder.setName(parameter1.getParameterValue());
////                                ValuesHolder.setImageY(Integer.parseInt(parameter2.getParameterValue()));
////                                ValuesHolder.setImageX(Integer.parseInt(parameter3.getParameterValue()));
////                                ValuesHolder.setTextSize(Integer.parseInt(parameter4.getParameterValue()));
//                                updateValues();
//                                startActivity(intentCalc);
//                                break;
//                            case R.id.settings_menu:
////                                ValuesHolder.makeUpdated();
////                                ValuesHolder.setName(parameter1.getParameterValue());
////                                ValuesHolder.setImageY(Integer.parseInt(parameter2.getParameterValue()));
////                                ValuesHolder.setImageX(Integer.parseInt(parameter3.getParameterValue()));
////                                ValuesHolder.setTextSize(Integer.parseInt(parameter4.getParameterValue()));
//                                updateValues();
//                                toastAlready.show();
//                                break;
//                        }
//                        return false;
//                    }
//                });
    }

    public void updateValues(){
        ValuesHolder.makeUpdated();
        ValuesHolder.setName(parameter1.getParameterValue());
        ValuesHolder.setImageX(parameter3.getFramed());
        setY();
        valuesHolder.saveAll();
    }

    Integer textY, numPadY, sumY;

    public void setY(Integer goodNumPadY, Integer gooodTextY){
        ValuesHolder.setImageY(goodNumPadY);
        ValuesHolder.setTextSize(gooodTextY);
    }

    public void setY(){
        textY = Integer.parseInt(parameter4.getParameterValue());
        numPadY = Integer.parseInt(parameter2.getParameterValue());
        if(textY + numPadY <= 150){
            setY(numPadY, textY);
        }
        else if (textY!=null && numPadY!=null){
            sumY = textY + numPadY;
            numPadY = numPadY*150/sumY;
            if(numPadY<20) numPadY = 30;
            if(numPadY>145) numPadY = 130;
            textY = 150 - numPadY;
            setY(numPadY, textY);
        }
    }

    public Integer returningTextSize(Float number){
        if(number<1.5){
            return 1;
        }
        if(number>2.5){
            return 3;
        }
        return 2;
    }
}