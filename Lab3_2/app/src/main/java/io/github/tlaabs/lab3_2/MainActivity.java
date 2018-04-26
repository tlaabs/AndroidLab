package io.github.tlaabs.lab3_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    public final static int MAIN_ACTIVITY = 1;

    EditText editBox;
    RadioGroup genderGroup;
    RadioButton genderMale;
    RadioButton genderFemale;
    CheckBox checkSMS;
    CheckBox checkEmail;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ResultActivity.class);
                String editText="", genderText="", receiveText = "";
                //get EditBox Text to String.
                editText = editBox.getText().toString();

                //get RadioButton selection from RadioGroup
                int groupId = genderGroup.getCheckedRadioButtonId();
                switch (groupId){
                    case R.id.gender_male:
                        genderText = "남";
                        break;
                    case R.id.gender_female:
                        genderText = "여";
                        break;
                }

                if(checkSMS.isChecked()) receiveText += " SMS ";
                if(checkEmail.isChecked()) receiveText += " e-mail ";

                //add data to bundle
                Bundle bundle = new Bundle();
                bundle.putString("editText", editText);
                bundle.putString("genderText", genderText);
                bundle.putString("receiveText", receiveText);

                i.putExtras(bundle);

                startActivityForResult(i,MAIN_ACTIVITY);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == MAIN_ACTIVITY){
            if(resultCode == RESULT_OK){ //OK
                //Reset
                editBox.setText("");
                genderGroup.clearCheck();
                checkSMS.setChecked(false);
                checkEmail.setChecked(false);
            }
        }
    }

    public void init(){
        editBox = findViewById(R.id.editBox);
        genderGroup = findViewById(R.id.gender_group);
        genderMale = findViewById(R.id.gender_male);
        genderFemale = findViewById(R.id.gender_female);
        checkSMS = findViewById(R.id.check_sms);
        checkEmail = findViewById(R.id.check_email);
        submit = findViewById(R.id.submit);
    }
}
