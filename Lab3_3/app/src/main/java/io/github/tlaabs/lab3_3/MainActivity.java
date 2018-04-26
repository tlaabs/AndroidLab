package io.github.tlaabs.lab3_3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button frag1Btn;
    Button frag2Btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init(){
        frag1Btn = findViewById(R.id.frag1_btn);
        frag2Btn = findViewById(R.id.frag2_btn);



        frag1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //fragment replace
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, new Fragment1()).commit();
            }
        });

        frag2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //fragment replace
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, new Fragment2()).commit();
            }
        });
    }
}
