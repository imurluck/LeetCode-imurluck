package classification.dfs.medium;

import java.util.Stack;

public class DecodeString394 {

    public String decodeString(String s) {
        Stack<Integer> opStack = new Stack<>();
        Stack<String> codeStack = new Stack<>();
        int multi = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                multi = multi * 10 + (c - '0');
            } else if (c == '[') {
                codeStack.push(sb.toString());
                sb = new StringBuilder();
                opStack.push(multi);
                multi = 0;
            } else if (c == ']') {
                String popStr = codeStack.pop();
                StringBuilder tmp = new StringBuilder();
                int multiOp = opStack.pop();
                for (int j = 0; j < multiOp; j++) {
                    tmp.append(sb);
                }
                sb = new StringBuilder(popStr).append(tmp);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
