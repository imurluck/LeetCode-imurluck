package classification.bfs.medium;

import java.util.*;

public class CourseSchedulePlus210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ingress = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            ingress[prerequisite[0]]++;
        }
        Queue<Integer> zeroQueue = new LinkedList<>();
        for (int i = 0; i < ingress.length; i++) {
            if (ingress[i] == 0) {
                zeroQueue.offer(i);
            }
        }
        int[] result = new int[numCourses];
        int index = 0;
        while (!zeroQueue.isEmpty()) {
            int node = zeroQueue.poll();
            result[index++] = node;
            numCourses--;
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == node) {
                    ingress[prerequisite[0]]--;
                    if (ingress[prerequisite[0]] == 0) {
                        zeroQueue.offer(prerequisite[0]);
                    }
                }
            }
        }
        if (numCourses != 0) {
            return new int[0];
        }
        return result;
    }

}
