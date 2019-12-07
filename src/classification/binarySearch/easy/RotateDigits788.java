package classification.binarySearch.easy;

public class RotateDigits788 {

    private int[] canRotateArray = new int[] {0, 1, 2, 5, 6, 8, 9};
    private int[] notChangeArray = new int[] {0, 1, 8};

    public int rotatedDigits(int N) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (isGoodDigit(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isGoodDigit(int n) {
        int tmp = n;
        boolean hasOneNotInNoChangeArray = false;
        while (tmp > 0) {
            int a = tmp % 10;
            if (!isInRotateArray(a)) {
                return false;
            }
            if (!hasOneNotInNoChangeArray && !isInNotChangeArray(a)) {
                hasOneNotInNoChangeArray = true;
            }
            tmp = tmp / 10;
        }
        return hasOneNotInNoChangeArray;
    }

    private boolean isInRotateArray(int n) {
        for (int i = 0; i < canRotateArray.length; i++) {
            if (n == canRotateArray[i]) {
                return true;
            }
        }
        return false;
    }

    private boolean isInNotChangeArray(int n) {
        for (int i = 0; i < notChangeArray.length; i++) {
            if (n == notChangeArray[i]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        RotateDigits788 rotateDigits788 = new RotateDigits788();
        System.out.println(rotateDigits788.rotatedDigits(857));
    }

}
