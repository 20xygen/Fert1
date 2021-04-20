package com.example.fert1;

import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class NumpadTaskChanger {
    static TextView task;
    static TextView dialog;
    PolishSolver polishSolver;
    TaskChanger taskChanger;
    static ArrayList<String> taskArray;
    FailTimer failTimer;
    Randomer randomer;
    SoulHolder soulHolder;
    NumpadMain numpadMain;
    ImageButton backButton;
    ImageButton equallyButton;

    public void setImageButtons(ImageButton imageButton1, ImageButton imageButton2){
        backButton = imageButton1; equallyButton = imageButton2;
    }

    /*
    public void setQuestionType(){
        if (backButton == null) System.out.println("num17 IS NULL");
        else if (equallyButton == null) System.out.println("num20 IS NULL");
        else {
            backButton.setImageResource(R.drawable.disrespect);
            equallyButton.setImageResource(R.drawable.respect);
        }

    }

    public void setSimpleType(){
        if (backButton == null) System.out.println("num17 IS NULL");
        else if (equallyButton == null) System.out.println("num20 IS NULL");
        else {
            backButton.setImageResource(R.drawable.delete);
            equallyButton.setImageResource(R.drawable.equally);
        }
    }

     */

    public NumpadTaskChanger(){
        polishSolver = new PolishSolver();
        taskArray = new ArrayList<>();
        failTimer = new FailTimer();
        randomer = new Randomer();
        soulHolder = new SoulHolder();
    }

    public void setTask (TextView textView){
        task = textView;
        taskChanger = new TaskChanger(task);
    }

    public void setDialog(TextView textView){
        dialog = textView;
    }

    public void setNumpadMain(NumpadMain numpadMain) {
        this.numpadMain = numpadMain;
    }

    public boolean hasPoint(){
        if(taskArray.size()>0){
            for (int i = taskArray.size()-1; i >= 0; i--) {
                System.out.println("hasPoint: taskArray[" + i + "] = " + taskArray.get(i) + " is " + polishSolver.getSymbol(taskArray.get(i)));
                if (polishSolver.getSymbol(taskArray.get(i))!=9 &&
                        polishSolver.getSymbol(taskArray.get(i))!=8){
                    System.out.println(polishSolver.getSymbol(taskArray.get(i)) + " не цифра и не точка");
                    return false;
                }
                else if (polishSolver.getSymbol(taskArray.get(i))==8) return true;
            }
        }
        return false;
    }

    boolean canUpdate;

    public void update(String newSymbol){

        canUpdate = false;
        System.out.println(newSymbol);
        //hasPoint = false;
        System.out.println(polishSolver.getSymbol(newSymbol)==2);
        System.out.println(polishSolver.getSymbol(newSymbol)>=3 && polishSolver.getSymbol(newSymbol)<=7);
        System.out.println(polishSolver.getSymbol(newSymbol)==8);
        System.out.println(polishSolver.getSymbol(newSymbol)!=8 && polishSolver.getSymbol(newSymbol)!=2);
        if(taskArray.size()==0 && polishSolver.getSymbol(newSymbol)<9){
            System.out.println("Нельзя ставить знак пока нет числа");
        }
        else if (polishSolver.getSymbol(newSymbol)==2){
            System.out.println(taskArray);
                System.out.println("path 1");
                canUpdate = canPasteRightBracket();
            }
            else if (polishSolver.getSymbol(newSymbol)>=3 && polishSolver.getSymbol(newSymbol)<=7){
                System.out.println("path 2");
                if (polishSolver.getSymbol(taskArray.get(taskArray.size()-1))<3  ||
                        polishSolver.getSymbol(taskArray.get(taskArray.size()-1))>7){
                    canUpdate=true;
                }
            }
            else if (polishSolver.getSymbol(newSymbol)==8){
                System.out.println("path 3");
                canUpdate = !hasPoint();
            }
            else if (polishSolver.getSymbol(newSymbol)!=8 && polishSolver.getSymbol(newSymbol)!=2){
                System.out.println("path 4");
                canUpdate=true;
            }
            if (canUpdate){
                taskArray.add(newSymbol);
                taskChanger.changeWithArray(taskArray);
            }


    }

    Double updateAnswer;

    public void simpleUpdate(){
        System.out.println("i am simple");
        dialog.setText("Процент ошибки: 1%");
        System.out.println("Передаю собирателю: " + taskArray);
        taskArray = polishSolver.solve(taskArray);
        System.out.println("Взял от собирателя и передаю решателю: " + taskArray);
        taskChanger.changeWithArray(polishSolver.count(taskArray));
        updateAnswer=polishSolver.count(taskArray);
        //taskArray.clear();
        //taskArray.add(updateAnswer.toString());
        symbolUpdate(updateAnswer);
    }

    Integer intRandom;

    public void update(Integer typeOfAction){
        //try {
        if(soulHolder.checkWaiting()){
            switch (typeOfAction){
                case 1:
                    if(soulHolder.getTypeOfReaction()==1){
                        System.out.println("disrespect childishness");
                        soulHolder.lazinessFromChildishness(randomer.getRoughly(0.2f));
                    }
                    else if(soulHolder.getTypeOfReaction()==2){
                        System.out.println("disrespect laziness");
                        soulHolder.childishnessFromLaziness(randomer.getRoughly(0.2f));
                    }
                    else if(soulHolder.getTypeOfReaction()==0){
                        System.out.println("disrespect truth");
                        soulHolder.increase(randomer.getRoughly(0.15f));
                    }
                    break;
                case 2:
                    if(soulHolder.getTypeOfReaction()==2){
                        System.out.println("respect laziness");
                        soulHolder.lazinessFromChildishness(randomer.getRoughly(0.2f));
                    }
                    else if(soulHolder.getTypeOfReaction()==1){
                        System.out.println("respect childishness");
                        soulHolder.childishnessFromLaziness(randomer.getRoughly(0.2f));
                    }
                    else if(soulHolder.getTypeOfReaction()==0){
                        System.out.println("respect truth");
                        soulHolder.decrease(randomer.getRoughly(0.15f));
                    }
                    break;
            }
            //numpadMain.setQuestionType();
            numpadMain.setSimpleType();
            soulHolder.stopWaitForReaction();
        }
        else if(taskArray!=null) {
            switch (typeOfAction) {
                case 1:
                    if (taskArray.size() > 1) {
                        taskArray.remove(taskArray.size() - 1);
                    } else if (taskArray.size() == 1) {
                        taskArray.remove(taskArray.size() - 1);
                        task.setText("0");
                    }
                    taskChanger.changeWithArray(taskArray);
                    break;
                case 2:
                    System.out.println("Tapped equally");
                    if (failTimer.getIsWaiting()) {
                        System.out.println("We are waiting");
                        if (failTimer.isEnded()) {
                            if (taskArray.size()>0){
                                System.out.println(taskArray);
                                System.out.println("Ended");
                                soulHolder.setTypeOfReaction(2);
                                soulHolder.startWaitForReaction();
                                //numpadMain.setQuestionType();
                                numpadMain.setQuestionType();
                                dialog.setText("Процент ошибки: 1%");
                                simpleUpdate();
                            }
                            else symbolUpdate(0d);

                        } else {
                            System.out.println("Not ended");
                            dialog.setText("Мне лень, зайди несколько секунд");
                        }
                    } else {
                        System.out.println("We are NOT waiting");
                        if (randomer.doOrNot(50, 1f)) {
                            System.out.println("Do event");
                            switch (randomer.childOrLazy(soulHolder.getChildishness(), soulHolder.getLaziness())) {
                                case 1:
                                    System.out.println("I am lazy");
                                    dialog.setText("Мне лень, зайди через секунд 10");
                                    failTimer.setAll(10);
                                    break;
                                case 2:
                                    if (randomer.doOrNot(50, 1f)) {
                                        System.out.println("Random answer");
                                        soulHolder.startWaitForReaction();
                                        soulHolder.setTypeOfReaction(1);
                                        //numpadMain.setQuestionType();
                                        numpadMain.setQuestionType();
                                        intRandom = randomer.getRandom();
                                        task.setText(intRandom + "");
                                        symbolUpdate((double) intRandom);
                                        //symbolUpdate((double) (int) randomer.getRandom());
                                    } else {
                                        System.out.println("Simple Answer");
                                        simpleUpdate();
                                        soulHolder.setTypeOfReaction(0);
                                        soulHolder.startWaitForReaction();
                                        //numpadMain.setQuestionType();
                                        numpadMain.setQuestionType();
                                    }
                                    dialog.setText("Процент ошибки: 50%");
                            }
                        } else {
                            if(taskArray.size()>0){
                                System.out.println("Do Simple");
                                dialog.setText("Процент ошибки: 1%");
                                simpleUpdate();
                                soulHolder.setTypeOfReaction(0);
                                soulHolder.startWaitForReaction();
                                //numpadMain.setQuestionType();
                                numpadMain.setQuestionType();
                            }
                            else symbolUpdate(0d);
                        }
                    }
            }
        }
        else {
            symbolUpdate(0d);
        }
        //}
        //catch (Exception e){
        //    System.out.println(e);
        //    taskChanger.notifyError();
        //}

    }

    String symbolUpdateString;
    Integer symbolUpdateInteger;

    public void symbolUpdate (Double inputSymbolUpdate){
        try {
            if(inputSymbolUpdate%1==0.0) {
                symbolUpdateInteger = (int) (double) inputSymbolUpdate;
                symbolUpdateString=symbolUpdateInteger.toString();
                taskArray.clear();
                for (int i = 0; i < symbolUpdateString.length(); i++) {
                    taskArray.add(symbolUpdateString.substring(i,i+1));;
                }
            }
            else {
                symbolUpdateString=inputSymbolUpdate.toString();
                taskArray.clear();
                for (int i = 0; i < symbolUpdateString.length(); i++) {
                    taskArray.add(symbolUpdateString.substring(i,i+1));;
                }
            }
        }
        catch (Exception e){
            taskChanger.notifyError();
        }
    }

    Integer leftBrackets = 0;
    Integer rightBrackets = 0;

    public boolean canPasteRightBracket(){
        leftBrackets=0;
        rightBrackets=0;
        for (int i = 0; i < taskArray.size(); i++) {
            if (taskArray.get(i).contains("(")) leftBrackets++;
            if (taskArray.get(i).contains(")")) rightBrackets++;
        }
        return rightBrackets<leftBrackets;
    }
}
