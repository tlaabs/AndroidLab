package com.github.tlaabs.lab2_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText urlEdit;
    Button nextBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), GoBackActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("url",urlEdit.getText().toString());
                i.putExtras(bundle);

                startActivity(i);
            }
        });
    }

    public void init(){
        urlEdit = findViewById(R.id.urlEdit);
        nextBtn = findViewById(R.id.nextBtn);
    }
}
