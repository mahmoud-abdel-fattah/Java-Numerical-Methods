package Integration;

public abstract class Integrator {

    protected void validateSubintervals(int n){
        if(n <= 0) throw new IllegalArgumentException("Subinterval must be greater than zero");
    }
    protected double calculateStepSize(double a, double b, int n){
        return (b-a)/n;
    }

}
