package com.example.fert1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainCalc extends AppCompatActivity {

    String userName;
    TextView dialog;
    TextView task;
    String taskString;
    //Counter counter;
    PolishSolver polishSolver;
    ArrayList<String> taskArray;

    private static final String TAG = "MainCalc";

    TaskChanger taskChanger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc_main);

        userName = getIntent().getStringExtra("UserName");
        //userName = "I am OK";
        dialog = findViewById(R.id.topText);
        task = findViewById(R.id.bottomText);
        taskChanger = new TaskChanger(task);
        //counter = new Counter(task);
        polishSolver = new PolishSolver();
        taskArray = new ArrayList<>();


        if (userName.contains("Введите ваше имя:")){
            userName = userName.substring(18);
            dialog.setText("Вот здесь, " + userName + ", будет отображаться наш с тобой диалог.");
            //dialog.setText(userName);
        }
        else {
            dialog.setText(userName);
        }
    }

    /*public void clickedLeftBracketButton(View view) {
        taskChanger.change("(");
    }
    public void clickedRightBracketButton(View view) {
        taskChanger.change(")");
    }
    public void clickedCommaButton(View view) {
        taskChanger.change(",");
    }
    public void clickedPowerButton(View view) {
        taskChanger.change("^");
    }

    public void clickedOneButton(View view) {
        taskChanger.change("1");
    }
    public void clickedTwoBracketButton(View view) {
        taskChanger.change("2");
    }
    public void clickedThreeButton(View view) {
        taskChanger.change("3");
    }
    public void clickedDivideButton(View view) {
        taskChanger.change("/");
    }

    public void clickedFourButton(View view) {
        taskChanger.change("4");
    }
    public void clickedFiveBracketButton(View view) {
        taskChanger.change("5");
    }
    public void clickedSixButton(View view) {
        taskChanger.change("6");
    }
    public void clickedMultiplyButton(View view) {
        taskChanger.change("*");
    }

    public void clickedSevenButton(View view) {
        taskChanger.change("7");
    }
    public void clickedEightBracketButton(View view) {
        taskChanger.change("8");
    }
    public void clickedNineButton(View view) {
        taskChanger.change("9");
    }
    public void clickedMinusButton(View view) {
        taskChanger.change("-");
    }

    public void clickedDeleteButton(View view) {
        taskChanger.change(-1);
    }
    public void clickedZeroButton(View view) {
        taskChanger.change("0");
    }
    public void clickedEquallyButton(View view) {
        counter.answer((String) task.getText());
        Log.w(TAG, "Это мое сообщение для записи в журналеНажата кнопка Равно");
    }
    public void clickedPlusButton(View view) {
        taskChanger.change("+");
    }

     */

    public void startNumpad(View view) {
        Intent intent = new Intent(MainCalc.this, NumpadActivity.class);
        //userName = String.valueOf(editText.getText());
        //intent.putExtra("UserName", userName);
        startActivity(intent);
    }


    public void clickedLeftBracketButton(View view) {
        update("(");
    }
    public void clickedRightBracketButton(View view) {
        update(")");
    }
    public void clickedCommaButton(View view) {
        update(".");
    }
    public void clickedPowerButton(View view) {
        update("^");
    }

    public void clickedOneButton(View view) {
        update("1");
    }
    public void clickedTwoBracketButton(View view) {
        update("2");
    }
    public void clickedThreeButton(View view) {
        update("3");
    }
    public void clickedDivideButton(View view) {
        update("/");
    }

    public void clickedFourButton(View view) {
        update("4");
    }
    public void clickedFiveBracketButton(View view) {
        update("5");
    }
    public void clickedSixButton(View view) {
        update("6");
    }
    public void clickedMultiplyButton(View view) {
        update("*");
    }

    public void clickedSevenButton(View view) {
        update("7");
    }
    public void clickedEightBracketButton(View view) {
        update("8");
    }
    public void clickedNineButton(View view) {
        update("9");
    }
    public void clickedMinusButton(View view) {
        update("-");
    }

    public void clickedDeleteButton(View view) {
        update(1);
    }
    public void clickedZeroButton(View view) {
        update("0");
    }
    public void clickedEquallyButton(View view) {
        update(2);
    }
    public void clickedPlusButton(View view) {
        update("+");
    }





    public void update(String newSymbol){
        try {
            taskArray.add(newSymbol);
            taskChanger.changeWithArray(taskArray);
        }
        catch (Exception e){
            taskChanger.notifyError();
        }

    }

    Double updateAnswer;

    public void update(Integer typeOfAction){
        try {
            switch (typeOfAction){
                case 1:
                    if (taskArray.size()>1){
                        taskArray.remove(taskArray.size()-1);
                    }
                    else if (taskArray.size()==1){
                        taskArray.remove(taskArray.size()-1);
                        task.setText("0");
                    }
                    taskChanger.changeWithArray(taskArray);
                    break;
                case 2:
                    System.out.println("Передаю собирателю: " + taskArray);
                    taskArray = polishSolver.solve(taskArray);
                    System.out.println("Взял от собирателя и передаю решателю: " + taskArray);
                    taskChanger.changeWithArray(polishSolver.count(taskArray));
                    updateAnswer=polishSolver.count(taskArray);
                    //taskArray.clear();
                    //taskArray.add(updateAnswer.toString());
                    symbolUpdate(updateAnswer);
            }
        }
        catch (Exception e){
            taskChanger.notifyError();
        }

    }

    String symbolUpdateString;
    Integer symbolUpdateInteger;

    public void symbolUpdate (Double inputSymbolUpdate){
        try {
            if(inputSymbolUpdate%1==0.0) {
                symbolUpdateInteger = (int) (double) inputSymbolUpdate;
                symbolUpdateString=symbolUpdateInteger.toString();
                taskArray.clear();
                for (int i = 0; i < symbolUpdateString.length(); i++) {
                    taskArray.add(symbolUpdateString.substring(i,i+1));;
                }
            }
            else {
                symbolUpdateString=inputSymbolUpdate.toString();
                taskArray.clear();
                for (int i = 0; i < symbolUpdateString.length(); i++) {
                    taskArray.add(symbolUpdateString.substring(i,i+1));;
                }
            }
        }
        catch (Exception e){
            taskChanger.notifyError();
        }
    }
}