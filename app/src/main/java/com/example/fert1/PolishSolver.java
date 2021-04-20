package com.example.fert1;

import java.util.ArrayList;

public class PolishSolver {
    ArrayList<String> polishEntryArray = new ArrayList<>();
    ArrayList<String> polishFirstArray = new ArrayList<>();
    ArrayList<String> polishSecondArray = new ArrayList<>();
    String currentPolishElement;

    public ArrayList<String> solve (ArrayList<String> inputPolishEntryArray){
        //clearAll();
        polishEntryArray = inputPolishEntryArray;
        System.out.println("Принял от главного: " + polishEntryArray);
        //polishFirstArray.clear();
        System.out.println("0: polishEntryArray " + polishEntryArray);
        polishFirstArray= new ArrayList<>();
        //polishFirstArray.clear();
        System.out.println("1: polishEntryArray " + polishEntryArray);
        //polishSecondArray.clear();
        polishSecondArray = new ArrayList<>();
        System.out.println("2: polishEntryArray " + polishEntryArray);

        polishEntryArray = concatNumbers(polishEntryArray);

        for (int i = 0; i < polishEntryArray.size(); i++) {
            System.out.println("3*: polishEntryArray " + polishEntryArray);
            currentPolishElement=polishEntryArray.get(i);
            System.out.println("4*: polishEntryArray " + polishEntryArray);
            System.out.println("Before operations:");
            System.out.println("5*: polishEntryArray " + polishEntryArray);
            printInfo();
            System.out.println("6*: polishEntryArray " + polishEntryArray);
            if(isNumber(currentPolishElement)){
                System.out.println("[" + currentPolishElement + "] это число, значит добавляем в первый массив");
                System.out.println();
                polishFirstArray.add(currentPolishElement);
            }
            else if(getSymbol(currentPolishElement) >=3 && getSymbol(currentPolishElement) <=7){
                if(polishSecondArray.isEmpty()){
                    System.out.println("[" + currentPolishElement + "] это знак и второй массив пустой, значит добавляем" +
                            " во второй массив");
                    polishSecondArray.add(currentPolishElement);
                }
                else if(getPriority(polishSecondArray.get(polishSecondArray.size()-1))>=getPriority(currentPolishElement)){
                    System.out.println("[" + currentPolishElement + "] это знак и последний знак (элемент) во втором массиве" +
                            " [" + polishSecondArray.get(polishSecondArray.size()-1) + "] имеет больший приоритет чем текущий," +
                            " значит выталкиваем элемент второго массива");
                    polishFirstArray.add(polishSecondArray.get(polishSecondArray.size()-1));
                    polishSecondArray.remove(polishSecondArray.size()-1);
                    polishSecondArray.add(currentPolishElement);
                }
                else {
                    System.out.println("[" + currentPolishElement + "] это знак и последний знак (элемент) во втором массиве" +
                            " [" + polishSecondArray.get(polishSecondArray.size()-1) + "] имеет меньший приоритет чем текущий," +
                            " значит добавляем во второй массив");
                    polishSecondArray.add(currentPolishElement);
                }
            }
            else if(getSymbol(currentPolishElement)==1){
                System.out.println("[" + currentPolishElement + "] это левая скобка, добавляем во второй массив");
                polishSecondArray.add(currentPolishElement);
            }
            else if(getSymbol(currentPolishElement)==2){
                System.out.println("[" + currentPolishElement + "] это правая скобка, выталкиваем второй массив до левой скобки");
                for (int j = polishSecondArray.size()-1; j > -1 ; j--) {
                    if (getSymbol(polishSecondArray.get(j))==1){
                        polishSecondArray.remove(j);
                        break;
                    }
                    else {
                        polishFirstArray.add(polishSecondArray.get(j));
                        polishSecondArray.remove(j);
                    }
                }
            }
            System.out.println("After operations:");
            printInfo();
            System.out.println("-------------------------------------------");
            System.out.println("");
        }
        System.out.println("Before operations:");
        printInfo();
        if(!(polishSecondArray.isEmpty())){
            for (int j = polishSecondArray.size()-1; j > -1 ; j--) {
                polishFirstArray.add(polishSecondArray.get(j));
                polishSecondArray.remove(j);
            }
        }
        System.out.println("After operations:");
        printInfo();
        System.out.println("-------------------------------------------");
        System.out.println();
        return polishFirstArray;
    }

    ArrayList<String> countEntryArray = new ArrayList<>();
    ArrayList<Double> countExitArray = new ArrayList<>();
    Double currentCountElement;
    public Double count (ArrayList<String> inputCountArray){
        countEntryArray=inputCountArray;
        //countEntryArray=solve(inputCountArray);
        countExitArray.clear();
        for (int i = 0; i < countEntryArray.size(); i++) {
            if (getSymbol(countEntryArray.get(i))==9){
                countExitArray.add(Double.parseDouble(countEntryArray.get(i)));
            }
            else/* if(getSymbol(countEntryArray.get(i))>=3 && getSymbol(countEntryArray.get(i))<=7)*/{
                if(countExitArray.size()>=2){
                    switch (getSymbol(countEntryArray.get(i))){
                        case 3:
                            currentCountElement = 1.0;
                            for (int j = 0; j < countExitArray.get(countExitArray.size()-1); j++) {
                                currentCountElement*=countExitArray.get(countExitArray.size()-2);
                            }
                            countExitArray.remove(countExitArray.size()-1);
                            countExitArray.remove(countExitArray.size()-1);
                            countExitArray.add(currentCountElement);
                            break;
                        case  4:
                            currentCountElement=countExitArray.get(countExitArray.size()-2)*countExitArray.get(countExitArray.size()-1);
                            countExitArray.remove(countExitArray.size()-1);
                            countExitArray.remove(countExitArray.size()-1);
                            countExitArray.add(currentCountElement);
                            break;
                        case  5:
                            currentCountElement=countExitArray.get(countExitArray.size()-2)/countExitArray.get(countExitArray.size()-1);
                            countExitArray.remove(countExitArray.size()-1);
                            countExitArray.remove(countExitArray.size()-1);
                            countExitArray.add(currentCountElement);
                            break;
                        case  6:
                            currentCountElement=countExitArray.get(countExitArray.size()-2)+countExitArray.get(countExitArray.size()-1);
                            countExitArray.remove(countExitArray.size()-1);
                            countExitArray.remove(countExitArray.size()-1);
                            countExitArray.add(currentCountElement);
                            break;
                        case  7:
                            currentCountElement=countExitArray.get(countExitArray.size()-2)-countExitArray.get(countExitArray.size()-1);
                            countExitArray.remove(countExitArray.size()-1);
                            countExitArray.remove(countExitArray.size()-1);
                            countExitArray.add(currentCountElement);
                            break;
                    }
                }

            }
            System.out.println(countEntryArray + " " + countExitArray);
        }
        return countExitArray.get(0);
    }

    ArrayList<String> concatNumbersArray;
    //ArrayList<String> concatNumbersExitArray;
    Integer lastSize;

    public ArrayList<String> concatNumbers(ArrayList<String> inputConcatNumbers){
        concatNumbersArray = inputConcatNumbers;
        //concatNumbersExitArray = new ArrayList<>();
        lastSize = -1;
        while (lastSize!=concatNumbersArray.size()){
            lastSize=concatNumbersArray.size();
            for (int i = 0; i < concatNumbersArray.size(); i++) {
                if(i<concatNumbersArray.size()-1){
                    if(isNumber(concatNumbersArray.get(i)) && isNumber(concatNumbersArray.get(i+1))){
                        concatNumbersArray.add(i, concatNumbersArray.get(i).concat(concatNumbersArray.get(i+1)));
                        concatNumbersArray.remove(i+1);
                        concatNumbersArray.remove(i+1);
                        break;
                    }
                }
            }
        }
        return concatNumbersArray;
    }

    public boolean hasElement (ArrayList<String> inputHasElementArray, String element) {
        for (int i = 0; i < inputHasElementArray.size(); i++) {
            if (inputHasElementArray.get(i).equals(element)) {
                return true;
            }
        }
        return false;
    }

    String isNumberString;

    public boolean isNumber (String input){
        isNumberString = input;
        //добавсь сюда запятую
        for (int i = 0; i < input.length(); i++) {
            //isNumArray.add(input.substring(i, i+1));
            if(!(isNumberString.substring(i,i+1).equals("0") || isNumberString.substring(i,i+1).equals("1")
                    || isNumberString.substring(i,i+1).equals("2") || isNumberString.substring(i,i+1).equals("3")
                    || isNumberString.substring(i,i+1).equals("4") || isNumberString.substring(i,i+1).equals("5")
                    || isNumberString.substring(i,i+1).equals("6") || isNumberString.substring(i,i+1).equals("7")
                    || isNumberString.substring(i,i+1).equals("8") || isNumberString.substring(i,i+1).equals("9")
                    || isNumberString.substring(i,i+1).equals(",") || isNumberString.substring(i,i+1).equals("."))){
                System.out.println(isNumberString + " is not a number");
                return false;
            }
        }
        System.out.println(isNumberString + " is a number");
        return true;
    }

    Integer getPriorityNumber;

    public Integer getPriority(String string){
        getPriorityNumber=getSymbol(string);
        switch (getPriorityNumber){
            case 3:
                return 3;
            case 4:
                return 2;
            case 5:
                return 2;
            case 6:
                return 1;
            case 7:
                return 1;
        }
        return 0;
    }

    public Integer getSymbol(String string){
        if (string.equals("(")){
            return 1;
        }
        else if (string.equals(")")){
            return 2;
        }
        else if (string.equals("^")){
            return 3;
        }
        else if (string.equals("*")){
            return 4;
        }
        else if (string.equals("/")){
            return 5;
        }
        else if (string.equals("+")){
            return 6;
        }
        else if (string.equals("-")){
            return 7;
        }
        else if (string.equals(".")){
            return 8;
        }
        else if (isNumber(string)){
            return 9;
        }
        else return 0;
    }

    public void printInfo(){
        System.out.println("polishEntryArray " + polishEntryArray);
        System.out.println("polishFirstArray " + polishFirstArray);
        System.out.println("polishSecondArray " + polishSecondArray);
        System.out.println("currentPolishElement " + currentPolishElement);
    }

    public void clearAll(){
        getPriorityNumber = 0;
        isNumberString = "";
        countEntryArray.clear();
        countExitArray.clear();
        currentCountElement = 0.0;
        polishEntryArray.clear();
        polishFirstArray.clear();
        polishSecondArray.clear();
        currentPolishElement = "";
    }
}
