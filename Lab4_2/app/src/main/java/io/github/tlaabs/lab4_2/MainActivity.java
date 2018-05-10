package io.github.tlaabs.lab4_2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    Button baseBtn;
    Button slideBtn;
    LinearLayout baseArea;
    LinearLayout slideArea;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        baseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation anim = AnimationUtils.loadAnimation(
                        getApplicationContext(), R.anim.left_slide);
                slideArea.setVisibility(View.VISIBLE);
                slideArea.startAnimation(anim);

            }
        });

        slideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation anim = AnimationUtils.loadAnimation(
                        getApplicationContext(), R.anim.right_slide);
                slideArea.startAnimation(anim);
                //Animate finish, Slide Layout is gone.
                slideArea.setVisibility(View.GONE);
            }
        });
    }

    void init(){
        baseBtn = findViewById(R.id.base_btn);
        slideBtn = findViewById(R.id.slide_btn);

        baseArea = findViewById(R.id.base_area);
        slideArea = findViewById(R.id.sliding_area);
    }


}
