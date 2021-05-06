package com.example.fert1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FailTimer {
    // Текущее время
    protected Date currentDate = new Date();
    protected DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
    protected String timeText = timeFormat.format(currentDate);

    protected String timeRegex = ":";

    protected static Integer startTime = 0;
    protected static Integer endTime = 0;
    protected static Integer difference;
    protected static Integer currentTime;
    protected static Integer waitFor;
    protected static  boolean isWaiting = false;


    public Integer timeToInteger(String string){
        return Integer.parseInt(string.split(timeRegex)[2]) +
                Integer.parseInt(string.split(timeRegex)[1]) * 60 +
                Integer.parseInt(string.split(timeRegex)[0]) * 3600;
    }

    public Integer getTime(){
        Date currentDate = new Date();
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        timeText = timeFormat.format(currentDate);
        System.out.println(timeText);
        currentTime = timeToInteger(timeText);
        System.out.println("Time is " + currentTime);
        return currentTime;
    }

    public Integer getWaitFor(){
        System.out.println(startTime + difference);
        return startTime + difference;
    }

    public Integer setStartTime() {
        startTime = getTime();
        isWaiting = true;
        return startTime;
    }

    public Integer setWaitFor() {
        waitFor = startTime + difference;
        if(waitFor>24*60*60) waitFor-=24*60*60;
        System.out.println("Waiting for " + waitFor);
        return waitFor;
    }

    public Integer setDifference(Integer integer){
        difference = integer;
        return difference;
    }

    public boolean isEnded(){
        endTime = getTime();
        if(endTime>waitFor) isWaiting=false;
        return endTime>waitFor;
    }

    public void setAll(Integer integer){
        setStartTime();
        setDifference(integer);
        setWaitFor();
    }

    public  boolean getIsWaiting() {
        return isWaiting;
    }
}