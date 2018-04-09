package com.github.tlaabs.lab2_2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GoBackActivity extends AppCompatActivity {
    TextView textView;
    Button goBtn;
    Button backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_back);

        init();

        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        final String url = bundle.getString("url");
        textView.setText(url);

        goBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www." + url));
                startActivity(i);
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void init(){
        textView = findViewById(R.id.textView);
        goBtn = findViewById(R.id.goBtn);
        backBtn = findViewById(R.id.backBtn);
    }
}
