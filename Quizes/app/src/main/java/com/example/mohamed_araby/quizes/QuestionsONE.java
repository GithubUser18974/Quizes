package com.example.mohamed_araby.quizes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class QuestionsONE extends AppCompatActivity {
    private List<String> ansewrs;
    private List<Qiuz> quiz;
    private int score=0;
    private int counter=0;
    private RadioButton rChoosen,ans1,ans2,ans3,ans4;
    private RadioGroup radioGro;
    private TextView q;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        q=(TextView) findViewById(R.id.question);
        quiz=new ArrayList<>();
        radioGro=(RadioGroup) findViewById(R.id.radiogroup);
        ans1=(RadioButton) findViewById(R.id.ans1);
        ans2=(RadioButton) findViewById(R.id.ans2);
        ans3=(RadioButton) findViewById(R.id.ans3);
        ans4=(RadioButton) findViewById(R.id.ans4);
        quiz.add(new Qiuz(
                "Which of these keywords is used to refer to member of base class from a sub class",
                "upper",
                "super",
                "this",
                "none of the mentioned"));

        /////////////////////
        quiz.add(new Qiuz(
                "Which of these is correct way of inheriting class A by class B?",
                "class B + class A {}",
                "class B inherits class A {}",
                "class B extends A {}",
                "class B extends class A {}"));

        //////////////////////////////////////////////////
        quiz.add(new Qiuz(
                "Which of these class provides various types of rounding functions?",
                "Math",
                "Process",
                "System",
                "Object"));
        //////////////////////////////////////////////////
        quiz.add(new Qiuz(
                "What is the process of defining a method in subclass having same name  type signature as a method in its superclass?",
                "Method overloading",
                "Method overriding",
                "Method hiding",
                "None of the mentioned"));
        //////////////////////////////////////////////////
        quiz.add(new Qiuz(
                "Which of these is correct way of calling a constructor having no parameters, of superclass A by subclass B?",
                "super(void);",
                "superclass.();",
                "super.A();",
                "super();"));
        //////////////////////////////////////////////////

        ansewrs=new ArrayList<>();
        ansewrs.add("super");
        ansewrs.add("class B extends A {}");
        ansewrs.add("Math");
        ansewrs.add("Method overriding");
        ansewrs.add("super();");
    }



    public void retry(View view){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);

    }



    public void submitQuestion_BTN(View view){
        if(counter<5) {
            RadioGroup rGroup;
            rGroup = (RadioGroup) findViewById(R.id.radiogroup);
            int selectedID = 0;
            selectedID = rGroup.getCheckedRadioButtonId();
            if (selectedID == 0 || counter > 4) {
                return;
            }
            rChoosen = (RadioButton) findViewById(selectedID);
            if (rChoosen==null) {
                Toast.makeText(getApplicationContext(), "you have to choose one answer", Toast.LENGTH_LONG).show();
                return;
            }
            if (rChoosen.getText().equals(ansewrs.get(counter)) == true) {
                score++;
            }
            if (counter >= 4) {
                setContentView(R.layout.question);
                TextView textView = (TextView) findViewById(R.id.finalMSG);
                textView.setText("Your Score is " + score + "/5");
                Toast.makeText(getApplicationContext(),"Your score = "+score,Toast.LENGTH_LONG).show();
                return;
            }

            else {
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

            }
        }
        }
    }



