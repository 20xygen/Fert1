package com.example.fert1;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TableLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class NumpadMain extends TableLayout {

    public ImageButton leftBracket, rightBracket, comma, power, num0, num1, num2, num3,
            num4, num5, num6, num7, num8, num9, divide, multiply, minus, plus, equally, back;
    public ArrayList<ImageButton> imageArray;
    private TableLayout tableLayout;
    NumpadTaskChanger numpadTaskChanger;

    public NumpadMain(Context context, @Nullable AttributeSet attrs) {

        super(context, attrs);
        inflateNumpad(context);
        numpadTaskChanger = new NumpadTaskChanger();


    }

    //public ImageButton returnNum17(){return num17;}
    //public ImageButton returnNum20(){return num20;}

    public ImageButton returnDisrespectButton(){return back;}
    public ImageButton returnRespectButton(){return equally;}

    public void setQuestionType(){
        back.setImageResource(R.drawable.disrespect);
        equally.setImageResource(R.drawable.respect);
    }

    public void setSimpleType(){
        back.setImageResource(R.drawable.delete);
        equally.setImageResource(R.drawable.equally);
    }

    private void inflateNumpad(Context context) {
        View view = inflate(context, R.layout.numpad_layout, this);
        initialiseWidgets(view);
        if(ValuesHolder.isUpdated){
            System.out.println("updated");
            setImageSize(ValuesHolder.getImageX(), ValuesHolder.getImageY(), context);
        }
    }

    public static int dpToPx(int dp, Context context) {
        float density = context.getResources().getDisplayMetrics().density;
        return Math.round((float) dp * density);
    }

    float convertPixelsToDp(Context context, Integer pixels) {
        return pixels * context.getResources().getDisplayMetrics().density;
    }

    private void setImageSize(Integer valueX, Integer valueY, Context context){

        valueX = (int) convertPixelsToDp(context, valueX);
        valueY = (int) convertPixelsToDp(context, valueY);
        /*LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(valueX, valueY);
        num1.setLayoutParams(layoutParams);
        num3.setLayoutParams(layoutParams);
        num4.setLayoutParams(layoutParams);
        num5.setLayoutParams(layoutParams);
        num6.setLayoutParams(layoutParams);
        num7.setLayoutParams(layoutParams);
        num8.setLayoutParams(layoutParams);
        num9.setLayoutParams(layoutParams);
        num10.setLayoutParams(layoutParams);
        num11.setLayoutParams(layoutParams);
        num12.setLayoutParams(layoutParams);
        num13.setLayoutParams(layoutParams);
        num14.setLayoutParams(layoutParams);
        num15.setLayoutParams(layoutParams);
        num16.setLayoutParams(layoutParams);
        num17.setLayoutParams(layoutParams);
        num18.setLayoutParams(layoutParams);
        num19.setLayoutParams(layoutParams);
        num20.setLayoutParams(layoutParams);*/
        //if(num9==null) System.out.println("null");
        /*num1.setAdjustViewBounds(true);
        num1.setMaxHeight(valueY);
        num1.setMaxWidth(valueX);*/
        System.out.println("Start to remake buttons. Set: " + valueX + " and " + valueY);
        for (int i = 0; i < imageArray.size(); i++) {
            if(imageArray.get(i)!=null){
                /*imageArray.get(i).setAdjustViewBounds(true);
                System.out.println("It is " + imageArray.get(i));
                System.out.println("Before:");
                System.out.println(imageArray.get(i).getWidth());
                System.out.println(imageArray.get(i).getHeight());
                imageArray.get(i).setMaxHeight(valueY);
                imageArray.get(i).setMaxWidth(valueX);
                imageArray.get(i).setMinimumHeight(valueY);
                imageArray.get(i).setMaxWidth(valueX);
                System.out.println("After:");
                System.out.println(imageArray.get(i).getWidth());
                System.out.println(imageArray.get(i).getHeight());
                imageArray.get(i).invalidate();
                imageArray.get(i).postInvalidate();*/
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(valueX, valueY);
                imageArray.get(i).setLayoutParams(layoutParams);
                imageArray.get(i).invalidate();
            }
            else {
                System.out.println("button [" + i + "] is null. Look: " + imageArray.get(i));
            }

        }

        //LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(valueX, valueY);
        //num1.setLayoutParams(layoutParams);
        //layoutParams = new LinearLayout.LayoutParams(valueX, valueY);
        //num2.setLayoutParams(layoutParams);
    }



    private void initialiseWidgets(View view) {
        //Numpad widgets
        leftBracket = view.findViewById(R.id.imageButton1);
        rightBracket = view.findViewById(R.id.imageButton2);
        comma = view.findViewById(R.id.imageButton3);
        power = view.findViewById(R.id.imageButton4);
        num1 = view.findViewById(R.id.imageButton5);
        num2 = view.findViewById(R.id.imageButton6);
        num3 = view.findViewById(R.id.imageButton7);
        divide = view.findViewById(R.id.imageButton8);
        num4 = view.findViewById(R.id.imageButton9);
        num5 = view.findViewById(R.id.imageButton10);
        num6 = view.findViewById(R.id.imageButton11);
        multiply = view.findViewById(R.id.imageButton12);
        num7 = view.findViewById(R.id.imageButton13);
        num8 = view.findViewById(R.id.imageButton14);
        num9 = view.findViewById(R.id.imageButton15);
        minus = view.findViewById(R.id.imageButton16);
        back = view.findViewById(R.id.imageButton17);
        num0 = view.findViewById(R.id.imageButton18);
        equally = view.findViewById(R.id.imageButton19);
        plus = view.findViewById(R.id.imageButton20);
        tableLayout = view.findViewById(R.id.numpad_container);


        imageArray = new ArrayList<>();
        imageArray.add(num1);
        imageArray.add(num2);
        imageArray.add(num3);
        imageArray.add(num4);
        imageArray.add(num5);
        imageArray.add(num6);
        imageArray.add(num7);
        imageArray.add(num8);
        imageArray.add(num9);
        imageArray.add(num0);
        imageArray.add(leftBracket);
        imageArray.add(rightBracket);
        imageArray.add(comma);
        imageArray.add(power);
        imageArray.add(divide);
        imageArray.add(multiply);
        imageArray.add(minus);
        imageArray.add(plus);
        imageArray.add(equally);
        imageArray.add(back);

        /*
        num1 = view.findViewById(R.id.imageButton1);
        num2 = view.findViewById(R.id.imageButton2);
        num3 = view.findViewById(R.id.imageButton3);
        num4 = view.findViewById(R.id.imageButton4);
        num5 = view.findViewById(R.id.imageButton5);
        num6 = view.findViewById(R.id.imageButton6);
        num7 = view.findViewById(R.id.imageButton7);
        num8 = view.findViewById(R.id.imageButton8);
        num9 = view.findViewById(R.id.imageButton9);
        tableLayout = view.findViewById(R.id.numpad_container);

         */

    }

    /*public void tappedLeftBracketButton(View view) {
        numpadTaskChanger.update("(");
    }
    public void clickedRightBracketButton(View view) {
        numpadTaskChanger.update(")");
    }
    public void clickedCommaButton(View view) {
        numpadTaskChanger.update(".");
    }
    public void clickedPowerButton(View view) {
        numpadTaskChanger.update("^");
    }

    public void clickedOneButton(View view) {
        numpadTaskChanger.update("1");
    }
    public void clickedTwoButton(View view) {
        numpadTaskChanger.update("2");
    }
    public void clickedThreeButton(View view) {
        numpadTaskChanger.update("3");
    }
    public void clickedDivideButton(View view) {
        numpadTaskChanger.update("/");
    }

    public void clickedFourButton(View view) {
        numpadTaskChanger.update("4");
    }
    public void clickedFiveBracketButton(View view) {
        numpadTaskChanger.update("5");
    }
    public void clickedSixButton(View view) {
        numpadTaskChanger.update("6");
    }
    public void clickedMultiplyButton(View view) {
        numpadTaskChanger.update("*");
    }

    public void clickedSevenButton(View view) {
        numpadTaskChanger.update("7");
    }
    public void clickedEightBracketButton(View view) {
        numpadTaskChanger.update("8");
    }
    public void clickedNineButton(View view) {
        numpadTaskChanger.update("9");
    }
    public void clickedMinusButton(View view) {
        numpadTaskChanger.update("-");
    }

    public void clickedDeleteButton(View view) {
        numpadTaskChanger.update(1);
    }
    public void clickedZeroButton(View view) {
        numpadTaskChanger.update("0");
    }
    public void clickedEquallyButton(View view) {
        numpadTaskChanger.update(2);
    }
    public void clickedPlusButton(View view) {
        numpadTaskChanger.update("+");
    }

     */
}
