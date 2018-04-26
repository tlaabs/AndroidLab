package io.github.tlaabs.lab3_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView nameText;
    TextView genderText;
    TextView receiveText;
    Button previousBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        init();

        //get Extra & unpacking data
        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        String name = bundle.getString("editText");
        String gender = bundle.getString("genderText");
        String receive = bundle.getString("receiveText");

        nameText.setText(" : " + name);
        genderText.setText(" : " + gender);
        receiveText.setText(" : " + receive);

    }

    public void init(){
        nameText = findViewById(R.id.name);
        genderText = findViewById(R.id.gender);
        receiveText = findViewById(R.id.receive);
        previousBtn = findViewById(R.id.previous);
        
        previousBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_OK);
                finish();
            }
        });
    }
}
