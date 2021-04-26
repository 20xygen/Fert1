package com.example.fert1;

public class Randomer {
    public Integer minRandom = 0;
    public Integer maxRandom = 100;
    public SoulHolder soulHolder;

    public boolean eventIsGoing = false;

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

    public boolean doOrNot(Integer percent, Float coefficient){
        return (minRandom + (int) (Math.random() * maxRandom)) * coefficient > percent;
    }

    float randomFloat;

    public boolean doOrNot(){
        System.out.println("doing new random");
        soulHolder = new SoulHolder();
        System.out.println(soulHolder.getLaziness() + soulHolder.getChildishness());
        randomFloat = ((float) Math.random()) * 4.8f + (soulHolder.getLaziness() + soulHolder.getChildishness());
        System.out.println(randomFloat);
        return randomFloat > 4.4f;
    }

    public Integer choose(Integer quantity){
        return 1 + (int) (Math.random() * (quantity-1));
    }

    Double randomCOL;

    public Integer childOrLazy(Float childishnessCoefficient, Float lazinessCoefficient){
        randomCOL = Math.random() * (childishnessCoefficient + lazinessCoefficient);
        System.out.println("randomCOL = ---------------------------- " + randomCOL);
        if (randomCOL > childishnessCoefficient){
            return 2;
        }
        return 1;
    }
}
