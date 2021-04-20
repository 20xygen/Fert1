package com.example.fert1;

public class Randomer {
    public Integer minRandom = 0;
    public Integer maxRandom = 100;

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
