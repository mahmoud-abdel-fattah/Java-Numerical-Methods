package Integration;

public class Integrate {

    public static double simpson(String f, String a, String b, int n){
        Simpson simpson = new Simpson();
        return simpson.simpson(f,a,b,n);
    }

}
