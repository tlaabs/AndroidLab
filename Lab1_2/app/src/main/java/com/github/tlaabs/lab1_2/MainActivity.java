package com.github.tlaabs.lab1_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public EditText editText;
    public Button printBtn;
    public Button clearBtn;
    public TextView showText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    void init(){
        editText = findViewById(R.id.editText);
        printBtn = findViewById(R.id.printBtn);
        clearBtn = findViewById(R.id.clearBtn);
        showText = findViewById(R.id.showText);
    }

    //clearBtn
    public void clearClicked(View v){
        editText.setText(""); //clear editText
        showText.setText(""); //clear editTExt
    }

    //printBtn
    public void printClicked(View v){
        String msg = editText.getText().toString(); //Editable obj convert to String
        showText.setText(msg); //setting msg;
    }
}
