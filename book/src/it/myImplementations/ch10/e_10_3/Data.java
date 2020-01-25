package it.myImplementations.ch10.e_10_3;

import it.myImplementations.ch10.common.Measurable;
import it.myImplementations.ch10.common.Named;

public class Data {

    public static double average (Measurable[] measurables){

        double sum = 0;
        for (Measurable measurable: measurables) {
            sum += measurable.getMeasure();
        }

        if(measurables.length > 0){
            return sum / measurables.length;
        }else{
            return 0;
        }
    }

    public static Measurable max(Measurable[] measurables){

        if(measurables.length == 0)
            return null;

        Measurable max = measurables[0];
        for (int i = 1; i < measurables.length; i++){
            if(max.getMeasure() < measurables[i].getMeasure())
                max = measurables[i];
        }

        return max;
    }

    public static String stringa(Named named){
        return named.getName();
    }




}
