package com.example.fert1;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import yanzhikai.textpath.AsyncTextPathView;

public class NewCustomDialog extends Dialog implements
        View.OnClickListener {
    public Activity activity;
    public Dialog dialog;
    public Button button;
//    public TextView textView;
    public AsyncTextPathView asyncTextPathView;
    public ValuesSaver valuesSaver;
//    public TextWriter textWriter;


    public NewCustomDialog(Activity a) {
        super(a);
        // TODO Auto-generated constructor stub
        this.activity = a;
        dialog = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_layout);
        button = findViewById(R.id.button);
//        textView = findViewById(R.id.textView);
        valuesSaver = new ValuesSaver(activity.getApplicationContext());
        asyncTextPathView = findViewById(R.id.animatedText);
        asyncTextPathView.setText("- После взаи-   модействия с    Фертом вам       будет предло- жено отреаги-  ровать с помо- щью появи-       вшихся кнопок.");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(activity.getApplicationContext(),
                        "Хорошо", Toast.LENGTH_SHORT);
                toast.show();

                System.out.println("Before: " + valuesSaver.loadInteger("LearningProgress"));
                System.out.println("Before: " + valuesSaver.loadInteger("LearningProgress"));
                valuesSaver.save("LearningProgress", valuesSaver.loadInteger("LearningProgress")+1);
                ValuesHolder.setLearningProgress(valuesSaver.loadInteger("LearningProgress"));
                System.out.println("After: " + valuesSaver.loadInteger("LearningProgress"));
                dismiss();
            }
        });
        
//        textWriter = findViewById(R.id.textWriter);
//
//
//
//        textWriter
//                .setWidth(12)
//                .setDelay(30)
//                .setColor(Color.RED)
//                .setConfig(TextWriter.Configuration.INTERMEDIATE)
//                .setSizeFactor(30f)
//                .setLetterSpacing(25f)
//                .setText("LIVERPOOL FC EEEEEE")
//                .setListener(new TextWriter.Listener() {
//                    @Override
//                    public void WritingFinished() {
//
//                        //do stuff after animation is finished
//                    }
//                })
//                .startAnimation();
//        textWriter.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
//        asyncTextPathView = findViewById(R.id.animatedText);
//        asyncTextPathView.setText("После взаи-  модействия сФертом вам  будет предло-жено отреаги-ровать с по-  мощью поя-  вившихся       кнопок.");

    }

    public void buttonClicked(View view){
        Toast toast = Toast.makeText(activity.getApplicationContext(),
                "buttonClicked", Toast.LENGTH_SHORT);
        toast.show();
        dismiss();
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
//        switch (v.getId()) {
//            case R.id.btn_yes:
//                c.finish();
//                break;
//            case R.id.btn_no:
//                dismiss();
//                break;
//            default:
//                break;
//        }
//        dismiss();
    }
}
