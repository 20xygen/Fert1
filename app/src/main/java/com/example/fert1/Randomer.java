package com.example.fert1;

import com.example.fert1.keeping.SoulHolder;

public class Randomer {
    protected Integer minRandom = 0;
    protected Integer maxRandom = 100;
    protected SoulHolder soulHolder;

    protected boolean eventIsGoing = false;

    public void startEvent(){eventIsGoing=true;}

    public void stopEvent(){eventIsGoing=false;}

    public boolean isEventIsGoing() {
        return eventIsGoing;
    }

    public void setMinRandom(Integer minRandom) {
        this.minRandom = minRandom;
    }

    public void setMaxRandom(Integer maxRandom) {
        this.maxRandom = maxRandom;
    }

    public Float getRoughly(Float number){
        return (float) (number * 0.75 + Math.random() * number * 0.5);
    }

    public Integer getRandom(){
        return (int) (Math.random() * 1000);
    }

    public Double getDouble(){
        return (double) (-1000d + Math.random() * 2000d);
    }

    public boolean doOrNot(Integer percent, Float coefficient){
        return (minRandom + (int) (Math.random() * maxRandom)) * coefficient > percent;
    }

    protected float randomFloat;

    public boolean doOrNot(){
        System.out.println("doing new random");
        soulHolder = new SoulHolder();
        System.out.println(soulHolder.getLaziness() + soulHolder.getChildishness());
        randomFloat = ((float) Math.random()) * 4.8f + (soulHolder.getLaziness() + soulHolder.getChildishness());
        System.out.println(randomFloat);
        return randomFloat > 4.4f;
    }

    public Integer choose(Integer quantity){
        return 1 + (int) (Math.random() * (quantity));
    }

    protected Double randomCOL;

    public Integer childOrLazy(Float childishnessCoefficient, Float lazinessCoefficient){
        randomCOL = Math.random() * (childishnessCoefficient + lazinessCoefficient);
        System.out.println("randomCOL = ---------------------------- " + randomCOL);
        if (randomCOL > childishnessCoefficient){
            return 2;
        }
        return 1;
    }
}
