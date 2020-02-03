package it.myImplementations.class_exercises.Vectors;

public class PolarCoords{
        
    private double theta, len;

    public double getTheta() {
        return theta;
    }

    public double getLen() {
        return len;
    }

        public PolarCoords(double theta, double len) {
            if(len < 0)
                throw new IllegalArgumentException("Length cannot be negative");
            if(theta > 2*Math.PI || len < 0)
                throw new IllegalArgumentException("Theta must be between 0 and 2 PI");
            this.theta = theta;
            this.len = len;
        }
        
    }
