package com.example.fert1;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Parameter extends LinearLayout {

    EditText editText;
    TextView textView;
    public Parameter(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        inflateParameter(context);
    }

    public void inflateParameter(Context context) {
        View view = inflate(context, R.layout.edit_text_settings, this);
        editText = view.findViewById(R.id.editTextParameter);
        textView = view.findViewById(R.id.textViewParameter);
    }

    public void setBroken(){
        textView.setTextColor(Color.parseColor("#919191"));
        editText.setTextColor(Color.parseColor("#919191"));
    }

    public void setTextSize(Integer integer){
        switch (integer){
            case 1:
                textView.setTextSize(R.dimen.text_size_small);
                editText.setTextSize(R.dimen.text_size_small);
                break;
            case 2:
                textView.setTextSize(R.dimen.text_size_medium);
                editText.setTextSize(R.dimen.text_size_medium);
                break;
            case 3:
                textView.setTextSize(R.dimen.text_size_large);
                editText.setTextSize(R.dimen.text_size_large);
                break;
        }
    }

    public Integer minValue, maxValue;

    public void setMin(Integer integer){minValue = integer;}

    public void setMax(Integer integer){maxValue = integer;}

    public Integer getFramed(){
        if (isInFrame()) return Integer.parseInt(editText.getText().toString());
        else if (minValue!=null){
            if(Integer.parseInt(editText.getText().toString())<minValue) return minValue;
        }
        else if (maxValue!=null){
            if(Integer.parseInt(editText.getText().toString())>maxValue) return maxValue;
        }
        return Integer.parseInt(editText.getText().toString());
    }

    public Boolean isInFrame(){

        Integer intValue = Integer.parseInt(editText.getText().toString());

        if(minValue!=null && maxValue!=null){
            return (intValue>=minValue && intValue<=maxValue);
        }
        else if(minValue!=null){
            return intValue>minValue;
        }
        else if(maxValue!=null){
            return intValue<maxValue;
        }
        else{
            return true;
        }
    }

    public void setParameterName(String string){
        textView.setText(string);
    }

    public void setParameterValue(String value){
        editText.setText(value);
    }

    public void setParameterValue(Integer value){
        editText.setText(value.toString());
    }

    public String getParameterValue(){
        return editText.getText().toString();
    }
}
