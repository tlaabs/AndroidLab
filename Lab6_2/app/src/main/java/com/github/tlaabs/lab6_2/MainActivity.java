package com.github.tlaabs.lab6_2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText snEdit,nameEdit;
    Button loadBtn, saveBtn, clearBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        loadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences settings = getSharedPreferences("mypre",MODE_PRIVATE);
                snEdit.setText(settings.getString("sn", "..."));
                nameEdit.setText(settings.getString("name", "..."));
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences settings = getSharedPreferences("mypre",MODE_PRIVATE);
                SharedPreferences.Editor editor = settings.edit(); //using editor to edit.
                editor.putString("sn", snEdit.getText().toString());
                editor.putString("name", nameEdit.getText().toString());
                editor.commit();
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                snEdit.setText("");
                nameEdit.setText("");
            }
        });
    }

    public void init(){
        snEdit = findViewById(R.id.sn);
        nameEdit = findViewById(R.id.name);
        loadBtn = findViewById(R.id.loadBtn);
        saveBtn = findViewById(R.id.saveBtn);
        clearBtn = findViewById(R.id.resetBtn);
    }
}
