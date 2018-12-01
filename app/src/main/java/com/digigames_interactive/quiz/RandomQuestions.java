package com.digigames_interactive.quiz;

import java.util.Locale;
import java.util.Random;

public class RandomQuestions {

    private final int UPPER_LIMIT = 51;

    private int currentAnswer = -1;
    private int currentWrongAnswer1 = -1;
    private int currentWrongAnswer2 = -1;

    public String getCurrentAnswer() {
        return String.valueOf(currentAnswer);
    }

    public String getCurrentWrongAnswer1() {
        return String.valueOf(currentWrongAnswer1);
    }

    public String getCurrentWrongAnswer2() {
        return String.valueOf(currentWrongAnswer2);
    }

    public String getQuestion() {
        Random random = new Random();
        int randomNumber1 = random.nextInt(UPPER_LIMIT);
        int randomNumber2 = random.nextInt(UPPER_LIMIT);
        currentAnswer = randomNumber1 + randomNumber2;
        currentWrongAnswer1 = random.nextInt(UPPER_LIMIT);
        currentWrongAnswer2 = random.nextInt(UPPER_LIMIT);
        return String.format(Locale.getDefault(), "%d + %d = ?", randomNumber1, randomNumber2);
    }


}
