package com.example.quizapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView questionTV, questionNumberTV;
    private Button optionBtn1, optionBtn2, optionBtn3, optionBtn4;
    private ArrayList<Quizmodel> quizmodelArrayList;
    Random random;
    int currentScore = 1, questionAttempted =1, currentpost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        questionTV = findViewById(R.id.idTvQuestion);
        questionNumberTV = findViewById(R.id.idTVQuestionsAttempted);
        optionBtn1 = findViewById(R.id.option1);
        optionBtn2 = findViewById(R.id.option2);
        optionBtn3 = findViewById(R.id.option3);
        optionBtn4 = findViewById(R.id.option4);
        quizmodelArrayList = new ArrayList<>();
        random = new Random();
        getQuizQuestion(quizmodelArrayList);
        currentpost = random.nextInt(quizmodelArrayList.size());
        setDataView(currentpost);

        optionBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodelArrayList.get(currentpost).getAnswer().trim().equals(optionBtn1.getText().toString().trim().toLowerCase())){
                    try{
                        currentScore++;
                    }
                    catch (NullPointerException exp){
                        exp.getStackTrace();
                    }

                }
                questionAttempted++;
                currentpost = random.nextInt(quizmodelArrayList.size());
                setDataView(currentpost);
            }
        });


        optionBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodelArrayList.get(currentpost).getAnswer().trim().toLowerCase().equals(optionBtn2.getText().toString().trim().toLowerCase())){
                    try{
                        currentScore++;
                    }
                    catch (NullPointerException exp){
                        exp.getStackTrace();
                    }
                }
                questionAttempted++;
                currentpost = random.nextInt(quizmodelArrayList.size());
                setDataView(currentpost);
            }
        });


        optionBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodelArrayList.get(currentpost).getAnswer().trim().toLowerCase().equals(optionBtn3.getText().toString().trim().toLowerCase())){
                    try{
                        currentScore++;
                    }
                    catch (NullPointerException exp){
                        exp.getStackTrace();
                    }
                }
                questionAttempted++;
                currentpost = random.nextInt(quizmodelArrayList.size());
                setDataView(currentpost);
            }
        });

        optionBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodelArrayList.get(currentpost).getAnswer().trim().toLowerCase().equals(optionBtn4.getText().toString().trim().toLowerCase())){
                    try{
                        currentScore++;
                    }
                    catch (NullPointerException exp){
                        exp.getStackTrace();
                    }
                }
                questionAttempted++;
                currentpost = random.nextInt(quizmodelArrayList.size());
                setDataView(currentpost);
            }
        });

    }

    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.socre_bottom_sheet, (LinearLayout)findViewById(R.id.idLLscore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTVscore);

        Button restartQuizBtn = bottomSheetDialog.findViewById(R.id.btnRestart);
        scoreTV.setText("Your Score is\n"+currentpost+ "/10");

        restartQuizBtn.setOnClickListener(v -> {
            currentpost= random.nextInt(quizmodelArrayList.size());
            setDataView(currentpost);
            questionAttempted =1;
            currentScore = 0;
            bottomSheetDialog.dismiss();
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

    private void setDataView(int currentpost) {
        questionNumberTV.setText(" Questions Attempted :"+questionAttempted+"/10");
        if(questionAttempted == 10 ){
            showBottomSheet();
        }else {
            questionTV.setText(quizmodelArrayList.get(currentpost).getQuestion());
            optionBtn1.setText(quizmodelArrayList.get(currentpost).getOption1());
            optionBtn2.setText(quizmodelArrayList.get(currentpost).getOption2());
            optionBtn3.setText(quizmodelArrayList.get(currentpost).getOption3());
            optionBtn4.setText(quizmodelArrayList.get(currentpost).getOption4());
        }

    }

    private void getQuizQuestion(ArrayList<Quizmodel> quizmodelArrayList) {
        quizmodelArrayList.add(new Quizmodel("1. Who is the father of C language? ","a) Steve Jobs","b) James Gosling","c) Dennis Ritchie","d) Rasmus Lerdorf","c) Dennis Ritchie"));
        //Answer: c
        quizmodelArrayList.add(new Quizmodel("2. Which of the following is not a valid C variable name? ","a) int number;","b) float rate;","c) int variable_count;","d) int $main;","d) int $main;"));
        //Answer: d
        quizmodelArrayList.add(new Quizmodel("3. All keywords in C are in ____________","a) LowerCase letters","b) UpperCase letters","c) CamelCase letters","d) None of the mentioned","a) LowerCase letters"));
        //Answer: a
        quizmodelArrayList.add(new Quizmodel("4. Which of the following cannot be a variable name in C?","a) volatile","b) true","c) friend","d) export","a) volatile"));
        //Answer: a
        quizmodelArrayList.add(new Quizmodel("5. Which keyword is used to prevent any changes in the variable within a C program?","a) immutable","b) mutable","c) const","d) volatile","c) const"));
        //Answer: c
    }
}