package com.example.fert1.numpad;

import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskChanger {
    protected TextView task;
    protected String taskString;
    protected ArrayList<String> taskChangerArray = new ArrayList<>();
    protected static boolean isFirst = true;

    private static final String TAG = "TaskChanger";


    public TaskChanger(TextView task) {
        this.task = task;
    }

    protected String changeWithArrayString = "";

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

    protected Integer intAnswer;

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
        if (switcher == -1) {
            taskString = (String) task.getText();
            if (!(taskString.equals(""))) {
                taskString = taskString.substring(0, taskString.length() - 1);
            }
        }
        task.setText(taskString);
    }

    public void notifyError(){
        task.setText("При вычислении получена ошибка. Пожалуйста, проверьте введённые данные.");
    }
}
