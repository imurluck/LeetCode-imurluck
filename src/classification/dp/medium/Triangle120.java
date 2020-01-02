package classification.dp.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[] minlen = new int[row + 1];
        for (int level = row - 1; level >= 0; level--) {
            for (int i = 0; i <= level; i++) {
                minlen[i] = Math.min(minlen[i], minlen[i + 1]) + triangle.get(level).get(i);
            }
        }
        for (int i = 0; i < minlen.length; i++) {
            System.out.print(minlen[i] + " ");
        }
        return minlen[0];
    }

    public static void main(String[] args) {
        Triangle120 triangle120 = new Triangle120();
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = Arrays.asList(2);
        List<Integer> list2 = Arrays.asList(3, 4);
        List<Integer> list3 = Arrays.asList(6, 5, 7);
        List<Integer> list4 = Arrays.asList(4, 1, 8, 3);
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        System.out.println(triangle120.minimumTotal(list));
    }
}
