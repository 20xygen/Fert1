package com.example.fert1;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numpad);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

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

        Intent intentSoul = new Intent(NumpadActivity.this, SoulActivity.class);
        Intent intentSettings = new Intent(NumpadActivity.this, SettingsActivity.class);


        findViewById(R.id.soul_button).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                startActivity(intentSoul);
            }});

        findViewById(R.id.numpad_button).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                numpadTaskChanger.clearTaskArray();
            }});

        findViewById(R.id.settings_button).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                startActivity(intentSettings);
            }});

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
            @Override public void onClick(View v) { numpadTaskChanger.update("("); }});

        findViewById(R.id.imageButton2).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { numpadTaskChanger.update(")"); }});

        findViewById(R.id.imageButton3).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { numpadTaskChanger.update("."); }});

        findViewById(R.id.imageButton4).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { numpadTaskChanger.update("^"); }});

        findViewById(R.id.imageButton5).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { numpadTaskChanger.update("1"); }});

        findViewById(R.id.imageButton6).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { numpadTaskChanger.update("2"); }});

        findViewById(R.id.imageButton7).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { numpadTaskChanger.update("3"); }});

        findViewById(R.id.imageButton8).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { numpadTaskChanger.update("/"); }});

        findViewById(R.id.imageButton9).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { numpadTaskChanger.update("4"); }});

        findViewById(R.id.imageButton10).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { numpadTaskChanger.update("5"); }});

        findViewById(R.id.imageButton11).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { numpadTaskChanger.update("6"); }});

        findViewById(R.id.imageButton12).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { numpadTaskChanger.update("*"); }});

        findViewById(R.id.imageButton13).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { numpadTaskChanger.update("7"); }});

        findViewById(R.id.imageButton14).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { numpadTaskChanger.update("8"); }});

        findViewById(R.id.imageButton15).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { numpadTaskChanger.update("9"); }});

        findViewById(R.id.imageButton16).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { numpadTaskChanger.update("-"); }});

        findViewById(R.id.imageButton17).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { numpadTaskChanger.specialUpdate(1); }});

        findViewById(R.id.imageButton18).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { numpadTaskChanger.update("0"); }});

        findViewById(R.id.imageButton19).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { numpadTaskChanger.specialUpdate(2); }});

        findViewById(R.id.imageButton20).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { numpadTaskChanger.update("+"); }});

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