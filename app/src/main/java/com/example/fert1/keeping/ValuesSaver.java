package com.example.fert1.keeping;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.fert1.keeping.SoulHolder;
import com.example.fert1.keeping.ValuesHolder;

public class ValuesSaver {
    public static final String APP_PREFERENCES = "mySettings";

    protected static final String APP_PREFERENCES_NAME = "Name";
    protected static final String APP_PREFERENCES_IMAGEX = "ImageX";
    protected static final String APP_PREFERENCES_IMAGEY = "ImageY";
    protected static final String APP_PREFERENCES_TEXTSIZE = "TextSize";
    protected static final String APP_PREFERENCES_ISUPDATED = "IsUpdated";
    protected static final String APP_PREFERENCES_ISCREATED = "IsCreated";
    protected static final String APP_PREFERENCES_CHILDISHNESS = "Childishness";
    protected static final String APP_PREFERENCES_LAZINESS = "Laziness";
    protected static final String APP_PREFERENCES_LEARNINGPROGRESS = "LearningProgress";
    protected ValuesHolder valuesHolder;
    protected SoulHolder soulHolder;

    protected SharedPreferences mySettings;

    public ValuesSaver(Context context){
        mySettings = context.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE); //use default?
    }

    public void save(String file, String value){
        SharedPreferences.Editor editor1 = mySettings.edit();
        editor1.putString(APP_PREFERENCES_NAME, value);
        editor1.apply();
    }

    public void save(String file, Integer value){
        switch (file){
            case APP_PREFERENCES_IMAGEX:
                SharedPreferences.Editor editor2 = mySettings.edit();
                editor2.putInt(APP_PREFERENCES_IMAGEX, value);
                editor2.apply();
                break;
            case APP_PREFERENCES_IMAGEY:
                SharedPreferences.Editor editor3 = mySettings.edit();
                editor3.putInt(APP_PREFERENCES_IMAGEY, value);
                editor3.apply();
                break;
            case APP_PREFERENCES_TEXTSIZE:
                SharedPreferences.Editor editor4 = mySettings.edit();
                editor4.putInt(APP_PREFERENCES_TEXTSIZE, value);
                editor4.apply();
                break;
            case APP_PREFERENCES_LEARNINGPROGRESS:
                SharedPreferences.Editor editor0 = mySettings.edit();
                editor0.putInt(APP_PREFERENCES_LEARNINGPROGRESS, value);
                editor0.apply();
                break;
            default:
                System.out.println("I have not this value (integer)");
                break;
        }
    }

    public void save(String file, Boolean value){
        switch (file){
            case APP_PREFERENCES_ISUPDATED:
                SharedPreferences.Editor editor5 = mySettings.edit();
                editor5.putBoolean(APP_PREFERENCES_ISUPDATED, value);
                editor5.apply();
                break;
            case APP_PREFERENCES_ISCREATED:
                SharedPreferences.Editor editor6 = mySettings.edit();
                editor6.putBoolean(APP_PREFERENCES_ISCREATED, value);
                editor6.apply();
                break;
            default:
                System.out.println("I have not this value (boolean)");
                break;
        }
    }

    public void save(String file, Float value){
        switch (file){
            case APP_PREFERENCES_CHILDISHNESS:
                SharedPreferences.Editor editor7 = mySettings.edit();
                //editor7.putFloat(APP_PREFERENCES_ISUPDATED, value); aaaaxxaxaxaxaxaxaxxaaxaxaxaaxx lol
                editor7.putFloat(APP_PREFERENCES_CHILDISHNESS, value);
                editor7.apply();
                break;
            case APP_PREFERENCES_LAZINESS:
                SharedPreferences.Editor editor8 = mySettings.edit();
                editor8.putFloat(APP_PREFERENCES_LAZINESS, value);
                editor8.apply();
                break;
            default:
                System.out.println("I have not this value (float)");
                break;
        }
    }

   public String loadString(String file){
       if(mySettings.contains(APP_PREFERENCES_NAME)) {
           return mySettings.getString(APP_PREFERENCES_NAME, "");
       }
       return "UserName";
   }

    public Integer loadInteger(String file){
        switch (file){
            case APP_PREFERENCES_IMAGEX:
                if(mySettings.contains(APP_PREFERENCES_IMAGEX)) {
                    return mySettings.getInt(APP_PREFERENCES_IMAGEX, 98);
                }
                break;
            case APP_PREFERENCES_IMAGEY:
                if(mySettings.contains(APP_PREFERENCES_IMAGEY)) {
                    return mySettings.getInt(APP_PREFERENCES_IMAGEY, 98);
                }
                break;
            case APP_PREFERENCES_TEXTSIZE:
                if(mySettings.contains(APP_PREFERENCES_TEXTSIZE)) {
                    return mySettings.getInt(APP_PREFERENCES_TEXTSIZE, 30);
                }
                break;
            case APP_PREFERENCES_LEARNINGPROGRESS:
                if(mySettings.contains(APP_PREFERENCES_LEARNINGPROGRESS)) {
                    return mySettings.getInt(APP_PREFERENCES_LEARNINGPROGRESS, 0);
                }
                break;
            default:
                System.out.println("I have not this value");
                break;
        }
        return 50;
    }

    public Boolean loadBoolean(String file){
        switch (file){
            case APP_PREFERENCES_ISUPDATED:
                if(mySettings.contains(APP_PREFERENCES_ISUPDATED)) {
                    //System.out.println(APP_PREFERENCES_ISUPDATED + " " + mySettings.getBoolean(APP_PREFERENCES_ISUPDATED, false));
                    System.out.println(mySettings.getBoolean(APP_PREFERENCES_ISUPDATED, false));
                    return mySettings.getBoolean(APP_PREFERENCES_ISUPDATED, false);
                }
                break;
            case APP_PREFERENCES_ISCREATED:
                if(mySettings.contains(APP_PREFERENCES_ISCREATED)) {
                    return mySettings.getBoolean(APP_PREFERENCES_ISCREATED, false);
                }
                break;
            default:
                System.out.println("I have not this value");
                break;
        }
        return false;
    }

    public Float loadFloat(String file){
        switch (file){
            case APP_PREFERENCES_CHILDISHNESS:
                if(mySettings.contains(APP_PREFERENCES_CHILDISHNESS)) {
                    return mySettings.getFloat(APP_PREFERENCES_CHILDISHNESS, 1);
                }
            case APP_PREFERENCES_LAZINESS:
                if(mySettings.contains(APP_PREFERENCES_LAZINESS)) {
                    return mySettings.getFloat(APP_PREFERENCES_LAZINESS, 1);
                }
        }
        return 1f;
    }

    public boolean exitBool;

    public Boolean saveDefault(){
        exitBool = false;
        valuesHolder = new ValuesHolder();
        soulHolder = new SoulHolder();

        System.out.println(APP_PREFERENCES_IMAGEX);
        if(mySettings.contains(APP_PREFERENCES_IMAGEX)) {
            System.out.println("I have it");
            ValuesHolder.setImageX(loadInteger(APP_PREFERENCES_IMAGEX));
            exitBool = true;
        }
        else {
            System.out.println("I do not have it");
            save(APP_PREFERENCES_IMAGEX, ValuesHolder.getImageX());
        }

        System.out.println(APP_PREFERENCES_LEARNINGPROGRESS);
        if(mySettings.contains(APP_PREFERENCES_LEARNINGPROGRESS)) {
            System.out.println("I have it");
            ValuesHolder.setLearningProgress(loadInteger(APP_PREFERENCES_LEARNINGPROGRESS));
            exitBool = true;
        }
        else {
            System.out.println("I do not have it");
            save(APP_PREFERENCES_LEARNINGPROGRESS, ValuesHolder.getLearningProgress());
        }

        System.out.println(APP_PREFERENCES_IMAGEY);
        if(mySettings.contains(APP_PREFERENCES_IMAGEY)) {
            System.out.println("I have it");
            ValuesHolder.setImageY(loadInteger(APP_PREFERENCES_IMAGEY));
            exitBool = true;
        }
        else {
            System.out.println("I do not have it");
            save(APP_PREFERENCES_IMAGEY, ValuesHolder.getImageY());
        }

        System.out.println(APP_PREFERENCES_CHILDISHNESS);
        if(mySettings.contains(APP_PREFERENCES_CHILDISHNESS)) {
            System.out.println("I have it");
            soulHolder.setChildishness(loadFloat(APP_PREFERENCES_CHILDISHNESS));
            exitBool = true;
        }
        else {
            System.out.println("I do not have it");
            save(APP_PREFERENCES_CHILDISHNESS, soulHolder.getChildishness());
        }

        System.out.println(APP_PREFERENCES_LAZINESS);
        if(mySettings.contains(APP_PREFERENCES_LAZINESS)) {
            System.out.println("I have it");
            soulHolder.setLaziness(loadFloat(APP_PREFERENCES_LAZINESS));
            exitBool = true;
        }
        else {
            System.out.println("I do not have it");
            save(APP_PREFERENCES_LAZINESS, soulHolder.getLaziness());
        }

        System.out.println(APP_PREFERENCES_TEXTSIZE);
        if(mySettings.contains(APP_PREFERENCES_TEXTSIZE)) {
            System.out.println("I have it");
            ValuesHolder.setTextSize(loadInteger(APP_PREFERENCES_TEXTSIZE));
            exitBool = true;
        }
        else {
            System.out.println("I do not have it");
            save(APP_PREFERENCES_TEXTSIZE, ValuesHolder.getTextSize());
        }

        System.out.println(APP_PREFERENCES_NAME);
        if(mySettings.contains(APP_PREFERENCES_NAME)) {
            System.out.println("I have it");
            ValuesHolder.setName(loadString(APP_PREFERENCES_NAME));
            exitBool = true;
        }
        else {
            System.out.println("I do not have it");
            save(APP_PREFERENCES_NAME, ValuesHolder.getName());
        }

        System.out.println(APP_PREFERENCES_ISCREATED);
        if(mySettings.contains(APP_PREFERENCES_ISCREATED)) {
            System.out.println("I have it");
            ValuesHolder.setIsCreated(loadBoolean(APP_PREFERENCES_ISCREATED));
            exitBool = true;
        }
        else {
            System.out.println("I do not have it");
            save(APP_PREFERENCES_ISCREATED, ValuesHolder.getCreateStatus());
        }

        System.out.println(APP_PREFERENCES_ISUPDATED);
        if(mySettings.contains(APP_PREFERENCES_ISUPDATED)) {
            System.out.println("I have it");
            ValuesHolder.setIsUpdated(loadBoolean(APP_PREFERENCES_ISUPDATED));
            exitBool = true;
        }
        else {
            System.out.println("I do not have it");
            save(APP_PREFERENCES_ISUPDATED, ValuesHolder.getUpdateStatus());
        }

        return exitBool;
    }
}
