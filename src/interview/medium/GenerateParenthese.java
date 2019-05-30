package interview.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthese {

    public List<String> generateParenthese(int n) {
        List<String> list = new ArrayList<>();
        dfs(n, n, list, "");
        return list;
    }

    private void dfs(int restLeft, int restRight, List<String> list, String currentStr) {
        System.out.println(restLeft + "" + restRight + " " + currentStr);
        //')'多于'('不合法，返回
        if (restLeft > restRight) {
            return;
        }
        if (restLeft == 0 && restRight == 0) {
            list.add(currentStr);
            return;
        }
        if (restLeft > 0) {
            dfs(restLeft - 1, restRight, list, currentStr + '(');
        }
        if (restRight > 0) {
            dfs(restLeft, restRight - 1, list, currentStr + ')');
        }
    }

    public static void main(String[] args) {
        GenerateParenthese solution = new GenerateParenthese();
        System.out.println(solution.generateParenthese(2));
    }
}
