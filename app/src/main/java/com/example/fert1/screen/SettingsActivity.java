package com.example.fert1.screen;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Toast;

import com.example.fert1.R;
import com.example.fert1.keeping.ValuesHolder;
import com.example.fert1.custom.CustomBottom;
import com.example.fert1.custom.Parameter;
import com.example.fert1.dialog.HelpOperator;
import com.example.fert1.dialog.NewCustomDialog;
import com.example.fert1.numpad.NumpadActivity;

public class SettingsActivity extends Activity {

    Parameter parameter1;
    Parameter parameter2;
    Parameter parameter3;
    Parameter parameter4;
    ValuesHolder valuesHolder;
    CustomBottom customBottom;
    public Activity thisActivity;
    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        thisActivity = this;

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

        HelpOperator.create(this, "   - Здесь ты         можешь              изменить           настройки          приложения.", 3);

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
                startVibration(50);
                updateValues();
                startActivity(intentSoul);
            }});

        findViewById(R.id.numpad_button).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                startVibration(50);
                updateValues();
                startActivity(intentCalc);
            }});

        findViewById(R.id.settings_button).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                startVibration(50);
                updateValues();
                toastAlready.show();
            }});

        findViewById(R.id.settings_button).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                startVibration(75);
                NewCustomDialog.setTypeOfWaiting(1);
                startActivity(intentCalc);
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

    public void startVibration(Integer duration){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator.vibrate(VibrationEffect.createOneShot(duration, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            vibrator.vibrate(duration);
        }
    }
}