package com.example.fert1;

import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class Counter {
    String entry;
    TextView task;
    ArrayList<String> question = new ArrayList<>();
    ArrayList<String> solveArray = new ArrayList<>();
    NumberChanger numberChanger = new NumberChanger();
    String output = "=";
    private static final String TAG = "Counter";
    boolean flag = false;
    boolean doubleFlag = false;
    String string;

    int firstNumber;
    int secondNumber;
    Integer exitNumber;

    public  Counter(TextView task) {
        this.task = task;
    }

    public void answer(String entryText){
        Log.w(TAG, "Активирован метод answer класса Counter");
        entry = entryText;
        for (int i = 0; i < entry.length(); i++) {
            question.add(entry.substring(i, i+1));
        }
        question = numberChanger.changeArrayToArray(question);
        //for (int i = 0; i < question.size(); i++) {
        //    output = output.concat(question.get(i)/*  + " " */);
        //}
        //task.setText(output);
        task.setText(solve(question));
        output = "=";
        question.clear();
    }

    Integer solveArraySize;
    public String solve(ArrayList<String> inputSolveArray){
        solveArray.clear();
        solveArray = inputSolveArray;
        System.out.println("Получил массив " + solveArray);

        /*
        solveArraySize=-1;
        while (solveArraySize!=solveArray.size()){
            if(hasElement(solveArray, "(") || hasElement(solveArray, ")")){
                System.out.println("Есть скобка");
                solveArraySize=solveArray.size();
                solveArray=doBrackets(solveArray);
            }
            else break;
        }

         */
        solveArraySize=-1;
        while (solveArraySize!=solveArray.size()){
            solveArraySize=solveArray.size();
            solveArray=reduce(solveArray,1);
        }
        //System.out.println("После проверки массива на наличие степеней, размер стал равен " + solveArray.size());
        solveArraySize=-1;
        while (solveArraySize!=solveArray.size()){
            solveArraySize=solveArray.size();
            solveArray=reduce(solveArray,2);
        }
        //System.out.println("После проверки массива на наличие умножений, размер стал равен " + solveArray.size());
        solveArraySize=-1;
        while (solveArraySize!=solveArray.size()){
            solveArraySize=solveArray.size();
            solveArray=reduce(solveArray,3);
        }
        //System.out.println("После проверки массива на наличие делений, размер стал равен " + solveArray.size());
        solveArraySize=-1;
        while (solveArraySize!=solveArray.size()){
            solveArraySize=solveArray.size();
            solveArray=reduce(solveArray,4);
        }
        //System.out.println("После проверки массива на наличие сложений, размер стал равен " + solveArray.size());
        solveArraySize=-1;
        while (solveArraySize!=solveArray.size()){
            solveArraySize=solveArray.size();
            solveArray=reduce(solveArray,5);
        }
        //System.out.println("После проверки массива на наличие вычитаний, размер стал равен " + solveArray.size());
        if (solveArray.size()==1){
            return  solveArray.get(0);
        }
        else return "размер массива " + solveArray.size();
    }

    public Integer findAction(String string){
        if (string.equals("^")){
            return 1;
        }
        else if (string.equals("*")){
            return 2;
        }
        else if (string.equals("/")){
            return 3;
        }
        else if (string.equals("+")){
            return 4;
        }
        else if (string.equals("-")){
            return 5;
        }
        else return 0;
    }

    ArrayList<String> isNumArray = new ArrayList<>();

    public boolean isNumber (String input){
        /*
        Log.w(TAG, "Активирован метод isNumber класса Counter");
        string = input;
        if(string.equals("0") || string.equals("1") || string.equals("2") || string.equals("3")
                || string.equals("4") || string.equals("5") || string.equals("6")
                || string.equals("7")  || string.equals("8")  || string.equals("9")){
            return true;
        }*/
        //isNumArray.clear();
        string = input;
        for (int i = 0; i < input.length(); i++) {
            //isNumArray.add(input.substring(i, i+1));
            if(!(string.substring(i,i+1).equals("0") || string.substring(i,i+1).equals("1") || string.substring(i,i+1).equals("2") || string.substring(i,i+1).equals("3")
                    || string.substring(i,i+1).equals("4") || string.substring(i,i+1).equals("5") || string.substring(i,i+1).equals("6")
                    || string.substring(i,i+1).equals("7")  || string.substring(i,i+1).equals("8")  || string.substring(i,i+1).equals("9"))){
                System.out.println(string + "is not a number");
                return false;
            }
        }
        System.out.println(string + "is a number");
        return true;
    }

    ArrayList<String> reduceArray = new ArrayList<>();
    Integer reduceNumber;
    Integer reducePrevious;
    Integer reduceNext;

    public ArrayList<String> reduce (ArrayList<String> inputConnectArray, Integer type){
        System.out.println(inputConnectArray);
        reduceArray = inputConnectArray;
        System.out.println("reduce начат " + type);
        switch (type){
            case 1:
                reduceNumber=1;
                for (int i = 1; i < reduceArray.size()-1; i++) {
                    if(findAction(reduceArray.get(i))==1){
                        System.out.println("найден повер");
                        if (isNumber(reduceArray.get(i-1))) reducePrevious = Integer.parseInt(reduceArray.get(i - 1));
                        else reducePrevious = 1;
                        if (isNumber(reduceArray.get(i+1))) reduceNext = Integer.parseInt(reduceArray.get(i + 1));
                        else reduceNext = 1;
                        for (int j = 0; j < 3; j++) reduceArray.remove(i-1);
                        for (int j = 0; j < reduceNext; j++) reduceNumber*=reducePrevious;
                        reduceArray.add(i-1,reduceNumber.toString());
                        break;
                    }
                }
                break;
            case 2:
                System.out.println("reduce начал искать знак, размер массива " + reduceArray.size());
                for (int i = 1; i < reduceArray.size()-1; i++) {
                    if(findAction(reduceArray.get(i))==2){
                        System.out.println("найден множик");
                        System.out.println("нашёл умножение");
                        if (isNumber(reduceArray.get(i-1))) reducePrevious = Integer.parseInt(reduceArray.get(i - 1));
                        else reducePrevious = 1;
                        System.out.println("reducePrevious " + reducePrevious);
                        if (isNumber(reduceArray.get(i+1))) reduceNext = Integer.parseInt(reduceArray.get(i + 1));
                        else reduceNext = 1;
                        System.out.println("reduceNext " + reducePrevious);
                        System.out.println("массив до  " + reduceArray);
                        for (int j = 0; j < 3; j++) reduceArray.remove(i-1);
                        System.out.println("массив в процессе " + reduceArray);
                        reduceNumber = reducePrevious*reduceNext;
                        reduceArray.add(i-1,reduceNumber.toString());
                        System.out.println("массив после  " + reduceArray);
                        break;
                    }
                }
                break;
            case 3:
                for (int i = 1; i < reduceArray.size()-1; i++) {
                    if(findAction(reduceArray.get(i))==3){
                        System.out.println("найдена делитка");
                        if (isNumber(reduceArray.get(i-1))) reducePrevious = Integer.parseInt(reduceArray.get(i - 1));
                        else reducePrevious = 1;
                        if (isNumber(reduceArray.get(i+1))) reduceNext = Integer.parseInt(reduceArray.get(i + 1));
                        else reduceNext = 1;
                        for (int j = 0; j < 3; j++) reduceArray.remove(i-1);
                        reduceNumber = reducePrevious/reduceNext;
                        reduceArray.add(i-1,reduceNumber.toString());
                        break;
                    }
                }
                break;
            case 4:
                for (int i = 1; i < reduceArray.size()-1; i++) {
                    if(findAction(reduceArray.get(i))==4){
                        System.out.println("найден плюсик");
                        System.out.println("предыдущий " + reduceArray.get(i-1));
                        System.out.println("следующий  " + reduceArray.get(i+1));
                        if (isNumber(reduceArray.get(i-1))) reducePrevious = Integer.parseInt(reduceArray.get(i - 1));
                        else reducePrevious = 1;
                        System.out.println(Integer.parseInt(reduceArray.get(i + 1)));
                        //reduceNext = Integer.parseInt(reduceArray.get(i + 1));
                        if (isNumber(reduceArray.get(i+1))) reduceNext = Integer.parseInt(reduceArray.get(i + 1));
                        else reduceNext = 1;
                        System.out.println("предыдущий " + reducePrevious);
                        System.out.println("следующий  " + reduceNext);
                        for (int j = 0; j < 3; j++) reduceArray.remove(i-1);
                        reduceNumber = reducePrevious+reduceNext;
                        reduceArray.add(i-1,reduceNumber.toString());
                        break;
                    }
                }
                break;
            case 5:
                for (int i = 1; i < reduceArray.size()-1; i++) {
                    if(findAction(reduceArray.get(i))==5){
                        System.out.println("найден минусик");
                        if (isNumber(reduceArray.get(i-1))) reducePrevious = Integer.parseInt(reduceArray.get(i - 1));
                        else reducePrevious = 1;
                        if (isNumber(reduceArray.get(i+1))) reduceNext = Integer.parseInt(reduceArray.get(i + 1));
                        else reduceNext = 1;
                        for (int j = 0; j < 3; j++) reduceArray.remove(i-1);
                        reduceNumber = reducePrevious-reduceNext;
                        reduceArray.add(i-1,reduceNumber.toString());
                        break;
                    }
                }
                break;
        }
        return reduceArray;
    }

    ArrayList<String> doBracketsArray = new ArrayList<>();
    ArrayList<String> doBracketsSmallArray = new ArrayList<>();
    ArrayList<String> doBracketsExitArray = new ArrayList<>();
    boolean hasLeftBracket;
    boolean hasRightBracket;
    int leftBracket;
    int rightBracket;
    String currentAnswer;

    public ArrayList<String> doBrackets (ArrayList<String> inputDoBracketsArray){
        doBracketsArray = inputDoBracketsArray;
        doBracketsSmallArray.clear();
        doBracketsExitArray.clear();
        hasLeftBracket = hasElement(doBracketsArray, "(");
        hasRightBracket = hasElement(doBracketsArray, ")");
        if(hasLeftBracket && hasRightBracket){
            System.out.println("Есть обе скобки");
            for (int i = 0; i < doBracketsArray.size(); i++) {
                if(doBracketsArray.get(i).equals("(")){
                    leftBracket = i;
                    break;
                }
                //else leftBracket = 0;
            }
            System.out.println("Индекси левой " + leftBracket);
            for (int i = doBracketsArray.size()-1; i > -1; i--) {
                if(doBracketsArray.get(i).equals(")")){
                    rightBracket = i;
                    break;
                }
                //else rightBracket = doBracketsArray.size()-1;
            }
            System.out.println("Индекси правой " + rightBracket);
            for (int i = leftBracket+1; i < rightBracket; i++) {
                doBracketsSmallArray.add(doBracketsArray.get(i));
            }
            System.out.println("Меньший массив " + doBracketsSmallArray);
            System.out.println("Больший массив до " + doBracketsArray);
            for (int i = leftBracket; i < rightBracket+1; i++) {
                doBracketsArray.remove(leftBracket);
            }
            System.out.println("Больший массив во время " + doBracketsArray);
            //System.out.println("Ответ на вопрос без скобок " + solve(doBracketsSmallArray));
            currentAnswer = solve(doBracketsSmallArray);
            doBracketsArray.add(leftBracket, solve(doBracketsSmallArray));
            System.out.println("Больший массив после " + doBracketsArray);
        }
        else if (hasLeftBracket){
            for (int i = 0; i < doBracketsArray.size(); i++) {
                if(doBracketsArray.get(i).equals("(")){
                    leftBracket = i;
                    break;
                }
                //else leftBracket = 0;
            }
            doBracketsArray.remove(leftBracket);
        }
        else if (hasRightBracket){
            for (int i = doBracketsArray.size()-1; i > -1; i--) {
                if(doBracketsArray.get(i).equals(")")){
                    rightBracket = i;
                    break;
                }
                //else rightBracket = doBracketsArray.size()-1;
            }
            doBracketsArray.remove(rightBracket);
        }
        System.out.println("Скобки не найдены в " + doBracketsArray);
        return doBracketsArray;
    }

    //ArrayList<String> hasElementArray = new ArrayList<>();

    public boolean hasElement (ArrayList<String> inputHasElementArray, String element){
        for (int i = 0; i < inputHasElementArray.size(); i++) {
            if(inputHasElementArray.get(i).equals(element)){
                return true;
            }
        }
        return false;
    }
}

/*

        while (solveArray.size()>1){
            flag = false;
            for (int i = 1; i < solveArray.size(); i++) {
                if(i < solveArray.size()-1 && isNumber(solveArray.get(i-1)) && isNumber(solveArray.get(i+1))){
                    firstNumber = Integer.parseInt(solveArray.get(i-1));
                    secondNumber = Integer.parseInt(solveArray.get(i+1));
                    if (findAction(solveArray.get(i))==1){
                        exitNumber = 1;
                        for (int j = 0; j < secondNumber; j++) {
                            exitNumber*=firstNumber;
                        }
                        flag = true;
                    }
                }
                if(flag){
                    solveArray.remove(i-1);
                    solveArray.remove(i-1);
                    solveArray.remove(i-1);
                    solveArray.add(i-1, exitNumber.toString());
                    break;
                }
            }
            if(!flag){
                break;
            }
        }
        while (solveArray.size()>1){
            flag = false;
            for (int i = 1; i < solveArray.size(); i++) {
                if(i < solveArray.size()-1 && isNumber(solveArray.get(i-1)) && isNumber(solveArray.get(i+1))){
                    firstNumber = Integer.parseInt(solveArray.get(i-1));
                    secondNumber = Integer.parseInt(solveArray.get(i+1));
                    if (findAction(solveArray.get(i))==2){
                        exitNumber = firstNumber * secondNumber;
                        flag = true;
                    }
                }
                if(flag){
                    solveArray.remove(i-1);
                    solveArray.remove(i-1);
                    solveArray.remove(i-1);
                    solveArray.add(i-1, exitNumber.toString());
                    break;
                }
            }
            if(!flag){
                break;
            }
        }
        while (solveArray.size()>1){
            flag = false;
            for (int i = 1; i < solveArray.size(); i++) {
                if(i < solveArray.size()-1 && isNumber(solveArray.get(i-1)) && isNumber(solveArray.get(i+1))){
                    firstNumber = Integer.parseInt(solveArray.get(i-1));
                    secondNumber = Integer.parseInt(solveArray.get(i+1));
                    if (findAction(solveArray.get(i))==3){
                        exitNumber = firstNumber / secondNumber;
                        flag = true;
                    }
                }
                if(flag){
                    solveArray.remove(i-1);
                    solveArray.remove(i-1);
                    solveArray.remove(i-1);
                    solveArray.add(i-1, exitNumber.toString());
                    break;
                }
            }
            if(!flag){
                break;
            }
        }
        while (solveArray.size()>1){
            flag = false;
            for (int i = 1; i < solveArray.size(); i++) {
                if(i < solveArray.size()-1 && isNumber(solveArray.get(i-1)) && isNumber(solveArray.get(i+1))){
                    firstNumber = Integer.parseInt(solveArray.get(i-1));
                    secondNumber = Integer.parseInt(solveArray.get(i+1));
                    if (findAction(solveArray.get(i))==4){
                        exitNumber = firstNumber + secondNumber;
                        flag = true;
                    }
                }
                if(flag){
                    solveArray.remove(i-1);
                    solveArray.remove(i-1);
                    solveArray.remove(i-1);
                    solveArray.add(i-1, exitNumber.toString());
                    break;
                }
            }
            if(!flag){
                break;
            }
        }
        while (solveArray.size()>1){
            flag = false;
            for (int i = 1; i < solveArray.size(); i++) {
                if(i < solveArray.size()-1 && isNumber(solveArray.get(i-1)) && isNumber(solveArray.get(i+1))){
                    firstNumber = Integer.parseInt(solveArray.get(i-1));
                    secondNumber = Integer.parseInt(solveArray.get(i+1));
                    if (findAction(solveArray.get(i))==5){
                        exitNumber = firstNumber - secondNumber;
                        flag = true;
                    }
                }
                if(flag){
                    solveArray.remove(i-1);
                    solveArray.remove(i-1);
                    solveArray.remove(i-1);
                    solveArray.add(i-1, exitNumber.toString());
                    break;
                }
            }
            if(!flag){
                break;
            }
        }
        return solveArray.get(0);
 */