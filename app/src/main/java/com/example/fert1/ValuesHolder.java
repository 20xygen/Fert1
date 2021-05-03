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
    public static Integer learningProgress = 11;
    public static Integer typeOfWaiting;

    public static Integer getTypeOfWaiting() {
        return typeOfWaiting;
    }

    public static void setTypeOfWaiting(Integer typeOfWaiting) {
        ValuesHolder.typeOfWaiting = typeOfWaiting;
    }

    public static Integer getLearningProgress() {
        return learningProgress;
    }

    public static void setLearningProgress(Integer learningProgress) {
        ValuesHolder.learningProgress = learningProgress;
    }

    public ValuesHolder(){

    }

    public static void setIsUpdated(boolean isUpdated) {
        ValuesHolder.isUpdated = isUpdated;
    }

    public static void setIsCreated(boolean isCreated) {
        ValuesHolder.isCreated = isCreated;
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

    public void saveAll(){
        valuesSaver.save("Name", name);
        valuesSaver.save("ImageX", imageX);
        valuesSaver.save("ImageY", imageY);
        valuesSaver.save("TextSize", textSize);
        valuesSaver.save("IsUpdated", isUpdated);
        valuesSaver.save("IsCreated", isCreated);
        valuesSaver.save("LearningProgress", learningProgress);
    }

    public void loadAll(){
        System.out.println("Name " + valuesSaver.loadString("Name"));
        name = valuesSaver.loadString("Name");
        System.out.println("LearningProgress " + valuesSaver.loadInteger("LearningProgress"));
        imageX = valuesSaver.loadInteger("LearningProgress");
        System.out.println("ImageX " + valuesSaver.loadInteger("ImageX"));
        imageX = valuesSaver.loadInteger("ImageX");
        System.out.println("ImageY " + valuesSaver.loadInteger("ImageY"));
        imageY = valuesSaver.loadInteger("ImageY");
        System.out.println("TextSize " + valuesSaver.loadInteger("TextSize"));
        textSize = valuesSaver.loadInteger("TextSize");
        //System.out.println("Is created : ");
        System.out.println("IsCreated " + valuesSaver.loadBoolean("IsCreated"));
        //isUpdated = valuesSaver.loadBoolean("IsUpdated");
        isCreated = valuesSaver.loadBoolean("IsCreated");
        System.out.println("IsUpdated " + valuesSaver.loadBoolean("IsUpdated"));
        isUpdated = valuesSaver.loadBoolean("IsUpdated");
    }
}
