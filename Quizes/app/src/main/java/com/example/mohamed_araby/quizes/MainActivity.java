package com.example.mohamed_araby.quizes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private boolean is=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
       editText=(EditText)findViewById(R.id.edittext);

    }
    public void startQuiz_BTN(View view){
        if(editText==null||!editText.getText().toString().toLowerCase().equals("object oriented programming")){
            Toast.makeText(getApplicationContext(),"Wrong answer",Toast.LENGTH_LONG).show();
            return;
        }else {
            Intent intent = new Intent(this, QuestionsONE.class);
            startActivity(intent);
        }


    }
    public void startQuiz_BTN2(View view){
        if(editText==null||!editText.getText().toString().toLowerCase().equals("object oriented programming")){
            Toast.makeText(getApplicationContext(),"Wrong answer",Toast.LENGTH_LONG).show();
            return;
        }else {
            Intent intent = new Intent(this, QuestionsMulti.class);
            startActivity(intent);
        }


    }

}
