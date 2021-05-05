package com.example.fert1;

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

public class NumpadActivity extends Activity {

    TextView task;
    TextView dialog;
    NumpadTaskChanger numpadTaskChanger;
    NumpadMain numpadMain;
    ImageButton num17, num20;
    NewCustomDialog newCustomDialog;
    CustomBottom customBottom;
    NewCustomDialog newCustomDialogSettings, getNewCustomDialogSoul;
    Vibrator vibrator;

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

//        System.out.println("Is edited by dialog in settings: " + ValuesHolder.getEditedByDialogSettings());
//        System.out.println("Is edited by dialog in soul: " + SoulHolder.getEditedByDialogSoul());
        if(NewCustomDialog.getTypeOfWaiting()==1){
            System.out.println("Edited by dialog in settings");
            newCustomDialogSettings = new NewCustomDialog(this, 1);
            newCustomDialogSettings.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            newCustomDialogSettings.show();
//            ValuesHolder.setEditedByDialogSettings(false);
            NewCustomDialog.setTypeOfWaiting(0);
        }
        else if(NewCustomDialog.getTypeOfWaiting()==2){
            System.out.println("Edited by dialog in soul");
            getNewCustomDialogSoul = new NewCustomDialog(this, 2);
            getNewCustomDialogSoul.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            getNewCustomDialogSoul.show();
//            SoulHolder.setEditedByDialogSoul(false);
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
//                ValuesHolder.setEditedByDialogSettings(false);
//                SoulHolder.setEditedByDialogSoul(true);
                NewCustomDialog.setTypeOfWaiting(2);
                startActivity(intentEasterEgg);
                return false;
            }
        });

        Toast toastAlready = Toast.makeText(getApplicationContext(),
                R.string.toast_already, Toast.LENGTH_SHORT);
//        BottomNavigationView bottomNavigationView = (BottomNavigationView)
//                findViewById(R.id.bottom_navigation);

//        bottomNavigationView.setOnNavigationItemSelectedListener(
//                new BottomNavigationView.OnNavigationItemSelectedListener() {
//                    @Override
//                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                        switch (item.getItemId()) {
//                            case R.id.soul_menu:
////                                bottomNavigationView.setSelectedItemId(R.id.soul_menu);
//                                startActivity(intentSoul);
//                                break;
//                            case R.id.calc_menu:
////                                bottomNavigationView.setSelectedItemId(R.id.calc_menu);
////                                toastAlready.show();
//                                numpadTaskChanger.clearTaskArray();
//                                break;
//                            case R.id.settings_menu:
////                                bottomNavigationView.setSelectedItemId(R.id.settings_menu);
//                                startActivity(intentSettings);
//                                break;
//                        }
//                        return false;
//                    }
//                });

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
        /*
        switch (integer){
            case 1:
                task.setTextSize(15);
                dialog.setTextSize(15);
                System.out.println(task.getTextSize() + " " + dialog.getTextSize());
                break;
            case 2:
                task.setTextSize(30);
                dialog.setTextSize(30);
                System.out.println(task.getTextSize() + " " + dialog.getTextSize());
                break;
            case 3:
                task.setTextSize(45);
                dialog.setTextSize(45);
                System.out.println(task.getTextSize() + " " + dialog.getTextSize());
                break;
        }
         */
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

    public void addLearningLevel(){
        numpadTaskChanger.getValuesSaver().save("LearningProgress", numpadTaskChanger.getValuesSaver().loadInteger("LearningProgress")+1);
        ValuesHolder.setLearningProgress(numpadTaskChanger.getValuesSaver().loadInteger("LearningProgress"));
    }

    public void startDialog(){
        newCustomDialog = new NewCustomDialog(this);
        newCustomDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        newCustomDialog.show();
    }
}