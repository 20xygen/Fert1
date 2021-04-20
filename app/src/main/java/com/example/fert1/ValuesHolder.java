package com.example.fert1;

import android.content.Context;

public class ValuesHolder {
    public static Integer imageX = 98;
    public static Integer imageY = 98;
    public static String name = "User";
    public static Integer textSize = 30;
    public static boolean isUpdated = false;
    public static boolean isCreated = false;
    public static ValuesSaver valuesSaver;
    public Context context;

    public ValuesHolder(){

    }

    public void createValuesSaver(){
        valuesSaver = new ValuesSaver(context);
    }


    public void setContext(Context context) {
        this.context = context;
    }

    public static Integer getTextSize() {
        return textSize;
    }

    public static void setTextSize(Integer textSize) {
        ValuesHolder.textSize = textSize;
    }

    public static boolean getUpdateStatus(){return isUpdated; }

    public static boolean getCreateStatus(){return isCreated; }

    public static void makeUpdated(){isUpdated=true;}

    public static void makeCreated(){isCreated=true;}

    public static void makeNotUpdated(){isUpdated=false;}

    public static void makeNotCreated(){isCreated=false;}

    public static Integer getImageX() {
        return imageX;
    }

    public static void setImageX(Integer imageX) {
        ValuesHolder.imageX = imageX;
    }

    public static Integer getImageY() {
        return imageY;
    }

    public static void setImageY(Integer imageY) {
        ValuesHolder.imageY = imageY;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        ValuesHolder.name = name;
    }

    public static void saveAll(){
        valuesSaver.save("Name", name);
        valuesSaver.save("ImageX", imageX);
        valuesSaver.save("ImageY", imageY);
        valuesSaver.save("TextSize", textSize);
        valuesSaver.save("IsUpdated", isUpdated);
        valuesSaver.save("IsCreated", isCreated);
    }

    public static void loadAll(){
        name = valuesSaver.loadString("Name");
        imageX = valuesSaver.loadInteger("ImageX");
        imageY = valuesSaver.loadInteger("ImageY");
        textSize = valuesSaver.loadInteger("TextSize");
        isUpdated = valuesSaver.loadBoolean("IsUpdated");
        isCreated = valuesSaver.loadBoolean("IsCreated");
    }
}
