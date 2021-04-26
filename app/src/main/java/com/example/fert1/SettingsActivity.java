package com.example.fert1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SettingsActivity extends Activity {

    Parameter parameter1;
    Parameter parameter2;
    Parameter parameter3;
    Parameter parameter4;
    ValuesHolder valuesHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        parameter1 = findViewById(R.id.parameter1);
        parameter2 = findViewById(R.id.parameter2);
        parameter3 = findViewById(R.id.parameter3);
        parameter4 = findViewById(R.id.parameter4);
        valuesHolder = new ValuesHolder();
        valuesHolder.setContext(this);
        valuesHolder.createValuesSaver();
        valuesHolder.loadAll();

        parameter1.setParameterName("Имя");
        parameter2.setParameterName("Высота плитки");
        //parameter2.setBroken();
        parameter3.setParameterName("Ширина плитки");
        //parameter3.setBroken();
        parameter4.setParameterName("Размер текста (1-3)");
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
                R.string.toast_already, Toast.LENGTH_SHORT);

        Intent intentCalc = new Intent(SettingsActivity.this, NumpadActivity.class);
        Intent intentSoul = new Intent(SettingsActivity.this, SoulActivity.class);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.soul_menu:
//                                ValuesHolder.setName(parameter1.getParameterValue());
//                                ValuesHolder.setImageY(Integer.parseInt(parameter2.getParameterValue()));
//                                ValuesHolder.setImageX(Integer.parseInt(parameter3.getParameterValue()));
//                                ValuesHolder.setTextSize(Integer.parseInt(parameter4.getParameterValue()));
//                                ValuesHolder.makeUpdated();
                                updateValues();
                                startActivity(intentSoul);
                                break;
                            case R.id.calc_menu:
//                                ValuesHolder.makeUpdated();
//                                ValuesHolder.setName(parameter1.getParameterValue());
//                                ValuesHolder.setImageY(Integer.parseInt(parameter2.getParameterValue()));
//                                ValuesHolder.setImageX(Integer.parseInt(parameter3.getParameterValue()));
//                                ValuesHolder.setTextSize(Integer.parseInt(parameter4.getParameterValue()));
                                updateValues();
                                startActivity(intentCalc);
                                break;
                            case R.id.settings_menu:
//                                ValuesHolder.makeUpdated();
//                                ValuesHolder.setName(parameter1.getParameterValue());
//                                ValuesHolder.setImageY(Integer.parseInt(parameter2.getParameterValue()));
//                                ValuesHolder.setImageX(Integer.parseInt(parameter3.getParameterValue()));
//                                ValuesHolder.setTextSize(Integer.parseInt(parameter4.getParameterValue()));
                                updateValues();
                                toastAlready.show();
                                break;
                        }
                        return false;
                    }
                });
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