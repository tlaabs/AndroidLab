package com.github.tlaabs.lab1_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView redImage;
    ImageView blueImage;
    int imageIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        redImage = findViewById(R.id.redAndroid);
        blueImage = findViewById(R.id.blueAndroid);

    }

    public void onChangeButton(View v){
        changeImage();
    }

    private void changeImage(){
        if(imageIndex == 0){
            blueImage.setVisibility(View.INVISIBLE); //hide blueImage
            redImage.setVisibility(View.VISIBLE); //show redImage

            imageIndex = 1; //case change
        }
        else if(imageIndex == 1){
            blueImage.setVisibility(View.VISIBLE); //show blueImage
            redImage.setVisibility(View.INVISIBLE); //hide redImage

            imageIndex = 0;
        }
    }
}
