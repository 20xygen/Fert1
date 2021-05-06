package com.example.fert1.numpad;

import android.util.Log;

import java.util.ArrayList;

public class NumberChanger {
    protected ArrayList<String> inputArray = new ArrayList<>();
    protected ArrayList<String> outputArray = new ArrayList<>();
    protected String string;
    protected String currentString;
    private static final String TAG = "NumberChanger";

    public NumberChanger(){ }

    public ArrayList<String> changeArrayToArray(ArrayList<String> input){
        Log.w(TAG, "Активирован метод changeArrayToArray класса NumberChanger");
        outputArray.clear();
        inputArray.clear();
        inputArray = input;
        while (inputArray.size()>0){
            currentString=inputArray.get(0);
            inputArray.remove(0);
            if (isNumber(currentString)){
                while (inputArray.size()>0){
                    if (isNumber(inputArray.get(0))){
                        currentString = currentString.concat(inputArray.get(0));
                        inputArray.remove(0);
                    }
                    else {
                        break;
                    }
                }
            }
            outputArray.add(currentString);
        }
        return outputArray;
    }

    public boolean isNumber (String input){
        Log.w(TAG, "Активирован метод isNumber класса NumberChanger");
        string = input;
        if(string.equals("0") || string.equals("1") || string.equals("2") || string.equals("3")
                || string.equals("4") || string.equals("5") || string.equals("6")
                || string.equals("7") || string.equals("8") || string.equals("9")
                || string.equals(",") || string.equals(".")){
            return true;
        }
        return false;
    }
}
