package classification.bfs.medium;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] ingress = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            ingress[prerequisites[i][0]]++;
        }
        Queue<Integer> zeroQueue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (ingress[i] == 0) {
                zeroQueue.offer(i);
            }
        }
        while (!zeroQueue.isEmpty()) {
            int point = zeroQueue.poll();
            numCourses--;
            for (int[] frontPoint : prerequisites) {
                if (frontPoint[1] == point) {
                    ingress[frontPoint[0]]--;
                    if (ingress[frontPoint[0]] == 0) {
                        zeroQueue.offer(frontPoint[0]);
                    }
                }
            }
        }
        return numCourses == 0;
    }


    public static void main(String[] args) {
        CourseSchedule207 schedule207 = new CourseSchedule207();
        int[][] array = new int[][] {{0, 1}};
        System.out.println(schedule207.canFinish(2, array));
    }
}
