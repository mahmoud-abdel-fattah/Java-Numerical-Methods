package Integration;

import Utils.MathParser;
import net.objecthunter.exp4j.Expression;

public class Trapezoidal extends Integrator{
    // I = h/2 [ (y0 + y_n) + 2*(y1 + ... + y_n-1) ]

    public double trapezoidal(String f, String a, String b, int n){
        validateSubintervals(n);
        double start = MathParser.evalLimit(a);
        double end = MathParser.evalLimit(b);

        Expression function = MathParser.parse(f);
        double h = calculateStepSize(start,end,n);
        double sum = 0.0;

        for(int i = 0; i <= n; i++){
            double x = start + i * h;
            double fx = MathParser.eval(function,x);

            sum += (i == 0 || i == n)? fx : 2*fx;
        }

        return (h / 2) * sum;

    }
}
