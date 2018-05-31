package com.github.tlaabs.lab6_3;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText snEdit, nameEdit;
    Button addBtn, removeBtn;
    ListView list;

    String[] items;
    DBHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = new DBHelper(this); //DBOpenHelper class, Custom

        init();
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inputInsertCheck()){ //insert check
                    insert();
                }else{
                    Toast.makeText(getApplicationContext(), "모든 항목을 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inputDeleteCheck()){ // insert check
                    delete(nameEdit.getText().toString());
                }else{
                    Toast.makeText(getApplicationContext(), "이름을 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        invalidate();
    }

    public boolean inputInsertCheck(){
        return (snEdit.getText().toString().equals("") || nameEdit.getText().toString().equals("")) ? false : true;
    }
    public boolean inputDeleteCheck(){
        return nameEdit.getText().toString().equals("") ? false : true;
    }

    public void delete(String name){
        SQLiteDatabase db = helper.getWritableDatabase();
        db.delete("student","name=?",new String[]{name});
        invalidate();
    }

    public void insert(){
        SQLiteDatabase db = helper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", nameEdit.getText().toString());
        values.put("studentNo",snEdit.getText().toString());
        db.insert(DBHelper.DATABASE_TABLE,null,values);
        invalidate();
    }

    public void select(){
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor c = db.query(DBHelper.DATABASE_TABLE,null,null,null,null,null,null);
        items = new String[c.getCount()];
        int count = 0;
        while(c.moveToNext()) {
            items[count] = c.getString(c.getColumnIndex("name"))
                    + " " + c.getString(c.getColumnIndex("studentNo"));
            count++;
        }

        c.close();
    }

    private void invalidate(){
        select(); // reload
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, items);
        list.setAdapter(adapter);
    }
    public void init(){
        snEdit = findViewById(R.id.sn);
        nameEdit = findViewById(R.id.name);
        addBtn = findViewById(R.id.addBtn);
        removeBtn = findViewById(R.id.removeBtn);
        list = findViewById(R.id.list);
    }
}
