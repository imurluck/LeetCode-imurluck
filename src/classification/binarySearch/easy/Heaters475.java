package classification.binarySearch.easy;

import java.util.Arrays;

public class Heaters475 {

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int min = 0;
        for (int i = 0; i < houses.length; i++) {
            min = Math.max(min, binarySearch(houses[i], heaters));
        }
        return min;
    }

    public int binarySearch(int house, int[] heaters) {
        int left = 0;
        int right = heaters.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (house == heaters[mid]) {
                left = mid;
                break;
            } else if (house < heaters[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        int leftValue = left == 0 ? Math.abs(heaters[left] - house) : house - heaters[left - 1];
        int rightValue = left == heaters.length - 1 ? Math.abs(house - heaters[heaters.length - 1]) : heaters[left] - house;
        return Math.min(leftValue, rightValue);
    }

    public static void main(String[] args) {
        Heaters475 heaters475 = new Heaters475();
        System.out.println(heaters475.findRadius(new int[] {1, 2, 3}, new int[] {1, 2, 2}));
    }
}
