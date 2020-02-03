package it.myImplementations.book.ch10.e_10_09;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main_e_10_09 {

    public static void main(String[] args) {


        Rectangle[] rectangles = new Rectangle[]{
                new Rectangle(10, 10),
                new Rectangle(20, 30),
                new Rectangle(50, 100),
                new Rectangle(100, 1000),
                new Rectangle(30, 30),
        };


        Comparator<Rectangle> rectangleComparator = (o1, o2) -> {

            boolean expression = ((o1.width+o1.height)*2) < ((o2.width+o2.height)*2);

            if(expression)
                return 1;
            else
                return -1;

        };

        Arrays.sort(rectangles,rectangleComparator);
        System.out.println(rectangles[0].height + " " + rectangles[0].width);

    }
}
