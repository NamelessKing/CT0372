package it.myImplementations.book.ch14.self_assessments.e_09;

import java.util.LinkedList;

public class Main_e_09 {

    public static void main(String[] args) {


        LinkedList<String> staff = new LinkedList<>();
        staff.addLast("Diana") ;
        staff.addLast( "Harry") ;
        staff.addLast( "Romeo") ;
        staff.addLast("Tom");

        System.out.println("Staff :"+staff);

        LinkedList<String> result = getElementsInOddPositions(staff);

        System.out.println("result :"+ result);

        staff.remove("Tom");
        System.out.println("Staff :"+staff);


        System.out.println("result :"+ result);


    }


    /**
     * 9. Scrivete un ciclo che visualizzi tutti gli elementi di posizione dispari (contando le posizioni
     * da zero come gli indici, cioè il secondo elemento, il quarto, ecc.) della lista concatenata
     * di stringhe words
     */
    public static <T> LinkedList<T> getElementsInOddPositions(LinkedList<T> tLinkedList) {

        LinkedList<T> tListWithElementsInOddPisitions = new LinkedList<>();

        int i = 0;

        for (T tObj: tLinkedList) {
            if(i%2 != 0)
                tListWithElementsInOddPisitions.add(tObj);
            i++;
        }

        return tListWithElementsInOddPisitions;
    }




}
