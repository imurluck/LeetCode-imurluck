package classification.bitoperation.easy;

public class AlternatingBits693 {


    public boolean hasAlternatingBits(int n) {
        n = (n ^ (n >> 1));
        return (n & ((long) n+1)) == 0;
    }
}
