package com.github.tlaabs.lab2_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InputActivity extends AppCompatActivity {
    EditText nameEdit;
    EditText ageEdit;
    Button addBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        init();

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ShowActivity.class);
                Bundle bundle = new Bundle(); //create Bundle
                String name = nameEdit.getText().toString(); //get Text from nameEdit
                int age = Integer.parseInt(ageEdit.getText().toString());//get TExt from ageEdit, conver String to integer
                bundle.putString("name",name);
                bundle.putInt("age",age);
                intent.putExtras(bundle); //include bundle to intent
                startActivity(intent);
            }
        });
    }

    //init view
    public void init(){
        nameEdit = findViewById(R.id.nameEdit);
        ageEdit = findViewById(R.id.ageEdit);
        addBtn = findViewById(R.id.addBtn);
    }
}
