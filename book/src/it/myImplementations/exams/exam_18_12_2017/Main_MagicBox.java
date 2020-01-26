package it.myImplementations.exams.exam_18_12_2017;

public class Main_MagicBox {

    public static void main(String[] args) {


        MagicBox<String> mb1 = new MagicBox<>();
        mb1.add("Pippo");
        mb1.add("Pluto");
        mb1.add("Paperino");
        MagicBox<String> mb2 = mb1.filterWith(
                (x)->(
                        ((String)x).length() < 6
                )
        );

        System.out.println(mb2.toArrayList());


    }
}
