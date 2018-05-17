package com.github.tlaabs.lab5_2;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText inputEdit;
    Button caculBtn;
    TextView shownumbersText;
    TextView resultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        caculBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalculateTask task = new CalculateTask();
                int num = Integer.parseInt(inputEdit.getText().toString()); //get number from editText
                task.execute(num);
            }
        });

    }

    public void init(){
        inputEdit = findViewById(R.id.inputedit);
        caculBtn = findViewById(R.id.calculBtn);
        shownumbersText = findViewById(R.id.shownumbers);
        resultText = findViewById(R.id.result);
    }
    class CalculateTask extends AsyncTask<Integer, Integer, Void>{
        String shownumber = "";
        long result_c = 1;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected Void doInBackground(Integer... integers) {
            int n = integers[0];
            int temp = n;
            for(int i = 0 ; i < n ; i++){
                try {
                    Thread.sleep(500);
                    publishProgress(temp,0); //update
                    temp--;
                }catch(InterruptedException ex){}
            }
            publishProgress(0,1);//update
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            int n1 = values[0];
            int n2 = values[1];
            if(n2 == 0) { //showing facto numbers...
                result_c *= n1;
                shownumber = shownumber.concat(n1 + " ");
                shownumbersText.setText(shownumber);
            }else{ //complete showing facto numbers.
                resultText.setText("= " + result_c);
            }
        }
    }
}
