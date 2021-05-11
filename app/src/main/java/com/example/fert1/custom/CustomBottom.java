package com.example.fert1.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.fert1.R;

public class CustomBottom extends ConstraintLayout {

    protected ImageButton soulButton, numpadButton, settingsButton;
    protected TextView soulText, numpadText, settingsText;

    public CustomBottom(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View view = inflateAll(context);
    }

    public void setSelected(Integer item){
        soulButton.setImageResource(R.drawable.soul_passive);
        numpadButton.setImageResource(R.drawable.numpad_passive);
        settingsButton.setImageResource(R.drawable.settings_passive);
        switch (item){
            case 1:
                soulButton.setImageResource(R.drawable.soul_selected);
                break;
            case 2:
                numpadButton.setImageResource(R.drawable.numpad_selected);
                break;
            case 3:
                settingsButton.setImageResource(R.drawable.settings_selected);
                break;
        }
    }

    public View inflateAll(Context context){
        View inflatingView = inflate(context, R.layout.custom_bottom, this);
        soulButton = inflatingView.findViewById(R.id.soul_button);
        numpadButton = inflatingView.findViewById(R.id.numpad_button);
        settingsButton = inflatingView.findViewById(R.id.settings_button);
        soulText = inflatingView.findViewById(R.id.soul_text);
        numpadText = inflatingView.findViewById(R.id.numpad_text);
        settingsText = inflatingView.findViewById(R.id.settings_text);
        return inflatingView;
    }
}
