package com.example.fert1;

import android.content.Context;
import android.content.SharedPreferences;

public class ValuesSaver {
    public static final String APP_PREFERENCES = "mySettings";

    public static final String APP_PREFERENCES_NAME = "Name";
    public static final String APP_PREFERENCES_IMAGEX = "ImageX";
    public static final String APP_PREFERENCES_IMAGEY = "ImageY";
    public static final String APP_PREFERENCES_TEXTSIZE = "TextSize";
    public static final String APP_PREFERENCES_ISUPDATED = "IsUpdated";
    public static final String APP_PREFERENCES_ISCREATED = "IsCreated";
    public static final String APP_PREFERENCES_CHILDISHNESS = "Childishness";
    public static final String APP_PREFERENCES_LAZINESS = "Laziness";

    SharedPreferences mySettings;

    public ValuesSaver(Context context){
        mySettings = context.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
    }

    public void save(String file, String value){
//        switch (file){
//            case APP_PREFERENCES_NAME:
//                SharedPreferences.Editor editor1 = mySettings.edit();
//                editor1.putString(APP_PREFERENCES_NAME, value);
//                editor1.apply();
//                break;
//            default:
//                System.out.println("I have not this value");
//                break;
//        }
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
            default:
                System.out.println("I have not this value");
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
                System.out.println("I have not this value");
                break;
        }
    }

    public void save(String file, Float value){
        switch (file){
            case APP_PREFERENCES_CHILDISHNESS:
                SharedPreferences.Editor editor7 = mySettings.edit();
                editor7.putFloat(APP_PREFERENCES_ISUPDATED, value);
                editor7.apply();
                break;
            case APP_PREFERENCES_LAZINESS:
                SharedPreferences.Editor editor8 = mySettings.edit();
                editor8.putFloat(APP_PREFERENCES_LAZINESS, value);
                editor8.apply();
                break;
            default:
                System.out.println("I have not this value");
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
            default:
                System.out.println("I have not this value");
                break;
        }
        return null;
    }

    public Boolean loadBoolean(String file){
        switch (file){
            case APP_PREFERENCES_ISUPDATED:
                if(mySettings.contains(APP_PREFERENCES_ISUPDATED)) {
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
        return null;
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
        return null;
    }
}
