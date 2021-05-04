package com.example.fert1;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

public class HelpOperator {
    public static Integer length = 3;
//    public static Context context;

    public static void create(Activity a, String text, Integer type){
        if(!getStatus(a.getApplicationContext(), type)){
            System.out.println("HelpOperator creates dialog");
            NewCustomDialog newCustomDialog = new NewCustomDialog(a, text);
            newCustomDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            newCustomDialog.setPosition(type);
            newCustomDialog.show();
//            setCreated(a.getApplicationContext(), type);
        }
        else System.out.println("HelpOperator: It is already shown");

    }

    public static Boolean getStatus(Context inContext, Integer position){
        ValuesSaver valuesSaver = new ValuesSaver(inContext);
        Integer currentLength = 0;
//        Integer current = 1;
        Integer currentValue = valuesSaver.loadInteger("LearningProgress");
        System.out.println(currentValue);
        currentLength = currentValue.toString().length();
        if(currentLength<length){
            while (currentLength<length){
                System.out.println(currentLength + "(length of " + currentValue + ") < " + length);
                currentValue*=10;
                currentLength = currentValue.toString().length();
            }
        }
        else if(currentLength>length){
            while (currentLength>length){
                System.out.println(currentLength + " > " + length);
                currentValue/=10;
                currentLength = currentValue.toString().length();
            }
        }
        valuesSaver.save("LearningProgress", currentValue);
        return currentValue.toString().substring(position-1, position).contains("2");
    }

    public static void setCreated(Context inContext, Integer position){
        ValuesSaver valuesSaver = new ValuesSaver(inContext);
        Integer currentLength = 0;
//        Integer current = 1;
        Integer currentValue = valuesSaver.loadInteger("LearningProgress");
        currentLength = currentValue.toString().length();
        if(currentLength<length){
            while (currentLength<length){
                currentValue*=10;
                currentValue++;
                currentLength = currentValue.toString().length();
            }
        }
        else if(currentLength>length){
            while (currentLength>length){
                currentValue/=10;
                currentLength = currentValue.toString().length();
            }
        }

        System.out.println(currentValue);
        currentValue = Integer.parseInt(currentValue.toString().substring(0, position-1) + "2"
                + currentValue.toString().substring(position, currentValue.toString().length()));
        System.out.println(currentValue);
        ValuesHolder.setLearningProgress(currentValue);
        valuesSaver.save("LearningProgress", currentValue);
    }
}
