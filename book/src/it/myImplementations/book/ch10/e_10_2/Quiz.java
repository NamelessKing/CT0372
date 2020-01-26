package it.myImplementations.book.ch10.e_10_2;

import it.myImplementations.book.ch10.common.Measurable;


/**
 * Implement a class Quiz that implements the Measurable interface.
 * A quiz has a score and a letter grade(such as B+).
 * Use the Data class of Exercise E10.1 to process an array of quizzes.
 * Display the average score and the quiz
 * with the highest score (both letter garde and score).
 *
 * @author Namelessking
 *
 */
public class Quiz implements Measurable {

    private final static int MAX_SCORE = 10;

    private int  score;
    private char letterGrade;


    public Quiz(int score) {
        this.setScore(score);
    }

    public Quiz(char letterGrade) {
        this.setLetterGrade(letterGrade);
    }

    private static int letterGradeToScore(char letterGrade){

        int convertedLetterToScore = 'A'- Character.toUpperCase(letterGrade)  + MAX_SCORE;

        return convertedLetterToScore;
    }

    private static char ScoreToLetterGrade(int score){

        char convertedScoreToLetter = (char)('A'- score  + MAX_SCORE);

        return convertedScoreToLetter;
    }


    @Override
    public double getMeasure() {
        return this.getScore();
    }

    public int getScore() {
        return score;
    }

    private void setScore(int score) {
        char convertedScoreToLetter = ScoreToLetterGrade(score);
        setLetterGrade(convertedScoreToLetter);
    }

    public char getLetterGrade() {
        return letterGrade;
    }

    private void setLetterGrade(char letterGrade) {

        int convertedLetterToScore = letterGradeToScore(letterGrade);

        if(convertedLetterToScore <= 0 || convertedLetterToScore > MAX_SCORE) {
            throw new IllegalArgumentException();
        }else {
            this.letterGrade = letterGrade;
            this.score = convertedLetterToScore;
        }
    }
}
