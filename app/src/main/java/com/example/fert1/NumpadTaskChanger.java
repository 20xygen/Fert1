package com.example.fert1;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
    Context context;
    ValuesSaver valuesSaver;
    NewCustomDialog newCustomDialog;

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    Activity activity;

    public void setContext(Context context){
        this.context = context;
    }

    public void createValuesSaver(){
        valuesSaver = new ValuesSaver(context);
        soulHolder.setContext(context);
        soulHolder.createValuesSaver();
    }

    public ValuesSaver getValuesSaver() {
        return valuesSaver;
    }

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

    public void clearTaskArray(){
        taskArray = new ArrayList<String>();
        task.setText("0");
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

//        if(soulHolder.checkWaiting()){
//            numpadMain.setQuestionType();
//        }
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

    public Boolean hasNumber(){
        if(taskArray.size()==0){
            return false;
        }
        else {
            for (int i = 0; i < taskArray.size(); i++) {
                if(polishSolver.getSymbol(taskArray.get(i))==9) return true;
            }
            return false;
        }
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
        if (taskArray.size()==0){
            if(polishSolver.getSymbol(newSymbol)<9 && polishSolver.getSymbol(newSymbol)!=1){
                System.out.println("Нельзя ставить знак пока нет числа");
            }
            else {
                taskArray.add(newSymbol);
                taskChanger.changeWithArray(taskArray);
            }
        }

        else if(!hasNumber() && polishSolver.getSymbol(newSymbol)<9 && polishSolver.getSymbol(newSymbol)!=1){
            System.out.println("Нельзя ставить знак пока нет числа");
        }
        else if(polishSolver.getSymbol(taskArray.get(taskArray.size()-1))!=9 && polishSolver.getSymbol(newSymbol)<9 && polishSolver.getSymbol(newSymbol)!=1 && polishSolver.getSymbol(newSymbol)!=2){
            if(polishSolver.getSymbol(taskArray.get(taskArray.size()-1))==2 && polishSolver.getSymbol(newSymbol)!=1 && polishSolver.getSymbol(newSymbol)!=8){
                System.out.println("Последний - скобка, всё ок");
                taskArray.add(newSymbol);
                taskChanger.changeWithArray(taskArray);
            }
            else System.out.println("Последний символ не число");

        }
        else if (polishSolver.getSymbol(newSymbol)==1){
            if(polishSolver.getSymbol(taskArray.get(taskArray.size()-1))!=2 && polishSolver.getSymbol(taskArray.get(taskArray.size()-1))!=8 && polishSolver.getSymbol(taskArray.get(taskArray.size()-1))!=9){
                taskArray.add(newSymbol);
                taskChanger.changeWithArray(taskArray);
            }
            else {
                System.out.println("Не могу сюда вставить скобку");
            }
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
        try {
            addZeros();
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
        catch (Exception e){
            taskArray = new ArrayList<String>();
            task.setText("Допущена ошибка :(");
        }
    }

    public Boolean hasSpecialMinuses = true;

    public void addZeros(){
        System.out.println("I add zeros: " + taskArray);
        if (taskArray.size()>1){
            System.out.println("Size is more that 1");
            hasSpecialMinuses = true;
            while (hasSpecialMinuses){
                System.out.println("Current taskArray is: " + taskArray);
                hasSpecialMinuses = false;
                for (int i = 0; i < taskArray.size(); i++) {
                    System.out.println("Symbol " + i + " is " + taskArray.get(i));
                    if(taskArray.size()>2){
                        System.out.println("Size is more that 1");
                        if(i>0){
                            if(taskArray.get(i).equals("-") && !polishSolver.isNumber(taskArray.get(i-1))){
                                System.out.println("It has not number before minus, look: " + taskArray);
                                taskArray.add(i-1, "0");
                                hasSpecialMinuses = true;
                                System.out.println("I fixed it, look: " + taskArray);
                                break;
                            }
                        }
                    }
                    else if(taskArray.get(0).equals("-")){
                        System.out.println("Size is less that 2");
                        System.out.println("It has not number before minus in first position, look: " + taskArray);
                        taskArray.add(0, "0");
                        hasSpecialMinuses = true;
                        System.out.println("I fixed it, look: " + taskArray);
                        break;
                    };
                }
            }
        }
        else if(taskArray.size()>0){
            if(taskArray.get(0).equals("-")){
                System.out.println("Size is less that 2");
                taskArray.add(0, "0");
                hasSpecialMinuses = true;
            }
        }
        System.out.println("After: " + taskArray);
    }

    public void startNewDialog(){
//        if(valuesSaver.loadInteger("LearningProgress")==0){
//            newCustomDialog = new NewCustomDialog(activity);
//            newCustomDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//            newCustomDialog.show();
//        }
        HelpOperator.create(activity, "- После взаи-   модействия с    Фертом вам       будет предло- жено отреаги-  ровать с помо- щью появи-       вшихся кнопок.", 1);
    }

    Integer intRandom;

    public void update(Integer typeOfAction){
        //try {
        if(soulHolder.checkWaiting()){
            soulHolder.loadAll();

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
            soulHolder.saveAll();
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
                                startNewDialog();
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
                        if (/*randomer.doOrNot(50, 1f)*/ randomer.doOrNot()) {
                            System.out.println("Do event");
                            switch (randomer.childOrLazy(soulHolder.getChildishness(), soulHolder.getLaziness())) {
                                case 1:
                                    System.out.println("I am lazy");
                                    dialog.setText("Мне лень, зайди через секунд 10");
                                    failTimer.setAll(10);
                                    break;
                                case 2:
                                    if (randomer.doOrNot()) {
                                        System.out.println("Random answer");
                                        soulHolder.startWaitForReaction();
                                        startNewDialog();
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
                                        startNewDialog();
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
                                startNewDialog();
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
            if(inputSymbolUpdate.toString().contains("Infinity")){
                taskArray = new ArrayList<String>();
            }
            else if(inputSymbolUpdate%1==0.0) {
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
        clearPoints();
        addZeros();
    }

    public boolean canMoveToInteger(String string){
        try {
            return Double.parseDouble(string) % 1 == 0;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    public boolean canMoveToInteger(Double doubleInput){
        try {
            return doubleInput % 1 == 0;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public void symbolUpdate (String inputSymbolUpdate){
        taskArray.clear();
        if(!(inputSymbolUpdate.contains("Infinity"))){
            for (int i = 0; i < inputSymbolUpdate.length(); i++) {
                taskArray.add(inputSymbolUpdate.substring(i,i+1));;
            }
        }
        clearPoints();
        addZeros();
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

    public void addLearningLevel(){
        valuesSaver.save("LearningProgress", valuesSaver.loadInteger("LearningProgress")+1);
        ValuesHolder.setLearningProgress(valuesSaver.loadInteger("LearningProgress"));
    }

    public ArrayList<String> clonedTaskArray;
    public Integer points = 0;

    public void clearPoints(){
        System.out.println("I clear points");
        System.out.println(taskArray);
        points = 0;
        for (int i = 0; i < taskArray.size(); i++) {
            if(taskArray.get(i).equals(".")){
                points++;
            }
        }
        while (points>1){
            taskArray.remove(".");
            points = 0;
            for (int i = 0; i < taskArray.size(); i++) {
                if(taskArray.get(i).equals(".")){
                    points++;
                }
            }
        }
        System.out.println("After: " + taskArray);
    }

    public String cutTail(String string){
        if(string.length()>7) string = string.substring(0, 7);
        return string;
    }

    public String stringRandom = "";
    public Integer positionType = 0;
    public Integer firstRandom = 0;
    public Integer secondRandom = 0;
    public Double wrongDouble = 0d;

    public Double randomDouble = 0d;
    public Double firstRandomDouble = 0d;
    public Double secondRandomDouble = 0d;

    public void startEvent(Integer type){
        switch (type){
            case 0:
                simpleUpdate();
                soulHolder.setTypeOfReaction(0);
                soulHolder.startWaitForReaction();
                startNewDialog();
                numpadMain.setQuestionType();
                break;
            case 11:
                //numpadMain.setQuestionType();
                System.out.println("I am lazy");
                dialog.setText("Мне лень, зайди через секунд 10");
                failTimer.setAll(10);
                break;
            case 12:
                soulHolder.startWaitForReaction();
                startNewDialog();
                soulHolder.setTypeOfReaction(2);
                //numpadMain.setQuestionType();
                numpadMain.setQuestionType();
                dialog.setText("Что-то из этого...");
//                soulHolder.startWaitForReaction();
//                startNewDialog();
//                soulHolder.setTypeOfReaction(1);
//                numpadMain.setQuestionType();
                intRandom = randomer.getRandom();
                randomDouble = randomer.getDouble();
                //stringRandom = intRandom.toString();
                if(randomer.choose(2)==1){
                    System.out.println("Передаю собирателю: " + taskArray);
                    taskArray = polishSolver.solve(taskArray);
                    System.out.println("Взял от собирателя и передаю решателю: " + taskArray);
                    stringRandom = polishSolver.count(taskArray).toString() + cutTail(randomDouble.toString());
                    task.setText(polishSolver.count(taskArray).toString() + " или " + cutTail(randomDouble.toString()));
                }
                else{
                    System.out.println("Передаю собирателю: " + taskArray);
                    taskArray = polishSolver.solve(taskArray);
                    System.out.println("Взял от собирателя и передаю решателю: " + taskArray);
                    stringRandom = cutTail(randomDouble.toString()) + polishSolver.count(taskArray).toString();
                    task.setText(cutTail(randomDouble.toString()) + " или " + polishSolver.count(taskArray).toString());
                }
                symbolUpdate(stringRandom);
                break;
            case 13:
                soulHolder.startWaitForReaction();
                startNewDialog();
                soulHolder.setTypeOfReaction(2);
                //numpadMain.setQuestionType();
                numpadMain.setQuestionType();
                dialog.setText("Что-то из этого...");
//                soulHolder.startWaitForReaction();
//                startNewDialog();
//                soulHolder.setTypeOfReaction(1);
//                numpadMain.setQuestionType();
                firstRandom = randomer.getRandom();
                firstRandomDouble = randomer.getDouble();
                secondRandom = randomer.getRandom();
                secondRandomDouble = randomer.getDouble();
                //stringRandom = intRandom.toString();
                positionType = randomer.choose(3);
                switch (positionType){
                    case 1:
                        System.out.println("Передаю собирателю: " + taskArray);
                        taskArray = polishSolver.solve(taskArray);
                        System.out.println("Взял от собирателя и передаю решателю: " + taskArray);
//                        stringRandom = polishSolver.count(taskArray).toString() + firstRandom.toString() + secondRandom.toString();
//                        task.setText(polishSolver.count(taskArray).toString() + " или " + firstRandom.toString() + " или " + secondRandom.toString());
                        stringRandom = polishSolver.count(taskArray).toString() + cutTail(firstRandomDouble.toString()) + cutTail(secondRandomDouble.toString());
                        task.setText(polishSolver.count(taskArray).toString() + " или " + cutTail(firstRandomDouble.toString()) + " или " + cutTail(secondRandomDouble.toString()));
                        break;
                    case  2:
                        System.out.println("Передаю собирателю: " + taskArray);
                        taskArray = polishSolver.solve(taskArray);
                        System.out.println("Взял от собирателя и передаю решателю: " + taskArray);
                        stringRandom = cutTail(firstRandomDouble.toString()) + polishSolver.count(taskArray).toString() + cutTail(secondRandomDouble.toString());
                        task.setText(cutTail(firstRandomDouble.toString()) + " или " + polishSolver.count(taskArray).toString() + " или " + cutTail(secondRandomDouble.toString()));
                        break;
                    case  3:
                        System.out.println("Передаю собирателю: " + taskArray);
                        taskArray = polishSolver.solve(taskArray);
                        System.out.println("Взял от собирателя и передаю решателю: " + taskArray);
                        stringRandom = firstRandomDouble.toString() + secondRandomDouble.toString() + polishSolver.count(taskArray).toString();
                        task.setText(cutTail(firstRandomDouble.toString()) + " или " + cutTail(secondRandomDouble.toString()) + " или " + polishSolver.count(taskArray).toString());
                        break;
                }
                symbolUpdate(stringRandom);
                break;
            case 21:
                soulHolder.startWaitForReaction();
                startNewDialog();
                soulHolder.setTypeOfReaction(1);
                //numpadMain.setQuestionType();
                numpadMain.setQuestionType();
                randomDouble = randomer.getDouble();
                task.setText(cutTail(randomDouble.toString()));
                symbolUpdate(cutTail(randomDouble.toString()));
                break;
            case 22:
                soulHolder.startWaitForReaction();
                startNewDialog();
                soulHolder.setTypeOfReaction(1);
                //numpadMain.setQuestionType();
                numpadMain.setQuestionType();
                System.out.println("Передаю собирателю: " + taskArray);
                taskArray = polishSolver.solve(taskArray);
                System.out.println("Взял от собирателя и передаю решателю: " + taskArray);
                wrongDouble = 0 - polishSolver.count(taskArray);
                System.out.println("wrongDouble is:" + wrongDouble);
                if (canMoveToInteger(wrongDouble)){
                    symbolUpdate((double) (int) (double) wrongDouble);
                    task.setText(String.valueOf((int) (double) wrongDouble));
//                    task.setText(Integer.parseInt(wrongDouble.toString()) +"");
                    break;
                }
                else {
                    symbolUpdate(wrongDouble);
                    task.setText(wrongDouble +"");
                    break;
                }
            case 23:
                soulHolder.startWaitForReaction();
                startNewDialog();
                soulHolder.setTypeOfReaction(1);
                //numpadMain.setQuestionType();
                numpadMain.setQuestionType();
                System.out.println("Передаю собирателю: " + taskArray);
                taskArray = polishSolver.solve(taskArray);
                System.out.println("Взял от собирателя и передаю решателю: " + taskArray);
                positionType = randomer.choose(2);
                switch (positionType){
                    case 1:
                        wrongDouble = polishSolver.count(taskArray) + 1;
                        break;
                    case 2:
                        wrongDouble = polishSolver.count(taskArray) - 1;
                        break;
                }
                if (canMoveToInteger(wrongDouble)){
                    symbolUpdate((double) (int) (double) wrongDouble);
                    task.setText(String.valueOf((int) (double) wrongDouble));
                    break;
                }
                else {
                    symbolUpdate(wrongDouble);
                    task.setText(wrongDouble +"");
                    break;
                }

        }
    }

    public void specialUpdate(Integer typeOfAction){
        System.out.println("Now taskArray is: " + taskArray);
        addZeros();
        clearPoints();
        soulHolder.loadAll();
        if(soulHolder.checkWaiting()){
            switch (typeOfAction){
                case 1:
                    if(soulHolder.getTypeOfReaction()==1){
                        System.out.println("disrespect childishness");
                        dialog.setText(ReactionOperator.getRandomReaction());
                        soulHolder.lazinessFromChildishness(randomer.getRoughly(0.2f));
                    }
                    else if(soulHolder.getTypeOfReaction()==2){
                        System.out.println("disrespect laziness");
                        dialog.setText(ReactionOperator.getRandomReaction());
                        soulHolder.childishnessFromLaziness(randomer.getRoughly(0.2f));
                    }
                    else if(soulHolder.getTypeOfReaction()==0){
                        System.out.println("disrespect truth");
                        dialog.setText(ReactionOperator.getRandomReaction(false));
                        soulHolder.increase(randomer.getRoughly(0.15f));
                    }
                    break;
                case 2:
                    if(soulHolder.getTypeOfReaction()==2){
                        System.out.println("respect laziness");
                        dialog.setText(ReactionOperator.getRandomReaction());
                        soulHolder.lazinessFromChildishness(randomer.getRoughly(0.2f));
                    }
                    else if(soulHolder.getTypeOfReaction()==1){
                        System.out.println("respect childishness");
                        dialog.setText(ReactionOperator.getRandomReaction());
                        soulHolder.childishnessFromLaziness(randomer.getRoughly(0.2f));
                    }
                    else if(soulHolder.getTypeOfReaction()==0){
                        System.out.println("respect truth");
                        dialog.setText(ReactionOperator.getRandomReaction(true));
                        soulHolder.decrease(randomer.getRoughly(0.15f));
                    }
                    break;
            }
            //numpadMain.setQuestionType();
            numpadMain.setSimpleType();
            soulHolder.stopWaitForReaction();
            soulHolder.saveAll();
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
                                startNewDialog();
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
                        if (/*randomer.doOrNot(50, 1f)*/ randomer.doOrNot()) {
                            System.out.println("Do event");
//                            switch (randomer.childOrLazy(soulHolder.getChildishness(), soulHolder.getLaziness())) {
//                                case 1:
//                                    startEvent(11);
//                                    break;
//                                case 2:
//                                    if (randomer.doOrNot()) {
//                                        startEvent(21);
//                                    } else {
//                                        startEvent(0);
//                                    }
//                                    dialog.setText("Процент ошибки: 50%");
//                            }
                            switch (randomer.childOrLazy(soulHolder.getChildishness(), soulHolder.getLaziness())) {
                                case 1:
                                    switch (randomer.choose(3)){
                                        case 1:
                                            startEvent(11);
                                            break;
                                        case 2:
                                            startEvent(12);
                                            break;
                                        case 3:
                                            startEvent(13);
                                            break;
                                    }
                                    break;
                                case 2:
                                    dialog.setText("Процент ошибки: +- 50%");
                                    switch (randomer.choose(3)){
                                        case 1:
                                            startEvent(21);
                                            break;
                                        case 2:
                                            startEvent(22);
                                            break;
                                        case 3:
                                            startEvent(23);
                                            break;
                                    }
                                    break;
                            }
                        } else {
                            if(taskArray.size()>0){
                                System.out.println("Do Simple");
                                dialog.setText("Процент ошибки: 1%");
                                startEvent(0);
                            }
                            else symbolUpdate(0d);
                        }
                    }
            }
        }
        else {
            symbolUpdate(0d);
        }
    }
}
