package com.example.fert1.numpad;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fert1.R;
import com.example.fert1.screen.SettingsActivity;
import com.example.fert1.screen.SoulActivity;
import com.example.fert1.keeping.SoulHolder;
import com.example.fert1.keeping.ValuesHolder;
import com.example.fert1.custom.CustomBottom;
import com.example.fert1.dialog.NewCustomDialog;
import com.example.fert1.screen.EasterEggActivity;

public class NumpadActivity extends Activity {

    protected TextView task;
    protected TextView dialog;
    protected NumpadTaskChanger numpadTaskChanger;
    protected NumpadMain numpadMain;
    protected ImageButton num17, num20;
    protected NewCustomDialog newCustomDialog;
    protected CustomBottom customBottom;
    protected NewCustomDialog newCustomDialogSettings, getNewCustomDialogSoul;
    protected Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numpad);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);


        final Animation animMix = AnimationUtils.loadAnimation(this, R.anim.mix);

        task = findViewById(R.id.textView);
        numpadTaskChanger = new NumpadTaskChanger();
        numpadTaskChanger.setActivity(this);
        numpadTaskChanger.setTask(task);
        numpadMain = findViewById(R.id.my_numpad);
        dialog = findViewById(R.id.textView1);
        numpadTaskChanger.setDialog(dialog);
        numpadTaskChanger.setNumpadMain(numpadMain);
        num17 = numpadMain.returnDisrespectButton();
        num20 = numpadMain.returnRespectButton();
        numpadTaskChanger.setImageButtons(num17, num20);
        setTextSize(ValuesHolder.getTextSize());
        numpadTaskChanger.setContext(this);
        numpadTaskChanger.createValuesSaver();
        customBottom = findViewById(R.id.bottom_in_numpad);
        customBottom.setSelected(2);

        if(new SoulHolder().checkWaiting()){
            numpadMain.setQuestionType();
        }


        if(NewCustomDialog.getTypeOfWaiting()==1){
            System.out.println("Edited by dialog in settings");
            newCustomDialogSettings = new NewCustomDialog(this, 1);
            newCustomDialogSettings.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            newCustomDialogSettings.show();
            NewCustomDialog.setTypeOfWaiting(0);
        }
        else if(NewCustomDialog.getTypeOfWaiting()==2){
            System.out.println("Edited by dialog in soul");
            getNewCustomDialogSoul = new NewCustomDialog(this, 2);
            getNewCustomDialogSoul.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            getNewCustomDialogSoul.show();
            NewCustomDialog.setTypeOfWaiting(0);
        }

        Intent intentSoul = new Intent(NumpadActivity.this, SoulActivity.class);
        Intent intentSettings = new Intent(NumpadActivity.this, SettingsActivity.class);
        Intent intentEasterEgg = new Intent(NumpadActivity.this, EasterEggActivity.class);


        findViewById(R.id.soul_button).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                startActivity(intentSoul);
                startVibration(50);
            }});

        findViewById(R.id.numpad_button).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                numpadTaskChanger.clearTaskArray();
                startVibration(50);
            }});

        findViewById(R.id.settings_button).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                startActivity(intentSettings);
                startVibration(50);
            }});

        findViewById(R.id.numpad_button).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                startVibration(75);
                NewCustomDialog.setTypeOfWaiting(2);
                startActivity(intentEasterEgg);
                return false;
            }
        });

        Toast toastAlready = Toast.makeText(getApplicationContext(),
                R.string.toast_already, Toast.LENGTH_SHORT);

        findViewById(R.id.imageButton1).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                numpadTaskChanger.update("(");
                v.startAnimation(animMix);
                startVibration(50);
            }});

        findViewById(R.id.imageButton2).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { numpadTaskChanger.update(")");
                v.startAnimation(animMix);
                startVibration(50);
            }});


        findViewById(R.id.imageButton3).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { numpadTaskChanger.update(".");
                v.startAnimation(animMix);
                startVibration(50);
            }});

        findViewById(R.id.imageButton4).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { numpadTaskChanger.update("^");
                v.startAnimation(animMix);
                startVibration(50);
            }});

        findViewById(R.id.imageButton5).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { numpadTaskChanger.update("1");
                v.startAnimation(animMix);
                startVibration(50);
            }});

        findViewById(R.id.imageButton6).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { numpadTaskChanger.update("2");
                v.startAnimation(animMix);
                startVibration(50);
            }});

        findViewById(R.id.imageButton7).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { numpadTaskChanger.update("3");
                v.startAnimation(animMix);
                startVibration(50);
            }});

        findViewById(R.id.imageButton8).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { numpadTaskChanger.update("/");
                v.startAnimation(animMix);
                startVibration(50);
            }});

        findViewById(R.id.imageButton9).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { numpadTaskChanger.update("4");
                v.startAnimation(animMix);
                startVibration(50);
            }});

        findViewById(R.id.imageButton10).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { numpadTaskChanger.update("5");
                v.startAnimation(animMix);
                startVibration(50);
            }});

        findViewById(R.id.imageButton11).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { numpadTaskChanger.update("6");
                v.startAnimation(animMix);
                startVibration(50);
            }});

        findViewById(R.id.imageButton12).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { numpadTaskChanger.update("*");
                v.startAnimation(animMix);
                startVibration(50);
            }});

        findViewById(R.id.imageButton13).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { numpadTaskChanger.update("7");
                v.startAnimation(animMix);
                startVibration(50);
            }});

        findViewById(R.id.imageButton14).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { numpadTaskChanger.update("8");
                v.startAnimation(animMix);
                startVibration(50);
            }});

        findViewById(R.id.imageButton15).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { numpadTaskChanger.update("9");
                v.startAnimation(animMix);
                startVibration(50);
            }});

        findViewById(R.id.imageButton16).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { numpadTaskChanger.update("-");
                v.startAnimation(animMix);
                startVibration(50);
            }});

        findViewById(R.id.imageButton17).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { numpadTaskChanger.specialUpdate(1);
                v.startAnimation(animMix);
                startVibration(50);
            }});

        findViewById(R.id.imageButton18).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { numpadTaskChanger.update("0");
                v.startAnimation(animMix);
                startVibration(50);
            }});

        findViewById(R.id.imageButton19).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { numpadTaskChanger.specialUpdate(2);
                v.startAnimation(animMix);
                startVibration(50);
            }});

        findViewById(R.id.imageButton20).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { numpadTaskChanger.update("+");
                v.startAnimation(animMix);
                startVibration(50);
            }});

    }

    public void setTextSize(Integer integer){
        System.out.println("Setting text size: size = " + integer + ", task = " + task + ", dialog = " + dialog);
        task.setTextSize(integer);
        dialog.setTextSize(integer);
        System.out.println(task.getTextSize() + " " + dialog.getTextSize());
    }

    public void startVibration(Integer duration){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator.vibrate(VibrationEffect.createOneShot(duration, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            vibrator.vibrate(duration);
        }
    }

}