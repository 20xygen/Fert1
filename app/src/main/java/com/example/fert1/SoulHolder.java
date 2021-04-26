package com.example.fert1;

import android.content.Context;

public class SoulHolder {
    public static float childishness = 1;
    public static float laziness = 1;
    public static boolean waitingFotReaction = false;
    public static Integer typeOfReaction = -1;
    public static ValuesSaver valuesSaver;
    public Context context;

    public void setContext(Context context){
        this.context = context;
    }

    public void createValuesSaver(){
        valuesSaver = new ValuesSaver(context);
    }

    public SoulHolder(){

    }

    public  Integer getTypeOfReaction() {
        return typeOfReaction;
    }

    public  void setTypeOfReaction(Integer typeOfReaction) {
        SoulHolder.typeOfReaction = typeOfReaction;
    }

    public void startWaitForReaction(){waitingFotReaction=true;}

    public void stopWaitForReaction(){waitingFotReaction=false;}

    public boolean checkWaiting(){return waitingFotReaction;}

    public  float getChildishness() {
        return childishness;
    }

    public  void setChildishness(float childishness) {
        SoulHolder.childishness = childishness;
    }

    public  float getLaziness() {
        return laziness;
    }

    public  void setLaziness(float laziness) {
        SoulHolder.laziness = laziness;
    }

    public void childishnessFromLaziness(Float value){
        if(childishness+value<=1.8)childishness+=value;
        else childishness = 1.8f;
        if(laziness-value>=0.2)laziness-=value;
        else laziness = 0.2f;
        System.out.println("childishnessFromLaziness, childishness is " + childishness + ", laziness is " + laziness);
    }

    public void lazinessFromChildishness(Float value){
        if(laziness+value<=1.8)laziness+=value;
        else laziness = 1.8f;
        if(childishness-value>=0.2)childishness-=value;
        else childishness = 0.2f;
        System.out.println("lazinessFromChildishness, childishness is " + childishness + ", laziness is " + laziness);
    }

    public void increase(Float value){
        if(laziness+value<=1.8)laziness+=value;
        else laziness = 1.8f;
        if(childishness+value<=1.8)childishness+=value;
        else childishness = 1.8f;
        System.out.println("increase, childishness is " + childishness + ", laziness is " + laziness);
    }

    public void decrease(Float value){
        if(childishness-value>=0.2)childishness-=value;
        else childishness = 0.2f;
        if(laziness-value>=0.2)laziness-=value;
        else laziness = 0.2f;
        System.out.println("decrease, childishness is " + childishness + ", laziness is " + laziness);
    }

    public void saveAll(){
        System.out.println("valuesSaver " + valuesSaver);
        System.out.println("childishness " + childishness);
        System.out.println("laziness " + laziness);
        valuesSaver.save("Childishness", childishness);
        valuesSaver.save("Laziness", laziness);
    }

    public void loadAll(){
        childishness = valuesSaver.loadFloat("Childishness");
        laziness = valuesSaver.loadFloat("Laziness");
    }
}
