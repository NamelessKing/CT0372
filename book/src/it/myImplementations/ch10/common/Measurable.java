package it.myImplementations.ch10.common;

public interface Measurable {
    default double getMeasure(){return 0;}

    /**
     * Computes the average of the measures of the given objects
     * @param objects an array of Measurable objects
     * @return the average of the measures
     */
     static double average(Measurable[] objects) {
        double sum = 0;
        for (Measurable obj : objects) {
            sum = sum + obj.getMeasure();
        }
        if (objects.length > 0) {
            return sum / objects.length;
        }
        else {
            return 0;
        }
    }

    default boolean smallerThan(Measurable other)
    {
        return getMeasure() < other.getMeasure();
    }
}
