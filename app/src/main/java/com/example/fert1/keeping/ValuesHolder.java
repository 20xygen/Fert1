package com.example.fert1.keeping;

import android.content.Context;

public class ValuesHolder {
    protected static Integer imageX = 98;
    protected static Integer imageY = 98;
    protected static String name = "User";
    protected static Integer textSize = 30;
    protected static boolean isUpdated = false;
    protected static boolean isCreated = false;
    protected static ValuesSaver valuesSaver;
    protected Context context;
    protected static Integer learningProgress = 111;
    protected static Integer typeOfWaiting;

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
