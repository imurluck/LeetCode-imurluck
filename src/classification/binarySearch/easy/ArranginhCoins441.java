package classification.binarySearch.easy;

public class ArranginhCoins441 {

    public int arrangeCoins(int n) {
        return (int) (Math.sqrt(2) * Math.sqrt(n + 0.125d) - 0.5);
    }

    public static void main(String[] args) {
        ArranginhCoins441 arranginhCoins441 = new ArranginhCoins441();
        System.out.println(arranginhCoins441.arrangeCoins(2146467959));
    }
}
