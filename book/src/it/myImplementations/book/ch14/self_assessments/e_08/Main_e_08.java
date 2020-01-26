package it.myImplementations.book.ch14.self_assessments.e_08;

import java.util.LinkedList;
import java.util.ListIterator;

public class Main_e_08 {

    public static void main(String[] args) {


        LinkedList<String> staff = new LinkedList<>();
        staff.addLast("Diana") ;
        staff.addLast( "Harry") ;
        staff.addLast( "Romeo") ;
        staff.addLast("Tom");

        System.out.println(staff);


        removeSrtingWithLengthN(staff,6);

        System.out.println(staff);



    }

    /**
     * 8. Scrivete un ciclo che elimini dalla lista concatenata di stringhe words tutte le stringhe
     * aventi lunghezza inferiore a quattro.
     */

    public static void removeSrtingWithLengthN(LinkedList<String> stringLinkedList, int wordLength){

        ListIterator<String> stringListIterator = stringLinkedList.listIterator();

        while (stringListIterator.hasNext()){

            String word = stringListIterator.next();

            if(word.length() < wordLength)
                stringListIterator.remove();
        }

    }
}
