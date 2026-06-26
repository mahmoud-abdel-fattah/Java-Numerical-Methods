package Integration;

import Utils.MathParser;
import net.objecthunter.exp4j.Expression;

public class Rectangular extends Integrator{
    // I (Left) = h [y0 + y1 + y2 ... + yn-1]
    // I (Right) = h [y1 + ... + yn]

    public double rectangle(String f, String a, String b, int n, RectangleType type){
        validateSubintervals(n);
        double start = MathParser.evalLimit(a);
        double end = MathParser.evalLimit(b);

        Expression function = MathParser.parse(f);
        double h = calculateStepSize(start,end,n);
        double sum = 0.0;

        for(int i = 0; i <= n; i++){
            double x = start + i * h;
            double fx = MathParser.eval(function,x);
            
            switch (type){
                case LEFT -> {
                    if(i==n) continue;
                    sum+= fx;
                }
                case RIGHT -> {
                    if(i==0) continue;
                    sum+= fx;
                }
            }
            }
        return h  * sum;

    }


}
