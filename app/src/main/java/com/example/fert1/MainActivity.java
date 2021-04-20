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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        userName = String.valueOf(editText.getText());
        //ValuesHolder.setName(userName);
        valuesHolder = new ValuesHolder();
    }

    public String cut(String string){
        if(string.equals("Введите ваше имя: ")){
            return "UserName";
        }
        if(string.contains("Введите ваше имя: ")){
            return string.substring(18, string.length());
        }
        return string;
    }

    public void switchToCalc(View view) {
        Intent intent = new Intent(MainActivity.this, NumpadActivity.class);
        userName = String.valueOf(editText.getText());
        intent.putExtra("UserName", cut(userName));
        System.out.println(cut(userName));
        valuesHolder.setName(cut(userName));
        startActivity(intent);
    }
}