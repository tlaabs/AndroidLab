package com.github.tlaabs.lab2_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ShowActivity extends AppCompatActivity {
    Button closeBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        closeBtn = findViewById(R.id.closeBtn);
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras(); //getBundle

        String name = bundle.getString("name"); //string
        int age = bundle.getInt("age"); //age

        Toast.makeText(this,"Student info : " + name + ","+age,Toast.LENGTH_SHORT).show(); //Toast


    }
}
