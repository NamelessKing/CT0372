package it.myImplementations.class_exercises.Iterables;

import java.util.Iterator;

public class PrimeNumbersGenerator implements Iterable<Integer>{

    int maxPrime;
        
    public PrimeNumbersGenerator(int maxPrime){
        this.maxPrime = maxPrime;
        //Objects.equals(this, this);
    }
    
    @Override
    public Iterator<Integer> iterator() {
        return new PrimeNumbersIterator(maxPrime);
    }
    
    
    public class PrimeNumbersIterator implements Iterator<Integer>{
        
        private int maxPrime;
        private int currentPrime;
        
        public PrimeNumbersIterator(int maxPrime){
            this.maxPrime = maxPrime;
            this.currentPrime = 1;
        }

        @Override
        public boolean hasNext(){
            return maxPrime > 0;
        }

        @Override
        public Integer next(){
            boolean isPrime = false;
            while(!isPrime){
               currentPrime++;
               isPrime = true;
               int i=2;
               while(isPrime && i<=currentPrime/2)
                  if(currentPrime % i++ == 0)
                     isPrime = false;
            }            
            maxPrime--;
            return currentPrime;
        }
        
    }
        
}
