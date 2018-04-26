package io.github.tlaabs.lab3_1;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        //regsiter Button to Context
        registerForContextMenu(btn);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        //Set Header Title
        menu.setHeaderTitle("Button Menu");

        //Create Menu Item
        menu.add(0,0,100,"Red");
        menu.add(0,1,200,"Green");
        menu.add(0,2,300,"Blue");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case 0:
                btn.setTextColor(Color.RED);
                break;
            case 1:
                btn.setTextColor(Color.GREEN);
                break;
            case 2:
                btn.setTextColor(Color.BLUE);
                break;
        }

        return super.onContextItemSelected(item);
    }
}
