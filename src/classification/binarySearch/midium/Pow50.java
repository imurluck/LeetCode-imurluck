package classification.binarySearch.midium;

public class Pow50 {

    public double myPow(double x, int n) {
        double res = 1.0;
        for(int i = n; i != 0; i /= 2){
            if(i % 2 != 0){
                res *= x;
            }
            x *= x;
        }
        return  n < 0 ? 1 / res : res;
    }

    public static void main(String[] args) {
        Pow50 pow50 = new Pow50();
        System.out.println(pow50.myPow(3, 10));
    }
}
