package com.example.fert1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    EditText editText;
    String userName;
    ValuesHolder valuesHolder;
    ValuesSaver valuesSaver;
    TextView hello;
    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        editText = findViewById(R.id.editText);
        userName = String.valueOf(editText.getText());
        hello = findViewById(R.id.helloText);
        //ValuesHolder.setName(userName);
        valuesHolder = new ValuesHolder();
        valuesHolder.setContext(this);
        valuesHolder.createValuesSaver();
        valuesSaver = new ValuesSaver(this);
//        System.out.println(valuesSaver);
//        if(!valuesSaver.loadBoolean("IsCreated")){
//            System.out.println("Already created");
//            valuesSaver.saveDefault();
//        }
//        valuesHolder.loadAll();
//        System.out.println("------------");
//        System.out.println(ValuesHolder.getImageX());
        if(valuesSaver.saveDefault()){
            editText.setVisibility(View.INVISIBLE);
            hello.setText("Приветствую тебя, " + valuesSaver.loadString("Name") + "!");
            hello.setTextSize(50);
            hello.setGravity(Gravity.CENTER);
        }
    }

    public String cut(String string){
        if(string.equals("Введите ваше имя: ") || string.length()==0){
            return "UserName";
        }
        if(string.contains("Введите ваше имя: ")){
            return string.substring(18, string.length());
        }
        return string;
    }

    public void switchToCalc(View view) {
        startVibration(50);
        valuesSaver.save("IsCreated", true);
        Intent intent = new Intent(MainActivity.this, NumpadActivity.class);
        userName = String.valueOf(editText.getText());
        intent.putExtra("UserName", cut(userName));
        if(userName.length()!=0){
            valuesHolder.setName(cut(userName));
            valuesSaver.save("Name", cut(userName));
            System.out.println(cut(userName));
        }
        startActivity(intent);
    }

    public void startVibration(Integer duration){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator.vibrate(VibrationEffect.createOneShot(duration, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            vibrator.vibrate(duration);
        }
    }
}