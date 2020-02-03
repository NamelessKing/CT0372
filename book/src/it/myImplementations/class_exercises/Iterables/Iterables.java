package it.myImplementations.class_exercises.Iterables;

public class Iterables {

    public static void main(String[] args) {
        for(int prime : new PrimeNumbersGenerator(10))
            System.out.println(prime);
    }
    
}
