package Integration;

import Utils.MathParser;
import net.objecthunter.exp4j.Expression;

public class Simpson extends Integrator{
    // I = h/3[ (y_0 + y_n) + 2*(y_even) + 4*(y_odd) ]

    public double simpson(String f, String a, String b, int n){
        if(n%2!=0) throw new IllegalArgumentException("Subinterval must be even for simpson's");
        validateSubintervals(n);
        double start = MathParser.evalLimit(a);
        double end = MathParser.evalLimit(b);

        Expression function = MathParser.parse(f);
        double h = calculateStepSize(start,end,n);
        double sum = 0.0;

        for(int i = 0; i <= n; i++){
            double x = start + i * h;
            double fx = MathParser.eval(function,x);

            sum += (i==0 || i==n)? fx :
                    (i%2==0)? 2*fx : 4*fx;
        }

        return (h / 3) * sum;

    }
}
