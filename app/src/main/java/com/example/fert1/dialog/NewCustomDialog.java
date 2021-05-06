package com.example.fert1.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.example.fert1.R;
import com.example.fert1.keeping.SoulHolder;
import com.example.fert1.keeping.ValuesHolder;
import com.example.fert1.keeping.ValuesSaver;

import yanzhikai.textpath.AsyncTextPathView;

public class NewCustomDialog extends Dialog implements
        View.OnClickListener {
    protected Activity activity;
    protected Dialog dialog;
    protected Button button;
    protected AsyncTextPathView asyncTextPathView;
    protected ValuesSaver valuesSaver;
    protected Boolean isCustom = false;
    protected String text;
    protected Integer position;
    protected Integer type;
    protected Button buttonAgree, buttonDisagree;
    SoulHolder soulHolder;
    protected static Integer typeOfWaiting = 0;

    public static Integer getTypeOfWaiting() {
        return typeOfWaiting;
    }

    public static void setTypeOfWaiting(Integer typeOfWaiting) {
        NewCustomDialog.typeOfWaiting = typeOfWaiting;
    }

    public NewCustomDialog(Activity a) {
        super(a);
        // TODO Auto-generated constructor stub
        this.activity = a;
        dialog = this;
        isCustom = false;
    }

    public NewCustomDialog(Activity a, Integer type) {
        super(a);
        // TODO Auto-generated constructor stub
        this.activity = a;
        dialog = this;
        this.type = type;
        isCustom = false;
    }

    public NewCustomDialog(Activity a, String text) {
        super(a);
        // TODO Auto-generated constructor stub
        this.activity = a;
        dialog = this;
        this.text = text;
        isCustom = true;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        System.out.println("Type is " + type);
        soulHolder = new SoulHolder();
        valuesSaver = new ValuesSaver(activity.getApplicationContext());
        if(type==null){
            setContentView(R.layout.dialog_layout);
            button = findViewById(R.id.buttonClose);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast toast = Toast.makeText(activity.getApplicationContext(),
                            "Хорошо", Toast.LENGTH_SHORT);

                    System.out.println("Before: " + valuesSaver.loadInteger("LearningProgress"));
                    //valuesSaver.save("LearningProgress", valuesSaver.loadInteger("LearningProgress")+1);
                    HelpOperator.setCreated(activity.getApplicationContext(), position);
                    System.out.println("After: " + valuesSaver.loadInteger("LearningProgress"));
                    dismiss();

                }
            });
        }
        else {
            setContentView(R.layout.dual_answer_dialog);
            buttonAgree = findViewById(R.id.buttonAgree);
            buttonDisagree = findViewById(R.id.buttonDisagree);
            buttonAgree.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (type){
                        case 1:
                            ValuesHolder.setTextSize(30);
                            ValuesHolder.setImageX(98);
                            ValuesHolder.setImageY(98);
                            valuesSaver.save("TextSize", 30);
                            valuesSaver.save("ImageX", 98);
                            valuesSaver.save("ImageY", 98);
                            break;
                        case 2:
                            soulHolder.setChildishness(1f);
                            soulHolder.setLaziness(1f);
                            valuesSaver.save("Laziness", 1f);
                            valuesSaver.save("Childishness", 1f);
                            break;
                    }
                    dismiss();
                }
            });

            buttonDisagree.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast toast = Toast.makeText(activity.getApplicationContext(),
                            "Отменено", Toast.LENGTH_SHORT);
                    toast.show();
                    dismiss();
                }
            });
        }

        valuesSaver = new ValuesSaver(activity.getApplicationContext());
        asyncTextPathView = findViewById(R.id.animatedText);
        if(isCustom){
            asyncTextPathView.setText(text);
        }
        else if (type==null){
            asyncTextPathView.setText("- После взаи-   модействия с    Фертом вам       будет предло- жено отреаги-  ровать с помо- щью появи-       вшихся кнопок.");
        }
        else {
            switch (type){
                case 1:
                    asyncTextPathView.setText("- Вы уверены,   что хотите вос-становить         настройки         по-умолчанию?");
                    break;
                case 2:
                    asyncTextPathView.setText("- Вы уверены,   что хотите вос-становить на-   чальный хара- ктер Ферта?");
            }
        }
    }

    @Override
    public void dismiss(){
        super.dismiss();
    }

    @Override
    public void onClick(View v) {
        Toast toast = Toast.makeText(activity.getApplicationContext(),
                "Принято", Toast.LENGTH_SHORT);
        toast.show();
        dismiss();
    }
}
