package com.github.tlaabs.lab5_1;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView imageView1;
    ImageView imageView2;
    EditText editText;
    Button button;
    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DogThread dogThread0 = new DogThread(0);
                DogThread dogThread1 = new DogThread(1);
                dogThread0.start();
                dogThread1.start();

            }
        });
    }

    public void init(){
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.changeBtn);
    }

    class DogThread extends Thread{
        int stateIndex = 0;
        int dogIndex;
        ArrayList<Integer> images = new ArrayList<Integer>();

        public DogThread(int index){
            dogIndex = index;
            //setting images
            images.add(R.drawable.dog_eating);
            images.add(R.drawable.dog_standing);
            images.add(R.drawable.dog_study);
        }
        @Override
        public void run() {
            for(int i = 0 ; i <9; i++){
                final String msg = "dog # " + dogIndex + " state: " + stateIndex;

                handler.post(new Runnable() {
                    @Override
                    public void run() { //implement run method
                        editText.append(msg +  "\n");

                        if(dogIndex == 0){ //dog0
                            imageView1.setImageResource(images.get(stateIndex));
                        }else if(dogIndex == 1){ //dog1
                            imageView2.setImageResource(images.get(stateIndex));
                        }
                    }});

                try{
                    int sleepTime = getRandomTime(500,3000);
                    Thread.sleep(sleepTime);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }

                stateIndex++;
                //rotate index
                if(stateIndex >= images.size()){
                    stateIndex = 0;
                }
            }
        }

        public int getRandomTime(int min, int max){
            return min  + (int)(Math.random() * (max-min));
        }
    }
}
