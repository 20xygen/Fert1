package com.example.fert1;

import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskChanger {
    TextView task;
    String taskString;
    ArrayList<String> taskChangerArray = new ArrayList<>();
    static boolean isFirst = true;

    private static final String TAG = "TaskChanger";


    public TaskChanger(TextView task) {
        this.task = task;
    }

    public void change(String newText) {
        Log.w(TAG, "Активирован метод change класса TaskChanger с String аргументом");
        taskString = (String) task.getText();
        if (isFirst || taskString.substring(0,1).equals("=")) {
            taskString = newText;
            task.setText(taskString);
            isFirst = false;
        } else {
            taskString = taskString + newText;
            task.setText(taskString);
        }
    }

    String changeWithArrayString = "";

    public void changeWithArray(ArrayList<String> inputChangeArray){
        taskChangerArray = inputChangeArray;
        changeWithArrayString = "";
        if(taskChangerArray.size()>0){
            for (int i = 0; i < taskChangerArray.size(); i++) {
                changeWithArrayString=changeWithArrayString.concat(taskChangerArray.get(i));
            }
            task.setText(changeWithArrayString);
        }
    }

    public void changeWithArray(String string){
        task.setText(string);
    }

    Double answer;
    Integer intAnswer;

    public void changeWithArray(Double newValue){
        if(newValue%1==0.0) {
            intAnswer = (int) (double) newValue;
            task.setText(intAnswer.toString());
        }
        else {
            task.setText(newValue.toString());
        }

    }

    public void change(int switcher) {
        Log.w(TAG, "Активирован метод change класса TaskChanger с int аргументом");
        switch (switcher){
            case -1:
                taskString = (String) task.getText();
                if (!(taskString.equals(""))){
                    taskString = taskString.substring(0, taskString.length()-1);
                }
                break;
            default:
                break;
        }
        task.setText(taskString);
    }

    public void notifyError(){
        task.setText("При вычислении получена ошибка. Пожалуйста, проверьте введённые данные.");
    }
}
