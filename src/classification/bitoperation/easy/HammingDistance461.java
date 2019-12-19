package classification.bitoperation.easy;

public class HammingDistance461 {

    public int hammingDistance(int x, int y) {
        int tmp = x ^ y;
        int distance = 0;
        while (tmp != 0) {
            distance ++;
            tmp &= (tmp - 1);
        }
        return distance;
    }
}
