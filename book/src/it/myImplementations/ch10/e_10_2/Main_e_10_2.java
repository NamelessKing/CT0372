package it.myImplementations.ch10.e_10_2;

import it.myImplementations.ch10.common.Data;
import it.myImplementations.ch10.common.Measurable;

public class Main_e_10_2 {

    public static void main(String[] args) {


        Measurable[] grades = new Quiz[5];

        grades[0] = new Quiz(10);
        grades[1] = new Quiz('b');
        grades[2] = new Quiz(7);
        grades[3] = new Quiz('A');
        grades[4] = new Quiz(3);



        double averageGrade = Data.average(grades);

        Quiz highestGrade = (Quiz) Data.max(grades);


        System.out.println("Average Quiz Grades: " + averageGrade);
        //System.out.println("Average Quiz Letter Grade: " + averageLetterGrade);
        System.out.println("Largest Quiz Grade: " + highestGrade.getScore());
        System.out.println("Largest Quiz Letter Grade: " + highestGrade.getLetterGrade());

    }
}
