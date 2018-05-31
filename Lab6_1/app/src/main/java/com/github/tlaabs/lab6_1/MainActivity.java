package com.github.tlaabs.lab6_1;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button writeBtn, clearBtn, readBtn, finishBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        writeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeSD("MyFiles","sdcard.txt");
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("");
            }
        });

        readBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readSD("MyFiles","sdcard.txt");
            }
        });

        finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void init(){
        editText = findViewById(R.id.txtData);
        writeBtn = findViewById(R.id.writeBtn);
        clearBtn = findViewById(R.id.clearBtn);
        readBtn = findViewById(R.id.readBtn);

        finishBtn = findViewById(R.id.finishBtn);
    }

    public void writeSD(String path, String filename){
        File sdCard =  Environment.getExternalStorageDirectory();
        File directory = new File(sdCard.getAbsolutePath() + "/" + path); //set directory path
        directory.mkdirs();
        try {
            //write file
            File file = new File(directory, filename);
            FileOutputStream fout = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fout);
            osw.write(editText.getText().toString());
            osw.close();
            Toast.makeText(getApplicationContext(), "Done writing SD '" + filename + "'", Toast.LENGTH_SHORT).show();
        }catch(FileNotFoundException ex){ex.printStackTrace();
        }catch(IOException ex){ex.printStackTrace();}
    }

    public void readSD(String path, String filename){
        File sdCard =  Environment.getExternalStorageDirectory();
        File directory = new File(sdCard.getAbsolutePath() + "/" + path);
        directory.mkdirs();
        try {
            //read
            File file = new File(directory, filename);
            FileInputStream fint = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fint);
            int i = 0;
            StringBuffer buf = new StringBuffer();

            //reading int
            while( (i = isr.read()) != -1){
                buf.append((char)i);
            }
            isr.close();
            Toast.makeText(getApplicationContext(), "Done reading SD '" + filename + "'", Toast.LENGTH_SHORT).show();
            editText.setText(buf.toString());
        }catch(FileNotFoundException ex){ex.printStackTrace();
        }catch(IOException ex){ex.printStackTrace();}
    }
}
