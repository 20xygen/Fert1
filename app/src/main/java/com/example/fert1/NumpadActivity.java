package com.example.fert1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class NumpadActivity extends Activity {

    TextView task;
    TextView dialog;
    NumpadTaskChanger numpadTaskChanger;
    NumpadMain numpadMain;
    ImageButton num17, num20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numpad);

        task = findViewById(R.id.textView);
        numpadTaskChanger = new NumpadTaskChanger();
        numpadTaskChanger.setTask(task);
        numpadMain = findViewById(R.id.my_numpad);
        dialog = findViewById(R.id.textView1);
        numpadTaskChanger.setDialog(dialog);
        numpadTaskChanger.setNumpadMain(numpadMain);
        num17 = numpadMain.returnDisrespectButton();
        num20 = numpadMain.returnRespectButton();
        numpadTaskChanger.setImageButtons(num17, num20);
        setTextSize(ValuesHolder.getTextSize());

        Toast toastAlready = Toast.makeText(getApplicationContext(),
                R.string.toast_already, Toast.LENGTH_SHORT);

        Intent intentSoul = new Intent(NumpadActivity.this, SoulActivity.class);
        Intent intentSettings = new Intent(NumpadActivity.this, SettingsActivity.class);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.soul_menu:
                                startActivity(intentSoul);
                                break;
                            case R.id.calc_menu:
                                toastAlready.show();
                                break;
                            case R.id.settings_menu:
                                startActivity(intentSettings);
                                break;
                        }
                        return false;
                    }
                });

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
            @Override public void onClick(View v) { numpadTaskChanger.update(1); }});

        findViewById(R.id.imageButton18).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { numpadTaskChanger.update("0"); }});

        findViewById(R.id.imageButton19).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { numpadTaskChanger.update(2); }});

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
}