package com.example.fert1;

import java.awt.font.NumericShaper;

public class ReactionOperator {
    public static String getRandomReaction(Boolean isGood){
        if(isGood){
            switch (new Randomer().choose(7)){
                case 1:
                    return "Эх... Не удалось...";
                case 2:
                    return "Почти получилось...";
                case 3:
                    return "Увы, не вышлло(";
                case 4:
                    return "Попытка - не пытка";
                case 5:
                    return "А ты хорош)";
                case 6:
                    return "Я хотя-бы попытался...";
                case 7:
                    return "В следующий раз повезёт";
            }
        }
        else {
            switch (new Randomer().choose(7)){
                case 1:
                    return "Шалость удалась)";
                case 2:
                    return "Я знал, что получится";
                case 3:
                    return "Хихи...";
                case 4:
                    return "Ура, успех!";
                case 5:
                    return "Тебе просто не повезло";
                case 6:
                    return "Будь внимательнее";
                case 7:
                    return "Оо, повезло, повезло!";
            }
        }
        return null;
    }

    public static String getRandomReaction(){
        switch (new Randomer().choose(7)){
            case 1:
                return "Хмм...";
            case 2:
                return "Интересно";
            case 3:
                return "Странно, но ладно";
            case 4:
                return "Надо мне всё обдумать...";
            case 5:
                return "Ага, занятно";
            case 6:
                return "Угу, понял";
            case 7:
                return "О, буду иметь ввиду...";
        }
        return null;
    }
}
