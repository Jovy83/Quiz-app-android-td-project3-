package com.digigames_interactive.quiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    RandomQuestions randomQuestions = new RandomQuestions();

    TextView questionTextView;
    Button submitButton;
    RadioGroup answerRadioGroup;
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();
        setupQuestionAnswer();
    }

    private void setupViews() {
        questionTextView = findViewById(R.id.questionTextView);
        submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                evaluateAnswer();
                setupQuestionAnswer();
            }
        });
        answerRadioGroup = findViewById(R.id.answerRadioGroup);
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        radioButton3 = findViewById(R.id.radioButton3);
    }

    private void setupQuestionAnswer() {
        questionTextView.setText(randomQuestions.getQuestion());

        Random random = new Random();
        int correctRadio = random.nextInt(3);
        switch (correctRadio) {
            case 0:
                radioButton1.setText(randomQuestions.getCurrentAnswer());
                radioButton2.setText(randomQuestions.getCurrentWrongAnswer1());
                radioButton3.setText(randomQuestions.getCurrentWrongAnswer2());
                break;
            case 1:
                radioButton1.setText(randomQuestions.getCurrentWrongAnswer1());
                radioButton2.setText(randomQuestions.getCurrentAnswer());
                radioButton3.setText(randomQuestions.getCurrentWrongAnswer2());
                break;
            case 2:
                radioButton1.setText(randomQuestions.getCurrentWrongAnswer1());
                radioButton2.setText(randomQuestions.getCurrentWrongAnswer2());
                radioButton3.setText(randomQuestions.getCurrentAnswer());
                break;
            default:
                break;
        }
    }

    private void evaluateAnswer() {
        int selectedRadioButtonId = answerRadioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(selectedRadioButtonId);
        String selectedAnswer = radioButton.getText().toString();
        if (selectedAnswer.contentEquals(String.valueOf(randomQuestions.getCurrentAnswer()))) {
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
        }
        answerRadioGroup.clearCheck();
    }
}
