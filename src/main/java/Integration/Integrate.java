package Integration;

public class Integrate {

    public static double simpson(String f, String a, String b, int n){
        Simpson simpson = new Simpson();
        return simpson.simpson(f,a,b,n);
    }
    public static double trapezoidal(String f, String a, String b, int n){
        Trapezoidal trapezoidal = new Trapezoidal();
        return trapezoidal.trapezoidal(f,a,b,n);
    }
    public static double rectangle(String f, String a, String b, int n, RectangleType type){
        Rectangular rectangular = new Rectangular();
        return rectangular.rectangle(f,a,b,n,type);
    }

}
