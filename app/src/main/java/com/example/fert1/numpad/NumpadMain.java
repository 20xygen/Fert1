package com.example.fert1.numpad;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TableLayout;

import androidx.annotation.Nullable;

import com.example.fert1.R;
import com.example.fert1.keeping.ValuesHolder;

import java.util.ArrayList;

public class NumpadMain extends TableLayout {

    protected ImageButton leftBracket, rightBracket, comma, power, num0, num1, num2, num3,
            num4, num5, num6, num7, num8, num9, divide, multiply, minus, plus, equally, back;
    protected ArrayList<ImageButton> imageArray;
    protected TableLayout tableLayout;
    protected NumpadTaskChanger numpadTaskChanger;

    public NumpadMain(Context context, @Nullable AttributeSet attrs) {

        super(context, attrs);
        inflateNumpad(context);
        numpadTaskChanger = new NumpadTaskChanger();


    }

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
        if(ValuesHolder.getUpdateStatus()){
            System.out.println("updated");
            ValuesHolder valuesHolder = new ValuesHolder();
            valuesHolder.setContext(context);
            valuesHolder.createValuesSaver();
            valuesHolder.loadAll();
            System.out.println("-------");
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
        System.out.println("Start to remake buttons. Set: " + valueX + " and " + valueY);
        for (int i = 0; i < imageArray.size(); i++) {
            if(imageArray.get(i)!=null){
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(valueX, valueY);
                imageArray.get(i).setLayoutParams(layoutParams);
                imageArray.get(i).invalidate();
            }
            else {
                System.out.println("button [" + i + "] is null. Look: " + imageArray.get(i));
            }

        }
    }



    private void initialiseWidgets(View view) {
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

    }
}
