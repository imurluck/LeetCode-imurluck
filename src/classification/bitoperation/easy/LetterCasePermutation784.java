package classification.bitoperation.easy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class LetterCasePermutation784 {

    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        if (S == null || S.length() == 0) {
            return result;
        }
        Stack<Character> stack = new Stack<>();
        doTraversal(result, 0, S, stack);
        return result;
    }

    private void doTraversal(List<String> result, int index, String str, Stack<Character> stack) {
        if (index >= str.length()) {
            result.add(getStackStr(stack));
            return;
        }
        char c = str.charAt(index);
        if (!isLetter(c)) {
            stack.push(c);
            doTraversal(result, index + 1, str, stack);
            stack.pop();
        } else {
            stack.push(c);
            doTraversal(result, index + 1, str, stack);
            stack.pop();
            stack.push((char) (c ^ 32));
            doTraversal(result, index + 1, str, stack);
            stack.pop();
        }
    }

    private boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private String getStackStr(Stack<Character> stack) {
        Iterator iterator = stack.iterator();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
        }
        return sb.toString();
    }
}
