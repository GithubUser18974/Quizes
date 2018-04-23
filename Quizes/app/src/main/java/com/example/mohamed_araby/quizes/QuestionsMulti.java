package com.example.mohamed_araby.quizes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class QuestionsMulti extends AppCompatActivity {
    private List<String> ansewrs;
    private List<Qiuz> quiz;
    private int score=0;
    private int counter=0;
    private TextView q;
    private CheckBox rChoosen,ans1,ans2,ans3,ans4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_multi);
        q=(TextView) findViewById(R.id.questionMULTI);
        ans1=(CheckBox)findViewById(R.id.ans1MULTI);
        ans2=(CheckBox)findViewById(R.id.ans2MULTI);
        ans3=(CheckBox)findViewById(R.id.ans3MULTI);
        ans4=(CheckBox)findViewById(R.id.ans4MULTI);
        quiz=new ArrayList<>();
        ansewrs=new ArrayList<>();
        quiz.add(new Qiuz(
                "Which of these football teams is an egyptian team",
                "Alahly",
                "Zamalek",
                "Masry",
                "Dallas Cowboys"));
        quiz.add(new Qiuz(
                "Which of these places located in egypt",
                "Giza",
                "New yourk",
                "benha",
                "paris"));
        quiz.add(new Qiuz(
                "Which of these food is famous in egypt  ",
                "Kushari",
                "Fish",
                "pizza",
                "Ful wa Ta'meya"));
        ansewrs.add("AlahlyZamalekMasry");
        ansewrs.add("Gizabenha");
        ansewrs.add("KushariFul wa Ta'meya");
    }
    public void submitQuestion_BTN_Multi(View view){
        boolean isChecked=false;
        if(counter<=2) {
            String ans="";
            if(ans1.isChecked()){ans=ans1.getText().toString();    isChecked=true;}
            if(ans2.isChecked()){ans=ans+ans2.getText().toString();isChecked=true;}
            if(ans3.isChecked()){ans=ans+ans3.getText().toString();isChecked=true;}
            if(ans4.isChecked()){ans=ans+ans4.getText().toString();isChecked=true;}
            if(!isChecked){
                Toast.makeText(getApplicationContext(), "you have to choose one answer", Toast.LENGTH_LONG).show();
                return;
            }
            if (ansewrs.get(counter).toString().equals(ans) == true) {
                score++;
            }

            if (counter >= 2){
                setContentView(R.layout.question);
                TextView textView=(TextView) findViewById(R.id.finalMSG);
                textView.setText("Your Score is "+score+"/3");
                Toast.makeText(getApplicationContext(),"Your score = "+score,Toast.LENGTH_LONG).show();
                return;
            }else {
                counter++;
                String tmp;
                tmp = quiz.get(counter).getQuestion();
                q.setText(tmp);
                tmp = quiz.get(counter).getAnswer1();
                ans1.setText(tmp);
                tmp = quiz.get(counter).getAnswer2();
                ans2.setText(tmp);
                tmp = quiz.get(counter).getAnswer3();
                ans3.setText(tmp);
                tmp = quiz.get(counter).getAnswer4();
                ans4.setText(tmp);
                ans1.setSelected(false);
                ans2.setSelected(false);
                ans3.setSelected(false);
                ans4.setSelected(false);
            }

        }
    }
    public void retry(View view){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);

    }
}
