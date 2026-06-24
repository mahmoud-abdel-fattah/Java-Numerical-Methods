package Utils;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.tokenizer.UnknownFunctionOrVariableException;

public class MathParser {

    private static final double MAX_LIMIT = 10000;
    private static final double MIN_LIMIT = -10000;

    public static Expression parse(String f){
        f = f.strip().toLowerCase();
        try{
            return new ExpressionBuilder(f)
                    .variable("x")
                    .build();
        }catch (UnknownFunctionOrVariableException e){
            throw new IllegalArgumentException("Unknown Function");
        }

    }

    public static double eval(Expression expression, double value){
        try{
            double result = expression.setVariable("x",value).evaluate();
            if (Double.isNaN(result) || Double.isInfinite(result)){
                throw new IllegalArgumentException("Unsupported Type: Improper Integral");
            }
            return result;
        } catch (ArithmeticException e){
            throw new IllegalArgumentException("Unsupported Type: Improper Integral");
        }
    }
    public static double evalLimits(String limit){
        if (limit.isEmpty()){
            throw new IllegalArgumentException("Invalid Limit");
        }
        limit = limit.strip().toLowerCase();
        try{
            double result = new ExpressionBuilder(limit)
                    .build()
                    .evaluate();
            checkLimits(result);
            return result;
        }catch (UnknownFunctionOrVariableException e){
            throw new IllegalArgumentException("Invalid Limit");
        }

    }
    private static void checkLimits(double l) {
        if (l > MAX_LIMIT || l < MIN_LIMIT) {
            throw new IllegalArgumentException("Limits from -10,000 and 10,000");
        }
    }

}
