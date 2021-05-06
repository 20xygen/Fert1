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

import com.example.fert1.dialog.NewCustomDialog;
import com.example.fert1.numpad.NumpadActivity;
import com.example.fert1.R;

public class EasterEggActivity extends Activity {
    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easter_egg);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
    }

    public void meTapped(View view){
        Toast toast = Toast.makeText(getApplicationContext(),
                "Главное - выборочная память!", Toast.LENGTH_SHORT);
        toast.show();
        startVibration(50);
    }

    public void senseiTapped(View view){
        Toast toast = Toast.makeText(getApplicationContext(),
                "Kotlin топ!", Toast.LENGTH_SHORT);
        toast.show();
        startVibration(50);
    }

    public void igorTapped(View view){
        Toast toast = Toast.makeText(getApplicationContext(),
                "Улыбайся шире, работай тяжелее!", Toast.LENGTH_SHORT);
        toast.show();
        startVibration(50);
    }

    public void backToNumpad(View view){
        NewCustomDialog.setTypeOfWaiting(0);
        startVibration(75);
        Intent intentBack = new Intent(EasterEggActivity.this, NumpadActivity.class);
        startActivity(intentBack);
    }

    public void startVibration(Integer duration){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator.vibrate(VibrationEffect.createOneShot(duration, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            vibrator.vibrate(duration);
        }
    }
}