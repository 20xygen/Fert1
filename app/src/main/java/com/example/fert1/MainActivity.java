package com.example.fert1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    EditText editText;
    String userName;
    ValuesHolder valuesHolder;
    ValuesSaver valuesSaver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        userName = String.valueOf(editText.getText());
        //ValuesHolder.setName(userName);
        valuesHolder = new ValuesHolder();
        valuesHolder.setContext(this);
        valuesHolder.createValuesSaver();
        valuesSaver = new ValuesSaver(this);
        System.out.println(valuesSaver);
        if(!valuesSaver.loadBoolean("IsCreated")){
            System.out.println("Already created");
            valuesSaver.saveDefault();
        }
        valuesHolder.loadAll();
        System.out.println("------------");
        System.out.println(ValuesHolder.getImageX());
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
        valuesSaver.save("IsCreated", true);
        Intent intent = new Intent(MainActivity.this, NumpadActivity.class);
        userName = String.valueOf(editText.getText());
        intent.putExtra("UserName", cut(userName));
        System.out.println(cut(userName));
        valuesHolder.setName(cut(userName));
        startActivity(intent);
    }
}